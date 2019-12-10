
package com.safeval.codeanalyzer.ws.analysis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="rrrId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vers" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fvers" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
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
    "rrrId",
    "vers",
    "fvers"
})
@XmlRootElement(name = "GetRobotRequest")
public class GetRobotRequest {

    protected String token;
    protected String rrrId;
    protected String vers;
    @XmlSchemaType(name = "unsignedInt")
    protected long fvers;

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
     * Obtém o valor da propriedade rrrId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRrrId() {
        return rrrId;
    }

    /**
     * Define o valor da propriedade rrrId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRrrId(String value) {
        this.rrrId = value;
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

    /**
     * Obtém o valor da propriedade fvers.
     * 
     */
    public long getFvers() {
        return fvers;
    }

    /**
     * Define o valor da propriedade fvers.
     * 
     */
    public void setFvers(long value) {
        this.fvers = value;
    }

}
