
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
 *         &lt;element name="organization" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="system" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="module" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="penetrationTestId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="scope" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxPage" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxLevel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxTest" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="copyCrawlId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="keepTentative" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sendData" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="minAssr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="minSevr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="minProb" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "organization",
    "name",
    "system",
    "module",
    "penetrationTestId",
    "url",
    "scope",
    "maxPage",
    "maxLevel",
    "maxTest",
    "copyCrawlId",
    "keepTentative",
    "sendData",
    "minAssr",
    "minSevr",
    "minProb",
    "vers",
    "fvers"
})
@XmlRootElement(name = "CreatePenetrationTestJob")
public class CreatePenetrationTestJob {

    protected String token;
    protected String organization;
    protected String name;
    protected String system;
    protected String module;
    protected String penetrationTestId;
    protected String url;
    protected int scope;
    protected int maxPage;
    protected int maxLevel;
    protected int maxTest;
    protected String copyCrawlId;
    protected int keepTentative;
    protected int sendData;
    protected int minAssr;
    protected int minSevr;
    protected int minProb;
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
     * Obtém o valor da propriedade organization.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * Define o valor da propriedade organization.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganization(String value) {
        this.organization = value;
    }

    /**
     * Obtém o valor da propriedade name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define o valor da propriedade name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtém o valor da propriedade system.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystem() {
        return system;
    }

    /**
     * Define o valor da propriedade system.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystem(String value) {
        this.system = value;
    }

    /**
     * Obtém o valor da propriedade module.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModule() {
        return module;
    }

    /**
     * Define o valor da propriedade module.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModule(String value) {
        this.module = value;
    }

    /**
     * Obtém o valor da propriedade penetrationTestId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPenetrationTestId() {
        return penetrationTestId;
    }

    /**
     * Define o valor da propriedade penetrationTestId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPenetrationTestId(String value) {
        this.penetrationTestId = value;
    }

    /**
     * Obtém o valor da propriedade url.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Define o valor da propriedade url.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Obtém o valor da propriedade scope.
     * 
     */
    public int getScope() {
        return scope;
    }

    /**
     * Define o valor da propriedade scope.
     * 
     */
    public void setScope(int value) {
        this.scope = value;
    }

    /**
     * Obtém o valor da propriedade maxPage.
     * 
     */
    public int getMaxPage() {
        return maxPage;
    }

    /**
     * Define o valor da propriedade maxPage.
     * 
     */
    public void setMaxPage(int value) {
        this.maxPage = value;
    }

    /**
     * Obtém o valor da propriedade maxLevel.
     * 
     */
    public int getMaxLevel() {
        return maxLevel;
    }

    /**
     * Define o valor da propriedade maxLevel.
     * 
     */
    public void setMaxLevel(int value) {
        this.maxLevel = value;
    }

    /**
     * Obtém o valor da propriedade maxTest.
     * 
     */
    public int getMaxTest() {
        return maxTest;
    }

    /**
     * Define o valor da propriedade maxTest.
     * 
     */
    public void setMaxTest(int value) {
        this.maxTest = value;
    }

    /**
     * Obtém o valor da propriedade copyCrawlId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCopyCrawlId() {
        return copyCrawlId;
    }

    /**
     * Define o valor da propriedade copyCrawlId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCopyCrawlId(String value) {
        this.copyCrawlId = value;
    }

    /**
     * Obtém o valor da propriedade keepTentative.
     * 
     */
    public int getKeepTentative() {
        return keepTentative;
    }

    /**
     * Define o valor da propriedade keepTentative.
     * 
     */
    public void setKeepTentative(int value) {
        this.keepTentative = value;
    }

    /**
     * Obtém o valor da propriedade sendData.
     * 
     */
    public int getSendData() {
        return sendData;
    }

    /**
     * Define o valor da propriedade sendData.
     * 
     */
    public void setSendData(int value) {
        this.sendData = value;
    }

    /**
     * Obtém o valor da propriedade minAssr.
     * 
     */
    public int getMinAssr() {
        return minAssr;
    }

    /**
     * Define o valor da propriedade minAssr.
     * 
     */
    public void setMinAssr(int value) {
        this.minAssr = value;
    }

    /**
     * Obtém o valor da propriedade minSevr.
     * 
     */
    public int getMinSevr() {
        return minSevr;
    }

    /**
     * Define o valor da propriedade minSevr.
     * 
     */
    public void setMinSevr(int value) {
        this.minSevr = value;
    }

    /**
     * Obtém o valor da propriedade minProb.
     * 
     */
    public int getMinProb() {
        return minProb;
    }

    /**
     * Define o valor da propriedade minProb.
     * 
     */
    public void setMinProb(int value) {
        this.minProb = value;
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
