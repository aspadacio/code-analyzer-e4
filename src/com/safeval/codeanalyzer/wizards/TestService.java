/**
 * 
 */
package com.safeval.codeanalyzer.wizards;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.safeval.codeanalyzer.persist.BufferPersist;
import com.safeval.codeanalyzer.persist.ResultVul;
import com.safeval.codeanalyzer.ws.analysis.AnalysisServiceSoap;
import com.safeval.codeanalyzer.ws.transfer.TransferServiceSoap;

/**
 * @author Spadacio
 *
 */
public class TestService {

	private static String WS_URL = "https://isasecdev.com";
	
	private static TransferServiceSoap transferService;
	private static AnalysisServiceSoap analysisService;
	
	public static void main(String[] args) {
		URL wsdlUrlL;
		
		try {
			wsdlUrlL = new URL(WS_URL + "/Analysis/AnalysisService.asmx?WSDL");	    		
			QName analysisServiceQname = new QName("http://ws.isasecdev.com/", "AnalysisService");
            
	        Service analysisServiceBase = Service.create(wsdlUrlL, analysisServiceQname);
	        analysisService = analysisServiceBase.getPort(new QName("http://ws.isasecdev.com/", "AnalysisServiceSoap"), AnalysisServiceSoap.class); 
			
			wsdlUrlL = new URL(WS_URL + "/DataTransfer/TransferService.asmx?WSDL");
			QName qnameL = new QName("http://ws.isasecdev.com/", "TransferService");
			
			Service serviceL = Service.create(wsdlUrlL, qnameL);
			transferService = serviceL.getPort(new QName("http://ws.isasecdev.com/", "TransferServiceSoap"),TransferServiceSoap.class);
			
			String resResult = analysisService.getJobResult("NDfZGFTCkQb0g24CsDKFRIDpMi1Lg2UxnhyKx1S4VUVrGGOSvnnbElefZPn8pi7I", "098302a1-03ab-4897-b350-b0b29b795f9d", 3, "3.0.39", 0x400001C);
            String[] resPart = resResult.split(":");
			
			String result = "";
			
        	String tag = resPart[0];
        	int npartes = Integer.parseInt(resPart[1]);
        	int totsize = Integer.parseInt(resPart[2]);
        	int blksize = 4000 * Integer.parseInt(resPart[3]);                    	
        	int pos = 0;
			
			for(int i = 0; i < npartes; i++){
        		String ped = "";
        		if (i == npartes-1) {
        			ped = transferService.download("NDfZGFTCkQb0g24CsDKFRIDpMi1Lg2UxnhyKx1S4VUVrGGOSvnnbElefZPn8pi7I", tag, pos, totsize-pos, "3.0.39");                    			
        		} else {
        			ped = transferService.download("NDfZGFTCkQb0g24CsDKFRIDpMi1Lg2UxnhyKx1S4VUVrGGOSvnnbElefZPn8pi7I", tag, pos, blksize, "3.0.39");                    			
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
            
            int nvul = bp1.LoadInt();
            ArrayList<ResultVul> vuls = new ArrayList<ResultVul> (); 
        	for(int i = 0; i < nvul; i++ ) {
        		ResultVul r = new ResultVul();
        		r.Load(bp1);
        		vuls.add(r);
        		System.out.println(r.path + ", " + r.line + ": " + r.name);
        	}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
