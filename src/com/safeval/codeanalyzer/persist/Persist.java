package com.safeval.codeanalyzer.persist;

public abstract class Persist {

    // ===========================================================================
    //
    //                S A F E V A L 
    //
    // ===========================================================================

    // ----------------------------------------------------------------------------
    // Gest�o de vers�o de arquivos Safeval
    // ----------------------------------------------------------------------------

    /// <summary>
    /// N�mero m�gico do arquivo do Safeval
    /// </summary>
    public static int safevalFileMagicNumber = 0x67cbFae1;

    /// <summary>
    /// Vers�es do arquivo Safeval
    /// </summary>
    //public static int safevalFileVers_4000000 = 0x4000000; // Vers�o  0 de arquivo da vers�o 4.0 (arquivos da 2.9 n�o s�o compat�veis)
    //public static int safevalFileVers_4000001 = 0x4000001; // Vers�o  1, altera��es no escopo e vari�veis, 09/03/2016, vers 4.0.39.1055
    //public static int safevalFileVers_4000002 = 0x4000002; // Vers�o  2, inclus�o de URLs alternativas, 23/03/2016, vers 1058
    //public static int safevalFileVers_4000003 = 0x4000003; // Vers�o  3, inclus�o de subida para servidor e descida, scopeinfo e variableinfo incluem referencia, 05/04/2016, vers 1060
    //public static int safevalFileVers_4000004 = 0x4000004; // Vers�o  4, inclus�o de subida para servidor e descida do teste de invas�o, 21/04/2016, vers 1075? Vers�o inicial para teste de invas�o.
    //public static int safevalFileVers_4000005 = 0x4000005; // Vers�o  5, abandonamos as vers�es anteriores ****
    //public static int safevalFileVers_4000006 = 0x4000006; // Vers�o  6, 4.1.16.1090, origem do c�digo fonte na propriedade da inspe��o
    //public static int safevalFileVers_4000007 = 0x4000007; // Vers�o  7, 4.1.18.1094, diferenciar entre p�ginas livres e que requerem autentica��o
    //public static int safevalFileVers_4000008 = 0x4000008; // Vers�o  8, 4.1.22.1112, incluir CVE, CWE, OSVBD e CVSSv2.  Incluir op��es de requerer tipo de p�gina no teste web. Salvar como vers�o anterior.
    // Ignorar vers�es anteriores
    public static int safevalFileVers_4000009 = 0x4000010; // Vers�o  9, 4.2.25.1120, id para guid.
    public static int safevalFileVers_4000011 = 0x4000011; // Vers�o 10, 4.2.30.1240, �ndices para resultados, movimento de vulnerablePoints para consolidated.
    public static int safevalFileVers_4000012 = 0x4000012; // Vers�o 11, 4.2.32.1245, �ndices para design e pentest. Upload to server.
    public static int safevalFileVers_4000014 = 0x4000014; // Vers�o 12, 4.2.33.1248, Propriedades do penetration test completas (User agent, exclusions, etc)
    public static int safevalFileVers_4000015 = 0x4000015; // Vers�o 15, 4.2.35.1250, Lista de bugs para primeira vers�o
    public static int safevalFileVers_4000016 = 0x4000016; // Vers�o 16, 4.2.36.1252, Inclus�o de special pages e fuzzy test
    public static int safevalFileVers_4000017 = 0x4000017; // Vers�o 17, 4.2.40.1266, Certificados digitais de cliente (senha do certificado)
    public static int safevalFileVers_4000018 = 0x4000018; // Vers�o 18, 4.3.44.1290, Observa��es do token match
    public static int safevalFileVers_4000019 = 0x4000019; // Vers�o 19, 4.3.47.1294, Inclus�o da vulnerability base para apresenta��o de agrupamento por vulnerabilidade
    public static int safevalFileVers_400001A = 0x400001A; // Vers�o 1A, 4.3.60.1335, Altera��o do teste de invas�o para p�gina pura e inclus�o de observation match
    public static int safevalFileVers_400001B = 0x400001B; // Vers�o 1B, 4.4.03.1430, Inclus�o de bibliotecas externas e relacionamento de vulnerabilidades a estas. CVSSv2 string.
    public static int safevalFileVers_400001C = 0x400001C; // Vers�o 1C, 4.4.65.1451, Inclus�o de bibliotecas externas e relacionamento de vulnerabilidades a estas. CVSSv2 string.

