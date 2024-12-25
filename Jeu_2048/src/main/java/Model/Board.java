
package Model;

/**
 *
 * Allows you to initialize the game board, with different methods linked to the
 * manipulation of the game board.
 *
 * @author nader-54685
 */
public class Board {

    public static final int rowNumber = 4;
    public static final int columnNumber = 4;
    private final int[][] arrayOfElements;
    private Element element;

    /**
     * Simple constructor of board.
     */
    public Board() {
        this.arrayOfElements = new int[rowNumber][columnNumber];
       
    }

    /**
     * Simple getter of the array of elements.
     *
     * @return
     */
    public int[][] getArrayOfElements() {
        return arrayOfElements;
    }

    /**
     * chiceck if the board is full.
     *
     * @return true , otherwise return false.
     */
    public boolean isFull() {
        for (int i = 0; i < Board.rowNumber; i++) {
            for (int j = 0; j < Board.columnNumber; j++) {
                if (arrayOfElements[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;

    }

    /**
     * Checks if the case of the array of elements is empty.
     *
     * @param position the position of the case on the board.
     * @return true , otherwise return false.
     */
    public boolean isCaseEmpty(Position position) {
        return String.valueOf(this.arrayOfElements[position.getRow()][position.getCol()]).equals("0");
    }

    /**
     * Add a value that can be 2 or 4 in the board
     *
     * @param elementPosition the position of the case where the value will be
     * added.
     */
    public void addDefaultElement(Position elementPosition) {
        element = new Element();
        this.arrayOfElements[elementPosition.getRow()][elementPosition.getCol()] = element.defaultElement;
    }

    /**
     * Simple getter of the element's value.
     *
     * @param elementPosition the position of the element.
     * @return the value of the element.
     */
    public int getElement(Position elementPosition) {
        return arrayOfElements[elementPosition.getRow()][elementPosition.getCol()];
    }

}
