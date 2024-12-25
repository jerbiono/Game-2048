/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Board;
import java.util.Scanner;

/**
 *
 * Allows user interaction and takes care of all board display and game status
 *
 * @author nader-54685
 */
public class View implements InterfaceView{

    Scanner sc = new Scanner(System.in);

    /**
     * Simple setter of a message.
     *
     * @param msg the given message.
     */
    @Override
    public void setMessage(String msg) {
        System.out.println(msg);
    }

    /**
     * Allows to get the character which refered to the direction choiced by the
     * user.
     *
     * @return the character choiced.
     */
    @Override
    public char choiceDirection() {
        String userChoice;
        setMessage("enter the direction you want to make the movement : you can input it in lowercase or uppercase.");
        setMessage("NORTH Direction : input the character n. \nSOUTH Direction : input the character s. \nEAST  Direction : input the character e. \nWEST  Direction : input the character w.");
        userChoice = sc.next().toLowerCase();
        char direction = userChoice.charAt(0);
        while ((direction != 'w' && direction != 'e' && direction != 'n' && direction != 's') || userChoice.length() != 1) {
            setMessage("you should input : \n n or s or e or w ");
            userChoice = sc.next().toLowerCase();
            direction = userChoice.charAt(0);
        }
        return direction;
    }

    /**
     * Print the board's values.
     *
     * @param board the given board.
     */
    @Override
    public void displayBoard(Board board) {
        
        for (int i = 0; i < Board.rowNumber; i++) {
            System.out.print("|");
            for (int j = 0; j < Board.columnNumber; j++) {

                switch (String.valueOf(board.getArrayOfElements()[i][j]).length()) {
                    case 1:
                        System.out.print("         " + board.getArrayOfElements()[i][j] + "        |");
                        break;
                    case 2:
                        System.out.print("        " + board.getArrayOfElements()[i][j] + "        |");
                        break;
                    case 3:
                        System.out.print("        " + board.getArrayOfElements()[i][j] + "       |");
                        break;
                    case 4:
                        System.out.print("        " + board.getArrayOfElements()[i][j] + "      |");
                        break;

                }
            }
            System.out.println("");
        }
        System.out.println("");
    }

    /**
     * Print the score of the user.
     *
     * @param score the given score.
     */
    @Override
    public void printScore(int score) {
        setMessage("your current score is : " + score);
    }

}
