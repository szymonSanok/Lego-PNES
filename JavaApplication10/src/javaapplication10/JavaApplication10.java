/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication10;

import java.util.Scanner;

/**
 *
 * @author Simon
 */
public class JavaApplication10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[][] quarter1 = new int[10][10];
        int[][] quarter2 = new int[10][10];
        int[][] quarter3 = new int[10][10];
        int[][] quarter4 = new int[10][10];
        int[][] quarter1o = new int[10][10];
        int[][] quarter2o = new int[10][10];
        int[][] quarter3o = new int[10][10];
        int[][] big = new int[100][100];
        resetTab(quarter1);
        resetTab(quarter2);
        resetTab(quarter3);
        resetTab(quarter4);

        Scanner scan = new Scanner(System.in);

        double angle = 0.0; //aby być działała musi być równa ilości przebiegu pętli
        double distance = 0; //zależna od odczytu z czujnika
        double y;
        double x;
        double diff = 90.0 / 20.0;

        for (int c = 0; c < 4; c++) {

            if (c == 0) {
                distance = 0;
                angle = 0.0;
                for (int i = 0; i < 20; i++) { // ptla wykonuje się 20 razy, pokryć najbardziej pesymistyczny przypadek
                    angle += diff;
                    //distance= LegoEV3Controller.getDistance_UltrasonicSensor(1);
                    System.out.println(angle);
                    y = Math.cos(Math.toRadians(angle)) * distance;
                    //y=odleglosc;
                    y = Math.round(y);
                    x = Math.sin(Math.toRadians(angle)) * distance;
                    x = Math.round(x);
                    System.out.println("y= " + y + " x= " + x);
                    quarter4[Math.abs((int) x)][Math.abs((int) y)] = 1;
                    //LegoEV3Controller.rotate(diff); // ROBOT obrót o dany kąt
                }
                quarter4[0][0] = 7;      //
                quarter4[0][1] = 7;      //wielkosc robota
                quarter4[1][0] = 7;      //stojącego na srodku
                quarter4[1][1] = 7;      //
            }
            if (c == 1) {
                distance = 0;
                angle = 0.0;
                for (int i = 0; i < 20; i++) { // ptla wykonuje się 20 razy, pokryć najbardziej pesymistyczny przypadek
                    angle += diff;
                    //distance= LegoEV3Controller.getDistance_UltrasonicSensor(1);
                    System.out.println(angle);
                    y = Math.cos(Math.toRadians(angle)) * distance;
                    //y=odleglosc;
                    y = Math.round(y);
                    x = Math.sin(Math.toRadians(angle)) * distance;
                    x = Math.round(x);
                    System.out.println("y= " + y + " x= " + x);
                    quarter4[Math.abs((int) x)][Math.abs((int) y)] = 1;
                    //LegoEV3Controller.rotate(diff); // ROBOT obrót o dany kąt
                }
                quarter1[0][0] = 7;      //
                quarter1[0][1] = 7;      //wielkosc robota
                quarter1[1][0] = 7;      //stojącego na srodku
                quarter1[1][1] = 7;      //
            }
            if (c == 2) {
                distance = 0;
                angle = 0.0;
                for (int i = 0; i < 20; i++) { // ptla wykonuje się 20 razy, pokryć najbardziej pesymistyczny przypadek
                    angle += diff;
                    //distance= LegoEV3Controller.getDistance_UltrasonicSensor(1);
                    System.out.println(angle);
                    y = Math.cos(Math.toRadians(angle)) * distance;
                    //y=odleglosc;
                    y = Math.round(y);
                    x = Math.sin(Math.toRadians(angle)) * distance;
                    x = Math.round(x);
                    System.out.println("y= " + y + " x= " + x);
                    quarter4[Math.abs((int) x)][Math.abs((int) y)] = 1;
                    //LegoEV3Controller.rotate(diff); // ROBOT obrót o dany kąt
                }
                quarter2[0][0] = 7;      //
                quarter2[0][1] = 7;      //wielkosc robota
                quarter2[1][0] = 7;      //stojącego na srodku
                quarter2[1][1] = 7;      //
            }
            if (c == 3) {
                distance = 0;
                angle = 0.0;
                for (int i = 0; i < 20; i++) { // ptla wykonuje się 20 razy, pokryć najbardziej pesymistyczny przypadek
                    angle += diff;
                    //distance= LegoEV3Controller.getDistance_UltrasonicSensor(1);
                    System.out.println(angle);
                    y = Math.cos(Math.toRadians(angle)) * distance;
                    //y=odleglosc;
                    y = Math.round(y);
                    x = Math.sin(Math.toRadians(angle)) * distance;
                    x = Math.round(x);
                    System.out.println("y= " + y + " x= " + x);
                    quarter4[Math.abs((int) x)][Math.abs((int) y)] = 1;
                    //LegoEV3Controller.rotate(diff); // ROBOT obrót o dany kąt
                }
                quarter3[0][0] = 7;      //
                quarter3[0][1] = 7;      //wielkosc robota
                quarter3[1][0] = 7;      //stojącego na srodku
                quarter3[1][1] = 7;      //
            }
        }

        quarter1o = rotate(quarter1);
        quarter2o = rotate(quarter2);
        quarter2o = rotate(quarter2o);
        quarter3o = rotate(quarter3);
        quarter3o = rotate(quarter3o);
        quarter3o = rotate(quarter3o);

        show(quarter1o);
        System.out.println("");
        show(quarter2o);
        System.out.println("");
        show(quarter3o);
        System.out.println("");
        show(quarter4);
        System.out.println("");

        resetTab2(big);
        big = merge(quarter2o, quarter1o, quarter3o, quarter4);
        showBig(big);
    }

    public static void resetTab(int[][] table) {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                table[i][j] = 0;
            }
        }
    }

    public static void resetTab2(int[][] table) {

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                table[i][j] = 0;
            }
        }
    }

    public static void show(int[][] table) {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void showBig(int[][] table) {

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] rotate(int[][] table) {
        int[][] tableR = new int[10][10];
        resetTab(tableR);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tableR[j][i] = table[i][9 - j];
            }
        }
        return tableR;
    }

    public static int[][] merge(int[][] tab1, int[][] tab2, int[][] tab3, int[][] tab4) {
        int[][] big = new int[100][100];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                big[i][j] = tab1[i][j];
            }
        }
        for (int i = 10; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                big[i][j] = tab3[i - 10][j];
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 10; j < 20; j++) {
                big[i][j] = tab2[i][j - 10];
            }
        }

        for (int i = 10; i < 20; i++) {
            for (int j = 10; j < 20; j++) {
                big[i][j] = tab4[i - 10][j - 10];
            }
        }

        return big;
    }
}
