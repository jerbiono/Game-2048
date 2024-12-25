package ViewJavaFx;

import Controller.Controller;
import javafx.scene.control.Button;

/**
 * Represnts the button of reset in the view.
 *
 * @author Nader - 54685
 */
public final class RestartButton extends Button {

    private final Button retryButton;
    private final Controller gameController;
    private final BoardView boardView;
    private final ScoreView scoreView;
    private final statusView gameStatus;

    /**
     * Simple constructor of the the reset button.
     *
     * @param gameController
     * @param boardView the view of the board.
     * @param scoreView the view of score
     * @param gameStatus the view of the list of the game status.
     */
    public RestartButton(Controller gameController, BoardView boardView, ScoreView scoreView, statusView gameStatus) {
        this.boardView = boardView;
        this.scoreView = scoreView;
        this.gameStatus = gameStatus;
        this.gameController = gameController;
        this.retryButton = new Button("Recommencer");
        this.retryButton.setStyle(
                "-fx-text-fill: white;"
                + " -fx-background-color:#8e7965;"
                + "-fx-font-family: Courier New;"
                + "-fx-font-weight: bold;"
                + "-fx-font-size: 20;"
        );
        this.retryButton.setFocusTraversable(false);
        clear();
    }

    /**
     * Allows to clear all the view containers.
     */
    public void clear() {
        this.retryButton.setOnAction(event -> {
            gameController.newGame();
            boardView.updateBoard(gameController.getArrayOfElements());
            scoreView.updateScore(gameController.getScore());
            gameStatus.getStatusContainer().getItems().clear();
            gameStatus.updateGameStatus(gameController.getGameStatus());
        });
    }

    /**
     * Simple getter of retry button.
     *
     * @return the retry button.
     */
    public Button getRestartButton() {
        return retryButton;
    }

}
