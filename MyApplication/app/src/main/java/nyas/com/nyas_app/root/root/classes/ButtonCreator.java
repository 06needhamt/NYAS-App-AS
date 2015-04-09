package nyas.com.nyas_app.root.root.classes;

import android.app.Activity;
import android.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import nyas.com.nyas_app.R;

/**
 * Created by Thomas Needham on 25/03/2015.
 * @author Thomas Needham
 * This class creates and displays a row of 6 navigation buttons which allow the user to navigate throughout the app
 */
public class ButtonCreator {

    public final int NUM_BUTTONS = 6;
    final Activity caller;
    final int[] drawableids;
    TableLayout table;
    final Fragment[] fragments;

    /**
     * Constructor for the button creator class
     * @param caller the activity which owns this instance
     * @param drawableids an integer array containing the IDs of the {@link nyas.com.nyas_app.R.drawable}
     *                    objects to be shown on the buttons
     * @param Table
     * @param fragments
     */
    public ButtonCreator(Activity caller, int[] drawableids, TableLayout Table, Fragment[] fragments)
    {
        this.caller = caller;
        this.drawableids = drawableids;
        this.table = Table;
        this.fragments = fragments;
    }

    public void createButtons()
    {
        TableRow row = new TableRow(caller.getBaseContext());
        row.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT, // width
                TableLayout.LayoutParams.MATCH_PARENT, // height
                1.0f)); // Scale
        table.addView(row);
        for (int i = 0; i < NUM_BUTTONS; i++)
        {
            final int buttonnumber = i;
            Button b = new Button(caller.getBaseContext());
            b.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT, // width
                    TableRow.LayoutParams.MATCH_PARENT, // height
                    1.0f )); // scale
            b.setPadding(0,0,0,0);
            b.setBackgroundResource(drawableids[i]);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buttonClicked(buttonnumber);
                }

            });
            row.addView(b);
            //Log.e("Count", String.valueOf(row.getChildCount()));
        }
    }
    private void buttonClicked(int buttonnumber) {
        caller.getFragmentManager().beginTransaction().replace(R.id.ContentFrame,fragments[buttonnumber]).commit();
    }
}
