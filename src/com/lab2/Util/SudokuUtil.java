package com.lab2.Util;

public class SudokuUtil {
	public static void printSudoku(int [][] sudoku){
		for (int i = 0; i < sudoku.length; i++) {
			for (int j = 0; j < sudoku.length; j++) {
				System.out.print(sudoku[i][j] + " ");
			}
			System.out.println();
		}
	}
}
