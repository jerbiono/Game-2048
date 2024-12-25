package Model;

import java.util.ArrayList;

/**
 *
 * Contains different the methods related to the 2048 game, it allows you to
 * move the elements in the game board according to the direction choiced by the
 * user and it allows to calculate the score and check if the game is over.
 *
 * @author nader-54685
 */
public class Game implements InterfaceGame {

    private final Board board;
    private int maxElementValue;
    private int score;

    /**
     * Simple constructor of the game.
     *
     * @param board
     */
    public Game(Board board) {
        this.board = board;
        this.score = 0;
    }

    /**
     * Simple getter of the biggest value of the board.
     *
     * @return the maxElementValue.
     */
    @Override
    public int getMaxElementValue() {
        return maxElementValue;
    }

    /**
     * Allows to move elements on the board according to the given direction.
     *
     * @param direction the given direction.
     */
    @Override
    public void moveElements(Direction direction) {
        switch (direction) {
            case EAST:

                moveEastElements();
                sumEastElements();
                moveEastElements();

                break;
            case WEST:

                moveWestElements();
                sumWestElements();
                moveWestElements();
                break;
            case NORTH:
                moveNorthElements();
                sumNorthElements();
                moveNorthElements();

                break;
            default:
                moveSouthElements();
                sumSouthElements();
                moveSouthElements();
                break;
        }
    }

    /**
     * Allows to move elements to the south direction.
     */
    public void moveSouthElements() {

        for (int col = 0; col < Board.columnNumber; col++) {
            for (int row = Board.rowNumber - 1; row > 0; row--) {
                int currentIndex = Board.rowNumber - 1;
                while (currentIndex > 0) {
                    if (board.getElement(new Position(currentIndex, col)) == 0 && board.getElement(new Position(currentIndex - 1, col)) != 0) {
                        int temp;
                        temp = board.getArrayOfElements()[currentIndex][col];
                        board.getArrayOfElements()[currentIndex][col] = board.getElement(new Position(currentIndex - 1, col));
                        board.getArrayOfElements()[currentIndex - 1][col] = temp;

                    }
                    currentIndex--;
                }
            }

        }
    }

    /**
     * Allows to move elements to the north direction.
     */
    public void moveNorthElements() {

        for (int col = 0; col < Board.columnNumber; col++) {
            for (int row = 0; row < Board.rowNumber; row++) {
                int currentIndex = 0;
                while (currentIndex < Board.rowNumber - 1) {
                    if (board.getElement(new Position(currentIndex + 1, col)) != 0 && board.getElement(new Position(currentIndex, col)) == 0) {
                        int temp;
                        temp = board.getArrayOfElements()[currentIndex][col];
                        board.getArrayOfElements()[currentIndex][col] = board.getElement(new Position(currentIndex + 1, col));
                        board.getArrayOfElements()[currentIndex + 1][col] = temp;

                    }
                    currentIndex++;
                }
            }

        }
    }

    /**
     * Allows to move elements to the east direction.
     */
    public void moveEastElements() {

        for (int row = 0; row < Board.rowNumber; row++) {
            for (int col = Board.columnNumber - 1; col > 0; col--) {
                int currentIndex = Board.columnNumber - 1;
                while (currentIndex > 0) {
                    if (board.getElement(new Position(row, currentIndex - 1)) != 0 && board.getElement(new Position(row, currentIndex)) == 0) {
                        int temp;
                        temp = board.getArrayOfElements()[row][currentIndex];
                        board.getArrayOfElements()[row][currentIndex] = board.getElement(new Position(row, currentIndex - 1));
                        board.getArrayOfElements()[row][currentIndex - 1] = temp;

                    }
                    currentIndex--;
                }
            }

        }
    }

    /**
     * Allows to move elements to the west direction.
     */
    public void moveWestElements() {

        for (int row = 0; row < Board.rowNumber; row++) {
            for (int col = 0; col < Board.columnNumber; col++) {
                int currentIndex = 0;

                while (currentIndex < Board.columnNumber - 1) {
                    if (board.getElement(new Position(row, currentIndex + 1)) != 0 && board.getElement(new Position(row, currentIndex)) == 0) {
                        int temp;
                        temp = board.getArrayOfElements()[row][currentIndex];
                        board.getArrayOfElements()[row][currentIndex] = board.getElement(new Position(row, currentIndex + 1));
                        board.getArrayOfElements()[row][currentIndex + 1] = temp;

                    }
                    currentIndex++;
                }

            }

        }

    }

