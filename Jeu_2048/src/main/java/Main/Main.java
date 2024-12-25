
package Main;

import Controller.Controller;
import Model.Board;
import Model.Game;
import View.View;

/**
 * Allows to launch the game.
 *
 * @author nader-54685
 */
public class Main {

    public static void main(String[] args) {

        Controller controller = new Controller(new View(), new Game(new Board()));
        controller.playGame();
    }
}
