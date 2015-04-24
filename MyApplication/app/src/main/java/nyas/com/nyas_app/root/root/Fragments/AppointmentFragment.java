package nyas.com.nyas_app.root.root.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import nyas.com.nyas_app.R;
import nyas.com.nyas_app.root.root.IAppConstants;
import nyas.com.nyas_app.root.root.classes.AppointmentList;
import nyas.com.nyas_app.root.root.classes.Time;
import nyas.com.nyas_app.root.root.classes.Tuple;

/**
 * Created by Tom on 15/04/2015.
 * This fragment displays the list of appointments that has been made within the app
 */
public class AppointmentFragment extends Fragment implements IAppConstants {
    View v;
    DisplayMetrics dm;
    ScrollView lv;
    SimpleAdapter simpleAdapter;
    Button BackButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_appointment, container, false);
        view.setPadding(0, 0, 0, 5);
        v = view;
        GetDisplayMetrics();
        SetUpViews();

        return view;
    }

    /**
     * this method sets up all of the necessary views to display this fragment
     */
    private void SetUpViews() {
        lv = (ScrollView) v.findViewById(R.id.items);
        LinearLayout linear = new LinearLayout(getActivity());
        linear.setOrientation(LinearLayout.VERTICAL);
        List<Tuple<String,String>> map = ReadAppointments();
        try {
            for(int i = 0; i < map.size(); i++)
            {
                TextView t = new TextView(getActivity());
                t.setTextColor(getActivity().getResources().getColor(R.color.Black));
                t.setTextSize(TypedValue.COMPLEX_UNIT_SP,25.0f);
                t.setText("Date: " + map.get(i).getX() + " Time " + map.get(i).getY());
                linear.addView(t, i);
            }
            lv.addView(linear);
        }
        catch (NullPointerException ex)
        {
            ex.printStackTrace();
            TextView t = new TextView(getActivity());
            t.setTextColor(getActivity().getResources().getColor(R.color.Black));
            t.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
            t.setText("No booked appointments");
            linear.addView(t);
            lv.addView(linear);

        }


    }

    /**
     * this method reads all of the booked appointments from the file
     * @return an {@link java.util.ArrayList} of {@link nyas.com.nyas_app.root.root.classes.Tuple} objects
     * witch contain key value pairs that represent {@link nyas.com.nyas_app.root.root.classes.Appointment} objects
     */
    private ArrayList<Tuple<String,String>> ReadAppointments() {
        try {
            File file = new File(getActivity().getFilesDir(), APPOINTMENT_FILE_NAME);
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            AppointmentList appointmentList = (AppointmentList) objectInputStream.readObject();
            return CreateMap(appointmentList);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            Log.e("ReadAppointment", "An error occurred while writing the appointment to a file");
        }
        catch (ClassNotFoundException cls)
        {
            cls.printStackTrace();
            Log.e("ReadAppointment", "Class Not Found");
            throw new Error("Class Not Found");
        }
        catch (NullPointerException npe)
        {
            npe.printStackTrace();
        }
        return null;
    }

    /**
     * Parses a date string from a {@link java.util.Date} object
     * @param d the {@link java.util.Date} object to parse
     * @return a string which represents the {@link java.util.Date} object
     */
    private String parseDate(Date d)
    {
        return d.getDate() + "/" + d.getMonth() + "/" + d.getYear();
    }

    /**
     * Parses a time string from a {@link nyas.com.nyas_app.root.root.classes.Time} object
     * @param t the {@link nyas.com.nyas_app.root.root.classes.Time} object to parse
     * @return a string which represents the {@link nyas.com.nyas_app.root.root.classes.Time} object
     */
    private String parseTime(Time t)
    {
        return t.getHours() + ":" + t.getMinutes();
    }

    /**
     * creates an {@link java.util.ArrayList} of {@link nyas.com.nyas_app.root.root.classes.Tuple} objects
     * which contains key value pairs which represent {@link nyas.com.nyas_app.root.root.classes.Appointment} objects
     * @param list an {@link nyas.com.nyas_app.root.root.classes.AppointmentList} object which contains
     *             all of the appointments read from the file
     * @return an {@link java.util.ArrayList} of {@link nyas.com.nyas_app.root.root.classes.Tuple} objects
     * witch contain key value pairs that represent {@link nyas.com.nyas_app.root.root.classes.Appointment} objects
     */
    private ArrayList<Tuple<String,String>> CreateMap(AppointmentList list) {
        if(list == null || list.getAppointments().size() == 0 )
        {
            return new ArrayList<>();
        }

        ArrayList<Tuple<String, String>> appointmentMapList = new ArrayList<>();
        for (int i = 0; i < list.getAppointments().size(); i++)
        {
           ArrayList<Tuple<String,String>> appointmentMap = new ArrayList<>();
            String date = parseDate(list.getAppointments().get(i).getDate());
            String time = parseTime(list.getAppointments().get(i).getTime());
            Tuple<String,String> tuple = new Tuple<>(date,time);
            appointmentMapList.add(tuple);
        }
        return appointmentMapList;
    }

    /**
     * this class gets the {@link android.util.DisplayMetrics} associated with the device that the app
     * is currently running on
     */
    private void GetDisplayMetrics() {
        dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
    }
}