    /**
     *
     * calculate the sum of each two consecutive elements and prepare them to
     * move in the west direction
     */
    public void sumWestElements() {

        for (int row = 0; row < Board.rowNumber; row++) {
            for (int col = 0; col < Board.columnNumber - 1; col++) {
                if (board.getElement(new Position(row, col)) != 0 && board.getElement(new Position(row, col)) == board.getElement(new Position(row, col + 1))) {
                    board.getArrayOfElements()[row][col] *= 2;
                    score += board.getArrayOfElements()[row][col];
                    board.getArrayOfElements()[row][col + 1] = 0;

                    setMaxElementValue(row, col);

                }

            }
        }
    }

    /**
     *
     * calculate the sum of each two consecutive elements and prepare them to
     * move in the north direction
     */
    public void sumNorthElements() {

        for (int col = 0; col < Board.columnNumber; col++) {
            for (int row = 0; row < Board.rowNumber - 1; row++) {
                if (board.getElement(new Position(row, col)) != 0 && board.getElement(new Position(row, col)) == board.getElement(new Position(row + 1, col))) {
                    board.getArrayOfElements()[row][col] *= 2;
                    score += board.getArrayOfElements()[row][col];
                    board.getArrayOfElements()[row + 1][col] = 0;

                    setMaxElementValue(row, col);

                }
            }
        }
    }

    /**
     *
     * calculate the sum of each two consecutive elements and prepare them to
     * move in the east direction
     */
    public void sumEastElements() {

        for (int row = 0; row < Board.rowNumber; row++) {
            for (int col = Board.columnNumber - 1; col > 0; col--) {
                if (board.getElement(new Position(row, col)) != 0 && board.getElement(new Position(row, col)) == board.getElement(new Position(row, col - 1))) {
                    board.getArrayOfElements()[row][col] *= 2;
                    score += board.getArrayOfElements()[row][col];
                    board.getArrayOfElements()[row][col - 1] = 0;

                    setMaxElementValue(row, col);

                }
            }
        }
    }

    /**
     *
     * calculate the sum of each two consecutive elements and prepare them to
     * move in the south direction
     */
    public void sumSouthElements() {
        for (int col = 0; col < Board.columnNumber; col++) {
            for (int row = Board.rowNumber - 1; row > 0; row--) {
                if (board.getElement(new Position(row, col)) != 0 && board.getElement(new Position(row, col)) == board.getElement(new Position(row - 1, col))) {
                    board.getArrayOfElements()[row][col] *= 2;
                    score += board.getArrayOfElements()[row][col];
                    board.getArrayOfElements()[row - 1][col] = 0;

                    setMaxElementValue(row, col);
                }

            }
        }
    }

    /**
     * Update and get the biggest element on the board.
     *
     * @param row the given row position.
     * @param col the given col postion.
     */
    private void setMaxElementValue(int row, int col) {
        if (this.maxElementValue < board.getArrayOfElements()[row][col]) {
            this.maxElementValue = board.getArrayOfElements()[row][col];
        }
    }

    /**
     *
     * checks the possibility of calculating the sum for the horizontal
     * direction
     *
     * @return return true if the calcul is allowed , otherwise return false.
     */
    public boolean canSumHorizontal() {
        for (int row = 0; row < Board.rowNumber; row++) {
            for (int col = Board.columnNumber - 1; col > 0; col--) {
                if (board.getElement(new Position(row, col)) != 0 && board.getElement(new Position(row, col)) == board.getElement(new Position(row, col - 1))) {
                    return true;
                }
            }
        }

        return false;

    }

    /**
     *
     * checks the possibility of calculating the sum for the vertical direction
     *
     * @return return true if the calcul is allowed , otherwise return false.
     */
    public boolean canSumVertical() {
        for (int col = 0; col < Board.columnNumber; col++) {
            for (int row = 0; row < Board.rowNumber - 1; row++) {
                if (board.getElement(new Position(row, col)) != 0 && board.getElement(new Position(row, col)) == board.getElement(new Position(row + 1, col))) {
                    return true;
                }
            }
        }
        return false;

    }

    /**
     * Checks if the direction is opt to make the sum.
     *
     * @param choiceUser the given direction
     * @return true if the sum to this direction is autorised , otherwise return
     * false.
     */
    @Override
    public boolean canSumDirection(Direction choiceUser) {

        switch (choiceUser) {
            case NORTH:
            case SOUTH:
                return canSumVertical();
            default:
                return canSumHorizontal();
        }

    }

