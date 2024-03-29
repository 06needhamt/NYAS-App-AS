package nyas.com.nyas_app.root.root.classes;

import android.app.Activity;
import android.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import nyas.com.nyas_app.R;
import nyas.com.nyas_app.root.root.Activities.MainActivity;
import nyas.com.nyas_app.root.root.Fragments.HomeContentFragment;

/**
 * Created by Thomas Needham on 25/03/2015.
 * @author Thomas Needham
 * This class creates and displays a row of 6 navigation buttons which allow the user to navigate throughout the app
 */
public class ButtonCreator {

    public final int NUM_BUTTONS = 6;
    MainActivity caller;
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
    public ButtonCreator(MainActivity caller, int[] drawableids, TableLayout Table, Fragment[] fragments)
    {
        this.caller = caller;
        this.drawableids = drawableids;
        this.table = Table;
        this.fragments = fragments;
    }

    /**
     * this method creates the bottom navigation buttons
     */
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

    /**
     * this method handles the navigation buttons being clicked
     * @param buttonnumber the number of the button that was clicked
     */
    private void buttonClicked(int buttonnumber) {
        if(buttonnumber < 5) {
            caller.findViewById(R.id.AccessibilityFrame).setVisibility(View.VISIBLE);
            caller.findViewById(R.id.SpeechFrame).setVisibility(View.VISIBLE);
            caller.findViewById(R.id.LogoFrame).setVisibility(View.VISIBLE);
            caller.findViewById(R.id.ContentFrame).setVisibility(View.VISIBLE);
        }
        caller.getFragmentManager().beginTransaction().replace(R.id.ContentFrame,fragments[buttonnumber]).commit();
    }
}
