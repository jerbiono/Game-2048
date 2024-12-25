package Model;

/**
 * Represents the pricipal methods which allows to play the game.
 *
 * @author nader-54685
 */
public interface InterfaceGame {

    /**
     * Allows to move elements on the board according to the given direction.
     *
     * @param direction the given direction.
     */
    void moveElements(Direction direction);

    /**
     * Checks if the biggest value on the board is 2048 or if the board is
     * blocked.
     *
     * @return true, otherwise return false.
     */
    boolean isFinished();

    /**
     * Checks if the game board is full and if no movement is allowed.
     *
     * @return true , otherwise return false.
     */
    boolean isBoardBlocked();

    /**
     * Add element to an empty random position.
     */
    void addElement();

    /**
     * Checks if the direction is opt to make the move.
     *
     * @param choiceUser the given direction
     * @return true if the move to this direction is autorised , otherwise
     * return false.
     */
    boolean canMoveDirection(Direction choiceUser);

    /**
     * Simple getter of the biggest value of the board.
     *
     * @return the maxElementValue.
     */
    int getMaxElementValue();

    /**
     * Checks if the direction is opt to make the sum.
     *
     * @param choiceUser the given direction
     * @return true if the sum to this direction is autorised , otherwise return
     * false.
     */
    boolean canSumDirection(Direction choiceUser);

    /**
     * Simple getter of board.
     *
     * @return the board.
     */
    Board getBoard();

    /**
     * Simple getter of score.
     *
     * @return the score.
     */
    int getScore();

}
