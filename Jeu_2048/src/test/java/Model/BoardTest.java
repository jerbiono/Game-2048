package Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Board class.
 *
 * @author nader-54685
 */
public class BoardTest {

    Board board = new Board();

    /**
     * Test of checkEmptyBoard method, of class Board.
     */
    @org.junit.jupiter.api.Test
    public void testisFull1() {
        System.out.println("check full board");
        board = new Board();
        for (int i = 0; i < Board.rowNumber; i++) {
            for (int j = 0; j < Board.columnNumber; j++) {
                board.getArrayOfElements()[i][j] = 2;
            }
        }
        boolean result = board.isFull();
        boolean expResult = true;
        assertEquals(result, expResult);
    }

    /**
     * Test of checkEmptyBoard method, of class Board.
     */
    @org.junit.jupiter.api.Test
    public void testisFull2() {
        System.out.println("check Full board");
        board = new Board();
        board.getArrayOfElements()[2][1] = 2;
        boolean result = board.isFull();
        boolean expResult = false;
        assertEquals(result, expResult);
    }

    /**
     * Test of checkEmptyCase method, of class Board.
     */
    @org.junit.jupiter.api.Test
    public void testCheckEmptyCase1() {
        System.out.println("check empty case");
        board.getArrayOfElements()[2][3] = 2;
        boolean result = board.isCaseEmpty(new Position(2, 3));
        boolean expResult = false;
        assertEquals(result, expResult);

    }

    /**
     * Test of checkEmptyCase method, of class Board.
     */
    @org.junit.jupiter.api.Test
    public void testCheckEmptyCase2() {
        System.out.println("check empty case");
        boolean result = board.isCaseEmpty(new Position(1, 2));
        boolean expResult = true;
        assertEquals(result, expResult);

    }

    /**
     * Test of addNewElement method, of class Board.
     */
    @Test
    public void testAddDefaultElement() {
        System.out.println("add default element");
        board.addDefaultElement(new Position(0, 2));
        int result = board.getArrayOfElements()[0][2];
        int exResult = 2;
        assertEquals(result, exResult);
    }

}
