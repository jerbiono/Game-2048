
package ViewJavaFx;

import Controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * Represnts the score of the player on the game.
 *
 * @author Nader -54685
 */
public final class ScoreView implements Observer {

    private final Label scoreLabel = new Label("Score :");
    private TextField scoreValue;
    private final HBox scoreContainer = new HBox();
    private final Controller gameController;

    /**
     * Simple Constructor of the score.
     *
     * @param gameController the game controller.
     */
    public ScoreView(Controller gameController) {
        this.gameController = gameController;
        scoreContainer.setSpacing(40);
        scoreContainer.setPadding(new Insets(0, 0, 20, 0));
        this.scoreValue = new TextField();
        scoreContainer.setAlignment(Pos.CENTER_LEFT);
        scoreContainer.getChildren().addAll(scoreLabel, scoreValue);
        updateScore(gameController.getScore());
        gameController.registerObserver(this);
    }

    /**
     * Simple getter of the score container.
     *
     * @return the score container.
     */
    public HBox getScoreContainer() {
        return scoreContainer;
    }

    /**
     * Allows to update the score on the view when the player moves the elements
     * on the board of game.
     *
     * @param score the current score given by the model.
     */
    public void updateScore(int score) {
        if (!this.scoreContainer.getChildren().isEmpty()) {
            this.scoreContainer.getChildren().clear();
        }
        this.scoreValue.setEditable(false);
        this.scoreValue.setFocusTraversable(false);
        scoreLabel.setUnderline(true);
        this.scoreValue = new TextField("" + score);
        this.scoreValue.setEditable(false);
        this.scoreValue.setFocusTraversable(false);
        scoreValue.setMinHeight(Tile.squareSize / 2);
        scoreValue.setMaxWidth(Tile.squareSize);
        scoreLabel.setStyle(
                "-fx-font-family: Courier New;"
                + "-fx-font-weight: bold;"
                + "-fx-font-size: 20;"
        );

        scoreValue.setStyle(
                "-fx-padding: 10;"
                + "-fx-font-family: Segoe UI Semibold;"
                + "-fx-font-weight: bold;"
                + "-fx-font-size: 20;"
        );
        scoreContainer.getChildren().addAll(scoreLabel, scoreValue);

    }

    /**
     * Allows to update the score's current value. 
     */
    @Override
    public void update() {
        updateScore(this.gameController.getScore());

    }

}
