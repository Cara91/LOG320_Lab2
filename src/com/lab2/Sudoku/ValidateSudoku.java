package com.lab2.Sudoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidateSudoku {
	
	private int[][] sudoku;
	private static int[][] lineNumberOccurence = new int[9][9];
	private static int[][] columnNumberOccurence =  new int[9][9];
	private static int[][] blocNumberOccurence = new int[9][9];
	private List<Possibility> possibilities = new ArrayList<>();
	private Possibility possibility;
	
	public ValidateSudoku(int[][] sudoku){
		this.sudoku = sudoku;
	}

	public boolean solveSudoku() {
		fillNumberOccurenceTables();
		return insertNumber(0);
	}

	public void fillNumberOccurenceTables(){
		for (int i=0 ; i<9 ; i++) {
			for (int j=0 ; j<9 ; j++) {
                if(this.sudoku[i][j]!=0) {
                    lineNumberOccurence[i][(this.sudoku[i][j] - 1)] = 1;
                    columnNumberOccurence[j][(this.sudoku[i][j] - 1)] = 1;
                    blocNumberOccurence[(3 * (i / 3)) + (j / 3)][(this.sudoku[i][j] - 1)] = 1;
                }
			}
		}

		for (int i=0 ; i<9 ; i++) {
			for (int j=0 ; j<9 ; j++) {
				if(this.sudoku[i][j]==0) {
					possibilities.add(new Possibility(i, j, calculatePossibilities(i, j)));
				}
			}
		}

		Collections.sort(possibilities);
	}
	
	private boolean insertNumber(int index) {

		if(index > possibilities.size() - 1) {
			return true;
		}

		possibility = possibilities.get(index);

		int x = possibility.i;
		int y = possibility.j;

		for (int i = 0; i < 9; i++) {
			if(lineNumberOccurence[x][i] == 0 && columnNumberOccurence[y][i] == 0 && blocNumberOccurence[(3 * (x / 3)) + (y / 3)][i] == 0) {
				lineNumberOccurence[x][i] = 1;
				columnNumberOccurence[y][i] = 1;
				blocNumberOccurence[(3 * (x / 3)) + (y / 3)][i] = 1;

				if(insertNumber(index+1)){
					this.sudoku[x][y]=i+1;
					return true;
				}

				lineNumberOccurence[x][i] = 0;
				columnNumberOccurence[y][i] = 0;
				blocNumberOccurence[(3 * (x / 3)) + (y / 3)][i] = 0;
			}
		}
		
		return false;
	}

	private int calculatePossibilities(int i, int j) {
		int poss = 0;
		for (int k=0; k < 9; k++) {
			if (lineNumberOccurence[i][k] == 0 && columnNumberOccurence[j][k] == 0 && blocNumberOccurence[3*(i/3)+(j/3)][k] == 0) {
				poss++;
			}
		}
		return poss;
	}
}
