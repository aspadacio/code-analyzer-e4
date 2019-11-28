package com.safeval.codeanalyzer.persist;

import java.util.Base64;

public class BufferPersist extends Persist {

	/// <summary>
    /// Buffer interno
    /// </summary>
    byte[] bufferInt;
     
    /// <summary>
    /// Posição
    /// </summary>
    int posInt;

    /// <summary>
    /// Inicio
    /// </summary>
    public BufferPersist()
    {

        bufferInt = new byte[0];
        posInt = 0;

    }

    /// <summary>
    /// Acesso ao array interno
    /// </summary>
    public byte[] getBuffer()
    {

        return bufferInt; 
        
    }    
    
    public void setBuffer(byte[] value)
    { 
    	
    	bufferInt = value; 
    
    }
    
    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
    
    /// <summary>
    /// Obtém e altera a string
    /// </summary>
    public String getBufferAsString()
    {

    	byte[] b = Base64.getEncoder().encode(bufferInt);
    	return new String(b);
        
    }
    
    public void setBufferAsString(String value)    
    { 
    	
    	int len = value.length();
    	if (len > 2 ){
	        
    		bufferInt = Base64.getDecoder().decode(new String(value).getBytes());
            
    	}
    	else
    	{
    		
        	bufferInt = new byte[0];
    		
    	}
    		            
    }

    /// <summary>
    /// Posição
    /// </summary>
    public int getPosition()
    { 
    	
    	return posInt; 
    
    }
    
    public void setPosition(int value)
    {
    	
        posInt = value; 

    }

    /// <summary>
    /// Escrita simples
    /// </summary>
    /// <param name="data"></param>
    /// <param name="len"></param>
    public void Write(byte[] data)
    {

        byte [] nb = new byte[posInt + data.length];
        System.arraycopy(nb, 0, bufferInt, 0, posInt);
        System.arraycopy(nb, posInt, data, 0, data.length);
        bufferInt = nb;

        posInt += data.length;

    }

    /// <summary>
    /// Leitura simples
    /// </summary>
    /// <param name="data"></param>
    /// <param name="len"></param>
    public byte[] Read(int size)
    {

    	byte[] data = new byte[size];
        System.arraycopy(bufferInt, posInt, data, 0, size);
        posInt += size;
        
        return data;

    }

    /// <summary>
    /// Pega a posição atual
    /// </summary>
    /// <returns></returns>
    public int GetPos()
    {

        return posInt;

    }

    /// <summary>
    /// Seta a posição atual
    /// </summary>
    /// <param name="p"></param>
    public void SetPos(int p)
    {

    	posInt = p;

    }

    /// <summary>
    /// Anda n bytes a partir da posição atual
    /// </summary>
    /// <param name="p"></param>
    public void FwdPos(int p)
    {

    	posInt += p;

    }

}
