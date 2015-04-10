package nyas.com.nyas_app.root.root.Fragments;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import nyas.com.nyas_app.R;

/**
 * Created by Thomas Needham on 25/03/2015.
 * This class creates and displays the speech fragment where important information will be displayed on the screen
 * @author Thomas Needham
 */
public class SpeechFragment extends LogoFragment {
    /**
     * The View object used in the creation of this fragment
     */
    View v;
    /**
     * The TextView object that will be used to display important information on the screen
     */
    TextView speech;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_speech, container, false);
        view.setPadding(0, 0, 0, 0);
        v = view;
        CreateViews();
        return view;
    }

    /**
     * this method creates all of the views in this fragment and assigns their layout params
     */
    private void CreateViews() {
        DisplayMetrics dm = new DisplayMetrics ();
        int screenwidth;
        int screenheight;
        this.getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        screenwidth = dm.widthPixels;
        screenheight = dm.heightPixels;
        speech = (TextView) v.findViewById(R.id.textSpeech);

        speech.setLayoutParams(createSpeechLayoutParams(screenwidth, screenheight));
    }

    /**
     * this method creates the layout params for the Speech TextView
     * @param screenwidth the width of the screen on the device that the app is currently running on
     * @param screenheight the height of the screen on the device that the app is currently running on
     * @return The FrameLayout.LayoutParams object to be assigned to the Speech TextView
     */
    private FrameLayout.LayoutParams createSpeechLayoutParams(int screenwidth, int screenheight) {

        FrameLayout.LayoutParams param = new FrameLayout.LayoutParams (screenwidth, screenheight);
        param.gravity = Gravity.RIGHT;
        param.width = (int) (screenwidth * 0.4);
        param.height = FrameLayout.LayoutParams.MATCH_PARENT;
        param.topMargin = (int) (screenheight * 0.02);
        param.rightMargin = (int) (screenwidth * 0.05);
        param.bottomMargin = (int) (screenheight * 0.02);
        return param;
    }
}
