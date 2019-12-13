package com.safeval.codeanalyzer.wizards;

import org.eclipse.jface.wizard.Wizard;

/**
 * Main Wizard to set and config Code Analyzer process
 * @author Spadacio
 *
 */
public class CodeAnalyzerWizard extends Wizard {
	
	/*
	 * 0. Token
	 * 1. MPT Tag
	 * 2. Directory / File / SVN / GIT name (Project Name)
	 * 3. File(s) total bytes length 
	 **/
	String sharedValues[];
	
	//Pages
	protected AuthWP authWizardPage;
	protected SelectProjectWP selectProjectWP;
	protected AnalyseWP analyseWP;
	
	public CodeAnalyzerWizard() {
		super();
		this.setWindowTitle("Safeval - Code Analyzer");
		
		this.sharedValues = new String[4];
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
