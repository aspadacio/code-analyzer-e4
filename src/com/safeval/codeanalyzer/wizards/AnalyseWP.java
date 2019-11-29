/**
 * 
 */
package com.safeval.codeanalyzer.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;

/**
 * @author Spadacio
 *
 */
public class AnalyseWP extends WizardPage {

	private static String WS_URL = "https://isasecdev.com";
	
	private Composite container;
	private String[] sharedValues;

	public AnalyseWP(String[] sharedValues) {
		super("Análise do código");
		setTitle("Análise do código");
		setDescription("Realizando a análise de vulnerabilidade do projeto");
		this.sharedValues = sharedValues;
	}

	@Override
	public void createControl(Composite parent) {
		GridLayout layout = new GridLayout(1, false);
		layout.marginWidth = 80;
		
		this.container = new Composite(parent, SWT.NONE);
		this.container.setLayout(layout);
		
		Label infoLabel = new Label(this.container, SWT.SINGLE);
		Font userNameLblFont = new Font(infoLabel.getDisplay(), new FontData("Mono", 10, SWT.BOLD));
		infoLabel.setFont(userNameLblFont);
		infoLabel.setText("Progresso da anãlise");
		
		ProgressBar uploadPB = new ProgressBar(container, SWT.NONE);
		uploadPB.setSelection(1); //Percentage of progress
		
		new Label(container, SWT.NONE); //Empty
		new Label(container, SWT.NONE); //Empty
		new Label(container, SWT.NONE); //Empty
		new Label(container, SWT.NONE); //Empty
		
		GridData labelGridData = new GridData(SWT.BEGINNING, SWT.CENTER, true, true);
		infoLabel.setLayoutData(labelGridData);
		
		GridData progressGridData = new GridData(SWT.HORIZONTAL);
		progressGridData.heightHint = 40;
		uploadPB.setLayoutData(progressGridData);
		
		this.setControl(container);
		this.setPageComplete(false);
	}

}
