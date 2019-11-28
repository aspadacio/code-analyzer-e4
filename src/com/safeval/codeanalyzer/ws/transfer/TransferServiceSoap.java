package com.safeval.codeanalyzer.ws.transfer;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "TransferServiceSoap", targetNamespace = "http://isasecdev.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TransferServiceSoap {


    /**
     * 
     * @param vers
     * @param token
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "StartUpload", action = "http://isasecdev.com/StartUpload")
    @WebResult(name = "StartUploadResult", targetNamespace = "http://isasecdev.com/")
    @RequestWrapper(localName = "StartUpload", targetNamespace = "http://isasecdev.com/", className = "com.isasecdev.StartUpload")
    @ResponseWrapper(localName = "StartUploadResponse", targetNamespace = "http://isasecdev.com/", className = "com.isasecdev.StartUploadResponse")
    public String startUpload(
        @WebParam(name = "token", targetNamespace = "http://isasecdev.com/")
        String token,
        @WebParam(name = "vers", targetNamespace = "http://isasecdev.com/")
        String vers);

    /**
     * 
     * @param pos
     * @param vers
     * @param tag
     * @param buffer
     * @param token
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "Upload", action = "http://isasecdev.com/Upload")
    @WebResult(name = "UploadResult", targetNamespace = "http://isasecdev.com/")
    @RequestWrapper(localName = "Upload", targetNamespace = "http://isasecdev.com/", className = "com.isasecdev.Upload")
    @ResponseWrapper(localName = "UploadResponse", targetNamespace = "http://isasecdev.com/", className = "com.isasecdev.UploadResponse")
    public String upload(
        @WebParam(name = "token", targetNamespace = "http://isasecdev.com/")
        String token,
        @WebParam(name = "tag", targetNamespace = "http://isasecdev.com/")
        String tag,
        @WebParam(name = "pos", targetNamespace = "http://isasecdev.com/")
        int pos,
        @WebParam(name = "buffer", targetNamespace = "http://isasecdev.com/")
        String buffer,
        @WebParam(name = "vers", targetNamespace = "http://isasecdev.com/")
        String vers);

    /**
     * 
     * @param size
     * @param pos
     * @param vers
     * @param tag
     * @param token
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "Download", action = "http://isasecdev.com/Download")
    @WebResult(name = "DownloadResult", targetNamespace = "http://isasecdev.com/")
    @RequestWrapper(localName = "Download", targetNamespace = "http://isasecdev.com/", className = "com.isasecdev.Download")
    @ResponseWrapper(localName = "DownloadResponse", targetNamespace = "http://isasecdev.com/", className = "com.isasecdev.DownloadResponse")
    public String download(
        @WebParam(name = "token", targetNamespace = "http://isasecdev.com/")
        String token,
        @WebParam(name = "tag", targetNamespace = "http://isasecdev.com/")
        String tag,
        @WebParam(name = "pos", targetNamespace = "http://isasecdev.com/")
        int pos,
        @WebParam(name = "size", targetNamespace = "http://isasecdev.com/")
        int size,
        @WebParam(name = "vers", targetNamespace = "http://isasecdev.com/")
        String vers);

    /**
     * 
     * @param vers
     * @param tag
     * @param token
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "EndDownload", action = "http://isasecdev.com/EndDownload")
    @WebResult(name = "EndDownloadResult", targetNamespace = "http://isasecdev.com/")
    @RequestWrapper(localName = "EndDownload", targetNamespace = "http://isasecdev.com/", className = "com.isasecdev.EndDownload")
    @ResponseWrapper(localName = "EndDownloadResponse", targetNamespace = "http://isasecdev.com/", className = "com.isasecdev.EndDownloadResponse")
    public String endDownload(
        @WebParam(name = "token", targetNamespace = "http://isasecdev.com/")
        String token,
        @WebParam(name = "tag", targetNamespace = "http://isasecdev.com/")
        String tag,
        @WebParam(name = "vers", targetNamespace = "http://isasecdev.com/")
        String vers);

}
