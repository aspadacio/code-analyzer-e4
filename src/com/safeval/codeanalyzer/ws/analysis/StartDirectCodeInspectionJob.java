
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
 *         &lt;element name="tag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="format" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="filename" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codeLanguageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numberOfLines" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fileMask" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="minAssr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="minSevr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="minProb" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ignoreLib" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="diferentialAnalysis" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="keepVuln" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "tag",
    "format",
    "filename",
    "codeLanguageId",
    "numberOfLines",
    "fileMask",
    "minAssr",
    "minSevr",
    "minProb",
    "ignoreLib",
    "diferentialAnalysis",
    "keepVuln",
    "vers",
    "fvers"
})
@XmlRootElement(name = "StartDirectCodeInspectionJob")
public class StartDirectCodeInspectionJob {

    protected String token;
    protected String organization;
    protected String name;
    protected String system;
    protected String module;
    protected String tag;
    protected int format;
    protected String filename;
    protected String codeLanguageId;
    protected int numberOfLines;
    protected String fileMask;
    protected int minAssr;
    protected int minSevr;
    protected int minProb;
    protected int ignoreLib;
    protected int diferentialAnalysis;
    protected int keepVuln;
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
     * Obtém o valor da propriedade tag.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTag() {
        return tag;
    }

    /**
     * Define o valor da propriedade tag.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTag(String value) {
        this.tag = value;
    }

    /**
     * Obtém o valor da propriedade format.
     * 
     */
    public int getFormat() {
        return format;
    }

    /**
     * Define o valor da propriedade format.
     * 
     */
    public void setFormat(int value) {
        this.format = value;
    }

    /**
     * Obtém o valor da propriedade filename.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Define o valor da propriedade filename.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilename(String value) {
        this.filename = value;
    }

    /**
     * Obtém o valor da propriedade codeLanguageId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeLanguageId() {
        return codeLanguageId;
    }

    /**
     * Define o valor da propriedade codeLanguageId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeLanguageId(String value) {
        this.codeLanguageId = value;
    }

    /**
     * Obtém o valor da propriedade numberOfLines.
     * 
     */
    public int getNumberOfLines() {
        return numberOfLines;
    }

    /**
     * Define o valor da propriedade numberOfLines.
     * 
     */
    public void setNumberOfLines(int value) {
        this.numberOfLines = value;
    }

    /**
     * Obtém o valor da propriedade fileMask.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileMask() {
        return fileMask;
    }

    /**
     * Define o valor da propriedade fileMask.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileMask(String value) {
        this.fileMask = value;
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
     * Obtém o valor da propriedade ignoreLib.
     * 
     */
    public int getIgnoreLib() {
        return ignoreLib;
    }

    /**
     * Define o valor da propriedade ignoreLib.
     * 
     */
    public void setIgnoreLib(int value) {
        this.ignoreLib = value;
    }

    /**
     * Obtém o valor da propriedade diferentialAnalysis.
     * 
     */
    public int getDiferentialAnalysis() {
        return diferentialAnalysis;
    }

    /**
     * Define o valor da propriedade diferentialAnalysis.
     * 
     */
    public void setDiferentialAnalysis(int value) {
        this.diferentialAnalysis = value;
    }

    /**
     * Obtém o valor da propriedade keepVuln.
     * 
     */
    public int getKeepVuln() {
        return keepVuln;
    }

    /**
     * Define o valor da propriedade keepVuln.
     * 
     */
    public void setKeepVuln(int value) {
        this.keepVuln = value;
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
