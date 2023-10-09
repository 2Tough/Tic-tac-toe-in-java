
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean player1Turn = true;
        boolean gameOver = false;
        String sign = player1Turn ? "X" : "O";

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

        System.out.println("Make your move");

        int[] coordinates = new int[2];
        for (int i = 0; i < 2; i++) {
            coordinates[i] = scanner.nextInt();
        }



        while (!gameOver) {
            if (!scanner.hasNextInt()) {
                System.out.println("You should enter numbers!");
            } else {

                int row = coordinates[0];
                int column = coordinates[1];
                int length = row < column ? column : row;

                // Make switch method for different situations

                //  Check if values are outside of range
                if (row == 4 || column == 4 || row == 4 && column == 4) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    for (int j = 0; j < 2; j++) {
                        coordinates[j] = scanner.nextInt();
                        row = coordinates[0];
                        column = coordinates[1];
                        length = row < column ? column : row;
                    }
                }

                // Check if position in board is filled
                if (table[row-1][column-1] == "O" || table[row-1][column-1] == "X") {
                    System.out.println("This cell is occupied! Choose another one!");
                    for (int k = 0; k < 2; k++) {
                        coordinates[k] = scanner.nextInt();
                        row = coordinates[0];
                        column = coordinates[1];
                        length = row < column ? column : row;
                    } continue;
                }


                // Check if input is int
                for (int i = 0; i <= 2; i++) {
                    if (table[i] == table[row-1]) {
                        for (int j = 0; j <= 2; j++) {
                            if (table[j] == table[column-1]) {
                                // Continue loop until board is filled
                                if (table[row-1][column-1] == " " && player1Turn) {
                                    table[row-1][column-1] = "X";
                                    player1Turn = false;
                                } else if (table[row-1][column-1] == " " && !player1Turn) {
                                    table[row-1][column-1] = "O";
                                    player1Turn = true;

                                }
                            }
                        }
                    }

                }


            }
            // Print updated table;
            System.out.println("---------");
            System.out.println("|" + " " + table[0][0] + " " + table[0][1] + " " + table[0][2] + " " + "|");
            System.out.println("|" + " " + table[1][0] + " " + table[1][1] + " " + table[1][2] + " " + "|");
            System.out.println("|" + " " + table[2][0] + " " + table[2][1] + " " + table[2][2] + " " + "|");
            System.out.println("---------");
        }

                /* if ((table[0][0] == "X" && table[0][1] == "X" && table[0][2] == "X") ||
                (table[0][0] == "X" && table[1][1] == "X" && table[2][2] == "X") ||
                (table[0][2] == "X" && table[1][0] == "X" && table[2][1] == "X") ||
                (table[0][0] == "X" && table[1][0] == "X" && table[2][0] == "X") ||
                (table[0][1] == "X" && table[1][1] == "X" && table[2][1] == "X") ||
                (table[0][2] == "X" && table[1][2] == "X" && table[2][2] == "X")
                ) {
                gameOver = true;
                System.out.println("X wins");

            } else if ((table[0][0] == "O" && table[0][1] == "O" && table[0][2] == "O") ||
                (table[0][0] == "O" && table[1][1] == "O" && table[2][2] == "O") ||
                (table[0][2] == "O" && table[1][0] == "O" && table[2][1] == "O") ||
                (table[0][0] == "O" && table[1][0] == "O" && table[2][0] == "O") ||
                (table[0][1] == "O" && table[1][1] == "O" && table[2][1] == "O") ||
                (table[0][2] == "O" && table[1][2] == "O" && table[2][2] == "O")
                ) {
                gameOver = true;
                System.out.println("O wins");
                }
               */
    }
}