package com.algorithms.recursion;

import java.util.HashSet;

public class SudokuSolver {

    int[][] box0 = new int[][]{{3, 0, 4}, {0, 2, 9}, {1, 0, 0}};
    int[][] box1 = new int[][]{{0, 8, 0}, {0, 1, 0}, {9, 0, 3}};
    int[][] box2 = new int[][]{{0, 0, 0}, {0, 8, 0}, {0, 0, 0}};
    int[][] box3 = new int[][]{{9, 0, 0}, {0, 0, 0}, {6, 0, 8}};
    int[][] box4 = new int[][]{{8, 0, 0}, {0, 0, 0}, {0, 0, 7}};
    int[][] box5 = new int[][]{{6, 0, 5}, {0, 0, 0}, {0, 0, 1}};
    int[][] box6 = new int[][]{{0, 0, 0}, {0, 5, 0}, {0, 0, 0}};
    int[][] box7 = new int[][]{{4, 0, 6}, {0, 9, 0}, {0, 5, 0}};
    int[][] box8 = new int[][]{{0, 0, 2}, {7, 6, 0}, {8, 0, 4}};

    Box[] boxes = new Box[]{new Box(box0), new Box(box1), new Box(box2), new Box(box3), new Box(box4), new Box(box5), new Box(box6), new Box(box7), new Box(box8)};

    // Is it a checker whether a filled Sudoku matrix is valid or not?
    private boolean isValid() {
        return verticallyValid() && horizontallyValid() && are3x3Valid();
    }

    private boolean verticallyValid() {

        boolean isValid = true;

        for (int col = 0; col < 9; col++) {

            isValid = columnChecker(col);

            if (!isValid) {
                return false;
            }
        }

        return true;
    }

    private boolean rowChecker(int row) {

        HashSet<Integer> set = new HashSet<Integer>();

        for (int c = 0; c < 9; c++) {

            int number = getNumber(row, c);

            if (set.contains(number)) {
                return false;
            } else {
                if (number != 0) {
                    set.add(number);
                }
            }

        }

        return true;
    }

    private void printRow(int row) {
        System.out.print("|");
        for (int c = 0; c < 9; c++) {
            Integer number = getNumber(row, c);
            String string = ((number == 0) ? "_" : number.toString());
            if (c == 2 || c == 5 || c == 8) {
                System.out.print(string + "|");
            } else {
                System.out.print(string + " ");
            }
        }
        System.out.println();
    }

    private int translateCtoBoxC(int c) {
        return ((c >= 0 && c < 3) ? c : ((c >= 3 && c < 6) ? (c - 3) : (c - 6)));
    }

    private int translateRtoBoxR(int row) {
        return ((row >= 0 && row < 3) ? row : ((row >= 3 && row < 6) ? (row - 3) : (row - 6)));
    }

    private boolean columnChecker(int col) {

        HashSet<Integer> set = new HashSet<Integer>();

        for (int r = 0; r < 9; r++) {

            int number = getNumber(r, col);

            if (set.contains(number)) {
                return false;
            } else {
                if (number != 0) {
                    set.add(number);
                }
            }
        }

        return true;
    }

    private int getNumber(int r, int c) {
        int effectiveColumn = translateCtoBoxC(c);
        int effectiveRow = translateRtoBoxR(r);

        Box b = getBox(r, c);
        if (b!= null) {
            return b.get(effectiveRow, effectiveColumn);
        }
        
        return -1;
    }

    private boolean horizontallyValid() {

        boolean isValid = true;

        for (int row = 0; row < 9; row++) {

            isValid = rowChecker(row);

            if (!isValid) {
                return false;
            }
        }

        return true;
    }

    private boolean are3x3Valid() {

        for (Box b : boxes) {
            if (!b.isValid()) {
                return false;
            }
        }

        return true;
    }

    private void put(int v, int r, int c) {
        
        if(r > 9) {return;}
        
        int effectiveColumn = translateCtoBoxC(c);
        int effectiveRow = translateRtoBoxR(r);
        Box b = getBox(r, c);
        
        if (b !=null) {
            b.put(v, effectiveRow, effectiveColumn);
        } else {
            System.out.println("NULL "+r+" "+c);
        }
    }

    private boolean putUtil(int row, int col) {

        if(row >= 9) {return false;}
        
        int number = getNumber(row, col);
        if (number == 0) {

            for (int i = 1; i < 10; i++) {
                put(i, row, col);
                if (!isValid()) {
                    put(0, row, col);
                    continue;
                } else {
                    
                    if (col == 8) {
                        putUtil(row++,0);
                    } else {
                        putUtil(row,col++);
                    }
                }
            }
        }   

        return false;
    }

    // Is it to find solution for a Sudoku?
    public void solve() {
        
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                int number = getNumber(i, j);
                if (number == 0) {
                    putUtil(i, j);
                }
            }
        }
        
        print();
    }

    private void print() {
        for (int row = 0; row < 9; row++) {
            if ((row) % 3 == 0) {
                System.out.println("+-----+-----+-----+");
            }
            printRow(row);
        }
        System.out.println("+-----+-----+-----+");
    }

    private Box getBox(int r, int c) {
        if ((r >= 0 && r < 3) && (c >= 0 && c < 3)) {
            return boxes[0];
        } else if ((r >= 0 && r < 3) && (c >= 3 && c < 6)) {
            return boxes[1];
        } else if ((r >= 0 && r < 3) && (c >= 6 && c < 9)) {
            return boxes[2];
        } else if ((r >= 3 && r < 6) && (c >= 0 && c < 3)) {
            return boxes[3];
        } else if ((r >= 3 && r < 6) && (c >= 3 && c < 6)) {
            return boxes[4];
        } else if ((r >= 3 && r < 6) && (c >= 6 && c < 9)) {
            return boxes[5];
        } else if ((r >= 6 && r < 9) && (c >= 0 && c < 3)) {
            return boxes[6];
        } else if ((r >= 6 && r < 9) && (c >= 3 && c < 6)) {
            return boxes[7];
        } else if ((r >= 6 && r < 9) && (c >= 6 && c < 9)) {
            return boxes[8];
        }

        return null;
    }

    public static void driver() {
        SudokuSolver sudokuSolver = new SudokuSolver();
        System.out.println("Before");
        sudokuSolver.print();
        System.out.println("\nAfter");
        sudokuSolver.solve();

    }
}

class Box {

    private int[][] mat = new int[9][9];

    public Box(int[][] mat) {
        this.mat = mat;
    }

    public boolean isValid() {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {

                if (mat[r][c] == 0) {
                    continue;
                }

                if (set.contains(mat[r][c])) {
                    return false;
                } else {
                    set.add(mat[r][c]);
                }
            }
        }
        return true;
    }

    public int get(int r, int c) {
        return mat[r][c];
    }

    public void put(int v, int r, int c) {
        mat[r][c] = v;
    }
}
