package nyas.com.nyas_app.root.root.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import nyas.com.nyas_app.R;
import nyas.com.nyas_app.root.root.IAppConstants;
import nyas.com.nyas_app.root.root.classes.SharedPreferencesHandler;
import nyas.com.nyas_app.root.root.dialogs.IConfirmDialogCompliant;
import nyas.com.nyas_app.root.root.dialogs.PinInputDialog;

/**
 * Created by 22416714 on 25/03/2015.
 */
public class UserProfileContentFragment extends Fragment implements IAppConstants,IConfirmDialogCompliant{

    View v;
    String pin = "";
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
        return view;
    }

    private synchronized void enterPin()
    {
        PinInputDialog p = new PinInputDialog(getResources().getString(R.string.enter_pin_string),this);
        p.show(getFragmentManager(),null);

    }
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

    @Override
    public void doYesConfirmClick(String pin) {
        this.pin = pin;
        correct = CheckPin();
        if(!correct)
        {
            enterPin();
        }
    }

    @Override
    public void doNoConfirmClick(String pin) {
        this.pin = pin;
        correct = CheckPin();
        if(!correct)
        {
            enterPin();
        }
    }
}
