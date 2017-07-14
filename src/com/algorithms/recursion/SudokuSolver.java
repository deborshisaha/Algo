package com.algorithms.recursion;

import com.algorithms.SudokuBox;

public class SudokuSolver {

    private SudokuBox sudokuBox = null;

    public SudokuSolver() {}

    public SudokuSolver(SudokuBox sudoku) {
        this.sudokuBox = sudoku;
    }

    private boolean solveUtil(int row, int col) {

        if (row == 9) {
            return true;
        }
        
        if (this.sudokuBox.isEmpty(row, col)) {

            for (int i = 1; i < 10; i++) {

                if (this.sudokuBox.put(i, row, col)) {
                    //this.sudokuBox.print();
                    // If row and col is at the end
                    if (row == 8 && col == 8) {
                        return true;
                    }

                    if (!isNextValid(row, col)) {
                        this.sudokuBox.put(0, row, col);
                    } else {
                        return true;
                    }
                }
            }
            // Exhausted all attempts. Not solvable 
            return false;
        } else {
            return isNextValid(row, col);
        }

    }

    public boolean isNextValid(int row, int col) {

        int nextCol = 0;
        int nextRow = 0;

        if (col == 8) {
            nextRow = row + 1;
            nextCol = 0;
        } else {
            nextRow = row;
            nextCol = col + 1;
        }

        return solveUtil(nextRow, nextCol);
    }

    // Is it to find solution for a Sudoku?
    public void solve() {
        if (solveUtil(0, 0)) {
            this.sudokuBox.print();
        } else {
            System.out.println("Not a valid Sudoku");
        }
        
    }

    public static void driver() {
        SudokuBox sudokuBox = new SudokuBox();
        SudokuSolver sudokuSolver = new SudokuSolver(sudokuBox);
        System.out.println("Before");
        sudokuSolver.sudokuBox.print();
        System.out.println("\nAfter");
        sudokuSolver.solve();

    }
}
