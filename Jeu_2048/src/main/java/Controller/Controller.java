package Controller;

import Model.Board;
import Model.Direction;
import Model.Game;
import Model.InterfaceGame;
import ViewJavaFx.Observer;
import View.InterfaceView;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.input.KeyEvent;

/**
 * Allows to link between the view and the game and contain the main methode to
 * play the game.
 *
 * @author nader-54685
 */
public class Controller implements Observable {

    public static boolean winDeclared = false;
    public static boolean looseDeclared = false;
    private int gameStatus = 0;
    private InterfaceView view;
    private InterfaceGame game;
    private List<Observer> observers = new ArrayList<>();

    /**
     * Simple constructor of Controller.
     *
     * @param view the given view.
     * @param game the given game.
     */
    public Controller(InterfaceView view, InterfaceGame game) {
        this.view = view;
        this.game = game;
    }

    /**
     * Simple constructor of Controller
     */
    public Controller() {
        this.game = new Game(new Board());
        this.game.addElement();
    }

    /**
     * Simple getter of the array of elements.
     *
     * @return the array of elements.
     */
    public int[][] getArrayOfElements() {
        return this.game.getBoard().getArrayOfElements();
    }

    /**
     * Simple getter of the score.
     *
     * @return the score.
     */
    public int getScore() {
        return this.game.getScore();
    }

    /**
     * Simple Setter of game status..
     */
    public void setGameStatus() {
        this.gameStatus = -1;
    }

    /**
     * Simple getter of game status.
     *
     * @return the game status.
     */
    public int getGameStatus() {
        return this.gameStatus;
    }

    /**
     * Allows to return the direction chosen by the user according to the
     * keyboard key chosen
     *
     * @param event the keyBoard key released
     * @return the choiced direction .
     */
    public Direction getFlechDirection(KeyEvent event) {
        switch (event.getCode()) {
            case UP:
                return Direction.NORTH;
            case DOWN:
                return Direction.SOUTH;
            case LEFT:
                return Direction.WEST;
            case RIGHT:
                return Direction.EAST;
        }
        return null;
    }

    /**
     * Allows to move the elements according to the giving direction.
     *
     * @param direction the given direction.
     */
    public void moveFlechDirection(Direction direction) {
        switch (direction) {
            case NORTH:
                this.game.moveElements(Direction.NORTH);
                break;
            case EAST:
                this.game.moveElements(Direction.EAST);
                break;
            case WEST:
                this.game.moveElements(Direction.WEST);
                break;
            default:
                this.game.moveElements(Direction.SOUTH);
        }
    }

    /**
     * Allows to play the game according to the keyboard key choiced.
     *
     * @param event the value of the key inputed by the user.
     */
    public void play(KeyEvent event) {
        Direction direction = getFlechDirection(event);
        if (direction != null && (!winDeclared && !looseDeclared)) {
            if (game.canMoveDirection(direction) || game.canSumDirection(direction)) {
                moveFlechDirection(direction);
                game.addElement();
            } else {
                if (!looseDeclared && !winDeclared) {
                    gameStatus = 1;
                }
            }
            if ((game.isBoardBlocked() && !looseDeclared)) {

                gameStatus = 3;
            }

            if ((this.game.getMaxElementValue() >= 2048 && !winDeclared)) {
                gameStatus = 2;
            }
            this.notifyObservers();
        }
    }

    /**
     * Allows to play the Game.
     */
    public void playGame() {
        while (!game.isFinished()) {
            game.addElement();
            this.printGameStatus();
            this.move();
        }

    }

    /**
     * Allows to move to the unblocked direction.
     */
    public void move() {
        if (!game.isBoardBlocked()) {
            Direction direction = this.getUserDirection();
            if (game.canMoveDirection(direction) || this.game.canSumDirection(direction)) {
                game.moveElements(direction);
                if (!game.canMoveDirection(direction)) {
                    playGame();
                }
            } else {
                view.setMessage("\nyou can't move to the " + direction + "\nplease choose another direction\n");
                printGameStatus();
                move();
            }
        } else {
            printResult();
        }

    }

    /**
     * Simple getter of the direction choiced by the user
     *
     * @return the direction.
     */
    public Direction getUserDirection() {
        char userChoice = view.choiceDirection();

        switch (userChoice) {
            case 'e':
                return Direction.EAST;
            case 'w':
                return Direction.WEST;
            case 'n':
                return Direction.NORTH;
            case 's':
                return Direction.SOUTH;

        }
        return null;
    }

    /**
     * Create new Instance of Game.
     */
    public void newGame() {
        this.game = new Game(new Board());
        game.addElement();
        looseDeclared = false;
        winDeclared = false;
        gameStatus = 4;

    }

    /**
     * Print the score and the values of squares on the board
     */
    public void printGameStatus() {
        view.displayBoard(game.getBoard());
        view.printScore(game.getScore());
    }

    /**
     * Print the final result of the game.
     */
    public void printResult() {
        view.setMessage("the game is finished !!");
        if (game.getMaxElementValue() == 2048) {
            view.setMessage("Good Game you won !!");
        } else {
            view.setMessage("Game over you loose!!");
        }
    }

    /**
     * Adds an observer to the list of observers for this object, provided that
     * it is not the same as some observer already in the list.
     *
     * @param observer the given observer.
     */
    @Override
    public void registerObserver(Observer observer) {
        if (!this.observers.contains(observer)) {
            this.observers.add(observer);
        }
    }

    /**
     * ALlows to notify all the observers.
     */
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }

    }

}
