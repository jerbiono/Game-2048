package ViewJavaFx;

import Controller.Controller;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;

/**
 * Represents the game status of the player.
 *
 * @author Nader - 54685
 */
public final class statusView implements Observer {

    private final Controller gameController;
    private final ListView statusContainer;
    private final HBox informationContainer = new HBox();
    private int scrollIndex;
    private DateFormat date;

    /**
     * Simple constructor of the game status.
     *
     * @param gameController the controller of the game
     */
    public statusView(Controller gameController) {

        this.gameController = gameController;

        this.statusContainer = new ListView();
        statusContainer.setScaleShape(true);
        statusContainer.setStyle(
//                "-fx-border-color: black;"
                 "-fx-font-family: Courier New;"
                + "-fx-font-weight: bold;"
                + "-fx-font-size: 20;"
        );
        updateGameStatus(gameController.getGameStatus());
        this.informationContainer.getChildren().addAll(statusContainer);
        statusContainer.setPrefSize(BoardView.size, BoardView.size);
        gameController.registerObserver(this);
    }

    /**
     * Allows to update the status of game when the player moves elements on the
     * board.
     *
     * @param gameStatus the given game status.
     */
    public void updateGameStatus(int gameStatus) {
        date = new DateFormat();
        date.getCurrentTime();
        switch (gameStatus) {
            case 0:
                this.statusContainer.getItems().add(date.getCurrentTime() + " - Bienvenue au jeu ~2048~\n");
                break;
            case 1:
                this.statusContainer.getItems().add(date.getCurrentTime() + " - mouvement impossible!\n");
                break;
            case 2:
                this.statusContainer.getItems().add(date.getCurrentTime() + " - le jeu est terminé.\n");
                this.statusContainer.getItems().add(date.getCurrentTime() + " - bien jouer vous avez gagnez!\n");
                Controller.winDeclared = true;
                break;
            case 3:
                this.statusContainer.getItems().add(date.getCurrentTime() + " - le jeu est terminé.\n");
                this.statusContainer.getItems().add(date.getCurrentTime() + " - vous avez perdu.\n");
                Controller.looseDeclared = true;
                break;
            case 4:
                this.statusContainer.getItems().add(date.getCurrentTime() + " - Bienvenue au jeu ~2048~\n");
                this.statusContainer.getItems().add(date.getCurrentTime() + " - la partie est recommencé.\n");

                break;
        }
        statusContainer.scrollTo(scrollIndex);
        ++scrollIndex;
        this.gameController.setGameStatus();
        statusContainer.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() != KeyCode.SPACE) {
                    event.consume();
                }

            }
        });

    }

    /**
     * Simple getter of the list view.
     *
     * @return the list view.
     */
    public ListView getStatusContainer() {
        return statusContainer;
    }

    /**
     * Simple getter of container of list view.
     *
     * @return the container of the list view.
     */
    public HBox getInformationContainer() {
        return informationContainer;
    }

    /**
     * Allows to update the list view's current value.
     */
    @Override
    public void update() {
        updateGameStatus(gameController.getGameStatus());
    }

}
