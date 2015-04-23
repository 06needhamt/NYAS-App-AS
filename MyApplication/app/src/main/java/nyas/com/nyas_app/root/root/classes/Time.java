package nyas.com.nyas_app.root.root.classes;

import java.io.Serializable;

/**
 * Created by Tom on 14/04/2015.
 * This class provides an implementation of a 24 hour time data structure
 */
public class Time implements Serializable{
    private int hours;
    private int minutes;
    private int seconds;

    /**
     * Empty constructor to create an object for later initialisation
     */
    public Time()
    {

    }

    /**
     * Constructor for a time object with hours and minutes
     * @param hours the current hour
     * @param minutes the current minute
     */
    public Time(int hours, int minutes)
    {
        this.hours = hours;
        this.minutes = minutes;
    }

    /**
     * Constructor for a time object with hours, minutes and seconds
     * @param hours the current hour
     * @param minutes the current minute
     * @param seconds the current second
     */
    public Time(int hours, int minutes, int seconds)
    {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    /**
     * gets the current hour
     * @return the current hour
     */
    public int getHours() {
        return hours;
    }

    /**
     * sets the current hour
     * @param hours the current hour
     */
    public void setHours(int hours) {
        this.hours = hours;
    }

    /**
     * gets the current minute
     * @return the current minute
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * sets the current minute
     * @param minutes the current minute
     */
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    /**
     * gets the current second
     * @return the current second
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     * sets the current second
     * @param seconds the current second
     */
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}
