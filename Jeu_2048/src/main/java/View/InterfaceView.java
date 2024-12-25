
package View;

import Model.Board;

/**
 * Represents the pricipal methods which allows the user to know the status of
 * the game.
 *
 * @author nader-54685
 */
public interface InterfaceView {

    /**
     * Simple setter of a message.
     *
     * @param msg the given message.
     */
    void setMessage(String msg);

    /**
     * Allows to get the character which refered to the direction choiced by the
     * user.
     *
     * @return the character choiced.
     */
    char choiceDirection();

    /**
     * Print the board's values.
     *
     * @param board the given board.
     */
    void displayBoard(Board board);

    /**
     * Print the score of the user.
     *
     * @param score the given score.
     */
    void printScore(int score);
}
