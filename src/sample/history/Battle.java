package sample.history;

import java.io.Serializable;
import java.util.Date;

/**
 * The type Battle.
 */
public class Battle implements Serializable {

    private String details;

    private Date date;

    /**
     * Instantiates a new Battle.
     *
     * @param details the details
     */
    public Battle(String details) {
        this.details = details;
        this.date = new Date();
    }

    /**
     * Gets details.
     *
     * @return the details
     */
    public String getDetails() {
        return date.toString() + " - " + details + '\n';
    }
}
