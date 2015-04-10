package nyas.com.nyas_app.root.root.Activities;

import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;

import nyas.com.nyas_app.R;
import nyas.com.nyas_app.root.root.Fragments.AccessibilityFragment;
import nyas.com.nyas_app.root.root.Fragments.ButtonFragment;
import nyas.com.nyas_app.root.root.Fragments.HomeContentFragment;
import nyas.com.nyas_app.root.root.Fragments.LogoFragment;
import nyas.com.nyas_app.root.root.Fragments.SpeechFragment;


/**
 * Created by Thomas Needham on 25/03/2015.
 * This class creates and displays the first Activity when the app is first opened
 * @author Thomas Needham
 *
 */
public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DisplayMetrics dm = new DisplayMetrics();
        GetDisplayMetrics(dm);
        //AddContentFragment(new Fragment());
        AddButtonFragment (new ButtonFragment());
        AddLogoFragment(new LogoFragment());
        AddSpeechFragment (new SpeechFragment());
        AddAccessabilityFragment (new AccessibilityFragment());
        AddContentFragment (new HomeContentFragment());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * This method adds the Fragment containing the navigation buttons to the Activity
     * @param f the fragment to add to the Activity
     */
    protected void AddButtonFragment(Fragment f) {
        this.getFragmentManager().beginTransaction().add(R.id.bottomTableForButtons, f).commit();
    }

    /**
    * This method adds the Fragment containing the logo to the Activity
    * @param f the fragment to add to the Activity
    */
    protected void AddLogoFragment(Fragment f) {
        this.getFragmentManager().beginTransaction().add(R.id.LogoFrame, f).commit();
    }

    /**
     * This method adds the Fragment containing the speech bubble to the Activity
     * @param f the fragment to add to the Activity
     */
    protected void AddSpeechFragment(Fragment f) {
        this.getFragmentManager().beginTransaction().add(R.id.SpeechFrame, f).commit();
    }

    /**
     * This method adds the Fragment containing the Accessibility bar to the Activity
     * @param f the fragment to add to the Activity
     */
    protected void AddAccessabilityFragment(Fragment f) {
        this.getFragmentManager().beginTransaction().add(R.id.AccessibilityFrame, f).commit();
    }

    /**
     * This method adds the Fragment containing the Content Pane to the Activity
     * @param f the fragment to add to the Activity
     */
    protected void AddContentFragment(Fragment f) {
        this.getFragmentManager().beginTransaction().add(R.id.ContentFrame, f).commit();
    }

    /**
     * gets the screen width and size for dynamic creation of the ui
     * @param dm the display metrics object to store the values in
     */
    protected void GetDisplayMetrics(DisplayMetrics dm) {
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width, height;
        width = dm.widthPixels;
        height = dm.heightPixels;
    }
}
