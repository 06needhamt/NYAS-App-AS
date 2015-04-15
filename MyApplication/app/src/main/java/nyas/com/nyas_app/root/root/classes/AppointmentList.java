package nyas.com.nyas_app.root.root.classes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Tom on 15/04/2015.
 */
public class AppointmentList implements Serializable {
    private ArrayList<Appointment> appointments;
    private static AppointmentList Instance;
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
    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Appointment addAppointment(Appointment appointment)
    {
        this.appointments.add(appointment);
        return appointment;
    }
}
