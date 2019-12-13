package com.safeval.codeanalyzer.persist;

public class ResultVul {
	
    /// <summary>
    /// Id de propriedade da analise
    /// </summary>
    public String id;

    /// <summary>
    /// Tipo de ponto vulnerável
    /// </summary>
    public int type;

    /// <summary>
    /// Vulerability number
    /// </summary>
    public int number;

    /// <summary>
    /// Severidade
    /// </summary>
    public int severity;

    /// <summary>
    /// Probabilidade
    /// </summary>
    public int probability;

    /// <summary>
    /// Garantia
    /// </summary>
    public int assurance;

    /// <summary>
    /// Prioridade
    /// </summary>
    public int priority;

    /// <summary>
    /// Status da vulnerabilidade de código
    /// </summary>
    public int status;

    /// <summary>
    /// Nome da vulnerabilidade
    /// </summary>
    public String name;

    /// <summary>
    /// Descrição da vulnerabilidade
    /// </summary>
    public String description;

    /// <summary>
    /// Recomendação da vulnerabilidade
    /// </summary>
    public String recommendation;

    /// <summary>
    /// Fonte original
    /// </summary>
    public String source;

    /// <summary>
    /// CVE
    /// </summary>
    public String cve;

    /// <summary>
    /// CWE
    /// </summary>
    public String cwe;

    /// <summary>
    /// OSVDB
    /// </summary>
    public String osvdb;

    /// <summary>
    /// CVSSv2
    /// </summary>
    public String cvssv2;

    /// <summary>
    /// Caminho do arquivo
    /// </summary>
    public String path;

    /// <summary>
    /// Linha do arquivo
    /// </summary>
    public int line;

    /// <summary>
    /// Cria vazio
    /// </summary>
    public ResultVul()
    {

        id = "";
        type = 0;
        number = 0;
        severity = 0;
        probability = 0;
        assurance = 0;
        priority = 0;
        status = 0;
        name = "";
        description = "";
        recommendation = "";
        source = "";
        cve = "";
        cwe = "";
        osvdb = "";
        cvssv2 = "";
        path = "";
        line = 0;

    }

    /// <summary>
    /// Persistência de LinearPersistLibrary
    /// </summary>
    /// <param name="data"></param>
    public void Load(Persist data)
    {

    	id = data.LoadString();
        type = data.LoadInt();
        number = data.LoadInt();
        severity = data.LoadInt();
        probability = data.LoadInt();
        assurance = data.LoadInt();
        priority = data.LoadInt();
        status = data.LoadInt();
        name = data.LoadString();
        description = data.LoadString();
        recommendation = data.LoadString();
        source = data.LoadString();
        cve = data.LoadString();
        cwe = data.LoadString();
        osvdb = data.LoadString();
        cvssv2 = data.LoadString();
        path = data.LoadString();
        line = data.LoadInt();

    }

}
