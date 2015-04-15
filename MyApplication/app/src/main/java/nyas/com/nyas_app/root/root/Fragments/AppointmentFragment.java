package nyas.com.nyas_app.root.root.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
 */
public class AppointmentFragment extends Fragment implements IAppConstants {
    View v;
    DisplayMetrics dm;
    ScrollView lv;
    SimpleAdapter simpleAdapter;

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

    private void SetUpViews() {
        lv = (ScrollView) v.findViewById(R.id.items);
        LinearLayout linear = new LinearLayout(getActivity());
        linear.setOrientation(LinearLayout.VERTICAL);
        List<Tuple<String,String>> map = ReadAppointments();
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

    private List<Tuple<String,String>> ReadAppointments() {
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
            throw new Error("\"An error occurred while reading the appointment to a file\"");
        }
        catch (ClassNotFoundException cls)
        {
            cls.printStackTrace();
            Log.e("ReadAppointment", "Class Not Found");
            throw new Error("Class Not Found");
        }
    }
    private String parseDate(Date d)
    {
        return d.getDate() + "/" + d.getMonth() + "/" + d.getYear();
    }

    private String parseTime(Time t)
    {
        return t.getHours() + ":" + t.getMinutes();
    }

    private List<Tuple<String,String>> CreateMap(AppointmentList list) {
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

    private void GetDisplayMetrics() {
        dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
    }
}