    /// <summary>
    /// Vers�o m�xima e m�nima
    /// </summary>
    public static int safevalFileMinVers = 0x4000000;      // M�nimo
    public static int safevalFileMaxVers = 0x40fffff;      // M�ximo

    /// <summary>
    /// É um arquivo safeval?
    /// </summary>
    /// <param name="v"></param>
    /// <returns></returns>
    public static boolean IsSafevalFile(int v) { return (v >= safevalFileMinVers && v <= safevalFileMaxVers); }

    /// <summary>
    /// Vers�o corrente do arquivo
    /// </summary>
    public static int currentSafevalFileVers = safevalFileVers_400001C;
    
    // ----------------------------------------------------------------------------
    // Gest�o de vers�o de bibliotecas Safeval
    // ----------------------------------------------------------------------------

    /// <summary>
    /// N�mero m�gico da biblioteca do safeval
    /// </summary>
    public static int safevalLibraryMagicNumber = 0x34b76a0d;
            
    /// <summary>
    /// Vers�o da biblioteca
    /// </summary>
    public static int safevalLibraryVers_0000100 = 0x0000100; // Vers�o 0, sem controle de vers�o
    public static int safevalLibraryVers_0000101 = 0x0000101; // Vers�o 1, Safeval=4.1.16.1090, abandonamos vers�es anteriores, primeira com controle de vers�o, inclus�o do tag da biblioteca
    public static int safevalLibraryVers_0000102 = 0x0000102; // Vers�o 2, WS=1.1.16.1028, Safeval=4.1.18.1094, Inclui atributos de requerer autentica��o para vulnerabilidade do pentest
    public static int safevalLibraryVers_0000103 = 0x0000103; // Vers�o 3, WS=1.2.18.1032, Safeval=4.1.22.1112, incluir CVE, CWE, OSVBD e CVSSv2. Incluir op��es de requerer tipo de p�gina. Salvar como vers�o anterior.
    // Ignorar vers�es anteriores
    public static int safevalLibraryVers_0000104 = 0x0000110; // Vers�o  4, 4.2.25.1120, id para guid.
    public static int safevalLibraryVers_0000111 = 0x0000111; // Vers�o  5, 4.2.33.1248, revis�o do agent user e propriedades do teste de invas�o
    public static int safevalLibraryVers_0000112 = 0x0000112; // Vers�o  6, 4.2.35.1250, Lista de bugs para primeira vers�o
    public static int safevalLibraryVers_0000113 = 0x0000113; // Vers�o  7, 4.2.35.1252, Inclus�o de inteiros para mensagens na base, para permitir exporta��o e importa��o
    public static int safevalLibraryVers_0000114 = 0x0000114; // Vers�o  8, 4.2.40.1266, Certificados digitais de cliente (senha do certificado), interface e pol�tica no arquivo offline
    public static int safevalLibraryVers_0000115 = 0x0000115; // Vers�o  9, 4.3.44.1290, Descri��o e tipo de descri��o no token de linguagem
    public static int safevalLibraryVers_0000116 = 0x0000116; // Vers�o 10, 4.3.47.1294, Inclus�o das bibliotecas de mensagens nas bibliotecas
    public static int safevalLibraryVers_0000117 = 0x0000117; // Vers�o 11, 4.3.55.1300, Inclus�o de observation match parcial
    public static int safevalLibraryVers_0000118 = 0x0000118; // Vers�o 12, 4.3.60.1335, Altera��o do teste de invas�o para p�gina pura e inclus�o de observation match final
    public static int safevalLibraryVers_0000119 = 0x0000119; // Vers�o 13, 4.4.03.1430, Inclus�o de bibliotecas externas e relacionamento de vulnerabilidades a estas. CVSSv2 string.

    /// <summary>
    /// Vers�o m�xima e m�nima
    /// </summary>
    public static int safevalLibraryMinVers = 0x0000100;      // M�nimo
    public static int safevalLibraryMaxVers = 0x001ffff;      // M�ximo

    /// <summary>
    /// É um arquivo de biblioteca?
    /// </summary>
    /// <param name="v"></param>
    /// <returns></returns>
    public static boolean IsSafevalLibrary(int v) { return (v >= safevalLibraryMinVers && v <= safevalLibraryMaxVers); }

