package com.lab2.Sudoku;

import com.lab2.Util.SudokuUtil;


public class ValidateSudoku {
	
	private int[][] sudoku;
	
	public ValidateSudoku(int[][] sudoku){
		this.sudoku = sudoku;
	}
	
	public boolean insertNumber(int x, int y){
		if(y == 9){
			return true;
		}
		
		if(sudoku[x][y] == 0){
			for (int i = 1; i <= 9; i++) {
				if(validNumber(x, y, i)){
					sudoku[x][y] = i;				
					
					if(x==8){
						if(insertNumber(0, y+1)){
							return true;
						}
					}else{
						if(insertNumber(x+1, y)){
							return true;
						}
					}
				}
			}
			//sudoku[x][y] = 0;
		}else{
			if(x==8){
				return insertNumber(0, y+1);
			}else{
				return insertNumber(x+1, y);
			}
		}
		sudoku[x][y] = 0;
		
		return false;
	}

	/**
	 * Valid only if no number from same ligne, column or block of 9 of the sudoku table at [x,y] 
	 * has the same value than pos and if pos is between 1 and 9
	 * @return
	 */
	private boolean validNumber(int x, int y, int nb){
		for (int i = 0; i < sudoku.length; i++) {
			if(!(nb >= 1 && nb <=9) || (nb == sudoku[x][i] && y != i) || (nb == sudoku[i][y] && x != i)){
				return false;
			}
		}	
		for (int i = x/3*3; i < x/3*3+3; i++) {
			for (int j = y/3*3; j < y/3*3+3; j++) {
				if(sudoku[i][y] != 0 && nb == sudoku[i][j] && (x != i || y != j)){
					//cpt++;
					return false;
				}
			}
		}	
		return true;
	}
}
