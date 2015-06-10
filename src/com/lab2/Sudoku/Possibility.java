package com.lab2.Sudoku;

import javafx.geometry.Pos;

public class Possibility implements Comparable {
    int i;
    int j;
    int value;

    public Possibility(int i, int j, int value) {
        this.i = i;
        this.j = j;
        this.value = value;
    }

    @Override
    public int compareTo(Object poss) {
        Possibility possibility = (Possibility)poss;
        if (possibility.value < this.value) {
            return 1;
        }

        if (possibility.value > this.value) {
            return -1;
        }

        return 0;
    }
}
