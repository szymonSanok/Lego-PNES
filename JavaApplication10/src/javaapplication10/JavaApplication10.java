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

        int[][] cwiartka1 = new int[10][10];
        int[][] cwiartka2 = new int[10][10];
        int[][] cwiartka3 = new int[10][10];
        int[][] cwiartka4 = new int[10][10];
        int[][] cwiartka1o = new int[10][10];
        int[][] cwiartka2o = new int[10][10];
        int[][] cwiartka3o = new int[10][10];
        int[][] cala = new int[100][100];
        resetTab(cwiartka1);
        resetTab(cwiartka2);
        resetTab(cwiartka3);
        resetTab(cwiartka4);

        Scanner scan = new Scanner(System.in);

        double kat = 0.0; //aby być w miare dokładnym skok musi wynosić ok 3 stopnie
        double odleglosc = 0; //zależna od odczytu z czujnika
        double y;
        double x;
        double skok = 90.0 / 20.0;

        for (int c = 0; c < 4; c++) {

            if (c == 0) {
                odleglosc = 0;
                kat = 0.0;
                for (int i = 0; i < 20; i++) {
                    kat +=skok;
                    //odleglosc= LegoEV3Controller.getDistance_UltrasonicSensor(1);
                    System.out.println(kat);
                    y = Math.cos(Math.toRadians(kat)) * odleglosc;
                    //y=odleglosc;
                    y = Math.round(y);
                    x = Math.sin(Math.toRadians(kat)) * odleglosc;
                    x = Math.round(x);
                    System.out.println("y= " + y + " x= " + x);
                    cwiartka4[Math.abs((int) x)][Math.abs((int) y)] = 1;
                    //LegoEV3Controller.rotate(skok); // ROBOT obrót o dany kąt
                }
                cwiartka4[0][0] = 7;      //
                cwiartka4[0][1] = 7;      //wielkosc robota
                cwiartka4[1][0] = 7;      //stojącego na srodku
                cwiartka4[1][1] = 7;      //
            }
            if (c == 1) {
                odleglosc = 0;
                kat = 0.0;
                for (int i = 0; i < 20; i++) {
                    kat +=skok;
                    //odleglosc= LegoEV3Controller.getDistance_UltrasonicSensor(1);
                    System.out.println(kat);
                    y = Math.cos(Math.toRadians(kat)) * odleglosc;
                    //y=odleglosc;
                    y = Math.round(y);
                    x = Math.sin(Math.toRadians(kat)) * odleglosc;
                    x = Math.round(x);
                    System.out.println("y= " + y + " x= " + x);
                    cwiartka4[Math.abs((int) x)][Math.abs((int) y)] = 1;
                    //LegoEV3Controller.rotate(skok); // ROBOT obrót o dany kąt
                }
                cwiartka1[0][0] = 7;      //
                cwiartka1[0][1] = 7;      //wielkosc robota
                cwiartka1[1][0] = 7;      //stojącego na srodku
                cwiartka1[1][1] = 7;      //
            }
            if (c == 2) {
                odleglosc = 0;
                kat = 0.0;
                for (int i = 0; i < 20; i++) {
                    kat +=skok;
                    //odleglosc= LegoEV3Controller.getDistance_UltrasonicSensor(1);
                    System.out.println(kat);
                    y = Math.cos(Math.toRadians(kat)) * odleglosc;
                    //y=odleglosc;
                    y = Math.round(y);
                    x = Math.sin(Math.toRadians(kat)) * odleglosc;
                    x = Math.round(x);
                    System.out.println("y= " + y + " x= " + x);
                    cwiartka4[Math.abs((int) x)][Math.abs((int) y)] = 1;
                    //LegoEV3Controller.rotate(skok); // ROBOT obrót o dany kąt
                }
                cwiartka2[0][0] = 7;      //
                cwiartka2[0][1] = 7;      //wielkosc robota
                cwiartka2[1][0] = 7;      //stojącego na srodku
                cwiartka2[1][1] = 7;      //
            }
            if (c == 3) {
                odleglosc = 0;
                kat = 0.0;
                for (int i = 0; i < 20; i++) {
                    kat +=skok;
                    //odleglosc= LegoEV3Controller.getDistance_UltrasonicSensor(1);
                    System.out.println(kat);
                    y = Math.cos(Math.toRadians(kat)) * odleglosc;
                    //y=odleglosc;
                    y = Math.round(y);
                    x = Math.sin(Math.toRadians(kat)) * odleglosc;
                    x = Math.round(x);
                    System.out.println("y= " + y + " x= " + x);
                    cwiartka4[Math.abs((int) x)][Math.abs((int) y)] = 1;
                    //LegoEV3Controller.rotate(skok); // ROBOT obrót o dany kąt
                }
                cwiartka3[0][0] = 7;      //
                cwiartka3[0][1] = 7;      //wielkosc robota
                cwiartka3[1][0] = 7;      //stojącego na srodku
                cwiartka3[1][1] = 7;      //
            }
        }

        cwiartka1o = obroc(cwiartka1);
        cwiartka2o = obroc(cwiartka2);
        cwiartka2o = obroc(cwiartka2o);
        cwiartka3o = obroc(cwiartka3);
        cwiartka3o = obroc(cwiartka3o);
        cwiartka3o = obroc(cwiartka3o);

        wypisz(cwiartka1o);
        System.out.println("");
        wypisz(cwiartka2o);
        System.out.println("");
        wypisz(cwiartka3o);
        System.out.println("");
        wypisz(cwiartka4);
        System.out.println("");

        resetTab2(cala);
        cala = scalanie(cwiartka2o, cwiartka1o, cwiartka3o, cwiartka4);
        wypisz2(cala);
    }

    public static void resetTab(int[][] tablica) {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tablica[i][j] = 0;
            }
        }
    }

    public static void resetTab2(int[][] tablica) {

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                tablica[i][j] = 0;
            }
        }
    }

    public static void wypisz(int[][] tablica) {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(tablica[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void wypisz2(int[][] tablica) {

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                System.out.print(tablica[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] obroc(int[][] tablica) {
        int[][] tablicaO = new int[10][10];
        resetTab(tablicaO);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tablicaO[j][i] = tablica[i][9 - j];
            }
        }
        return tablicaO;
    }

    public static int[][] scalanie(int[][] tab1, int[][] tab2, int[][] tab3, int[][] tab4) {
        int[][] cala = new int[100][100];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cala[i][j] = tab1[i][j];
            }
        }
        for (int i = 10; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                cala[i][j] = tab3[i - 10][j];
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 10; j < 20; j++) {
                cala[i][j] = tab2[i][j - 10];
            }
        }

        for (int i = 10; i < 20; i++) {
            for (int j = 10; j < 20; j++) {
                cala[i][j] = tab4[i - 10][j - 10];
            }
        }

        return cala;
    }
}
