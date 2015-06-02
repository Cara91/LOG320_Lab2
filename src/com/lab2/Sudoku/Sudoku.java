package com.lab2.Sudoku;

import com.lab2.Util.SudokuUtil;
import com.lab2.Util.TextFileUtil;

public class Sudoku {	
	public static void main(String[] args) {
		
		if(args.length == 1){
			
			
			int[][] sudoku = new int[9][9];
			String filePath = args[0];
						
			sudoku = TextFileUtil.readFile(filePath);
			
			System.out.println("INITIAL");
			SudokuUtil.printSudoku(sudoku);
			
			ValidateSudoku valid = new ValidateSudoku(sudoku);
			long debut = System.currentTimeMillis();
			
			valid.insertNumber(0, 0);
			
			long fin = System.currentTimeMillis();
			
			System.out.println("FINAL");
			SudokuUtil.printSudoku(sudoku);
			
			System.out.println("Temps d'execution:"+(fin-debut));
			
		}else{
			System.out.println("Vous devez entrer le nom du fichier Sudoku.");
		}
	}
}
