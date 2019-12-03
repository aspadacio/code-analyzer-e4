package com.safeval.codeanalyzer.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import com.safeval.codeanalyzer.views.ExploreFilesVulnerabilitiesView;

/**
 * @author Spadacio
 *
 */
public class CodeAnalyzerHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		
		/*
		 * MessageDialog.openInformation( window.getShell(), "Safeval - Code Analizer",
		 * "Analizar Código Fonte");
		 */
		
		/*
		 * WizardDialog authWizardDialog = new WizardDialog(window.getShell(), new
		 * CodeAnalyzerWizard()); authWizardDialog.open();
		 */
		
		try {
			ExploreFilesVulnerabilitiesView filesVulView = (ExploreFilesVulnerabilitiesView) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
					.showView("com.safeval.codeanalyzer.views.ExploreFilesVulnerabilitiesView");
			filesVulView.setFilesVulnerabilities("D:/Java/Eclipse-Workspaces/wrokspace-commiters/testes/src/testes/Teste.java", 13);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
