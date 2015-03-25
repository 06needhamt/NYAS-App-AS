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
 * Created by 22416714 on 25/03/2015.
 */
public class SpeechFragment extends LogoFragment {

    View v;
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
        DisplayMetrics dm = new DisplayMetrics ();
        int screenwidth;
        int screenheight;
        this.getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        screenwidth = dm.widthPixels;
        screenheight = dm.heightPixels;
        v = view;
        speech = (TextView) v.findViewById(R.id.textSpeech);

        speech.setLayoutParams(createSpeechLayoutParams(screenwidth, screenheight));
        return view;
    }

    private ViewGroup.LayoutParams createSpeechLayoutParams(int screenwidth, int screenheight) {

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
