package nyas.com.nyas_app.root.root.Fragments;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;

import nyas.com.nyas_app.R;
import nyas.com.nyas_app.root.root.IAppConstants;
import nyas.com.nyas_app.root.root.classes.Appointment;
import nyas.com.nyas_app.root.root.classes.AppointmentList;
import nyas.com.nyas_app.root.root.classes.Time;
import nyas.com.nyas_app.root.root.dialogs.CustomDateSetListener;

/**
 * Created by Tom on 14/04/2015.
 */
public class ContactFragment extends Fragment implements IAppConstants{

    Button dateButton;
    Button timeButton;
    Button submitButton;
    CalendarView calendarView;
    TextView dateText;
    TextView timeText;
    CustomDateSetListener customDateSetListener = new CustomDateSetListener();
    View v;
    public Date SelectedDate;
    public Time SelectedTime;
    Calendar c = Calendar.getInstance();
    int year = c.get(Calendar.YEAR);
    int month = c.get(Calendar.MONTH);
    int day = c.get(Calendar.DAY_OF_MONTH);
    DisplayMetrics dm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_content_contact_us, container, false);
        view.setPadding(0, 0, 0, 5);
        v = view;
        GetDisplayMetrics();
        SetUpViews();

        return view;
    }

    private void GetDisplayMetrics() {
        dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
    }

    public void setDate(Date d) {
        SelectedDate = d;
    }

    public void setTime(Time t) {
        SelectedTime = t;
    }

    private String parseDate(Date selectedDate) {
        String Year = String.valueOf(selectedDate.getYear());
        String Month = String.valueOf(selectedDate.getMonth() + 1);
        String Day = String.valueOf(selectedDate.getDate());
        if ((selectedDate.getMonth() + 1) < 10)
        {
            Month = "0" + selectedDate.getMonth();
        }
        if (selectedDate.getDate() < 10)
        {
            Day = "0" + selectedDate.getDate();
        }
        return Day + "/" + Month + "/" + Year;
    }

    private String parseTime(Time selectedTime) {
        String Hour = String.valueOf(selectedTime.getHours());
        String Minute = String.valueOf(selectedTime.getMinutes());
        if(selectedTime.getHours() < 10)
        {
            Hour = "0" + selectedTime.getHours();
        }
        if(selectedTime.getMinutes() < 10)
        {
            Minute = "0" + selectedTime.getMinutes();
        }
        return Hour + ":" + Minute;
    }


    private void SetUpViews() {

        int screenwidth = dm.widthPixels;
        int screenheight = dm.heightPixels;
        calendarView = (CalendarView) v.findViewById(R.id.calendarView);
        calendarView.setLayoutParams(CreateCalendarLayoutParams(screenheight, screenwidth));
        dateText = (TextView) v.findViewById(R.id.selectedDate);
        dateText.setLayoutParams(CreateDateTextLayoutParams(screenheight, screenwidth));
        timeText = (TextView) v.findViewById(R.id.selectedTime);
        timeText.setLayoutParams(CreateTimeTextLayoutParams(screenheight, screenwidth));
        dateButton = (Button) v.findViewById(R.id.SelectDate);
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetDate();
            }
        });
        dateButton.setLayoutParams(CreateDateButtonLayoutParams(screenheight, screenwidth));
        timeButton = (Button) v.findViewById(R.id.SelectTime);
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetTime();
            }
        });
        timeButton.setLayoutParams(CreateTimeButtonLayoutParams(screenheight, screenwidth));
        submitButton = (Button) v.findViewById(R.id.SubmitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WriteAppointmentToFile();
            }
        });
        submitButton.setLayoutParams(CreateSubmitButtonLayoutParams(screenheight, screenwidth));
    }

    private void WriteAppointmentToFile() {
        try {
            Appointment a = parseAppointment();
            File file = new File(getActivity().getFilesDir().getAbsolutePath(), APPOINTMENT_FILE_NAME);
            AppointmentList list;
            if(!file.exists())
            {
                file.createNewFile();
            }
            if(file.length() != 0)
            {
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                list = (AppointmentList) objectInputStream.readObject();
            }
            else
            {
                list = AppointmentList.GetInstance();
            }

            list.addAppointment(a);
            Log.e("List Size ", String.valueOf(list.getAppointments().size()));
            Log.e("File Path",file.getAbsolutePath());
            FileOutputStream fileOutputStream = new FileOutputStream(file,false);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            Log.e("File Size", String.valueOf(file.length()));
            Toast.makeText(getActivity(),"Appointment Request Submitted", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            Log.e("WriteAppointment","An error occurred while writing the appointment to a file");
            throw new Error("\"An error occurred while writing the appointment to a file\"");
        }



    }

    private Appointment parseAppointment() throws NumberFormatException {
        String[] datestring;
        String[] timsstring;
        Date d = new Date();
        Time t = new Time();
        Appointment a;
        datestring = dateText.getText().toString().split("/");
        d.setDate(Integer.parseInt(datestring[0]));
        d.setMonth(Integer.parseInt(datestring[1]));
        d.setYear(Integer.parseInt(datestring[2]));
        timsstring = timeText.getText().toString().split(":");
        t.setHours(Integer.parseInt(timsstring[0]));
        t.setMinutes(Integer.parseInt(timsstring[1]));
        a = new Appointment(d,t);
        return a;
    }

    private FrameLayout.LayoutParams CreateTimeTextLayoutParams(int screenheight, int screenwidth) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenheight, screenwidth);
        params.gravity = Gravity.START;
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = (int) (screenheight * 0.48);
        params.leftMargin = (int) (screenwidth * 0.05);
        return params;
    }

    private FrameLayout.LayoutParams CreateDateTextLayoutParams(int screenheight, int screenwidth) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenheight, screenwidth);
        params.gravity = Gravity.START;
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = (int) (screenheight * 0.38);
        params.leftMargin = (int) (screenwidth * 0.05);
        return params;
    }

    private FrameLayout.LayoutParams CreateDateButtonLayoutParams(int screenheight, int screenwidth) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth, screenheight);
        params.gravity = Gravity.END;
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = (int) (screenheight * 0.35);
        params.leftMargin = (int) (dateText.getWidth() + (screenwidth * 0.10));
        return params;
    }

    private FrameLayout.LayoutParams CreateCalendarLayoutParams(int screenheight, int screenwidth) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth, screenheight);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.width = FrameLayout.LayoutParams.MATCH_PARENT;
        params.height = (int) (screenheight * 0.30);
        return params;
    }

    private FrameLayout.LayoutParams CreateTimeButtonLayoutParams(int screenheight, int screenwidth) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth, screenheight);
        params.gravity = Gravity.END;
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = (int) (screenheight * 0.45);
        params.leftMargin = (int) (timeText.getWidth() + (screenwidth * 0.10));
        return params;
    }

    private FrameLayout.LayoutParams CreateSubmitButtonLayoutParams(int screenheight, int screenwidth) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth, screenheight);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = (int) (screenheight * 0.50);
        return params;
    }

    private void GetDate() {

        DatePickerDialog p = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Date d = new Date();
                d.setYear(year);
                d.setMonth(monthOfYear);
                d.setDate(dayOfMonth);
                setDate(d);
                dateText.setText(parseDate(SelectedDate));
            }
        }, year, month, day);
        p.show();
    }

    private void GetTime() {
        TimePickerDialog tp = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Time t = new Time(hourOfDay, minute);
                setTime(t);
                timeText.setText(parseTime(SelectedTime));
            }
        }, 12, 0, true);
        tp.show();
    }
}