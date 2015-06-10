package com.lab2.Sudoku;

public class ValidateSudoku {
	
	private int[][] sudoku;
	private static int[][] lineNumberOccurence = new int[9][9];
	private static int[][] columnNumberOccurence =  new int[9][9];
	private static int[][] blocNumberOccurence = new int[9][9];
	
	public ValidateSudoku(int[][] sudoku){
		this.sudoku = sudoku;
	}

	public void fillNumberOccurenceTables(){
		for (int i=0 ; i<9 ; i++){
			for (int j=0 ; j<9 ; j++){
                if(this.sudoku[i][j]!=0) {
                    lineNumberOccurence[i][(this.sudoku[i][j] - 1)] = 1;
                    columnNumberOccurence[j][(this.sudoku[i][j] - 1)] = 1;
                    blocNumberOccurence[(3 * (i / 3)) + (j / 3)][(this.sudoku[i][j] - 1)] = 1;
                }
			}
		}
	}
	
	public boolean insertNumber(int x, int y){
		if(y == 9){
			return true;
		}
		
		if(sudoku[x][y] == 0){

			for (int i = 0; i < 9; i++) {
				if( lineNumberOccurence[x][i] == 0 && columnNumberOccurence[y][i] == 0 && blocNumberOccurence[(3 * (x / 3)) + (y / 3)][i] == 0){
                    lineNumberOccurence[x][i] = 1;
                    columnNumberOccurence[y][i] = 1;
                    blocNumberOccurence[(3 * (x / 3)) + (y / 3)][i] = 1;
                    if(x==8){
                        if(insertNumber(0, y+1)){
                            sudoku[x][y]=i+1;
                            return true;
                        }
                    }else{
                        if(insertNumber(x+1, y)){
                            sudoku[x][y]=i+1;
                            return true;
                        }
                    }
                    lineNumberOccurence[x][i] = 0;
                    columnNumberOccurence[y][i] = 0;
                    blocNumberOccurence[(3 * (x / 3)) + (y / 3)][i] = 0;
                }
			}
		}else{
			if(x==8){
				return insertNumber(0, y+1);
			}else{
				return insertNumber(x+1, y);
			}
		}
		
		return false;
	}

	/**
	 * Valid only if no number from same line, column or block of 9 of the sudoku table at [x,y]
	 * has the same value than pos and if pos is between 1 and 9
	 * @return

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
     */
}
