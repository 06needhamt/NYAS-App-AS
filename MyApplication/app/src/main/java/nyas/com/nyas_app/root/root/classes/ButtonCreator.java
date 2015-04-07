package nyas.com.nyas_app.root.root.classes;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import nyas.com.nyas_app.R;

/**
 * Created by Tom on 25/03/2015.
 */
public class ButtonCreator {

    public final int NUM_BUTTONS = 6;
    Activity act;
    int[] drawableids;
    TableLayout table;
    Fragment[] fragments;

    public ButtonCreator(Activity A, int[] drawableids, TableLayout Table, Fragment[] fragments)
    {
        this.act = A;
        this.drawableids = drawableids;
        this.table = Table;
        this.fragments = fragments;
    }

    public void createButtons()
    {
        TableRow row = new TableRow(act.getBaseContext());
        row.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT, // width
                TableLayout.LayoutParams.MATCH_PARENT, // height
                1.0f)); // Scale
        table.addView(row);
        for (int i = 0; i < NUM_BUTTONS; i++)
        {
            final int buttonnumber = i;
            Button b = new Button(act.getBaseContext());
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
            Log.e("Count", String.valueOf(row.getChildCount()));
        }
    }
    private void buttonClicked(int buttonnumber) {
        act.getFragmentManager().beginTransaction().replace(R.id.ContentFrame,fragments[buttonnumber]).commit();
    }
}
