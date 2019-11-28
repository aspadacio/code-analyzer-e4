package com.safeval.codeanalyzer.ws.transfer;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.isasecdev package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.isasecdev
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UploadResponse }
     * 
     */
    public UploadResponse createUploadResponse() {
        return new UploadResponse();
    }

    /**
     * Create an instance of {@link EndDownload }
     * 
     */
    public EndDownload createEndDownload() {
        return new EndDownload();
    }

    /**
     * Create an instance of {@link Upload }
     * 
     */
    public Upload createUpload() {
        return new Upload();
    }

    /**
     * Create an instance of {@link DownloadResponse }
     * 
     */
    public DownloadResponse createDownloadResponse() {
        return new DownloadResponse();
    }

    /**
     * Create an instance of {@link StartUploadResponse }
     * 
     */
    public StartUploadResponse createStartUploadResponse() {
        return new StartUploadResponse();
    }

    /**
     * Create an instance of {@link Download }
     * 
     */
    public Download createDownload() {
        return new Download();
    }

    /**
     * Create an instance of {@link EndDownloadResponse }
     * 
     */
    public EndDownloadResponse createEndDownloadResponse() {
        return new EndDownloadResponse();
    }

    /**
     * Create an instance of {@link StartUpload }
     * 
     */
    public StartUpload createStartUpload() {
        return new StartUpload();
    }

}