    /**
     * Checks if the direction is opt to make the move.
     *
     * @param choiceUser the given direction
     * @return true if the move to this direction is autorised , otherwise
     * return false.
     */
    @Override
    public boolean canMoveDirection(Direction choiceUser) {

        switch (choiceUser) {
            case NORTH:
                return this.canNorthMove();
            case SOUTH:
                return this.canSouthMove();
            case WEST:
                return this.canWestMove();
            default:
                return this.canEastMove();
        }
    }

    /**
     *
     * checks the possibility of moving to the east direction
     *
     * @return return true if the move is allowed , otherwise return false.
     */
    public boolean canEastMove() {

        for (int row = 0; row < Board.rowNumber; row++) {
            for (int col = Board.columnNumber - 1; col > 0; col--) {
                int currentIndex = Board.columnNumber - 1;
                while (currentIndex > 0) {
                    if (board.getElement(new Position(row, currentIndex - 1)) != 0 && board.getElement(new Position(row, currentIndex)) == 0) {
                        return true;

                    }
                    currentIndex--;
                }
            }

        }
        return false;
    }

    /**
     *
     * checks the possibility of moving to the west direction
     *
     * @return return true if the move is allowed , otherwise return false.
     */
    public boolean canWestMove() {

        for (int row = 0; row < Board.rowNumber; row++) {
            for (int col = 0; col < Board.columnNumber; col++) {
                int currentIndex = 0;

                while (currentIndex < Board.columnNumber - 1) {
                    if (board.getElement(new Position(row, currentIndex + 1)) != 0 && board.getElement(new Position(row, currentIndex)) == 0) {
                        return true;

                    }
                    currentIndex++;
                }

            }

        }
        return false;

    }

    /**
     *
     * checks the possibility of moving to the north direction
     *
     * @return return true if the move is allowed , otherwise return false.
     */
    public boolean canNorthMove() {

        for (int col = 0; col < Board.columnNumber; col++) {
            for (int row = 0; row < Board.rowNumber; row++) {
                int currentIndex = 0;
                while (currentIndex < Board.rowNumber - 1) {
                    if (board.getElement(new Position(currentIndex + 1, col)) != 0 && board.getElement(new Position(currentIndex, col)) == 0) {
                        return true;

                    }
                    currentIndex++;
                }
            }

        }
        return false;
    }

    /**
     *
     * checks the possibility of moving to the south direction
     *
     * @return return true if the move is allowed , otherwise return false.
     */
    public boolean canSouthMove() {

        for (int col = 0; col < Board.columnNumber; col++) {
            for (int row = Board.rowNumber - 1; row > 0; row--) {
                int currentIndex = Board.rowNumber - 1;
                while (currentIndex > 0) {
                    if (board.getElement(new Position(currentIndex, col)) == 0 && board.getElement(new Position(currentIndex - 1, col)) != 0) {
                        return true;

                    }
                    currentIndex--;
                }
            }

        }
        return false;
    }

    /**
     * Checks if the game board is full and if no movement is allowed.
     *
     * @return true , otherwise return false.
     */
    @Override
    public boolean isBoardBlocked() {
        return this.board.isFull() && !canSumVertical() && !canSumHorizontal();
    }

    /**
     * Checks if the biggest value on the board is 2048 or if the board is
     * blocked.
     *
     * @return true, otherwise return false.
     */
    @Override
    public boolean isFinished() {
        return (this.maxElementValue >= 2048 || isBoardBlocked());
    }

    /**
     * Allows to get the available positions on the board.
     *
     * @return a list of available positions on the board.
     */
    private ArrayList<Position> getAvailablePositions() {
        ArrayList<Position> availablePositions = new ArrayList<>();
        for (int i = 0; i < Board.rowNumber; i++) {
            for (int j = 0; j < Board.columnNumber; j++) {
                Position position = new Position(i, j);
                if (board.isCaseEmpty(position)) {
                    availablePositions.add(position);
                }
            }
        }
        return availablePositions;
    }

    /**
     * Add element to an empty random position.
     */
    @Override
    public void addElement() {
        ArrayList<Position> availablePositions = getAvailablePositions();

        int randomPosition = (int) (Math.random() * availablePositions.size());
        if (!availablePositions.isEmpty()) {
            board.addDefaultElement(availablePositions.get(randomPosition));
        }
    }

    /**
     * Simple getter of score.
     *
     * @return the score.
     */
    @Override
    public int getScore() {
        return score;
    }

    /**
     * Simple getter of board.
     *
     * @return the board.
     */
    @Override
    public Board getBoard() {
        return board;
    }
}
