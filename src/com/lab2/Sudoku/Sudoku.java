package com.lab2.Sudoku;

import com.lab2.Util.SudokuUtil;
import com.lab2.Util.TextFileUtil;

public class Sudoku {	
	public static void main(String[] args) {
		
		if(args.length == 1){
			int[][] sudoku = new int[9][9];
			String filePath = args[0];
						
			sudoku = TextFileUtil.readFile(filePath);
			
			System.out.println("Voici le sudoku initial:");
			SudokuUtil.printSudoku(sudoku);
            boolean isValid = false;

			long debut = System.currentTimeMillis();

			ValidateSudoku valid = new ValidateSudoku(sudoku);
			isValid = valid.solveSudoku();
			
			long fin = System.currentTimeMillis();

            if(isValid) {
                System.out.println("Voici le sudoku résolu:");
                SudokuUtil.printSudoku(sudoku);
            }else{
                System.out.println("Le sudoku précédent n'a pas de solution!");
            }
			
			System.out.println("Temps d'execution: "+(fin-debut));
			
		}else{
			System.out.println("Vous devez entrer le nom du fichier Sudoku.");
		}
	}
}
