package com.safeval.codeanalyzer.wizards;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;

/**
 * Main Wizard to set and config Code Analyzer process
 * @author Spadacio
 *
 */
public class CodeAnalyzerWizard extends Wizard {
	
	//Pages
	protected AuthWP authWizardPage;
	protected SelectProjectWP selectProjectWP;
	
	public CodeAnalyzerWizard() {
		super();
		this.setWindowTitle("Safeval - Code Analyzer");
		
		this.authWizardPage = new AuthWP();
		this.selectProjectWP = new SelectProjectWP();
		
		this.addPage(this.authWizardPage);
		this.addPage(this.selectProjectWP);
	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		return super.getNextPage(page);
	}

	@Override
	public boolean performFinish() {
		
		System.out.println(this.authWizardPage.getTitle());
		System.out.println(this.selectProjectWP.getTitle());
		
		return false;
	}

}
