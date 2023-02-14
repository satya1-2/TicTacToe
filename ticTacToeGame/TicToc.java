package ticTacToeGame;
import java.util.Scanner;
public class TicToc {
    char tictoc[][] = new char[3][3];
    public static void display(char tictoc[][]) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tictoc[i][j] + " ");
            }
            System.out.println();
        }
    }
    //Replace Function
    static void replace(char arr[][], char find, char replace) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == find) {
                    arr[i][j] = replace;
                    return;
                }
            }
        }
    }
    public boolean checkForWin() {
        return (checkForRow() || checkForColomn() || checkForDiagnol());
    }
    public boolean check(char c1, char c2, char c3) {
        return ((c1 == c2) && (c2 == c3));
    }
    public boolean checkForRow() {
        for (int i = 0; i < 3; i++) {
            if (check(tictoc[i][0], tictoc[i][1], tictoc[i][2]) == true)
                return true;
        }
        return false;
    }
    public boolean checkForColomn() {
        for (int i = 0; i < 3; i++) {
            if (check(tictoc[0][i], tictoc[1][i], tictoc[2][0]) == true)
                return true;
        }
        return false;
    }
    public boolean checkForDiagnol() {
        return ((check(tictoc[0][0], tictoc[1][1], tictoc[2][2]) == true) || (check(tictoc[0][2], tictoc[1][1], tictoc[2][0]) == true));
    }
    public static void main(String[] args) {
        TicToc game = new TicToc();
        Scanner inpute = new Scanner(System.in);
        //Select Player
        String user1, user2;
        char user1mark, user2mark;
        System.out.print("Enter Player one Name: ");
        user1 = inpute.nextLine();
        System.out.print("Enter Player two Name: ");
        user2 = inpute.nextLine();
        //Mark Selection
        System.out.println(user1 + " Select Your Marker (O or X): ");
        user1mark = inpute.next().charAt(0);
        while (user1mark != 'X' && user1mark != 'x' && user1mark != 'O' && user1mark != 'o') {
            System.out.print("Invalid Input (Select O or X): ");
            user1mark = inpute.next().charAt(0);
        }
        if (user1mark == 'X' || user1mark == 'x')
            user2mark = 'O';
        else
            user2mark = 'X';
        //initialize board
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                game.tictoc[i][j] = Character.forDigit(++counter, 10);
            }
        }
        //Display Board
        display(game.tictoc);
        //Play
        char input;
        for (int i = 0; i < 4; i++) {
            System.out.print(user1 + " Turn: ");
            input = inpute.next().charAt(0);
            replace(game.tictoc, input, user1mark);
            display(game.tictoc);
            System.out.print(user2 + " Turn: ");
            input = inpute.next().charAt(0);
            replace(game.tictoc, input, user2mark);
            display(game.tictoc);
        }
        System.out.print("User " + user1 + ": ");
        input = inpute.next().charAt(0);
        replace(game.tictoc, input, user1mark);
        display(game.tictoc);
        //Check For Win or Tie
        if (game.checkForWin())
            System.out.print("you win");
        else
            System.out.print("Match is Draw");
    }
}

