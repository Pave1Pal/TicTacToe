package com.company;
import java.util.Arrays;

public class Board {

    private final Symbol X = new Symbol('X');
    private final Symbol O = new Symbol('O');
    Symbol insertSymbol = O;
    Symbol outSymbol = O;

    private int[][] busy = new int[9][2];
    int step = 0;

    char[][] board = {
            {' ', '|', ' ', '|',' '},
            {'-', '+', '-', '+','-'},
            {' ', '|', ' ', '|',' '},
            {'-', '+', '-', '+','-'},
            {' ', '|', ' ', '|',' '}
    };

    public void insert(int row, int column)
            throws ArrayIndexOutOfBoundsException, BusyFieldException {
        if (step % 2 != 0) insertSymbol = X;
        else insertSymbol = O;
        try {
            for (int[] i : busy) {
                if (this.isInBusy(row,column)) {
                    throw new BusyFieldException();
                }
            }
            board[(row - 1) * 2][(column - 1) * 2] = insertSymbol.symbol;
            busy[step][0] = row;
            busy[step][1] = column;
            insertSymbol.insertBusyFieldChar(row, column);
            step++;
            if (step % 2 != 0) outSymbol = X;
            else outSymbol = O;

        } catch (IndexOutOfBoundsException exc) {
            throw new ArrayIndexOutOfBoundsException();
        } catch (BusyFieldException exc) {
            throw new BusyFieldException();
        }
    }

    public void show() {
        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[i].length; k++) {
                System.out.print(board[i][k]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean isInBusy(int row, int column) {
        int[] field = new int[] {row, column};
        for (int[] i : busy) {
            if (Arrays.equals(i, field))
                return true;
        }
        return false;
    }

    public boolean win() {
        return insertSymbol.isWin();
    }
}