    /// <summary>
    /// Vers�o atual
    /// </summary>
    public static int currentSafevalLibraryVers = safevalLibraryVers_0000119;

    // ----------------------------------------------------------------------------
    // Gest�o de vers�o do arquivo de licen�as
    // ----------------------------------------------------------------------------

    /// <summary>
    /// N�mero m�gico da biblioteca do safeval
    /// </summary>
    public static int safevalLicenseMagicNumber = 0x34b76a0d;

    /// <summary>
    /// Vers�o da licen�a
    /// </summary>
    public static int safevalLicenseVers_0020000 = 0x0020000; // Vers�o 0, sem controle de vers�o
    public static int safevalLicenseVers_0020001 = 0x0020001; // Vers�o 1, WS=1.2.18.1032, Safeval=4.1.22.1112, inclui infos completas de licen�a, licenseType e licenseClass
    // Ignorar vers�es anteriores
    public static int safevalLicenseVers_0020002 = 0x0020010; // Vers�o 2, Safeval=4.2.25.1120, id para guid.
    public static int safevalLicenseVers_0020011 = 0x0020011; // Vers�o 3, Safeval=4.2.33.1248, inclus�o de organiza��o e usu�rio na licen�a.

    /// <summary>
    /// Vers�o m�xima e m�nima
    /// </summary>
    public static int safevalLicenseMinVers = 0x0020000;      // M�nimo
    public static int safevalLicenseMaxVers = 0x002ffff;      // M�ximo

    /// <summary>
    /// É um arquivo de licen�a?
    /// </summary>
    /// <param name="v"></param>
    /// <returns></returns>
    public static boolean IsSafevalLicense(int v) { return (v >= safevalLicenseMinVers && v <= safevalLicenseMaxVers) ; }

    /// <summary>
    /// Vers�o atual
    /// </summary>
    public static int currentSafevalLicenseVers = safevalLicenseVers_0020011;

    // ----------------------------------------------------------------------------
    // Gest�o de vers�o do arquivo local do Safeval
    // ----------------------------------------------------------------------------

    /// <summary>
    /// N�mero m�gico da biblioteca do safeval
    /// </summary>
    public static int safevalLocalMagicNumber = 0xdeb11a80;

    /// <summary>
    /// Vers�o do arquivo local
    /// </summary>
    public static int safevalLocalVers_0000001 = 0x0050001; // Vers�o 0, sem controle de vers�o
    public static int safevalLocalVers_0000002 = 0x0050002; // Vers�o 1, 4.2.35.1250, inclus�o de policies
    public static int safevalLocalVers_0000003 = 0x0050003; // Vers�o 2, 4.2.36.1252, Inclus�o de dicion�rios
    
    /// <summary>
    /// Vers�o m�xima e m�nima
    /// </summary>
    public static int safevalLocalMinVers = 0x0050000;      // M�nimo
    public static int safevalLocalMaxVers = 0x005ffff;      // M�ximo

    /// <summary>
    /// Vers�o atual
    /// </summary>
    public static int currentSafevalLocalVers = safevalLocalVers_0000003;

    // ===========================================================================
    //
    //                R I S K A N
    //
    // ===========================================================================

    // ----------------------------------------------------------------------------
    // Gest�o de vers�o de arquivos Riskan
    // ----------------------------------------------------------------------------

    /// <summary>
    /// N�mero m�gico do arquivo do Safeval
    /// </summary>
    public static int riskanFileMagicNumber = 0xF98AD87A;

    /// <summary>
    /// Vers�es do arquivo Safeval
    /// </summary>
    public static int riskanFileVers_4000000 = 0x4000000; // Vers�o 0 de arquivo da vers�o 4.0 (arquivos da 3.5 n�o s�o compat�veis)

    /// <summary>
    /// Vers�o corrente do arquivo
    /// </summary>
    public static int currentRiskanFileVers = riskanFileVers_4000000;

    // ----------------------------------------------------------------------------
    // Gest�o de vers�o do arquivo de licen�as
    // ----------------------------------------------------------------------------

    /// <summary>
    /// N�mero m�gico da biblioteca do riskan
    /// </summary>
    public static int riskanLicenseMagicNumber = 0x6ad3992b;
    
    /// <summary>
    /// Vers�o da biblioteca
    /// </summary>
    public static int riskanLicenseVers_0020000 = 0x0020000; // Vers�o 0, sem controle de vers�o

