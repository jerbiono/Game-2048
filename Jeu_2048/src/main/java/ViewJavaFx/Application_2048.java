package ViewJavaFx;

import Controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author nadou
 */
public class Application_2048 extends Application {

    private Controller gameController;
    private BoardView gameBoard;
    private ScoreView gameScore;
    private statusView gameStatus;
    private RestartButton gameRestart;

    @Override
    public void start(Stage stage) {

        gameController = new Controller();
        gameBoard = new BoardView(gameController);
        gameScore = new ScoreView(gameController);
        gameStatus = new statusView(gameController);
        gameRestart = new RestartButton(gameController, gameBoard, gameScore, gameStatus);

        stage.setTitle("Hadj youssef Nader - Projet 2048");
        stage.setMaxWidth(1000);
        stage.setMaxHeight(750);
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);

        VBox root = new VBox();
        root.setStyle("-fx-background-color: #bbada0");
        root.setPadding(new Insets(20, 10, 20, 10));
        root.setAlignment(Pos.CENTER);

        VBox gameContainer = new VBox();
        gameContainer.setAlignment(Pos.CENTER_LEFT);

        Pane boardContainer = gameBoard.getBoardContainer();
        HBox statusContainer = gameStatus.getInformationContainer();

        HBox centerContainer = new HBox();
        centerContainer.setAlignment(Pos.CENTER_LEFT);
        centerContainer.setSpacing(10);
        centerContainer.setPadding(new Insets(0, 0, 20, 0));
        centerContainer.setAlignment(Pos.CENTER_LEFT);
        centerContainer.getChildren().addAll(boardContainer, statusContainer);

        gameContainer.getChildren().addAll(gameScore.getScoreContainer(), centerContainer, gameRestart.getRestartButton());
        root.getChildren().addAll(gameContainer);

        Scene scene = new Scene(root);
        scene.setOnKeyReleased(event -> gameController.play(event));
        stage.setScene(scene);
        stage.show();

    }
}
