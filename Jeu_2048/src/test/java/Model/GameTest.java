package Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the game class.
 *
 * @author nader-54685
 */
public class GameTest {

    /**
     * Test of moveSouthElements method, of class Game.
     */
    @Test
    public void testMoveSouthElements() {
        System.out.println("test south move");
        Board board = new Board();
        Game game = new Game(board);
        board.getArrayOfElements()[0][0] = 8;
        game.moveSouthElements();
        int Result = board.getArrayOfElements()[Board.rowNumber - 1][0];
        int exResult = 8;
        int[][] array = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {8, 0, 0, 0}};
        assertArrayEquals(board.getArrayOfElements(), array);
        assertEquals(Result, exResult);
    }

    /**
     * Test of moveSouthElements method, of class Game.
     */
    @Test
    public void testMoveSouthElements2() {
        System.out.println("test south move");
        Board board = new Board();
        Game game = new Game(board);
        board.getArrayOfElements()[0][0] = 8;
        board.getArrayOfElements()[2][0] = 4;
        game.moveSouthElements();
        int Result = board.getArrayOfElements()[Board.rowNumber - 1][0];
        int exResult = 4;
        int Result1 = board.getArrayOfElements()[Board.rowNumber - 2][0];
        int exResult1 = 8;
        int[][] array = {{0, 0, 0, 0}, {0, 0, 0, 0}, {8, 0, 0, 0}, {4, 0, 0, 0}};
        assertArrayEquals(board.getArrayOfElements(), array);
        assertEquals(Result, exResult);
        assertEquals(Result1, exResult1);
    }

    /**
     * Test of moveSouthElements method, of class Game.
     */
    @Test
    public void testMoveSouthElementsAllCol() {
        System.out.println("test south move");
        Board board = new Board();
        Game game = new Game(board);
        board.getArrayOfElements()[0][0] = 8;
        board.getArrayOfElements()[0][1] = 32;
        board.getArrayOfElements()[0][2] = 128;
        board.getArrayOfElements()[0][3] = 512;
        board.getArrayOfElements()[2][0] = 4;
        board.getArrayOfElements()[2][1] = 16;
        board.getArrayOfElements()[2][2] = 64;
        board.getArrayOfElements()[2][3] = 256;
        game.moveSouthElements();
        int[][] array = {{0, 0, 0, 0}, {0, 0, 0, 0}, {8, 32, 128, 512}, {4, 16, 64, 256}};
        assertArrayEquals(board.getArrayOfElements(), array);
    }

    /**
     * Test of moveNorthElements method, of class Game.
     */
    @Test
    public void testMoveNorthElements() {

        System.out.println("test north move");
        Board board = new Board();
        Game game = new Game(board);
        board.getArrayOfElements()[3][0] = 8;
        game.moveNorthElements();
        int Result = board.getArrayOfElements()[0][0];
        int exResult = 8;
        int[][] array = {{8, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        assertArrayEquals(board.getArrayOfElements(), array);
        assertEquals(Result, exResult);
    }

    /**
     * Test of moveNorthElements method, of class Game.
     */
    @Test
    public void testMoveNorthElements2() {

        System.out.println("test north move");
        Board board = new Board();
        Game game = new Game(board);
        board.getArrayOfElements()[3][0] = 8;
        board.getArrayOfElements()[2][0] = 4;
        game.moveNorthElements();
        int Result = board.getArrayOfElements()[0][0];
        int exResult = 4;
        int Result1 = board.getArrayOfElements()[1][0];
        int exResult1 = 8;
        int[][] array = {{4, 0, 0, 0}, {8, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        assertArrayEquals(board.getArrayOfElements(), array);
        assertEquals(Result, exResult);
        assertEquals(Result1, exResult1);
    }

    /**
     * Test of moveSouthElements method, of class Game.
     */
    @Test
    public void testMoveNorthElementsAllCol() {
        System.out.println("test north move");
        Board board = new Board();
        Game game = new Game(board);
        board.getArrayOfElements()[3][0] = 8;
        board.getArrayOfElements()[3][1] = 32;
        board.getArrayOfElements()[3][2] = 128;
        board.getArrayOfElements()[3][3] = 512;
        board.getArrayOfElements()[1][0] = 4;
        board.getArrayOfElements()[1][1] = 16;
        board.getArrayOfElements()[1][2] = 64;
        board.getArrayOfElements()[1][3] = 256;
        game.moveNorthElements();
        int[][] array = {{4, 16, 64, 256}, {8, 32, 128, 512}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        assertArrayEquals(board.getArrayOfElements(), array);
    }

    /**
     * Test of moveEastElements method, of class Game.
     */
    @Test
    public void testMoveEastElements() {
        System.out.println("test east move");
        Board board = new Board();
        Game game = new Game(board);
        board.getArrayOfElements()[0][0] = 8;
        game.moveEastElements();
        int Result = board.getArrayOfElements()[0][3];
        int exResult = 8;
        int[][] array = {{0, 0, 0, 8}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        assertArrayEquals(board.getArrayOfElements(), array);
        assertEquals(Result, exResult);
    }

    /**
     * Test of moveNorthElements method, of class Game.
     */
    @Test
    public void testMoveEastElements2() {

        System.out.println("test east move");
        Board board = new Board();
        Game game = new Game(board);
        board.getArrayOfElements()[0][0] = 8;
        board.getArrayOfElements()[0][2] = 4;
        game.moveEastElements();
        int Result = board.getArrayOfElements()[0][3];
        int exResult = 4;
        int Result1 = board.getArrayOfElements()[0][2];
        int exResult1 = 8;
        int[][] array = {{0, 0, 8, 4}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        assertArrayEquals(board.getArrayOfElements(), array);
        assertEquals(Result, exResult);
        assertEquals(Result1, exResult1);
    }

    /**
     * Test of moveSouthElements method, of class Game.
     */
    @Test
    public void testMoveEastElementsAllRow() {
        System.out.println("test east move");
        Board board = new Board();
        Game game = new Game(board);
        board.getArrayOfElements()[0][0] = 8;
        board.getArrayOfElements()[1][0] = 32;
        board.getArrayOfElements()[2][0] = 128;
        board.getArrayOfElements()[3][0] = 512;
        board.getArrayOfElements()[0][2] = 4;
        board.getArrayOfElements()[1][2] = 16;
        board.getArrayOfElements()[2][2] = 64;
        board.getArrayOfElements()[3][2] = 256;
        game.moveEastElements();
        int[][] array = {{0, 0, 8, 4}, {0, 0, 32, 16}, {0, 0, 128, 64}, {0, 0, 512, 256}};
        assertArrayEquals(board.getArrayOfElements(), array);
    }

    /**
     * Test of moveWestElements method, of class Game.
     */
    @Test
    public void testMoveWestElements() {
        System.out.println("test west move");
        Board board = new Board();
        Game game = new Game(board);
        board.getArrayOfElements()[0][3] = 8;
        game.moveWestElements();
        int Result = board.getArrayOfElements()[0][0];
        int exResult = 8;
        int[][] array = {{8, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        assertArrayEquals(board.getArrayOfElements(), array);
        assertEquals(Result, exResult);
    }

    /**
     * Test of moveWestElements method, of class Game.
     */
    @Test
    public void testMoveWestElements2() {
        System.out.println("test west move");
        Board board = new Board();
        Game game = new Game(board);
        board.getArrayOfElements()[0][3] = 8;
        board.getArrayOfElements()[0][2] = 4;
        game.moveWestElements();
        int Result = board.getArrayOfElements()[0][0];
        int exResult = 4;
        int Result1 = board.getArrayOfElements()[0][1];
        int exResult1 = 8;
        int[][] array = {{4, 8, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        assertArrayEquals(board.getArrayOfElements(), array);
        assertEquals(Result, exResult);
        assertEquals(Result1, exResult1);
    }

    /**
     * Test of moveSouthElements method, of class Game.
     */
    @Test
    public void testMoveWestElementsAllRow() {
        System.out.println("test west move");
        Board board = new Board();
        Game game = new Game(board);
        board.getArrayOfElements()[0][3] = 8;
        board.getArrayOfElements()[1][3] = 32;
        board.getArrayOfElements()[2][3] = 128;
        board.getArrayOfElements()[3][3] = 512;
        board.getArrayOfElements()[0][1] = 4;
        board.getArrayOfElements()[1][1] = 16;
        board.getArrayOfElements()[2][1] = 64;
        board.getArrayOfElements()[3][1] = 256;
        game.moveWestElements();
        int[][] array = {{4, 8, 0, 0}, {16, 32, 0, 0}, {64, 128, 0, 0}, {256, 512, 0, 0}};
        assertArrayEquals(board.getArrayOfElements(), array);
    }

    /**
     * Test of addElement method, of class Game.
     */
    @Test
    public void testAddElement() {
        Board board = new Board();
        board.addDefaultElement(new Position(0, 0));
        assertTrue(!board.isCaseEmpty(new Position(0, 0)));
    }

    /**
     * Test of sumSouthElements method, of class Game.
     */
    @Test
    public void testSumSouthElements() {
        System.out.println("test south sum");
        Board board = new Board();
        Game game = new Game(board);
        board.getArrayOfElements()[0][0] = 8;
        board.getArrayOfElements()[1][0] = 8;
        game.sumSouthElements();
        int Result = board.getArrayOfElements()[1][0];
        int exResult = 16;
        assertEquals(Result, exResult);

    }

    /**
     * Test of sumSouthElements method, of class Game.
     */
    @Test
    public void testSumSouthElements2() {
        System.out.println("test south sum");
        Board board = new Board();
        Game game = new Game(board);
        board.getArrayOfElements()[0][0] = 8;
        board.getArrayOfElements()[1][0] = 8;
        board.getArrayOfElements()[2][0] = 4;
        board.getArrayOfElements()[3][0] = 4;
        board.getArrayOfElements()[0][2] = 32;
        board.getArrayOfElements()[1][2] = 32;
        board.getArrayOfElements()[2][2] = 64;
        board.getArrayOfElements()[3][2] = 64;
        game.sumSouthElements();
        int[][] array = {{0, 0, 0, 0}, {16, 0, 64, 0}, {0, 0, 0, 0}, {8, 0, 128, 0}};
        assertArrayEquals(array, board.getArrayOfElements());

    }

    /**
     * Test of sumSouthElements method, of class Game.
     */
    @Test
    public void testSumSouthElements3() {
        System.out.println("test south sum");
        Board board = new Board();
        Game game = new Game(board);
        board.getArrayOfElements()[0][0] = 8;
        board.getArrayOfElements()[1][0] = 16;
        board.getArrayOfElements()[2][0] = 4;
        board.getArrayOfElements()[3][0] = 32;
        board.getArrayOfElements()[0][2] = 8;
        board.getArrayOfElements()[1][2] = 16;
        board.getArrayOfElements()[2][2] = 64;
        board.getArrayOfElements()[3][2] = 16;
        game.sumSouthElements();
        int[][] array = {{8, 0, 8, 0}, {16, 0, 16, 0}, {4, 0, 64, 0}, {32, 0, 16, 0}};
        assertArrayEquals(array, board.getArrayOfElements());

    }

    /**
     * Test of isFinished method, of class Game.
     */
    @Test
    public void testIsFinished() {
        System.out.println("test if game is finished");
        Board board = new Board();
        Game game = new Game(board);
        board.getArrayOfElements()[2][0] = 1024;
        board.getArrayOfElements()[3][0] = 1024;
        game.sumNorthElements();
        game.moveNorthElements();
        game.sumNorthElements();
        assertTrue(game.isFinished());
    }

    @Test
    public void testIsFinished2() {
        System.out.println("test if game is finished");
        Board board = new Board();
        Game game = new Game(board);
        int val = 1;
        for (int i = 0; i < Board.rowNumber; i++) {
            for (int j = 0; j < Board.columnNumber; j++, val++) {
                board.getArrayOfElements()[i][j] = val;
            }
        }
        assertTrue(game.isFinished());
    }

    /**
     * Test of sumWestElements method, of class Game.
     */
    @Test
    public void testSumWestElements() {
        System.out.println("test west sum");
        Board board = new Board();
        Game game = new Game(board);
        board.getArrayOfElements()[0][0] = 8;
        board.getArrayOfElements()[0][1] = 8;
        game.sumWestElements();
        int Result = board.getArrayOfElements()[0][0];
        int exResult = 16;
        assertEquals(Result, exResult);

    }

    /**
     * Test of sumWestElements method, of class Game.
     */
    @Test
    public void testSumWestElements2() {
        System.out.println("test south sum");
        Board board = new Board();
        Game game = new Game(board);
        board.getArrayOfElements()[0][0] = 8;
        board.getArrayOfElements()[0][1] = 8;
        board.getArrayOfElements()[0][2] = 4;
        board.getArrayOfElements()[0][3] = 4;
        board.getArrayOfElements()[2][0] = 32;
        board.getArrayOfElements()[2][1] = 32;
        board.getArrayOfElements()[2][2] = 64;
        board.getArrayOfElements()[2][3] = 64;
        game.sumWestElements();
        int[][] array = {{16, 0, 8, 0}, {0, 0, 0, 0}, {64, 0, 128, 0}, {0, 0, 0, 0}};
        assertArrayEquals(array, board.getArrayOfElements());
    }

    /**
     * Test of sumWestElements method, of class Game.
     */
    @Test
    public void testSumWestElements3() {
        System.out.println("test south sum");
        Board board = new Board();
        Game game = new Game(board);
        board.getArrayOfElements()[0][0] = 8;
        board.getArrayOfElements()[0][1] = 16;
        board.getArrayOfElements()[0][2] = 4;
        board.getArrayOfElements()[0][3] = 32;
        board.getArrayOfElements()[2][0] = 8;
        board.getArrayOfElements()[2][1] = 16;
        board.getArrayOfElements()[2][2] = 64;
        board.getArrayOfElements()[2][3] = 16;
        game.sumWestElements();
        int[][] array = {{8, 16, 4, 32}, {0, 0, 0, 0}, {8, 16, 64, 16}, {0, 0, 0, 0}};
        assertArrayEquals(array, board.getArrayOfElements());
    }

    /**
     * Test of sumNorthElements method, of class Game.
     */
    @Test
    public void testSumNorthElements() {
        System.out.println("test north sum");
        Board board = new Board();
        Game game = new Game(board);
        board.getArrayOfElements()[0][0] = 8;
        board.getArrayOfElements()[1][0] = 8;
        game.sumNorthElements();
        int Result = board.getArrayOfElements()[0][0];
        int exResult = 16;
        assertEquals(Result, exResult);
    }

    /**
     * Test of sumNorthElements method, of class Game.
     */
    @Test
    public void testSumNorthElements2() {
        System.out.println("test north sum");
        Board board = new Board();
        Game game = new Game(board);
        board.getArrayOfElements()[0][0] = 8;
        board.getArrayOfElements()[1][0] = 8;
        board.getArrayOfElements()[2][0] = 4;
        board.getArrayOfElements()[3][0] = 4;
        board.getArrayOfElements()[0][2] = 32;
        board.getArrayOfElements()[1][2] = 32;
        board.getArrayOfElements()[2][2] = 64;
        board.getArrayOfElements()[3][2] = 64;
        game.sumNorthElements();
        int[][] array = {{16, 0, 64, 0}, {0, 0, 0, 0}, {8, 0, 128, 0}, {0, 0, 0, 0}};
        assertArrayEquals(array, board.getArrayOfElements());
    }

    /**
     * Test of sumNorthElements method, of class Game.
     */
    @Test
    public void testSumNorthElements3() {
        System.out.println("test north sum");
        Board board = new Board();
        Game game = new Game(board);
        board.getArrayOfElements()[0][0] = 8;
        board.getArrayOfElements()[1][0] = 16;
        board.getArrayOfElements()[2][0] = 4;
        board.getArrayOfElements()[3][0] = 32;
        board.getArrayOfElements()[0][2] = 8;
        board.getArrayOfElements()[1][2] = 16;
        board.getArrayOfElements()[2][2] = 64;
        board.getArrayOfElements()[3][2] = 16;
        game.sumNorthElements();
        int[][] array = {{8, 0, 8, 0}, {16, 0, 16, 0}, {4, 0, 64, 0}, {32, 0, 16, 0}};
        assertArrayEquals(array, board.getArrayOfElements());
    }

    /**
     * Test of sumEastElements method, of class Game.
     */
    @Test
    public void testSumEastElements() {
        System.out.println("test east sum");
        Board board = new Board();
        Game game = new Game(board);
        board.getArrayOfElements()[0][3] = 8;
        board.getArrayOfElements()[0][2] = 8;
        game.sumEastElements();
        int Result = board.getArrayOfElements()[0][3];
        int exResult = 16;
        assertEquals(Result, exResult);
    }

    /**
     * Test of sumEastElements method, of class Game.
     */
    @Test
    public void testSumEastElements2() {
        System.out.println("test east sum");
        Board board = new Board();
        Game game = new Game(board);
        board.getArrayOfElements()[0][0] = 8;
        board.getArrayOfElements()[0][1] = 8;
        board.getArrayOfElements()[0][2] = 4;
        board.getArrayOfElements()[0][3] = 4;
        board.getArrayOfElements()[2][0] = 32;
        board.getArrayOfElements()[2][1] = 32;
        board.getArrayOfElements()[2][2] = 64;
        board.getArrayOfElements()[2][3] = 64;
        game.sumEastElements();
        int[][] array = {{0, 16, 0, 8}, {0, 0, 0, 0}, {0, 64, 0, 128}, {0, 0, 0, 0}};
        assertArrayEquals(array, board.getArrayOfElements());
    }

    /**
     * Test of sumEastElements method, of class Game.
     */
    @Test
    public void testSumEastElements3() {
        System.out.println("test east sum");
        Board board = new Board();
        Game game = new Game(board);
        board.getArrayOfElements()[0][0] = 8;
        board.getArrayOfElements()[0][1] = 16;
        board.getArrayOfElements()[0][2] = 4;
        board.getArrayOfElements()[0][3] = 32;
        board.getArrayOfElements()[2][0] = 8;
        board.getArrayOfElements()[2][1] = 16;
        board.getArrayOfElements()[2][2] = 64;
        board.getArrayOfElements()[2][3] = 16;
        game.sumEastElements();
        int[][] array = {{8, 16, 4, 32}, {0, 0, 0, 0}, {8, 16, 64, 16}, {0, 0, 0, 0}};
        assertArrayEquals(array, board.getArrayOfElements());
    }

    /**
     * Test of canEastMove method, of class Game.
     */
    @Test
    public void testCanEastMove() {
        System.out.println("test east move");
        Board board = new Board();
        board.addDefaultElement(new Position(2, 3));
        board.addDefaultElement(new Position(1, 3));
        Game game = new Game(board);
        assertFalse(game.canEastMove());

    }

    /**
     * Test of canEastMove method, of class Game.
     */
    @Test
    public void testCanEastMove1() {
        System.out.println("test east move");
        Board board = new Board();
        board.addDefaultElement(new Position(2, 2));
        board.addDefaultElement(new Position(1, 3));
        Game game = new Game(board);
        assertTrue(game.canEastMove());

    }

    /**
     * Test of canEastMove method, of class Game.
     */
    @Test
    public void testCanEastMove3() {
        System.out.println("test east move");
        Board board = new Board();
        board.addDefaultElement(new Position(2, 3));
        board.addDefaultElement(new Position(1, 3));
        board.addDefaultElement(new Position(1, 2));
        Game game = new Game(board);
        assertFalse(game.canEastMove());

    }

    /**
     * Test of canEastMove method, of class Game.
     */
    @Test
    public void testCanEastMove2() {
        System.out.println("test east move");
        Board board = new Board();
        Game game = new Game(board);
        assertFalse(game.canEastMove());

    }

    /**
     * Test of canWestMove method, of class Game.
     */
    @Test
    public void testCanWestMove() {
        System.out.println("test west move");
        Board board = new Board();
        board.addDefaultElement(new Position(2, 0));
        board.addDefaultElement(new Position(1, 0));
        Game game = new Game(board);
        assertFalse(game.canWestMove());
    }

    /**
     * Test of canWestMove method, of class Game.
     */
    @Test
    public void testCanWestMove1() {
        System.out.println("test west move");
        Board board = new Board();
        board.addDefaultElement(new Position(2, 1));
        board.addDefaultElement(new Position(1, 0));
        Game game = new Game(board);
        assertTrue(game.canWestMove());
    }

    /**
     * Test of canWestMove method, of class Game.
     */
    @Test
    public void testCanWestMove3() {
        System.out.println("test west move");
        Board board = new Board();
        board.addDefaultElement(new Position(2, 0));
        board.addDefaultElement(new Position(2, 1));
        board.addDefaultElement(new Position(1, 0));
        Game game = new Game(board);
        assertFalse(game.canWestMove());
    }

    /**
     * Test of canWestMove method, of class Game.
     */
    @Test
    public void testCanWestMove2() {
        System.out.println("test west move");
        Board board = new Board();
        Game game = new Game(board);
        assertFalse(game.canWestMove());
    }

    /**
     * Test of canNorthMove method, of class Game.
     */
    @Test
    public void testCanNorthMove() {
        System.out.println("test north move");
        Board board = new Board();
        board.addDefaultElement(new Position(0, 1));
        board.addDefaultElement(new Position(0, 3));
        Game game = new Game(board);
        assertFalse(game.canNorthMove());

    }

    /**
     * Test of canNorthMove method, of class Game.
     */
    @Test
    public void testCanNorthMove1() {
        System.out.println("test north move");
        Board board = new Board();
        board.addDefaultElement(new Position(0, 1));
        board.addDefaultElement(new Position(1, 3));
        Game game = new Game(board);
        assertTrue(game.canNorthMove());

    }

    /**
     * Test of canNorthMove method, of class Game.
     */
    @Test
    public void testCanNorthMove3() {
        System.out.println("test north move");
        Board board = new Board();
        board.addDefaultElement(new Position(0, 1));
        board.addDefaultElement(new Position(1, 1));
        board.addDefaultElement(new Position(0, 3));
        Game game = new Game(board);
        assertFalse(game.canNorthMove());

    }

    /**
     * Test of canNorthMove method, of class Game.
     */
    @Test
    public void testCanNorthMove2() {
        System.out.println("test north move");
        Board board = new Board();
        Game game = new Game(board);
        assertFalse(game.canNorthMove());

    }

    /**
     * Test of canSouthMove method, of class Game.
     */
    @Test
    public void testCanSouthMove() {

        System.out.println("test south move");
        Board board = new Board();
        board.addDefaultElement(new Position(3, 0));
        board.addDefaultElement(new Position(3, 3));
        Game game = new Game(board);
        assertFalse(game.canSouthMove());
    }

    /**
     * Test of canSouthMove method, of class Game.
     */
    @Test
    public void testCanSouthMove1() {

        System.out.println("test south move");
        Board board = new Board();
        board.addDefaultElement(new Position(2, 0));
        board.addDefaultElement(new Position(3, 3));
        Game game = new Game(board);
        assertTrue(game.canSouthMove());
    }

    /**
     * Test of canSouthMove method, of class Game.
     */
    @Test
    public void testCanSouthMove3() {

        System.out.println("test south move");
        Board board = new Board();
        board.addDefaultElement(new Position(2, 0));
        board.addDefaultElement(new Position(3, 0));
        board.addDefaultElement(new Position(3, 3));
        Game game = new Game(board);
        assertFalse(game.canSouthMove());
    }

    /**
     * Test of canSouthMove method, of class Game.
     */
    @Test
    public void testCanSouthMove2() {

        System.out.println("test south move");
        Board board = new Board();
        Game game = new Game(board);
        assertFalse(game.canSouthMove());
    }

    /**
     * Test of isBoardBlocked method, of class Game.
     */
    @Test
    public void testIsBoardBlocked() {
        System.out.println("test board full and can't sum");
        Board board = new Board();
        Game game = new Game(board);
        int val = 2;
        for (int i = 0; i < Board.rowNumber; i++) {
            for (int j = 0; j < Board.columnNumber; j++) {
                board.getArrayOfElements()[i][j] = val;
                val *= 2;
            }

        }
        assertTrue(game.isBoardBlocked());

    }

    /**
     * Test of isBoardBlocked method, of class Game.
     */
    @Test
    public void testIsBoardBlocked2() {
        System.out.println("test board full and can sum");
        Board board = new Board();
        Game game = new Game(board);
        int val = 2;
        for (int i = 0; i < Board.rowNumber; i++) {
            for (int j = 0; j < Board.columnNumber; j++) {
                board.getArrayOfElements()[i][j] = val;
            }

        }
        assertFalse(game.isBoardBlocked());

    }

}
