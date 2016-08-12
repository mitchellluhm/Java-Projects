// Lab Partners:
// Chang-Hsin, Wu     wuxx1057
// Mitchell Luhm      luhmx009

import java.util.Arrays;
import java.util.Scanner;

public class BattleShipBoard {
    // the
    static int[][] board;
    static int highscore = 0;

    // constructor to make the board, place the ships and mines
    public BattleShipBoard(int m, int n) {
        // ensure valid size
        int size = m * n;

        if ((m >= 3 && n >= 3) && (m <= 10 && n <= 10)) {
            board = new int[m][n];
        }
        else {
            board = new int[3][3]; //default board if user enters an invalid row and columns combination
        }
        int c = numShipsMines(size);
        System.out.println("There are " + c + " ship(s).");
        while (c > 0) {
            addShip(m,n);
            addMine(m,n);
            c--;
        }
        testMode(); // for grading purposes display board.
    }

    public static int numShipsMines(int s) {

        if (s <= 16) {
            return 1;
        }
        else if (s <= 36) {
            return 2;
        }
        else {
            return 3;
        }
    }

    public static boolean checkCorner(int x, int y, int m, int n) {
        if (x == 0 && y == 0){
            return true;
        }
        else if (x == 0 && y == m-1){
            return true;
        }
        else if (x == n-1 && y == 0){
            return true;
        }
        else if (x == n-1 && y == m-1) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void addShip(int m, int n) {

        double orientation;
        int x, y;
        boolean valid_spot = false;
        while (valid_spot == false) {
            x = (int)Math.floor(Math.random() * n);
            y = (int)Math.floor(Math.random() * m);

            while (checkCorner(x, y, m, n) == true) {
                x = (int)Math.floor(Math.random() * n);
                y = (int)Math.floor(Math.random() * m);
            }

            // determine orientation (horizontal vs vertical)
            if (y == 0 || y == m - 1) {
                orientation = 0.75; // hor
            } else if (x == 0 || x == n - 1) {
                orientation = 0.25; // ver
            } else {
                orientation = Math.random();
            }

            // check if a ship/mine is already there, then place ship there
            if (orientation >= 0.5 && (board[y][x] == 0 && board[y][x + 1] == 0 && board[y][x - 1] == 0)) {
                board[y][x] = 8;
                board[y][x + 1] = 8; //hor
                board[y][x - 1] = 8;
                valid_spot = true;
            } else if (orientation < 0.5 && (board[y][x] == 0 && board[y + 1][x] == 0 && board[y - 1][x] == 0)) {
                board[y][x] = 8;
                board[y + 1][x] = 8; //ver
                board[y - 1][x] = 8;
                valid_spot = true;
            }
        }
    }

    public static void addMine(int m, int n) {
        int x = (int)Math.floor(Math.random() * n);
        int y = (int)Math.floor(Math.random() * m);

        while (board[y][x] != 0) {
            x = (int)Math.floor(Math.random() * n);
            y = (int)Math.floor(Math.random() * m);
        }
        board[y][x] = 9; //9 represents a mine
    }

    public static String checkUp1(int gR, int gC) {
        if (board[gR-1][gC] == 8) {
            return " but very close";
        }
        else {
            return "";
        }
    }

    public static String checkUp2(int gR, int gC) {
        if (board[gR-2][gC] == 8) {
            return " but close";
        }
        else {
            return "";
        }
    }

    public static String checkRight1(int gR, int gC) {
        if (board[gR][gC+1] == 8) {
            return " but very close";
        }
        else {
            return "";
        }
    }

    public static String checkRight2(int gR, int gC) {
        if (board[gR][gC+2] == 8) {
            return " but close";
        }
        else {
            return "";
        }
    }

    public static String checkDown1(int gR, int gC) {
        if (board[gR+1][gC] == 8) {
            return " but very close";
        }
        else {
            return "";
        }
    }

    public static String checkDown2(int gR, int gC) {
        if (board[gR+2][gC] == 8) {
            return " but close";
        }
        else {
            return "";
        }
    }

    public static String checkLeft1(int gR, int gC) {
        if (board[gR][gC-1] == 8) {
            return " but very close";
        }
        else {
            return "";
        }
    }

    public static String checkLeft2(int gR, int gC) {
        if (board[gR][gC-2] == 8) {
            return " but close";
        }
        else {
            return "";
        }
    }



    public static void hint(int gRow, int gCol, int r, int c) {
        if (gRow == 0 && gCol == 0) { //CORENERS
            System.out.print(checkDown1(gRow, gCol));
            System.out.print(checkDown2(gRow, gCol));
            System.out.print(checkRight1(gRow, gCol));
            System.out.print(checkRight2(gRow, gCol));
        }
        else if(gRow == r - 1 && gCol == 0) {
            System.out.print(checkUp1(gRow, gCol));
            System.out.print(checkUp2(gRow, gCol));
            System.out.print(checkRight1(gRow, gCol));
            System.out.print(checkRight2(gRow, gCol));
        }
        else if(gRow == 0 && gCol == c - 1) {
            System.out.print(checkLeft1(gRow, gCol));
            System.out.print(checkLeft2(gRow, gCol));
            System.out.print(checkDown1(gRow, gCol));
            System.out.print(checkDown2(gRow, gCol));
        }
        else if(gRow == r - 1 && gCol == c - 1) {
            System.out.print(checkLeft1(gRow, gCol));
            System.out.print(checkLeft2(gRow, gCol));
            System.out.print(checkUp1(gRow, gCol));
            System.out.print(checkUp2(gRow, gCol));
        }
        else if (gCol == 0 || gCol == c - 1) {
            if (gCol == 0) {
                System.out.print(checkRight1(gRow, gCol));
                System.out.print(checkRight2(gRow, gCol));
            }
            else {
                System.out.print(checkLeft1(gRow, gCol));
                System.out.print(checkLeft2(gRow, gCol));
            }
            System.out.print(checkUp1(gRow, gCol));
            System.out.print(checkDown1(gRow, gCol));

            if (gRow == 1 && r > 3) {
                System.out.print(checkDown2(gRow, gCol));
            }
            else if (gRow == r - 2 && r > 3) {
                System.out.print(checkUp2(gRow, gCol));
            }
            else if (gRow > 1 && gRow < r - 2) {
                System.out.print(checkDown2(gRow, gCol));
                System.out.print(checkUp2(gRow, gCol));
            }
        }
        else if (gRow == 0 || gRow == r - 1) {
            if (gRow == 0) {
                System.out.print(checkDown1(gRow, gCol));
                System.out.print(checkDown2(gRow, gCol));
            }
            else {
                System.out.print(checkUp1(gRow, gCol));
                System.out.print(checkUp2(gRow, gCol));
            }
            System.out.print(checkLeft1(gRow, gCol));
            System.out.print(checkRight1(gRow, gCol));
            if (gCol == 1 && c > 3) {
                System.out.print(checkRight2(gRow, gCol));
            }
            else if (gCol == c - 2 && c > 3) {
                System.out.print(checkLeft2(gRow, gCol));
            }
            else if (gCol > 1 && gCol < c - 2) {
                System.out.print(checkRight2(gRow, gCol));
                System.out.print(checkLeft2(gRow, gCol));
            }
        }
        else {
            System.out.print(checkRight1(gRow, gCol));
            System.out.print(checkRight2(gRow, gCol));
            System.out.print(checkLeft1(gRow, gCol));
            System.out.print(checkLeft2(gRow, gCol));
            System.out.print(checkUp1(gRow, gCol));
            System.out.print(checkUp2(gRow, gCol));
            System.out.print(checkDown1(gRow, gCol));
            System.out.print(checkDown2(gRow, gCol));
        }

    }

    public static void playGame(int r, int c) {
        System.out.println("The upper left coordinate is (0, 0)");
        System.out.println("Guess between (0, 0) and (" + (r-1) + ", " + (c-1) + ")");
        if (highscore == 0) {
            System.out.println("Best score: not set");
        }
        else {
            System.out.println("Best score: " + highscore);
        }
        Scanner g = new Scanner(System.in);

        boolean game_over = false;
        int guessRow, guessCol, turn=0;


        // each turn tell user hit/miss count, turn # and redudntnat guess
        while (!game_over) {
            System.out.println("Guess a Row then a Column separated by a space: ");
            guessRow = g.nextInt();
            guessCol = g.nextInt();
            while (!((0 <= guessRow && guessRow <= r-1) && (0 <= guessCol && guessCol <= c-1))) {
                System.out.println("Invalid coordinate, make sure the Row Guess is >= 0 and <= " + (r-1));
                System.out.println("And that the Column Guess is >= 0 and <= " + (c-1));
                System.out.println("Re-enter a guess of a Row then a Column separated by a space: ");
                guessRow = g.nextInt();
                guessCol = g.nextInt();
            }
            if (board[guessRow][guessCol] == 9) {
                System.out.print("Mine exploded. Charged an extra turn");
                hint(guessRow, guessCol, r, c);
                board[guessRow][guessCol] = 1;
                turn += 1;
            }
            else if (board[guessRow][guessCol] == 8) {
                System.out.print("Hit");
                board[guessRow][guessCol] = 1;
            }
            else if (board[guessRow][guessCol] == 1) {
                System.out.print("Redundant Strike");
                hint(guessRow, guessCol, r, c);
                turn += 1;
            }
            else {
                System.out.print("Miss");
                board[guessRow][guessCol] = 1;
                hint(guessRow, guessCol, r, c);
            }
            System.out.println(""); //new line for format
            turn += 1;
            game_over = true;
            //check to see if there are no 8's then game_over = true
            for(int i=0; i < board[0].length; i++) {
                for (int o=0; o < board.length; o++) {
                    if (board[o][i] == 8) {
                        game_over = false;
                    }
                }
            }
        }
        endGame(turn);
    }

    public static void endGame(int score) {
        System.out.println("All ships are sunk. Your score was " + score);
        if (highscore == 0) {
            highscore = score;
        }
        else if (score < highscore) {

            highscore = score;
        }

        Scanner playAgain = new Scanner(System.in);
        System.out.println("Type 0 to quit, Type 1 to keep playing");
        int keepPlaying = playAgain.nextInt();
        if (keepPlaying != 0) {
            Scanner size = new Scanner(System.in);

            System.out.println("Enter Amount of Rows such that 3 <= rows <= 10");
            int rows = size.nextInt();
            System.out.println("Enter Amount of Columns such that 3 <= rows <= 10");
            int columns = size.nextInt();
            BattleShipBoard test = new BattleShipBoard(rows,columns);
            test.playGame(rows, columns);
        }

    }

    public static void testMode() {
        System.out.println(Arrays.deepToString(board));
    }

    public static void main(String[] args) {
        Scanner size = new Scanner(System.in);

        System.out.println("Enter Amount of Rows such that 3 <= rows <= 10");
        int rows = size.nextInt();
        System.out.println("Enter Amount of Columns such that 3 <= rows <= 10");
        int columns = size.nextInt();
        new BattleShipBoard(rows,columns);

        playGame(rows, columns);


    }
}
