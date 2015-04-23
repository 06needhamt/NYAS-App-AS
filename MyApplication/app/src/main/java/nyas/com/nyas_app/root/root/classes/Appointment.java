package nyas.com.nyas_app.root.root.classes;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Tom on 15/04/2015.
 * this class represents an appointment object within the appointment system
 */
public class Appointment implements Serializable {

    private Date date;
    private Time time;

    /**
     * Constructor for constructing new Appointments
     * @param date the date of the appointment
     * @param time the time of the appointment in a 24 hour format
     */
    public Appointment(Date date, Time time)
    {
        this.date = date;
        this.time = time;
    }

    /**
     * gets the date of an appointment
     * @return the date of the appointment
     */
    public Date getDate() {
        return date;
    }

    /**
     * sets the date of an appointment
     * @param date the date of the appointment
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * gets the time of the appointment
     * @return the time of the appointment in a 24 hour format
     */
    public Time getTime() {
        return time;
    }

    /**
     * sets the time of the appointment
     * @param time the time of the appointment in a 24 hour format
     */
    public void setTime(Time time) {
        this.time = time;
    }
}