    /// <summary>
    /// Vers�o atual
    /// </summary>
    public static int currentRiskanLicenseVers = riskanLicenseVers_0020000;

    // ----------------------------------------------------------------------------
    // Gest�o de vers�o do arquivo de unidades
    // ----------------------------------------------------------------------------

    /// <summary>
    /// N�mero m�gico da biblioteca de unidades do riskan
    /// </summary>
    public static int riskanUnitMagicNumber = 0xb5e2332b;

    /// <summary>
    /// Vers�o da biblioteca
    /// </summary>
    public static int riskanUnitVers_0070000 = 0x0070000; // Vers�o 0, sem controle de vers�o

    /// <summary>
    /// Vers�o atual
    /// </summary>
    public static int currentRiskanUnitVers = riskanUnitVers_0070000;
    
    // ----------------------------------------------------------------------------
    // Vers�o corrente desse stream
    // ----------------------------------------------------------------------------

    /// <summary>
    /// Vers�o deste arquivo que est� sendo lido ou escrito
    /// </summary>
    int versionInt;

    /// <summary>
    /// A vers�o vis�vel
    /// </summary>
    public int getVersion()
    {

        return versionInt; 
     
    }
    
    public void setVersion(int value)
    { 
    
    	versionInt = value; 
    	
    }

    /// <summary>
    /// Cria uma persistencia
    /// </summary>
    protected Persist()
    {

    }

    /// <summary>
    /// Escrita simples
    /// </summary>
    /// <param name="data"></param>
    /// <param name="len"></param>
    public abstract void Write(byte[] data);

    /// <summary>
    /// Leitura simples
    /// </summary>
    /// <param name="data"></param>
    /// <param name="len"></param>
    public abstract byte[] Read(int len);

    /// <summary>
    /// Pega a posi��o atual
    /// </summary>
    /// <returns></returns>
    public abstract int GetPos();

    /// <summary>
    /// Seta a posi��o atual
    /// </summary>
    /// <param name="p"></param>
    public abstract void SetPos(int p);

    /// <summary>
    /// Anda n bytes a partir da posi��o atual
    /// </summary>
    /// <param name="p"></param>
    public abstract void FwdPos(int p);

    /// <summary>
    /// Guarda a situa��o atual
    /// </summary>
    public void Preserve() { }

    /// <summary>
    /// Joga fora a situa��o guardada
    /// </summary>
    public void Discharge() { }

    /// <summary>
    /// Volta ao in�cio
    /// </summary>
    public void Rewind() { SetPos(0); }

    /// <summary>
    /// Fecha o arquivo
    /// </summary>
    public void Close() { }

    /// <summary>
    /// Fun��o necess�ria para ler array de objetos
    /// </summary>
    /// <returns></returns>
    //public delegate LinearObject createObject();

    /// <summary>
    /// Salva string
    /// </summary>
    /// <param name="data"></param>
    public void Save(String data)
    {

        if (data == null)  
        {

            // Salva o tamanho como -1 (indica null)
            int n = -1;                
            Save(n);

        }
        else
        {

            //System.Text.UTF8Encoding encoding = new System.Text.UTF8Encoding();
            //byte[] b = encoding.GetBytes(data);

        	byte[] b = data.getBytes();
        	
            // Salva o tamanho
            Save(b.length);

            // Salva a string
            Write(b);

        }

    }

