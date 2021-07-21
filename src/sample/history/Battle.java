package sample.history;

import java.io.Serializable;
import java.util.Date;

public class Battle implements Serializable {

    private String details;

    private Date date;
    public Battle(String details) {
        this.details = details;
        this.date = new Date();
    }

    public String getDetails() {
        return date.toString() + " - " + details + '\n';
    }
}
