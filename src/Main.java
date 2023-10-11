package tictactoe;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean player1Turn = true;
        boolean gameOver = false;


        String[][] table = {
                {" "," "," "},
                {" "," "," "},
                {" "," "," "}
        };

        System.out.println("---------");
        System.out.println("|" + " " + table[0][0] + " " + table[0][1] + " " + table[0][2]  + " " + "|");
        System.out.println("|" + " " + table[1][0] + " " + table[1][1] + " " + table[1][2]  + " " + "|");
        System.out.println("|" + " " + table[2][0] + " " + table[2][1] + " " + table[2][2]  + " " + "|");
        System.out.println("---------");

        while (!gameOver) {
            if (!scanner.hasNextInt()) {
                System.out.println("You should enter numbers!");
            } else {

                String sign = player1Turn ? "X" : "O";

                int[] coordinates = new int[2];
                for (int i = 0; i < 2; i++) {
                    coordinates[i] = scanner.nextInt();

                }

                int row = coordinates[0];
                int column = coordinates[1];
                int length = row < column ? column : row;


                // Check if values are outside of range
                while (row == 4 || column == 4 || row == 4 && column == 4) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    for (int j = 0; j < 2; j++) {
                        coordinates[j] = scanner.nextInt();
                        row = coordinates[0];
                        column = coordinates[1];
                        length = row < column ? column : row;
                    }
                    System.out.println("print new row: " +  row);
                    System.out.println("print new row: " +  column);
                }

                if (table[row-1][column-1] != " ") {
                    System.out.println("This cell is occupied! Choose another one!");
                    for (int k = 0; k < 2; k++) {
                        coordinates[k] = scanner.nextInt();
                        row = coordinates[0];
                        column = coordinates[1];
                        length = row < column ? column : row;
                    }
                } else {
                    table[row-1][column-1] = sign;
                    player1Turn = !player1Turn;
                }

                // Error occours when input is 4, as table only goes from 0 - 2, and after calculating row 4 -1 = 3
            }
            // Print updated table;
            System.out.println("---------");
            System.out.println("|" + " " + table[0][0] + " " + table[0][1] + " " + table[0][2] + " " + "|");
            System.out.println("|" + " " + table[1][0] + " " + table[1][1] + " " + table[1][2] + " " + "|");
            System.out.println("|" + " " + table[2][0] + " " + table[2][1] + " " + table[2][2] + " " + "|");
            System.out.println("---------");
        }

    }
}