
package Model;

/**
 * Allows to have the position of case on the board.
 *
 * @author nader-54685
 */
public class Position {

    private final int row;
    private final int col;

    /**
     * Simple constructor of position.
     *
     * @param row the given row position.
     * @param col the given col position.
     */
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Simple getter of row position.
     *
     * @return row position.
     */
    public int getRow() {
        return row;
    }

    /**
     * Simple getter of col position.
     *
     * @return col position.
     */
    public int getCol() {
        return col;
    }

}
