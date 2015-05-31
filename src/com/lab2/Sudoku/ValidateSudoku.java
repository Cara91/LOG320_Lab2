package com.lab2.Sudoku;

public class ValidateSudoku {

	//public static int cpt = 0;
	
	private int[][] sudoku;
	
	public ValidateSudoku(int[][] sudoku){
		this.sudoku = sudoku;
	}
	
	public boolean validSudoku(){
		
		for (int i = 0; i < sudoku.length; i++) {
			for (int j = 0; j < sudoku[i].length; j++) {
				//System.out.println(i + " " + j);
				System.out.println(validNumber(i, j, sudoku[i][j]));
			}
		}
		//System.out.println(validNumber(0, 0, sudoku[0][0]));
		//System.out.println(cpt);
		return false;
	}

	/**
	 * Valid only if no number from same ligne, column or block of 9 of the sudoku table at [x,y] 
	 * has the same value than pos and if pos is between 1 and 9
	 * @return
	 */
	private boolean validNumber(int x, int y, int pos){
		for (int i = 0; i < sudoku.length; i++) {
			if(!(pos >= 1 && pos <=9) || (pos == sudoku[x][i] && y != i) || (pos == sudoku[i][y] && x != i)){
				//cpt++;
				return false;
			}
		}	
		for (int i = x/3*3; i < x/3*3+3; i++) {
			for (int j = y/3*3; j < y/3*3+3; j++) {
				if(sudoku[i][y] != 0 && pos == sudoku[i][j] && (x != i || y != j)){
					//cpt++;
					return false;
				}
			}
		}	
		return true;
	}
}
