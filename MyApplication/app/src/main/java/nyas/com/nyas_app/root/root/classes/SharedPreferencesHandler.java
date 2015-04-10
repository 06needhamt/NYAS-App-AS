package nyas.com.nyas_app.root.root.classes;

import android.content.SharedPreferences;
import android.widget.Toast;

/**
 * Created by Tom on 07/04/2015.
 * This class provides a simple way to access data stored within the apps shared preferences
 * @author
 */
public class SharedPreferencesHandler {
    /**
     * The {@link android.content.SharedPreferences object to access}
     */
    private SharedPreferences preferences;

    /**
     * constructor for the SharedPreferenceHandler Class
     * @param prefs The Shared Preference object used to access the data
     */
    public SharedPreferencesHandler(SharedPreferences prefs)
    {
        this.preferences = prefs;
    }

    /**
     * This method gets and returns the shared preferences object
     * @return the active shared preferences object
     */
    public SharedPreferences getPreferences() {
        return preferences;
    }

    /**
     * this method sets the active shared preference object
     * @param sp the shared preference object to be used
     */
    public void setPreferences(SharedPreferences sp) {
        this.preferences = sp;
    }

    /**
     * gets the value of the pin variable stored in shared preferences
     * @return the value of the pin variable
     */
    public String getPin()
    {
        return preferences.getString("pin","0000");
    }

    /**
     * sets the value of the pin variable in shared preferences to the value passed in the parameter
     * @param pin the value to set the pin variable to
     */
    public void setPin(String pin)
    {
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString("pin",pin);
        edit.apply();
        edit.commit();
    }
}
