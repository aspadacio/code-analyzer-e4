package com.safeval.codeanalyzer.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * Wizard Page that provides form to choose a project/file(s)
 * @author Spadacio
 *
 */
public class SelectProjectWP extends WizardPage {
	
	private Composite container;
	
	public SelectProjectWP() {
		super("Escolha o Projeto");
		setTitle("Escolha o Projeto");
		setDescription("Escolha qual projeto será analizado");
	}

	@Override
	public void createControl(Composite parent) {
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		
		this.container = new Composite(parent, SWT.NONE);
		this.container.setLayout(layout);
		
		//Username
		Label userNameLabel = new Label(this.container, SWT.NONE);
		userNameLabel.setText("Usuário");
		
		Text userNameText = new Text(this.container, SWT.BORDER | SWT.SINGLE);
		userNameText.setText("");
		
		//Password
		Label passwordLabel = new Label(this.container, SWT.NONE);
		passwordLabel.setText("Senha");
		
		Text passwordText = new Text(this.container, SWT.BORDER | SWT.SINGLE);
		passwordText.setText("");
		
		
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		
		userNameText.setLayoutData(gridData);
		passwordText.setLayoutData(gridData);
		
		this.setControl(container);
		this.setPageComplete(false);
	}

}
