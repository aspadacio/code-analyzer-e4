package com.safeval.codeanalyzer.wizards;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.safeval.codeanalyzer.persist.BufferPersist;
import com.safeval.codeanalyzer.persist.Persist;
import com.safeval.codeanalyzer.ws.login.LoginServiceSoap;


/**
 * Wizard Page that provides form to do authentication
 * @author Spadacio
 *
 */
public class AuthWP extends WizardPage {
	
	private static String WS_URL = "https://isasecdev.com";
	
	private Composite container;
	
	public AuthWP() {
		super("Autenticação");
		setTitle("Autenticação");
		setDescription("Forneça as credencias para autenticação");
	}

	@Override
	public void createControl(Composite parent) {
		GridLayout layout = new GridLayout(1, false);
		layout.marginWidth = 120;
		
		this.container = new Composite(parent, SWT.BORDER);
		this.container.setLayout(layout);
		
		//Username
		Label userNameLabel = new Label(this.container, SWT.SINGLE);
		Font userNameLblFont = new Font(userNameLabel.getDisplay(), new FontData("Mono", 10, SWT.BOLD));
		userNameLabel.setFont(userNameLblFont);
		userNameLabel.setText("Usuário");
		
		Text userNameText = new Text(this.container, SWT.BORDER);
		userNameText.setText(new String());
		
		//Password
		Label passwordLabel = new Label(this.container, SWT.SINGLE);
		Font passwordLblFont = new Font(passwordLabel.getDisplay(), new FontData("Mono", 10, SWT.BOLD));
		passwordLabel.setFont(passwordLblFont);
		passwordLabel.setText("Senha");
		
		Text passwordText = new Text(this.container, SWT.BORDER);
		passwordText.setText(new String());
		
		//Groups
		Group messagesGrup = new Group(this.container, SWT.NONE);
		RowLayout messageRowLayout = new RowLayout(SWT.HORIZONTAL);
		messageRowLayout.center = true;
		messagesGrup.setLayout(messageRowLayout);	    
		
		//Messages
		Label successLoginLB = new Label(messagesGrup, SWT.CENTER);
		Font successLoginFont = new Font(successLoginLB.getDisplay(), new FontData("Mono", 11, SWT.BOLD));
		successLoginLB.setFont(successLoginFont);
		successLoginLB.setText("Usuário autenticado!!!");
		successLoginLB.setForeground(parent.getDisplay().getSystemColor(SWT.COLOR_DARK_GREEN));
		successLoginLB.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		successLoginLB.setVisible(false);
		
		Label failLoginLB = new Label(messagesGrup, SWT.CENTER);
		Font failLoginFont = new Font(failLoginLB.getDisplay(), new FontData("Mono", 11, SWT.BOLD));
		failLoginLB.setFont(failLoginFont);
		failLoginLB.setText("Erro ao autenticar");
		failLoginLB.setForeground(parent.getDisplay().getSystemColor(SWT.COLOR_DARK_RED));
		failLoginLB.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		failLoginLB.setVisible(false);
		 
		//Login Button
		Button loginButton = new Button(this.container, SWT.PUSH);
		Font loginBtnFont = new Font(loginButton.getDisplay(), new FontData("Mono", 10, SWT.BOLD));
		loginButton.setFont(loginBtnFont);
		loginButton.setText("Login");
		
		//Set Layouts for fields
		GridData gridData2Label = new GridData(SWT.BEGINNING, SWT.CENTER, true, true);
		gridData2Label.widthHint = 100;
		userNameLabel.setLayoutData(gridData2Label);
		passwordLabel.setLayoutData(gridData2Label);
		
		GridData gridData2Text = new GridData(SWT.FILL, SWT.CENTER, true, true);
		gridData2Text.heightHint = 20;
		userNameText.setLayoutData(gridData2Text); 
		passwordText.setLayoutData(gridData2Text);
		
		GridData btnsFooterLayout = new GridData(SWT.HORIZONTAL);
		loginButton.setLayoutData(btnsFooterLayout);
		
		//Listeners
		loginButton.addSelectionListener(new SelectionAdapter() {
			@SuppressWarnings("unused")
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				
				//call login SOAP services and do authentication
				try {
					URL wsdlUrlL = new URL(WS_URL + "/Login/LoginService.asmx?WSDL");
					QName qnameL = new QName("http://isasecdev.com/", "LoginService");
					
			        Service serviceL = Service.create(wsdlUrlL, qnameL);
			        LoginServiceSoap soapL = serviceL.getPort(new QName("http://isasecdev.com/", "LoginServiceSoap"),LoginServiceSoap.class);

			        String login = userNameText.getText();
			        String password = passwordText.getText();
			        
			        String resLogin = soapL.login(login, password, "3.0.39", 0x400001C);
			        
			        if( resLogin.length() > 5 ) {
			        	BufferPersist bp = new BufferPersist();
	                    
	                    bp.setBufferAsString(resLogin);
	                    bp.Rewind();
	                    
	                    int magic = bp.LoadInt(); 
	                    int vers = bp.LoadInt();                 
	                    bp.setVersion(vers);
	                    if (vers > Persist.currentSafevalFileVers)
	                    {
	                    	System.out.println("Versão do resultado é mais nova que consigo compreender. Por favor, verifique no site uma atualização para esse sistema.");
	                    }
	                    
	                    String code = bp.LoadString();
	                    int message = bp.LoadInt();
	                    String token = bp.LoadString();
	                    
	                    if(token != null) {
	                    	System.out.println("Usuário atenticado com sucesso :: token :: " + token);
	                    	setPageComplete(true);
	                    	successLoginLB.setVisible(true);
	                    	parent.getShell().layout(false);

	                    	// TODO call next page to select project, but save the Token
	                    }
			        }else {
			        	failLoginLB.setVisible(true);
                    	parent.getShell().layout(false);
			        }
					
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}				
			}
		});
		
		this.setControl(container);
		this.setPageComplete(false);
	}

}
