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
 * Created by Thomas Needham on 15/04/2015.
 * this class creates and displays the fragment which allows a user to edit their user profile within the app
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
        LoadProfile();

        return view;
    }


    /**
     * This method sets up all of the views within this fragments
     * and also assigns their layout parameters
     * @see android.widget.FrameLayout.LayoutParams
     */
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

    /**
     * this method loads a previously save user profile from {@link android.content.SharedPreferences}
     */
    private void LoadProfile()
    {
        SharedPreferences prefs = getActivity().getSharedPreferences(PREF_NAMES,Context.MODE_PRIVATE);
        SharedPreferencesHandler sph = new SharedPreferencesHandler(prefs);
        FirstName.setText(sph.getFirstName());
        LastName.setText(sph.getLastName());
        if(sph.getAge() == 0)
        {
            Age.setText("Age");
        }
        else {
            Age.setText(String.valueOf(sph.getAge()));
        }
        City.setText(sph.getCity());
    }

    /**
     * this method saves the entered user profile information to {@link android.content.SharedPreferences}  
     */
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

    /**
     * this method creates the {@link android.widget.FrameLayout.LayoutParams} for the first name EditText
     * @param screenwidth the width of the devices screen
     * @param screenheight the height of the devices screen
     * @return the {@link android.widget.FrameLayout.LayoutParams} for the first name EditText
     */
    private FrameLayout.LayoutParams CreateFirstNameLayoutParams(int screenwidth, int screenheight) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = (int) (screenheight * 0.1);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        return params;
    }
    /**
     * this method creates the {@link android.widget.FrameLayout.LayoutParams} for the last name EditText
     * @param screenwidth the width of the devices screen
     * @param screenheight the height of the devices screen
     * @return the {@link android.widget.FrameLayout.LayoutParams} for the lasr name EditText
     */
    private FrameLayout.LayoutParams CreateLastNameLayoutParams(int screenwidth, int screenheight) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = (int) (screenheight * 0.2);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        return params;
    }
    /**
     * this method creates the {@link android.widget.FrameLayout.LayoutParams} for the age EditText
     * @param screenwidth the width of the devices screen
     * @param screenheight the height of the devices screen
     * @return the {@link android.widget.FrameLayout.LayoutParams} for the age EditText
     */
    private FrameLayout.LayoutParams CreateAgeLayoutParams(int screenwidth, int screenheight) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = (int) (screenheight * 0.3);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        return params;
    }
    /**
     * this method creates the {@link android.widget.FrameLayout.LayoutParams} for the city EditText
     * @param screenwidth the width of the devices screen
     * @param screenheight the height of the devices screen
     * @return the {@link android.widget.FrameLayout.LayoutParams} for the city EditText
     */
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

    /**
     * this method gets the {@link android.util.DisplayMetrics} associated with the device that the app
     * is currently running on
     */
    private void GetDisplayMetrics() {
        dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
    }
}
