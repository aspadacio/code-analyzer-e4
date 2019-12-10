
package com.safeval.codeanalyzer.ws.analysis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tskId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sts" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="percdone" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="vers" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "token",
    "tskId",
    "sts",
    "percdone",
    "vers"
})
@XmlRootElement(name = "UpdateRobotTaskStatus")
public class UpdateRobotTaskStatus {

    protected String token;
    protected String tskId;
    protected int sts;
    protected double percdone;
    protected String vers;

    /**
     * Obtém o valor da propriedade token.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Define o valor da propriedade token.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * Obtém o valor da propriedade tskId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTskId() {
        return tskId;
    }

    /**
     * Define o valor da propriedade tskId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTskId(String value) {
        this.tskId = value;
    }

    /**
     * Obtém o valor da propriedade sts.
     * 
     */
    public int getSts() {
        return sts;
    }

    /**
     * Define o valor da propriedade sts.
     * 
     */
    public void setSts(int value) {
        this.sts = value;
    }

    /**
     * Obtém o valor da propriedade percdone.
     * 
     */
    public double getPercdone() {
        return percdone;
    }

    /**
     * Define o valor da propriedade percdone.
     * 
     */
    public void setPercdone(double value) {
        this.percdone = value;
    }

    /**
     * Obtém o valor da propriedade vers.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVers() {
        return vers;
    }

    /**
     * Define o valor da propriedade vers.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVers(String value) {
        this.vers = value;
    }

}
