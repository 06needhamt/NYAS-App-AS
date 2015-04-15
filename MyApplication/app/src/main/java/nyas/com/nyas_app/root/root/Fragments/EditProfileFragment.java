package nyas.com.nyas_app.root.root.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import nyas.com.nyas_app.R;
import nyas.com.nyas_app.root.root.IAppConstants;
import nyas.com.nyas_app.root.root.classes.SharedPreferencesHandler;

/**
 * Created by Tom on 15/04/2015.
 */
public class EditProfileFragment extends Fragment implements IAppConstants{

    View v;
    DisplayMetrics dm;
    EditText FirstName;
    EditText LastName;
    EditText Age;
    EditText City;
    Button SaveChanges;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_edit_profile, container, false);
        view.setPadding(0, 0, 0, 5);
        v = view;
        GetDisplayMetrics();
        SetUpViews();

        return view;
    }

    private void SetUpViews() {
        int screenwidth = dm.widthPixels;
        int screenheight = dm.heightPixels;
        FirstName = (EditText) v.findViewById(R.id.FirstName);
        FirstName.setText("First Name");
        FirstName.setTextColor(getActivity().getResources().getColor(R.color.Black));
        FirstName.setLayoutParams(CreateFirstNameLayoutParams(screenwidth,screenheight));
        FirstName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirstName.setText("");
            }
        });
        LastName = (EditText) v.findViewById(R.id.LastName);
        LastName.setText("Last Name");
        LastName.setTextColor(getActivity().getResources().getColor(R.color.Black));
        LastName.setLayoutParams(CreateLastNameLayoutParams(screenwidth, screenheight));
        LastName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LastName.setText("");
            }
        });
        Age = (EditText) v.findViewById(R.id.Age);
        Age.setText("Age");
        Age.setInputType(InputType.TYPE_CLASS_NUMBER);
        Age.setTextColor(getActivity().getResources().getColor(R.color.Black));
        Age.setLayoutParams(CreateAgeLayoutParams(screenwidth,screenheight));
        Age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Age.setText("");
            }
        });
        City = (EditText) v.findViewById(R.id.City);
        City.setText("City");
        City.setTextColor(getActivity().getResources().getColor(R.color.Black));
        City.setLayoutParams(CreateCityLayoutParams(screenwidth,screenheight));
        City.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                City.setText("");
            }
        });
        SaveChanges = (Button) v.findViewById(R.id.SaveChanges);
        SaveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveProfile();
            }
        });
        SaveChanges.setLayoutParams(CreateSaveLayoutParams(screenwidth,screenheight));
    }

    private void SaveProfile() {
        SharedPreferences prefs = getActivity().getSharedPreferences(PREF_NAMES, Context.MODE_PRIVATE);
        SharedPreferencesHandler sph = new SharedPreferencesHandler(prefs);
        sph.setFirstName(FirstName.getText().toString());
        sph.setLastName(LastName.getText().toString());
        sph.setAge(Integer.parseInt(Age.getText().toString()));
        sph.setCity(City.getText().toString());
        Toast.makeText(getActivity(),"Profile Information Saved",Toast.LENGTH_LONG).show();
        Log.e("Profile",sph.getFirstName());
        Log.e("Profile",sph.getLastName());
        Log.e("Profile",String.valueOf(sph.getAge()));
        Log.e("Profile",sph.getCity());

    }

    private FrameLayout.LayoutParams CreateFirstNameLayoutParams(int screenwidth, int screenheight) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = (int) (screenheight * 0.1);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        return params;
    }

    private FrameLayout.LayoutParams CreateLastNameLayoutParams(int screenwidth, int screenheight) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = (int) (screenheight * 0.2);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        return params;
    }

    private FrameLayout.LayoutParams CreateAgeLayoutParams(int screenwidth, int screenheight) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = (int) (screenheight * 0.3);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        return params;
    }

    private FrameLayout.LayoutParams CreateCityLayoutParams(int screenwidth, int screenheight) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = (int) (screenheight * 0.4);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        return params;
    }

    private FrameLayout.LayoutParams CreateSaveLayoutParams(int screenwidth, int screenheight) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = (int) (screenheight * 0.5);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        return params;
    }


    private void GetDisplayMetrics() {
        dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
    }
}
