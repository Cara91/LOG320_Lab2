package com.lab2.Sudoku;

public class Possibility implements Comparable {
    int x;
    int y;
    int value;

    public Possibility(int x, int y, int value) {
        this.x = x;
        this.y = y;
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
