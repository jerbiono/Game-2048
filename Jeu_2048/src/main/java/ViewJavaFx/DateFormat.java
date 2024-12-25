package ViewJavaFx;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents the current date.
 *
 * @author Nader - 54685
 */
public class DateFormat {

    private final SimpleDateFormat formatter;
    private final Date date;

    /**
     * Simple constructor of the date.
     */
    public DateFormat() {
        formatter = new SimpleDateFormat("HH:mm");
        date = new Date();
    }

    /**
     * Simple getter of the current time.
     *
     * @return the current time.
     */
    public String getCurrentTime() {
        return formatter.format(date);
    }

}
