/**
 * 
 */
package com.safeval.codeanalyzer.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Spadacio
 *
 */
public class SafevalUtil {

	/***
	 * Méthod to divides in 'n' parts an Byte Array 
	 * @param src Array Bytes source
	 * @param nParts 'N' number of parts in bytes
	 * @return Array of Byte Array
	 */
	public static List<byte[]> getPartedFile(byte[] src, int nParts){
		int nLoops = (src.length / nParts);
		List<byte[]> result = new ArrayList<byte[]>();
		
		int posIn = 0;
		int posFn = nParts;
		
		for( int i=0; i<=nLoops; i++ ) {
			byte[] part = Arrays.copyOfRange(src, posIn, (posFn+1));
			result.add(part);
			posIn = posFn + 1;
			posFn = (posFn+4000);
			if( posFn > src.length ) {
				posFn = src.length - 1;
			}
		}
		
		return result;
	}
	
}
