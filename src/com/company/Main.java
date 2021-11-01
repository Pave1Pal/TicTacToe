package com.company;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
            throws  InterruptedException {

        Scanner scan = new Scanner(System.in);
        Board board = new Board();
        int row;
        int column;

        board.show();

        do {
            try {
                System.out.println("Сейчас вводят " + "\"" + board.outSymbol.symbol + "\"");

                System.out.println("Введите номер строки");
                row = scan.nextInt();
                System.out.println("Введите номер номер столбца");
                column = scan.nextInt();

                board.insert(row, column);
                board.show();

            } catch (ArrayIndexOutOfBoundsException exc) {
                Thread.sleep(500);
                System.out.println("Вы вышли за перделы таблицы" +
                        ", введите значения положения заного");

            } catch (BusyFieldException exc) {
                Thread.sleep(500);
                System.out.println("Это поле уже занято, выберите другое поле");
            } catch (InputMismatchException exc) {
                System.out.println("Вы ввели неверное значение," +
                        " введите значения поля заного");
                scan.nextLine();
            }

        } while (board.step != 9 & !board.win());

        if (board.win())
            System.out.println("\"" + board.insertSymbol.symbol + "\"" + " - ПОБЕДИЛ");
        else
            System.out.println("ПОБЕДИЛА ДРУЖБА!");

        System.out.println("ИГРА ЗАКОНЧЕНА");
    }
}
