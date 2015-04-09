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

    protected void AddButtonFragment(Fragment f) {
        this.getFragmentManager().beginTransaction().add(R.id.bottomTableForButtons, f).commit();
    }

    protected void AddLogoFragment(Fragment f) {
        this.getFragmentManager().beginTransaction().add(R.id.LogoFrame, f).commit();
    }

    protected void AddSpeechFragment(Fragment f) {
        this.getFragmentManager().beginTransaction().add(R.id.SpeechFrame, f).commit();
    }

    protected void AddAccessabilityFragment(Fragment f) {
        this.getFragmentManager().beginTransaction().add(R.id.AccessibilityFrame, f).commit();
    }

    protected void AddContentFragment(Fragment f) {
        this.getFragmentManager().beginTransaction().add(R.id.ContentFrame, f).commit();
    }

    protected void GetDisplayMetrics(DisplayMetrics dm) {
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width, height;
        width = dm.widthPixels;
        height = dm.heightPixels;
    }
}
