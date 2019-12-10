
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
 *         &lt;element name="StartScheduledJobResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "startScheduledJobResult"
})
@XmlRootElement(name = "StartScheduledJobResponse")
public class StartScheduledJobResponse {

    @XmlElement(name = "StartScheduledJobResult")
    protected String startScheduledJobResult;

    /**
     * Obtém o valor da propriedade startScheduledJobResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartScheduledJobResult() {
        return startScheduledJobResult;
    }

    /**
     * Define o valor da propriedade startScheduledJobResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartScheduledJobResult(String value) {
        this.startScheduledJobResult = value;
    }

}
