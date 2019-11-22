package com.safeval.codeanalyzer.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.safeval.codeanalyzer.wizards.CodeAnalyzerWizard;

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
		
		WizardDialog authWizardDialog = new WizardDialog(window.getShell(), new CodeAnalyzerWizard());
		authWizardDialog.open();
		
		return null;
	}
}