    /// <summary>
    /// Carrega uma string
    /// </summary>
    /// <returns></returns>
    public String LoadString()
    {

        String data = "";

        // Carrega o tamanho
        int len = LoadInt();

        // Menor que zero, � nulo
        if (len < 0)
            return null;

        // Carrega a string
        byte[] b = Read(len);

        if (b != null)
        {
            
            data = new String(b);

        }

        return data;

    }
    /*
    /// <summary>
    /// Salva objeto que tenha a interface ILinearObject
    /// </summary>
    /// <param name="data"></param>
    public void Save(LinearObject data)
    {

        BufferPersist bp = new BufferPersist();
        bp.version = version;
        Persist p = (Persist)bp;
        data.Save(p);

        Save(bp.buffer.Length);
        Write(bp.buffer);

    }
    
    /// <summary>
    /// Le objeto com a interface ILinearObject
    /// </summary>
    /// <param name="data"></param>
    public LinearObject LoadLinearObject(createObject create)
    {

        LinearObject data = create();

        int len = 0;
        Load(ref len);

        BufferPersist bp = new BufferPersist();
        bp.version = version;

        byte[] b = new byte[len];
        Read(ref b, len);
        bp.buffer = b;
        bp.position = 0;

        Persist p = (Persist)bp;
        data.Load(ref p);

        return data;

    }
	
    /// <summary>
    /// Le objeto com a interface ILinearObject
    /// </summary>
    /// <param name="data"></param>
    public void Load(ref LinearObject data, createObject create)
    {

        data = LoadLinearObject(create);

    }
	*/
    /// <summary>
    /// Salva inteiro
    /// </summary>
    /// <param name="data"></param>
    public void Save(int data)
    {
    	
    	byte[] b = new byte[4];

    	b[0] = (byte) ((data >> 24) & 0xFF);
    	b[1] = (byte) ((data >> 16) & 0xFF);
    	b[2] = (byte) ((data >> 8) & 0xFF);
    	b[3] = (byte) ((data) & 0xFF);

    	Write(b);

    }

    /// <summary>
    /// Le inteiro
    /// </summary>
    /// <param name="data"></param>
    public int LoadInt()
    {

        int data = 0;

        byte[] b = Read(4);
        
        if (b != null)
        {
        
        	data += b[3] << 24;
            data += b[2] << 16;
            data += b[1] << 8;
            data += b[0];
            
        }

        return data;

    }

    /// <summary>
    /// Salva caracter
    /// </summary>
    /// <param name="data"></param>
    public void Save(char data)
    {

        byte[] b = new byte[1];
        
        b[0] = (byte)data;
        		
        Write(b);

    }

    /// <summary>
    /// Le Caracter
    /// </summary>
    /// <param name="data"></param>
    public char LoadChar()
    {

        char data = '\0';

        byte[] b =Read(1);
        
        if (b != null)
            data = (char)b[0];

        return data;

    }

    /// <summary>
    /// Salva booleano
    /// </summary>
    /// <param name="data"></param>
    public void Save(boolean data)
    {

        byte[] b = new byte[1];
        
        if (data)
        	b[0] = 1;
        else
        	b[0] = 0;
        		
        Write(b);

    }

    /// <summary>
    /// L� booleano
    /// </summary>
    /// <param name="data"></param>
    public boolean LoadBool()
    {

        boolean data = false;

        byte[] b = Read(1);

        if (b != null) {
        	
        	if (b[0] != 0)
        		data = true; 
        	
        }

        return data;

    }

    /// <summary>
    /// Salva o longo
    /// </summary>
    /// <param name="data"></param>
    public void Save(long data)
    {

    	byte[] b = new byte[8];

    	b[0] = (byte) (data >> 56);
    	b[1] = (byte) (data >> 48);
    	b[2] = (byte) (data >> 40);
    	b[3] = (byte) (data >> 32);
    	b[4] = (byte) (data >> 24);
    	b[5] = (byte) (data >> 16);
    	b[6] = (byte) (data >> 8);
    	b[7] = (byte) (data);
    	
        Write(b);

    }

    /// <summary>
    /// L� o longo
    /// </summary>
    /// <param name="data"></param>
    public long LoadLong()
    {

        long data = 0;

        byte[] b = Read(8);

        if (b != null) {
        
        	data += b[0] << 56;
            data += b[1] << 48;
            data += b[2] << 40;
            data += b[3] << 32;
        	data += b[4] << 24;
            data += b[5] << 16;
            data += b[6] << 8;
            data += b[7];
        	
        }   

        return data;

    }
    /*
    /// <summary>
    /// Salva o longo
    /// </summary>
    /// <param name="data"></param>
    public void Save(Guid data)
    {

        byte[] b = data.ToByteArray();
        Write(b);

    }

    /// <summary>
    /// L� o longo
    /// </summary>
    /// <param name="data"></param>
    public void Load(ref Guid data)
    {

        data = LoadGuid();

    }

    /// <summary>
    /// L� o longo
    /// </summary>
    /// <param name="data"></param>
    public Guid LoadGuid()
    {

        Guid data = new Guid();

        byte[] b = null;
        Read(ref b, 16);

        if (b != null)
            data = new Guid(b);

        return data;

    }
	*/
    
