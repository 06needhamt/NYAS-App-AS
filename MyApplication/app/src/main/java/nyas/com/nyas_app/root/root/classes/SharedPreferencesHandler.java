package nyas.com.nyas_app.root.root.classes;

import android.content.SharedPreferences;
import android.widget.Toast;

/**
 * Created by Tom on 07/04/2015.
 */
public class SharedPreferencesHandler {

    private SharedPreferences preferences;

    public SharedPreferencesHandler(SharedPreferences prefs)
    {
        this.preferences = prefs;
    }

    public SharedPreferences getPreferences() {
        return preferences;
    }

    public void setPreferences(SharedPreferences sp) {
        this.preferences = sp;
    }

    public String getPin()
    {
        return preferences.getString("pin","0000");
    }

    public void setPin(String pin)
    {
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString("pin",pin);
        edit.apply();
        edit.commit();
    }
}
