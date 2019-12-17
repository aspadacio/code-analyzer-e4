/**
 * 
 */
package com.safeval.codeanalyzer.wizards;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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

import com.safeval.codeanalyzer.persist.BufferPersist;
import com.safeval.codeanalyzer.persist.Persist;
import com.safeval.codeanalyzer.persist.ResultVul;
import com.safeval.codeanalyzer.util.SafevalUtil;
import com.safeval.codeanalyzer.ws.analysis.AnalysisServiceSoap;
import com.safeval.codeanalyzer.ws.transfer.TransferServiceSoap;

/**
 * @author Spadacio
 *
 */
public class AnalyseWP extends WizardPage {	
	private Composite container;
	Button startAnalysis;
	
	private String[] sharedValues;
	
	private AnalysisServiceSoap analysisService;
	private TransferServiceSoap transferService;

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
			wsdlUrlL = new URL(SafevalUtil.WS_SITE + "/Analysis/AnalysisService.asmx?WSDL");	    		
			QName analysisServiceQname = new QName(SafevalUtil.WS_NAMESPACE, "AnalysisService");
            
	        Service analysisServiceBase = Service.create(wsdlUrlL, analysisServiceQname);
	        analysisService = analysisServiceBase.getPort(new QName(SafevalUtil.WS_NAMESPACE, "AnalysisServiceSoap"), AnalysisServiceSoap.class); 
			
			resp = analysisService.startDirectCodeInspectionJob(
					String.valueOf(sharedValues[0]), //token
					"", 
					String.valueOf(sharedValues[2]), //Project Name 
					"", 
					"", 
					String.valueOf(sharedValues[1]), //MTAG
					0, 
					"D:\\mine\\private-projects\\ISA\\Teste-Case\\teste.java", 
					//"D:\\Java\\Eclipse-Workspaces\\wrokspace-commiters\\testes\\src\\testes\\Teste.java",
					//String.valueOf(sharedValues[4]),  
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
				System.out.println("Iniciando processo de análise....");
				showJobStatus(resp.substring(3));
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param jobId
	 */
	private void showJobStatus(String jobId) {
		System.out.println("Job criado e iniciado :: (Task=" + jobId + ")");
		String jobStatus = "";
		
		while(true) {
			try {
				TimeUnit.SECONDS.sleep(60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			jobStatus = analysisService.getJobStatus(sharedValues[0], jobId, 3, "3.0.39", 0x400001C);
			
			if (jobStatus.length() < 3 || !jobStatus.startsWith("OK:")) {
				System.out.println("Error getting job status.");				
				System.exit(-1);

			}
			
			String [] resx = jobStatus.split(":");
			if (resx.length > 2) {
                if (resx[1].equals("R")) {
                	String currentJobStepName = "N/D";                    			
                    if (resx.length > 4) {
                    	currentJobStepName = resx[4];                    	
                    }
                    System.out.println(currentJobStepName + ": " + resx[3]);
                }
                else if (resx[1].equals("E")) {
                	String currentJobError = "";
                    if (resx.length > 3) {
                    	currentJobError = resx[3];                    	
                    }
                    System.out.println("Error: " + currentJobError);		
                    break;
                }
                else if (resx[1].equals("C")) {
                	int currentJobNumVuls = 0;
                    if (resx.length > 3) {
                    	currentJobNumVuls = Integer.parseInt(resx[3]);                    	
                    }
                    System.out.println("Job concluded: " + currentJobNumVuls + " vulnerabilities found.");
                    System.out.println("Downloading result");
                    System.out.println("Token: " + String.valueOf(sharedValues[0]));
                    System.out.println("JobId: " + jobId);
                    System.out.println("MTAG: " + String.valueOf(sharedValues[1]));
                    System.out.println();
                    
                    String resResult = analysisService.getJobResult(String.valueOf(sharedValues[0]), jobId, 3, "3.0.39", 0x400001C);
                    
                    // Faz o download
                    String[] resPart = resResult.split(":");
                    if (resPart.length >= 4){
                    	String result = "";
                    	String tag = resPart[0];
                    	int npartes = Integer.parseInt(resPart[1]);
                    	int totsize = Integer.parseInt(resPart[2]);
                    	int blksize = 4000 * Integer.parseInt(resPart[3]);                    	
                    	int pos = 0;
                    	
                    	URL wsdlUrlL;
						try {
							wsdlUrlL = new URL(SafevalUtil.WS_SITE + "/DataTransfer/TransferService.asmx?WSDL");
							QName qnameL = new QName(SafevalUtil.WS_NAMESPACE, "TransferService");
	            			Service serviceL = Service.create(wsdlUrlL, qnameL);
	            			transferService = serviceL.getPort(new QName(SafevalUtil.WS_NAMESPACE, "TransferServiceSoap"),TransferServiceSoap.class);
						} catch (MalformedURLException e) {
							e.printStackTrace();
						}
                    	
                    	for(int i = 0; i < npartes; i++){
                    		String ped = "";
                    		if (i == npartes-1) {
                    			ped = transferService.download(String.valueOf(sharedValues[0]), tag, pos, totsize-pos, "3.0.39");                    			
                    		} else {
                    			ped = transferService.download(String.valueOf(sharedValues[0]), tag, pos, blksize, "3.0.39");                    			
                    		}
                    			
                    		pos += blksize;
                    		if (ped.startsWith("OK:")) {
                    			ped = ped.substring(3);                    			
                    		}
                    		result += ped;
                    	}
                    	
                    	// Agora pega os dados
                    	BufferPersist bp1 = new BufferPersist();
                    	BufferPersist bp = new BufferPersist();
        	            
        	            bp1.setBufferAsString(result);
        	            bp1.Rewind();
        	
        	            int vers = bp1.LoadInt();                    
        	            bp.setVersion(vers);
        	            if (vers > Persist.currentSafevalFileVers){
        	            	System.out.println("Server version is higher than mine, cannot understand its response. Please update the component.");				
        	            	break;
        	            }
        	            
        	            int nvul = bp1.LoadInt();
        	            ArrayList<ResultVul> vuls = new ArrayList<ResultVul> (); 
                    	for(int i = 0; i < nvul; i++ ) {
                    		ResultVul r = new ResultVul();
                    		r.Load(bp1);
                    		vuls.add(r);
                    		System.out.println(r.path + ", " + r.line + ": " + r.name);
                    	}
                    }
                    // Acabou
                    break;
                }
                else {
					System.out.println("Error. sts=" + jobStatus);		                	
                }
			}
		}
	}

}
