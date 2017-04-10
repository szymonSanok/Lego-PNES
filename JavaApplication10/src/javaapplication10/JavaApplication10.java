package javaapplication10;

import java.util.Scanner;

public class JavaApplication10 {

    public static void main(String[] args) {

        int[][] quarter1 = new int[15][15];
        int[][] quarter2 = new int[15][15];
        int[][] quarter3 = new int[15][15];
        int[][] quarter4 = new int[15][15];
        int[][] quarter1o = new int[15][15];
        int[][] quarter2o = new int[15][15];
        int[][] quarter3o = new int[15][15];
        int[][] big = new int[100][100];
        resetTab(quarter1);
        resetTab(quarter2);
        resetTab(quarter3);
        resetTab(quarter4);

        Scanner scan = new Scanner(System.in);

        double angle = 0.0; //aby działała musi być równa ilości przebiegu pętli
        double distance = 200; //zależna od odczytu z czujnika
        double y = 0;
        double x = 0;
        double diff = 3.0; // kąt obrotu robota
        int move = 0;
        resetTab2(big);
        for (int z = 0; z < 3; z++) {
            for (int c = 0; c < 4; c++) {
                if (c == 0) {
                    quarter4 = calculate(quarter4, angle, diff, distance, x, y);
                }
                if (c == 1) {
                    quarter3 = calculate(quarter1, angle, diff, distance, x, y);
                }
                if (c == 2) {
                    quarter2 = calculate(quarter2, angle, diff, distance, x, y);
                }
                if (c == 3) {
                    quarter1 = calculate(quarter3, angle, diff, distance, x, y);
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

            
            big = merge(big, quarter2o, quarter1o, quarter3o, quarter4, move);
            move += 20; // odległość o jaką ma robot się przemieścic (dla celów testowych)
            //LegoEV3Controller.goForward(move+70); //po pełnym obrocie poruszanie się robota do przodu o 70cm
        }
        showBig(big);
    }

    public static int[][] calculate(int[][] table, double angle, double diff, double distance, double x, double y) {
        int[][] quarter = new int[15][15];
        Scanner scan = new Scanner(System.in);
        System.out.println(distance);
        for (int i = 0; i < 30; i++) { // petla wykonuje się 30 razy, pokryć najbardziej pesymistyczny przypadek
            System.out.println(distance);
            angle += diff;
            //distance= LegoEV3Controller.getDistance_UltrasonicSensor(1);
            if (i<=14)
                distance += 3;
            if (i>14)
                distance-=3;
            System.out.println(angle);
            y = Math.cos(Math.toRadians(angle)) * (distance / 15);
            y = Math.round(y);
            x = Math.sin(Math.toRadians(angle)) * (distance / 15);
            x = Math.round(x);
            System.out.println("y= " + y + " x= " + x);
            quarter[Math.abs((int) x)][Math.abs((int) y)] = 1;
            //LegoEV3Controller.rotate(diff); // ROBOT obrót o dany kąt
        }
        quarter[0][0] = 7;      //
        quarter[0][1] = 7;      //wielkosc robota
        quarter[1][0] = 7;      //stojącego na srodku
        quarter[1][1] = 7;      //

        return quarter;
    }

    public static void resetTab(int[][] table) {

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
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

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
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
        int[][] tableR = new int[15][15];
        resetTab(tableR);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                tableR[j][i] = table[i][14 - j];
            }
        }
        return tableR;
    }

    public static int[][] merge(int[][] big, int[][] tab1, int[][] tab2, int[][] tab3, int[][] tab4, int move) {
        
        for (int i = 0 + move; i < 15 + move; i++) {
            for (int j = 0; j < 15; j++) {
                big[i][j] = tab1[i - move][j];
            }
        }
        for (int i = 15 + move; i < 30 + move; i++) {
            for (int j = 0; j < 15; j++) {
                big[i][j] = tab3[i - 15 - move][j];
            }
        }

        for (int i = 0 + move; i < 15 + move; i++) {
            for (int j = 15; j < 30; j++) {
                big[i][j] = tab2[i - move][j - 15];
            }
        }

        for (int i = 15 + move; i < 30 + move; i++) {
            for (int j = 15; j < 30; j++) {
                big[i][j] = tab4[i - 15 - move][j - 15];
            }
        }

        return big;
    }
}
