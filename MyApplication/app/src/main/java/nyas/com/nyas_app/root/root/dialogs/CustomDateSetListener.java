package nyas.com.nyas_app.root.root.dialogs;

import android.app.DatePickerDialog;
import android.widget.DatePicker;

import java.util.Date;

import nyas.com.nyas_app.root.root.Fragments.ContactFragment;
import nyas.com.nyas_app.root.root.Fragments.UserProfileContentFragment;

/**
 * Created by Tom on 14/04/2015.
 */
public class CustomDateSetListener implements DatePickerDialog.OnDateSetListener {
    Date d;
    /**
     * @param view        The view associated with this listener.
     * @param year        The year that was set.
     * @param monthOfYear The month that was set (0-11) for compatibility
     *                    with {@link java.util.Calendar}.
     * @param dayOfMonth  The day of the month that was set.
     */
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        d = new Date();
        d.setYear(year);
        d.setMonth(monthOfYear);
        d.setDate(dayOfMonth);
        //ContactFragment.setDate(d);
    }

    public Date getDate()
    {
        return d;
    }
}