    /// <summary>
    /// Salva a data
    /// </summary>
    /// <param name="data"></param>
    public void Save(double data)
    {

    	byte[] b = new byte[8];
    	long lng = Double.doubleToLongBits(data);
    	for(int i = 0; i < 8; i++) b[i] = (byte)((lng >> ((7 - i) * 8)) & 0xff);
    	
        Write(b);

    }

    /// <summary>
    /// L� a data
    /// </summary>
    /// <param name="data"></param>
    public double LoadDouble()
    {

        double data = 0.0;

        byte[] b = Read(8);
        
        if (b != null)
        {
        	
        	
        }

        return data;

    }
    /*
        /// <summary>
        /// Salva data e hora
        /// </summary>
        /// <param name="data"></param>
        public void Save(Date data)
        {

            byte[] b = BitConverter.GetBytes(data.Ticks);
            Write(b);

//            long t = Base.conf.ConvertToUnixTimestamp(data);
//            Save(t);

        }

        /// <summary>
        /// L� data e hora
        /// </summary>
        /// <param name="data"></param>
        public Date LoadDateTime()
        {

        	Date data = Date.MinValue;

            byte[] b = null;
            Read(ref b, sizeof(Int64));

            if (b != null)
                data = DateTime.FromBinary(BitConverter.ToInt64(b, 0));

            return data;

//            DateTime data = DateTime.MinValue;

//            long t = 0;
//            Load(ref t);

//            data = Base.ConvertFromUnixTimestamp(t);

//            return data;

        }
		*/
    /// <summary>
    /// Salva lista de strings
    /// </summary>
    /// <param name="data"></param>
    public void Save(String[] data)
    {

        Save(data.length);

        for (int i = 0; i < data.length; i++)
            Save(data[i]);

    }

    /// <summary>
    /// Salva lista de strings
    /// </summary>
    /// <param name="data"></param>
    public String[] LoadListString()
    {

        int n = LoadInt();
        
        String[] data = new String[n];

        for (int i = 0; i < n; i++)
        {
            String s = LoadString();
            data[i] = s;
        }

        return data;

    }

    /// <summary>
    /// Salva lista de inteiros
    /// </summary>
    /// <param name="data"></param>
    public void Save(int[] data)
    {

        Save(data.length);

        for (int i = 0; i < data.length; i++)
            Save(data[i]);

    }

    /// <summary>
    /// Le lista de inteiro
    /// </summary>
    /// <param name="data"></param>
    public int[] LoadListInt()
    {

        int n = LoadInt();

        int[] data = new int[n];

        for (int i = 0; i < n; i++)
        {
            int s = LoadInt();
            data[i] = s;
        }

        return data;

    }

    /// <summary>
    /// Salva lista de long
    /// </summary>
    /// <param name="data"></param>
    public void Save(long[] data)
    {

        Save(data.length);

        for (int i = 0; i < data.length; i++)
            Save(data[i]);

    }

    /// <summary>
    /// Le lista de long
    /// </summary>
    /// <param name="data"></param>
    public long[] LoadListLong()
    {

        int n = LoadInt();
        
        long[] data = new long[n];

        for (int i = 0; i < n; i++)
        {
            long s = LoadLong();
            data[i] = s;
        }

        return data;

    }

    /// <summary>
    /// Salva lista de caracteres
    /// </summary>
    /// <param name="data"></param>
    public void Save(char[] data)
    {

        Save(data.length);

        for (int i = 0; i < data.length; i++)
            Save(data[i]);

    }

    /// <summary>
    /// Le lista de unsigned long
    /// </summary>
    /// <param name="data"></param>
    public char[] LoadListChar()
    {

        int n = LoadInt();

        char[] data = new char[n];

        for (int i = 0; i < n; i++)
        {
            char s = LoadChar();
            data[i] = s;
        }

        return data;

    }
    
    /// <summary>
    /// Salva array de inteiros
    /// </summary>
    /// <param name="data"></param>
    public void Save(byte[] data)
    {

        Save(data.length);

        for (int i = 0; i < data.length; i++)
            Save(data[i]);

    }

    /// <summary>
    /// Le lista de inteiro
    /// </summary>
    /// <param name="data"></param>
    public byte[] LoadArrayByte()
    {

    	int n = LoadInt();

        byte[] data = new byte[n];

        for (int i = 0; i < n; i++)
        {
            int s = LoadInt();
            data[i] = (byte)s;
        }

        return data;

    }             

}
