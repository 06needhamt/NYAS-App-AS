package nyas.com.nyas_app.root.root.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Size;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import nyas.com.nyas_app.R;
import nyas.com.nyas_app.root.root.IAppConstants;
import nyas.com.nyas_app.root.root.classes.SharedPreferencesHandler;
import nyas.com.nyas_app.root.root.dialogs.IConfirmDialogCompliant;
import nyas.com.nyas_app.root.root.dialogs.PinInputDialog;

/**
 * Created by Tom Needham on 25/03/2015.
 * This class creates and displays the UserProfileContentFragment where the content on the
 * user profile screen will be displayed
 */
public class UserProfileContentFragment extends Fragment implements IAppConstants,IConfirmDialogCompliant{
    /**
     * The view object used in the creation of this fragment
     */
    View v;
    /**
     * Variable used to store the pin number returned from {@link nyas.com.nyas_app.root.root.dialogs.PinInputDialog}
     */
    String pin = "";
    /**
     * Variable to store whether the pin returned from {@link nyas.com.nyas_app.root.root.dialogs.PinInputDialog} is correct
     */
    boolean correct = false;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View view = inflater.inflate(R.layout.fragment_content_user_profile,container,false);
        view.setPadding(0,0,0,5);
        v = view;
        enterPin();

        //SetUpViews();
        return view;
    }

    /**
     * this method calls and displays a dialog fragment which allows a user to enter their pin number
     * NOTE This method is thread safe
     */
    private synchronized void enterPin()
    {
        PinInputDialog p = new PinInputDialog(getResources().getString(R.string.enter_pin_string),this);
        p.show(getFragmentManager(),null);

    }

    /**
     * this method checks whether the pin number the user enetered at {@link #enterPin} was valid
     * if the pin was valid the profile screen will continue to load
     * if the pin is not valid the dialog fragment will be shown to allow thw user to try again
     * @return whether or not rhe entered pin was valid
     */
    private synchronized boolean CheckPin() {
        SharedPreferences prefs = getActivity().getSharedPreferences(PREF_NAMES, Context.MODE_PRIVATE);
        SharedPreferencesHandler sph = new SharedPreferencesHandler(prefs);
        if(sph.getPin().equals("0000"))
        {
            sph.setPin(this.pin);
            Toast.makeText(getActivity(),"Pin Set",Toast.LENGTH_LONG).show();
            return true;
        }
        else if(pin.equals(sph.getPin()))
        {
            Toast.makeText(getActivity(), "Correct Pin Entered", Toast.LENGTH_LONG).show();
            return true;
        }
        else {
            Toast.makeText(getActivity(),"Incorrect pin Entered Try Again",Toast.LENGTH_LONG).show();
            return false;
        }
    }

    /**
     * Method called from the onclick listener of the confirm button in {@link nyas.com.nyas_app.root.root.dialogs.PinInputDialog}
     * this method returns the entered pin from the dialog and checks if it correct by calling {@link #CheckPin()}
     * if it is not correct this method calls {@link #enterPin()} to allow the user to try again
     * @param pin the pin number entered into the dialog by the user
     */
    @Override
    public void doYesConfirmClick(String pin) {
        this.pin = pin;
        correct = CheckPin();
        if(!correct)
        {
            enterPin();
        }
    }

    /**
     * Method called from the onclick listener of the cancel button in {@link nyas.com.nyas_app.root.root.dialogs.PinInputDialog}
     * this method returns the user to the home screen because they did not enter a valid pin
     * @param pin 0000 because the user did not enter a pin
     */
    @Override
    public void doNoConfirmClick(String pin) {
        this.getFragmentManager().beginTransaction().replace(R.id.ContentFrame,new HomeContentFragment()).commit();
    }
}
