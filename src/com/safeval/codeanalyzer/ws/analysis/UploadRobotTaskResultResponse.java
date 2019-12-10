
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
 *         &lt;element name="UploadRobotTaskResultResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "uploadRobotTaskResultResult"
})
@XmlRootElement(name = "UploadRobotTaskResultResponse")
public class UploadRobotTaskResultResponse {

    @XmlElement(name = "UploadRobotTaskResultResult")
    protected String uploadRobotTaskResultResult;

    /**
     * Obtém o valor da propriedade uploadRobotTaskResultResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUploadRobotTaskResultResult() {
        return uploadRobotTaskResultResult;
    }

    /**
     * Define o valor da propriedade uploadRobotTaskResultResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUploadRobotTaskResultResult(String value) {
        this.uploadRobotTaskResultResult = value;
    }

}
