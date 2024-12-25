
package Model;

/**
 * The value which will be added to the board.
 *
 * @author nader-54685
 */
public class Element {

    public int defaultElement;

    /**
     * Simple constructor of element.
     */
    public Element() {
        this.defaultElement = setDefaultElement();
    }

    /**
     * Allows to retrieve a value 2 or 4 depending on a random value.
     *
     * @return 2 if random value is between 0.0 and 0.8 , otherwise return 4.
     */
    private static int setDefaultElement() {
        double random = Math.random();
        return (random >= 0.0 && random < 0.9) ? 2 : 4;
    }

}
