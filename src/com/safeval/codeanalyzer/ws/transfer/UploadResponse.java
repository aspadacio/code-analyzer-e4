package com.safeval.codeanalyzer.ws.transfer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UploadResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "uploadResult"
})
@XmlRootElement(name = "UploadResponse")
public class UploadResponse {

    @XmlElement(name = "UploadResult")
    protected String uploadResult;

    /**
     * Obtém o valor da propriedade uploadResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUploadResult() {
        return uploadResult;
    }

    /**
     * Define o valor da propriedade uploadResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUploadResult(String value) {
        this.uploadResult = value;
    }

}
