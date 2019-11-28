package com.safeval.codeanalyzer.wizards;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.stream.Stream;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.eclipse.core.internal.resources.Project;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import com.safeval.codeanalyzer.util.SafevalUtil;
import com.safeval.codeanalyzer.ws.transfer.TransferServiceSoap;

/**
 * Wizard Page that provides form to choose a project/file(s)
 * @author Spadacio
 *
 */
@SuppressWarnings("restriction")
public class SelectProjectWP extends WizardPage {
	
	private static String WS_URL = "https://isasecdev.com";
	
	private Composite container;
	private String[] sharedValues;
	private String projectSelected;
	
	long bLength; //length, in bytes, of All files
	long bUploaded; //lenght, in bytes, of the sum of files uploaded
	
	Button startUploadBtn;
	ProgressBar uploadPB;
	Font labelFont;
	Font buttonFont;
	
	/**
	 * @param sharedValues
	 */
	public SelectProjectWP(String[] sharedValues) {
		super("Escolha o Projeto");
		setTitle("Escolha o Projeto");
		setDescription("Escolha qual projeto será analizado");
		
		this.sharedValues = sharedValues;
	}

	@Override
	public void createControl(Composite parent) {
		GridLayout layout = new GridLayout(2, false);
		layout.marginWidth = 80;
		layout.verticalSpacing = 0;
		
		this.container = new Composite(parent, SWT.NONE);
		this.container.setLayout(layout);
		
		//Colors
		ResourceManager resManager = new LocalResourceManager(JFaceResources.getResources(), parent);
		
		//Labels
		Label directoryLb = new Label(container, SWT.NONE);
		labelFont = new Font(directoryLb.getDisplay(), new FontData("Mono", 10, SWT.BOLD));
		directoryLb.setText("Diretório:");
		directoryLb.setFont(labelFont);
		
		new Label(container, SWT.NONE); //Empty
		
		//Fields
		Text directoryText = new Text(this.container, SWT.BORDER);
		directoryText.setBackground(resManager.createColor(new RGB(255, 255, 255)));
		directoryText.setText("");
		directoryText.setEditable(false);
		directoryText.setCursor(parent.getDisplay().getSystemCursor(SWT.CURSOR_ARROW));
				
		Button openWorkspaceBtn = new Button(this.container, SWT.PUSH);
		buttonFont = new Font(openWorkspaceBtn.getDisplay(), new FontData("Mono", 10, SWT.BOLD));
		openWorkspaceBtn.setFont(buttonFont);
		openWorkspaceBtn.setText("Workspace...");
		
		Button openFileSystemBtn = new Button(this.container, SWT.PUSH);
		buttonFont = new Font(openFileSystemBtn.getDisplay(), new FontData("Mono", 10, SWT.BOLD));
		openFileSystemBtn.setFont(buttonFont);
		openFileSystemBtn.setText("File System...");
		
		new Label(container, SWT.NONE); //Empty
		new Label(container, SWT.NONE); //Empty
		new Label(container, SWT.NONE); //Empty
		new Label(container, SWT.NONE); //Empty
		
		uploadPB = new ProgressBar(container, SWT.NONE);
		uploadPB.setVisible(false);
		uploadPB.setSelection(0); //Percentage of progress
		
		startUploadBtn = new Button(this.container, SWT.PUSH);
		buttonFont = new Font(startUploadBtn.getDisplay(), new FontData("Mono", 10, SWT.BOLD));
		startUploadBtn.setFont(buttonFont);
		startUploadBtn.setText("Start Upload");
		startUploadBtn.setEnabled(false);
		
		//Layouts
		GridData gridData2Label = new GridData(SWT.BEGINNING, SWT.CENTER, true, true);
		directoryLb.setLayoutData(gridData2Label);
		
		GridData gridData2Text = new GridData(SWT.FILL, SWT.BEGINNING, true, true);
		gridData2Text.horizontalSpan = 3;
		gridData2Text.heightHint = 20;
		directoryText.setLayoutData(gridData2Text);
		
		GridData gridData2Btn = new GridData(SWT.END, SWT.END, false, false);
		openFileSystemBtn.setLayoutData(gridData2Btn);
		openWorkspaceBtn.setLayoutData(gridData2Btn);
		
		GridData gridData2UploadBtn = new GridData(SWT.FILL, SWT.BEGINNING, false, false);
		//gridData2UploadBtn.verticalSpan = 2;
		startUploadBtn.setLayoutData(gridData2UploadBtn);
		uploadPB.setLayoutData(gridData2UploadBtn);		
		
		//Listeners
		openWorkspaceBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				
				//Open Workspace projects
				ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
					    parent.getShell(), 
					    new WorkbenchLabelProvider(), 
					    new BaseWorkbenchContentProvider());
				
				dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
				dialog.setTitle("Selecionar projeto");
				dialog.open();
				
				if( dialog.getResult() != null ) {
					Project selected = (Project) dialog.getResult()[0];
					directoryText.setText("${workspace_loc:" + selected.getFullPath().toString() + "}");
					projectSelected = selected.getFullPath().toString();
					enableStartUpload();
				}
			}
		});
		
		openFileSystemBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				
				//Open File System explorer
				DirectoryDialog dirDialog = new DirectoryDialog(getShell());
		        dirDialog.setText("Selecionar diretório");
		        String selectedDir = dirDialog.open();
				
		        if( selectedDir != null ) {
		        	directoryText.setText(selectedDir);
		        	projectSelected = selectedDir;
		        	enableStartUpload();
		        }
			}
		});
		
		startUploadBtn.addSelectionListener(new SelectionAdapter() {
			@SuppressWarnings("unused")
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				
				//Calls StartUpload Service
				sharedValues[1] = getMPTTag(sharedValues[0]);
				setMessage("Canal para transações aberto", IMessageProvider.INFORMATION);; 
            	
				/**
				 * 1. Get each file as Byte Array divided by N parts of 4000 bytes
				 * 2. Calls Upload Service / Update ProgressBar for each file
				 */
				String path = "D:/mine/private-projects/brinquedoteca";

				bUploaded = 0;
				try {
					bLength = Files.walk(Paths.get(path))
					.map(f -> f.toFile())
					.filter(f -> f.isFile())
					.filter(f -> f.getName().toString().endsWith(".java"))
					.mapToLong(f -> f.length()).sum();
					
					Stream<Path> paths = Files.walk(Paths.get(path))
							.filter(Files::isRegularFile)
							.filter(f -> f.getFileName().toString().endsWith(".java"));

					paths.forEach(p -> {
						try {
							String response = null;
							byte[] b = Files.readAllBytes(p);
							bUploaded = bUploaded + (long) b.length;
							
							//System.out.println(p.getFileName());
							if (b.length > 4000) {
								List<byte[]> listPartedFile = SafevalUtil.getPartedFile(b, 4000);
								
								int pos = 0;
								for( byte[] part : listPartedFile ) {
									response = uploadService(Base64.getEncoder().encodeToString(part), pos);
									pos++;
									//Calls Analysis Service
								}
							}else {
								response = uploadService(Base64.getEncoder().encodeToString(b), 0);
								//Calls Analysis Service
							}
							
							if( response.equalsIgnoreCase("ok") ) {
								int perc = (int)(bUploaded * 100.0 / bLength + 0.5);
								//uploadPB.setSelection(perc); //Percentage of progress
								uploadPB.setVisible(true);					
								System.out.println("Uploading... - " + perc + "%");
								//System.out.println("");
							}
						} catch (IOException e1) {
							e1.printStackTrace();
						}				
					});
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		});
		
		this.setControl(container);
		this.setPageComplete(false);
	};

	/**
	 * Method amides to Upload the classes / files to further analysis
	 * @return Upload Response object
	 * @throws MalformedURLException 
	 */
	protected String uploadService(String buffer, int pos) {
		String uploadResp = null;
		
		URL wsdlUrlL;
		try {
			wsdlUrlL = new URL(WS_URL + "/DataTransfer/TransferService.asmx?WSDL");
			QName qnameL = new QName("http://isasecdev.com/", "TransferService");
			
			Service serviceL = Service.create(wsdlUrlL, qnameL);
			TransferServiceSoap soap = serviceL.getPort(new QName("http://isasecdev.com/", "TransferServiceSoap"),TransferServiceSoap.class);
			
			uploadResp = soap.upload(sharedValues[0], sharedValues[1], pos, buffer, "3.0.39");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return uploadResp;
	}
	
	/***
	 * Method that calls SOPA service to return MPT Tag
	 * that is necessary to send Bytes Array to proccess
	 */
	private String getMPTTag(String token) {
		String response = null;
		
		if(token != null && token != "" && token.length() > 1) {
			try {
				URL wsdlUrlL = new URL(WS_URL + "/DataTransfer/TransferService.asmx?WSDL");
				QName qnameL = new QName("http://isasecdev.com/", "TransferService");
				
				Service serviceL = Service.create(wsdlUrlL, qnameL);
				TransferServiceSoap soap = serviceL.getPort(new QName("http://isasecdev.com/", "TransferServiceSoap"),TransferServiceSoap.class);
				
				response = soap.startUpload(token, "3.0.39");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		
		if( response != null && response.length() > 4 ) {
			return response;
		}
		return null;
	}
	
	private void enableStartUpload() {
		this.startUploadBtn.setEnabled(true);
		uploadPB.setVisible(true);
	}

}
