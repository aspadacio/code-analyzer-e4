
package com.safeval.codeanalyzer.ws.analysis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetAnalysisListResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getAnalysisListResult"
})
@XmlRootElement(name = "GetAnalysisListResponse")
public class GetAnalysisListResponse {

    @XmlElement(name = "GetAnalysisListResult")
    protected String getAnalysisListResult;

    /**
     * Obt�m o valor da propriedade getAnalysisListResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetAnalysisListResult() {
        return getAnalysisListResult;
    }

    /**
     * Define o valor da propriedade getAnalysisListResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetAnalysisListResult(String value) {
        this.getAnalysisListResult = value;
    }

}
