package ViewJavaFx;

/**
 * Represents the board of the game.
 *
 * @author Nader - 54685
 */
import Controller.Controller;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public final class BoardView implements Observer {

    private final Pane boardContainer;
    private final Controller gameController;
    public static final int size = 480;

    /**
     * Simple constructor of the board.
     *
     * @param gameController the game controller.
     */
    public BoardView(Controller gameController) {
        this.gameController = gameController;
        boardContainer = new Pane();
        boardContainer.setMinSize(size, size);
        boardContainer.setMaxSize(size, size);
        updateBoard(this.gameController.getArrayOfElements());
        gameController.registerObserver(this);
    }

    /**
     * Simple getter of the board container.
     *
     * @return board container.
     */
    public Pane getBoardContainer() {
        return boardContainer;
    }

    /**
     * Allows to update the board view according to the values of the board of
     * the model. .
     *
     * @param array the given board of model.
     */
    public void updateBoard(int array[][]) {
        Label value;
        if (!this.boardContainer.getChildren().isEmpty()) {
            this.boardContainer.getChildren().clear();
        }
        for (int i = 0; i < Model.Board.rowNumber; i++) {
            for (int j = 0; j < Model.Board.columnNumber; j++) {
                Tile tile = new Tile();
                tile.setFocusTraversable(false);
                value = new Label(String.valueOf(array[i][j]));
                value.setFocusTraversable(false);
                value.setAlignment(Pos.CENTER);
                tile.setTranslateX(j * Tile.squareSize);
                tile.setTranslateY(i * Tile.squareSize);
                this.setColor(value, tile);
                tile.getChildren().add(value);
                boardContainer.getChildren().add(tile);
            }
        }
        if (!Controller.looseDeclared && !Controller.winDeclared) {
            boardContainer.setDisable(false);
        }
        if (gameController.getGameStatus() == 2 || gameController.getGameStatus() == 3) {
            boardContainer.setDisable(true);
        }
   
        boardContainer.setStyle(
        "-fx-border-color: black;"
        );
    }

    /**
     * Sets the color of the element on the board.
     *
     * @param value the label which contain the element in the board.
     * @param tile the container of the label which contain the value.
     */
    public void setColor(Label value, Tile tile) {
        switch (value.getText()) {
            case "2":
                tile.getSquare().setFill(Color.web("#e4d8cc"));
                break;
            case "4":
                tile.getSquare().setFill(Color.web("#ede0c8"));
                break;
            case "8":
                tile.getSquare().setFill(Color.web("#f2b179"));
                break;
            case "16":
                tile.getSquare().setFill(Color.web("#f59563"));
                break;
            case "32":
                tile.getSquare().setFill(Color.web("#f57b5e"));
                break;
            case "64":
                tile.getSquare().setFill(Color.web("#f65e3b"));
                break;
            case "128":
                tile.getSquare().setFill(Color.web("#e5be3f"));
                break;
            case "256":
                tile.getSquare().setFill(Color.web("#f2d04b"));
                break;
            case "512":
                tile.getSquare().setFill(Color.web("#eacd63"));
                break;
            case "1024":
                tile.getSquare().setFill(Color.web("#ebc440"));
                break;
            case "2048":
                tile.getSquare().setFill(Color.web("#edc02d"));
                break;

        }
        if (!(value.getText().equals("0") || value.getText().equals("2") || value.getText().equals("4"))) {
            value.setStyle("-fx-text-fill : white;");
        }
        if (value.getText().equals("0")) {
            value.setDisable(true);
        }
        value.setFont(Font.font("Roboto", 30));
    }

    /**
     * Allows to update the board's current values.
     */
    @Override
    public void update() {
        updateBoard(this.gameController.getArrayOfElements());
    }

}
