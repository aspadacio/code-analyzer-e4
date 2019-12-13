package com.safeval.codeanalyzer.views;

import java.util.ArrayList;

import javax.inject.Inject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.texteditor.ITextEditor;


/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

public class ExploreFilesVulnerabilitiesView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "com.safeval.codeanalyzer.views.ExploreFilesVulnerabilitiesView";

	@Inject IWorkbench workbench;
	
	private TreeViewer viewer;
	private DrillDownAdapter drillDownAdapter;
	private Action action1;
	private Action action2;
	private Action doubleClickAction;
	 
	class TreeObject implements IAdaptable {
		private String name;
		private TreeParent parent;
		
		public TreeObject(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
		public void setParent(TreeParent parent) {
			this.parent = parent;
		}
		public TreeParent getParent() {
			return parent;
		}
		@Override
		public String toString() {
			return getName();
		}
		@Override
		public <T> T getAdapter(Class<T> key) {
			return null;
		}
	}
	
	class TreeParent extends TreeObject {
		private ArrayList<TreeObject> children;
		public TreeParent(String name) {
			super(name);
			children = new ArrayList<TreeObject>();
		}
		public void addChild(TreeObject child) {
			children.add(child);
			child.setParent(this);
		}
		public void removeChild(TreeObject child) {
			children.remove(child);
			child.setParent(null);
		}
		public TreeObject [] getChildren() {
			return (TreeObject [])children.toArray(new TreeObject[children.size()]);
		}
		public boolean hasChildren() {
			return children.size()>0;
		}
	}
	
	class FilesVulnerabilityCP implements ITreeContentProvider {
		private TreeParent invisibleRoot;
		private String fPath;
		private int line;

		public Object[] getElements(Object parent) {
			if (parent.equals(getViewSite())) {
				if (invisibleRoot==null) initialize();
				return getChildren(invisibleRoot);
			}
			return getChildren(parent);
		}
		
		public Object getParent(Object child) {
			if (child instanceof TreeObject) {
				return ((TreeObject)child).getParent();
			}
			return null;
		}
		public Object [] getChildren(Object parent) {
			if (parent instanceof TreeParent) {
				return ((TreeParent)parent).getChildren();
			}
			return new Object[0];
		}
		public boolean hasChildren(Object parent) {
			if (parent instanceof TreeParent)
				return ((TreeParent)parent).hasChildren();
			return false;
		}
		
		private void initialize() {
			String pckFullPath = "";
			String fileName = "";
			
			for( String el : this.fPath.split("/") ) {
				if(el.endsWith(".java")) {
					fileName = el;
				}else {
					pckFullPath = pckFullPath + "/" + el;
				}
			}
			
			TreeObject file1 = new TreeObject(fileName);
			
			TreeParent parent1 = new TreeParent(pckFullPath);
			parent1.addChild(file1);
			
			TreeParent root = new TreeParent("com.safeval.codeanalyzer");
			root.addChild(parent1);
			
			invisibleRoot = new TreeParent("");
			invisibleRoot.addChild(root);
		}
		
		FilesVulnerabilityCP(String fPath, int line){
			this.fPath = fPath;
			this.line = line;
		}
		
	}

	class ViewLabelProvider extends LabelProvider {

		public String getText(Object obj) {
			return obj.toString();
		}
		public Image getImage(Object obj) {
			String imageKey = ISharedImages.IMG_OBJ_FILE;
			if (obj instanceof TreeParent)
			   imageKey = ISharedImages.IMG_OBJ_FOLDER;
			return workbench.getSharedImages().getImage(imageKey);
		}
	}

	@Override
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		drillDownAdapter = new DrillDownAdapter(viewer);
		
		viewer.setContentProvider(new FilesVulnerabilityCP("", 0));
		viewer.setInput(getViewSite());
		viewer.setLabelProvider(new ViewLabelProvider());

		// Create the help context id for the viewer's control
		workbench.getHelpSystem().setHelp(viewer.getControl(), "com.safeval.codeanalyzer.viewer");
		getSite().setSelectionProvider(viewer);
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
	}
	
	/**
	 * 
	 * @param filePaht
	 * @param line - vulnerability file's line
	 */
	public void setFilesVulnerabilities( String filePaht, int line ) {
		System.out.println("setTreeFilesVulnerabilities :: configurando...");
		
		action1.setToolTipText("Mudando texto - Exemplo");
		
		viewer.setContentProvider(new FilesVulnerabilityCP(filePaht, line));
	}
	
	

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				ExploreFilesVulnerabilitiesView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(action1);
		manager.add(new Separator());
		manager.add(action2);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(action1);
		manager.add(action2);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(action1);
		manager.add(action2);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
	}

	private void makeActions() {
		action1 = new Action() {
			public void run() {
				showMessage("Action 1 executed");
			}
		};
		action1.setText("Action 1");
		action1.setToolTipText("Action 1 tooltip");
		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		
		action2 = new Action() {
			public void run() {
				showMessage("Action 2 executed");
			}
		};
		action2.setText("Action 2");
		action2.setToolTipText("Action 2 tooltip");
		action2.setImageDescriptor(workbench.getSharedImages().
				getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		
		doubleClickAction = new Action() {
			public void run() {
				IStructuredSelection selection = viewer.getStructuredSelection();
				TreeObject obj = (TreeObject)selection.getFirstElement();
				
				String path = obj.getParent().getName();
				String file = obj.getName();
				
				IPath fileDir = new Path("D:/" + path + "/" + file);
				
				//Open editor
				//IFile fileToOpen = ResourcesPlugin.getWorkspace().getRoot().getFile(fileDir);
				
				IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
				IProject myProject = myWorkspaceRoot.getProject("testes");

				if( myProject.exists() && !myProject.isOpen() ) {
					try {
						myProject.open(null);
					} catch (CoreException e) {
						// TODO Auto-generated catch block
					}
				}
				
				IFolder javaFolderParent = myProject.getFolder("src");
				if( javaFolderParent.exists() ) {
					IFolder javaFolderWPackage = null;
					try {
						javaFolderWPackage = javaFolderParent.getFolder(javaFolderParent.members()[0].getName());
					} catch (CoreException e1) {
						e1.printStackTrace();
					}
					
					if( javaFolderWPackage.exists() ) {
						IFile fileToOpen = javaFolderWPackage.getFile("Teste.java");
						try {
							
							//Create Marker							
							  IResource res = fileToOpen; 
							  res.deleteMarkers("com.safeval.codeanalyzer.util.safevalMarker", true, IResource.DEPTH_ZERO);
							  res.deleteMarkers("com.safeval.codeanalyzer.marker.slicemarker", true, IResource.DEPTH_ZERO);
							  
							/*
							 * for( int i=0; i<2; i++ ) { IMarker marker =
							 * res.createMarker("com.safeval.codeanalyzer.util.safevalMarker");
							 * marker.setAttribute(IMarker.MESSAGE, "Descrição da vulnerabilidade => 0" +
							 * i); marker.setAttribute(IMarker.LINE_NUMBER, (i+12));
							 * marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING); }
							 */
							 
							  IEditorPart editor = IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), fileToOpen, true);
							
							//Get offSet of certain file's line
							  //IDocument document = (IDocument) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor()
							  //IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
							  IDocument doc = null; //(IDocument) editor.getAdapter(IDocument.class);
							  
							  if(editor instanceof ITextEditor) {
								  ITextEditor itextEditor = (ITextEditor)editor;
								  doc = itextEditor.getDocumentProvider().getDocument(itextEditor.getEditorInput());
							  }
							  
							  if( doc != null ) {
								  try {
									final int lineOffSet = doc.getLineOffset(13);
									final int lineLenght = doc.getLineLength(13);
									
									IMarker marker = res.createMarker("com.safeval.codeanalyzer.marker.slicemarker");
									marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
									marker.setAttribute(IMarker.MESSAGE, "Comentário da Vulnerabilidade ...");									
									marker.setAttribute(IMarker.CHAR_START, lineOffSet);
									marker.setAttribute(IMarker.CHAR_END, (lineOffSet + lineLenght));
									
								} catch (BadLocationException e) {
									e.printStackTrace();
								}
							  }
						} catch (CoreException e) {
							e.printStackTrace();
						}
					}
				}
				
				//showMessage("Double-click detected on "+obj.toString());
			}
		};
	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}
	private void showMessage(String message) {
		MessageDialog.openInformation(
			viewer.getControl().getShell(),
			"Files Vulnerabilities View",
			message);
	}

	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}
