/**
 * 
 */
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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;

import com.safeval.codeanalyzer.ws.analysis.AnalysisServiceSoap;

/**
 * @author Spadacio
 *
 */
public class AnalyseWP extends WizardPage {

	private static String WS_URL = "https://isasecdev.com";
	private static String WS_NAMESPACE = "http://ws.isasecdev.com/";
	
	private Composite container;
	Button startAnalysis;
	
	private String[] sharedValues;
	
	private AnalysisServiceSoap analysisService;

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
		
		startAnalysis = new Button(this.container, SWT.PUSH);
		Font buttonFont = new Font(startAnalysis.getDisplay(), new FontData("Mono", 10, SWT.BOLD));
		startAnalysis.setFont(buttonFont);
		startAnalysis.setText("Start Analysis");
		
		GridData labelGridData = new GridData(SWT.BEGINNING, SWT.CENTER, true, true);
		infoLabel.setLayoutData(labelGridData);
		
		GridData progressGridData = new GridData(SWT.HORIZONTAL);
		progressGridData.heightHint = 40;
		uploadPB.setLayoutData(progressGridData);
		
		startAnalysis.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				StartCodeInspection();
			}
			
		});
		
		this.setControl(container);
		this.setPageComplete(false);
	}
	
	private void StartCodeInspection() {
		String resp = null;
		URL wsdlUrlL;
		
		try {
			wsdlUrlL = new URL(WS_URL + "/Analysis/AnalysisService.asmx?WSDL");	    		
			QName analysisServiceQname = new QName("http://ws.isasecdev.com/", "AnalysisService");
            
	        Service analysisServiceBase = Service.create(wsdlUrlL, analysisServiceQname);
	        analysisService = analysisServiceBase.getPort(new QName(WS_NAMESPACE, "AnalysisServiceSoap"), AnalysisServiceSoap.class); 
			
			resp = analysisService.startDirectCodeInspectionJob(
					String.valueOf(sharedValues[0]), //token
					"", 
					"Teste", //sharedValues[2], 
					"", 
					"", 
					String.valueOf(sharedValues[1]), //MTAG
					0, 
					"D:\\Java\\Eclipse-Workspaces\\wrokspace-commiters\\testes\\src\\testes\\Teste.java", 
					"", 
					16, 
					"*.*", 
					1, 
					1,
					1, 
					1,
					0, 
					0, 
					"3.0.39", 
					0x400001C
					);
			
			if( resp != null && resp.length() > 5 ) {
				this.setPageComplete(true);
				System.out.println("Analisando....");
				
				showJobStatus(resp.substring(3));
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param jobId
	 */
	private void showJobStatus(String jobId) {
		System.out.println("Job criado e iniciado. (Task=" + jobId + ")");	
		
		String jobStatus = analysisService.getJobStatus(sharedValues[0], jobId, 3, "3.0.39", 0x400001C);
		System.out.println(jobStatus);
	}

}
