package com.safeval.codeanalyzer.wizards;

import org.eclipse.jface.wizard.Wizard;

/**
 * Main Wizard to set and config Code Analyzer process
 * @author Spadacio
 *
 */
public class CodeAnalyzerWizard extends Wizard {
	
	/*
	 * 1. Token
	 * 2. MPT Tag 
	 **/
	String sharedValues[];
	
	//Pages
	protected AuthWP authWizardPage;
	protected SelectProjectWP selectProjectWP;
	protected AnalyseWP analyseWP;
	
	public CodeAnalyzerWizard() {
		super();
		this.setWindowTitle("Safeval - Code Analyzer");
		
		this.sharedValues = new String[3];
		this.authWizardPage = new AuthWP(sharedValues);
		this.selectProjectWP = new SelectProjectWP(sharedValues);
		this.analyseWP = new AnalyseWP(sharedValues);
		
		this.addPage(this.authWizardPage);
		this.addPage(this.selectProjectWP);
		this.addPage(this.analyseWP);
	}

	@Override
	public boolean performFinish() {
		System.out.println("Finalizando análise...");
		return false;
	}

}
