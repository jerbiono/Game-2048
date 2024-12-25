
package ViewJavaFx;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Represents the square of the boardView.
 *
 * @author Nader - 54685
 */
public class Tile extends StackPane {

    private final Rectangle square;
    public static int squareSize = 120;

    /**
     * Simple Constructor of the tile.
     */
    public Tile() {
        square = new Rectangle(squareSize, squareSize);
        square.setFill(Color.web("#eee4da"));
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(square);
    }

    /**
     * Simple getter of the square of the tile.
     *
     * @return the square.
     */
    public Rectangle getSquare() {
        return square;
    }

}
