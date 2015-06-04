package com.lab2.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class TextFileUtil {
	public static int[][] readFile(String filePath){		
		try {
			int sudokuTable[][] = new int[9][9];
				
			BufferedReader br = new BufferedReader(new FileReader(filePath));

			String line = "";
			int i = 0;

			while((line = br.readLine()) != null) {
				for (int j = 0; j < line.length(); j++) {
					if ( ! Character.isDigit(line.charAt(j))) {
						throw new Exception("Contains an invalid digit");
					}
					sudokuTable[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
				}

				i++;
			}

			br.close();

			return sudokuTable;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
