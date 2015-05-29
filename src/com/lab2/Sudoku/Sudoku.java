package com.lab2.Sudoku;

import com.lab2.Util.TextFileUtil;

public class Sudoku {
	public static void main(String[] args) {
		
		if(args.length == 1){
			
			
			int[][] sudoku = new int[9][9];
			String filePath = args[0];
						
			TextFileUtil.readFile(filePath);
		}
	}
}
