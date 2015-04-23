package nyas.com.nyas_app.root.root.classes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Tom on 15/04/2015.
 * Serializable Singleton class that contains a list of all of the appointments
 * that have been booked within the app
 */
public class AppointmentList implements Serializable {

    private ArrayList<Appointment> appointments;
    private static AppointmentList Instance;

    /**
     * constructs a new list of appointments
     * @param appointments the list of appointments to use
     */
    private AppointmentList(ArrayList<Appointment> appointments)
    {
        if (this.appointments == null && appointments == null)
        {
            this.setAppointments(new ArrayList<Appointment>());
        }
        else if(appointments != null)
        {
            this.setAppointments(appointments);
        }
        Instance = this;

    }

    /**
     * get the currently active instance of this class or creates one if it does not exists
     * @return the currently active instance of this class
     */
    public static AppointmentList GetInstance()
    {
        if(Instance == null)
        {
           Instance = new AppointmentList(null);
            return Instance;
        }
        else
        {
            return Instance;
        }
    }

    /**
     * et the currently active instance of this class or creates one if it does not exists
     * @param appointments the list of appointments to use to create the new instance
     * @return the currently active instance of this class
     */
    public static AppointmentList GetInstance(ArrayList<Appointment> appointments)
    {
        if(Instance == null)
        {
            Instance = new AppointmentList(appointments);
            return Instance;
        }
        else
        {
            return Instance;
        }
    }

    /**
     * gets the list of appointments
     * @return the list of appointments
     */
    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    /**
     * sets the current list of appointments
     * @param appointments the list of appointments to set
     */
    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    /**
     * Add a new Appointment to the current list of appointment
     * @param appointment the appointment to add
     * @return the added appointment
     */
    public Appointment addAppointment(Appointment appointment)
    {
        this.appointments.add(appointment);
        return appointment;
    }
}
