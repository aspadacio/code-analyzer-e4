package com.safeval.codeanalyzer.ws.transfer;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "TransferService", targetNamespace = "http://ws.isasecdev.com/", wsdlLocation = "https://isasecdev.com/DataTransfer/TransferService.asmx?wsdl")
public class TransferService
    extends Service
{

    private final static URL TRANSFERSERVICE_WSDL_LOCATION;
    private final static WebServiceException TRANSFERSERVICE_EXCEPTION;
    private final static QName TRANSFERSERVICE_QNAME = new QName("http://ws.isasecdev.com/", "TransferService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://isasecdev.com/DataTransfer/TransferService.asmx?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TRANSFERSERVICE_WSDL_LOCATION = url;
        TRANSFERSERVICE_EXCEPTION = e;
    }

    public TransferService() {
        super(__getWsdlLocation(), TRANSFERSERVICE_QNAME);
    }

    public TransferService(WebServiceFeature... features) {
        super(__getWsdlLocation(), TRANSFERSERVICE_QNAME, features);
    }

    public TransferService(URL wsdlLocation) {
        super(wsdlLocation, TRANSFERSERVICE_QNAME);
    }

    public TransferService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TRANSFERSERVICE_QNAME, features);
    }

    public TransferService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TransferService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns TransferServiceSoap
     */
    @WebEndpoint(name = "TransferServiceSoap")
    public TransferServiceSoap getTransferServiceSoap() {
        return super.getPort(new QName("http://ws.isasecdev.com/", "TransferServiceSoap"), TransferServiceSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TransferServiceSoap
     */
    @WebEndpoint(name = "TransferServiceSoap")
    public TransferServiceSoap getTransferServiceSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.isasecdev.com/", "TransferServiceSoap"), TransferServiceSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TRANSFERSERVICE_EXCEPTION!= null) {
            throw TRANSFERSERVICE_EXCEPTION;
        }
        return TRANSFERSERVICE_WSDL_LOCATION;
    }

}
