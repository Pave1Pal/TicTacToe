package com.company;
import java.util.Arrays;

public class Symbol {

    char symbol;
    int[][] busyFieldChar = new int[5][2];
    int posInBusyFiled = 0;

    Symbol(char symbol) {
        this.symbol = symbol;
    }

    public void insertBusyFieldChar(int row, int column) {
        busyFieldChar[posInBusyFiled][0] = row;
        busyFieldChar[posInBusyFiled][1] = column;
        posInBusyFiled ++;
    }

    public boolean isWin() {

        int stepToWinRow = 0;
        int stepToWinColumn = 0;
        int stepToWinDiagonalL = 0;
        int stepToWinDiagonalR = 0;

        for (int k = 1; k <= 3; k++) {
            for (int i = 0; i < busyFieldChar.length; i++) {

                if (Arrays.compare(busyFieldChar[i], new int[] {k, 1}) == 0 |
                        Arrays.compare(busyFieldChar[i], new int[] {k, 2}) == 0 |
                        Arrays.compare(busyFieldChar[i], new int[] {k, 3}) == 0) {
                    stepToWinRow ++;
                    if (stepToWinRow == 3)
                        return true;
                }

                if (Arrays.compare(busyFieldChar[i], new int[] {1, k}) == 0 |
                        Arrays.compare(busyFieldChar[i], new int[] {2, k}) == 0 |
                        Arrays.compare(busyFieldChar[i], new int[] {3, k}) == 0) {
                    stepToWinColumn ++;
                    if (stepToWinColumn == 3)
                        return true;
                }

                if (Arrays.compare(busyFieldChar[i], new int[] {k, k}) == 0) {
                    stepToWinDiagonalL ++;
                    if (stepToWinDiagonalL == 3)
                        return true;
                }

                if (Arrays.compare(busyFieldChar[i], new int[] {k, 4-k}) == 0)
                    stepToWinDiagonalR ++;
                    if (stepToWinDiagonalR == 3)
                        return true;
            }

            stepToWinColumn = 0;
            stepToWinRow = 0;
        }
        return false;
    }
}
