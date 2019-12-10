
package com.safeval.codeanalyzer.ws.analysis;

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
 *         &lt;element name="GetJobStatusResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getJobStatusResult"
})
@XmlRootElement(name = "GetJobStatusResponse")
public class GetJobStatusResponse {

    @XmlElement(name = "GetJobStatusResult")
    protected String getJobStatusResult;

    /**
     * Obtém o valor da propriedade getJobStatusResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetJobStatusResult() {
        return getJobStatusResult;
    }

    /**
     * Define o valor da propriedade getJobStatusResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetJobStatusResult(String value) {
        this.getJobStatusResult = value;
    }

}
