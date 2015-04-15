package nyas.com.nyas_app.root.root.classes;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Tom on 15/04/2015.
 */
public class Appointment implements Serializable {

    private Date date;
    private Time time;

    public Appointment(Date date, Time time)
    {
        this.date = date;
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
