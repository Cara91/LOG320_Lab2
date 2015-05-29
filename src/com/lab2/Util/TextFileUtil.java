package com.lab2.Util;

import java.io.BufferedReader;
import java.io.FileReader;

public class TextFileUtil {
	public static int[][] readFile(String filePath){		
		try {
			int sudokuTable[][] = new int[9][9];
				
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			
			int line;
			int indexLigne = 0;
			int indexColonne = 0;
			
			
			while((line = br.read()) != -1){
				//System.out.println(line+" ");
				
				if(line == 13){
					br.read();
					indexLigne++;
					indexColonne=0;
				}else{
					sudokuTable[indexLigne][indexColonne] = line - 48;
					indexColonne++;
				}
			}
			
			br.close();
		
			return sudokuTable;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
