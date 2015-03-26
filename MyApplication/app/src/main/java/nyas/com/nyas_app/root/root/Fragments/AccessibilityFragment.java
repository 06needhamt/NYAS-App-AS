package nyas.com.nyas_app.root.root.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import nyas.com.nyas_app.R;


/**
 * Created by Tom Needham on 25/03/2015.
 */
public class AccessibilityFragment extends Fragment{

    View v;
    TextView TitleText;
    TextView LargeText;
    TextView MediumText;
    TextView SmallTexr;
    float defaultsize = 0.0f;
    ImageView Pink;
    ImageView Blue;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate (R.layout.fragment_accessibility, container, false);
        v = view;
        CreateLayoutParams();
        return view;
    }

    private void CreateLayoutParams() {
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenheight = dm.heightPixels;
        int screenwidth = dm.widthPixels;
        CreateTextViews(screenheight,screenwidth);
        CreateImageViews(screenheight,screenwidth);

    }

    private void CreateImageViews(int screenheight, int screenwidth) {
        Pink = (ImageView) v.findViewById(R.id.Pink);
        Pink.setBackgroundColor(v.getResources().getColor(R.color.Pink));
        Pink.setLayoutParams(CreatePinkLayoutParams(screenheight,screenwidth));
        Blue = (ImageView) v.findViewById(R.id.Blue);
        Blue.setBackgroundColor(v.getResources().getColor(R.color.Blue));
        Blue.setLayoutParams(CreateBlueLayoutParams(screenheight,screenwidth));

    }

    private FrameLayout.LayoutParams CreatePinkLayoutParams(int screenheight, int screenwidth) {

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.gravity = Gravity.LEFT;
        params.width = (int) (screenwidth * 0.03);
        params.height = (int) (screenwidth * 0.03);
        params.topMargin = (int) (screenwidth * 0.015);
        params.leftMargin = (int) (screenwidth * 0.40);
        return params;
    }

    private FrameLayout.LayoutParams CreateBlueLayoutParams(int screenheight, int screenwidth) {

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.gravity = Gravity.LEFT;
        params.width = (int) (screenwidth * 0.03);
        params.height = (int) (screenwidth * 0.03);
        params.topMargin = (int) (screenwidth * 0.015);
        params.leftMargin = (int) (screenwidth * 0.44);
        return params;
    }

    private void CreateTextViews(int screenheight, int screenwidth) {
        TitleText = (TextView) v.findViewById(R.id.TileText);
        TitleText.setTextColor(v.getResources().getColor(R.color.White));
        TitleText.setLayoutParams(CreateTitleLayoutParams(screenheight,screenwidth));
        defaultsize = TitleText.getTextSize();
        LargeText = (TextView) v.findViewById(R.id.LargeText);
        LargeText.setTextColor(v.getResources().getColor(R.color.White));
        LargeText.setLayoutParams(CreateLargeTextLayoutParams(screenheight,screenwidth));
        MediumText = (TextView) v.findViewById(R.id.mediumText);
        MediumText.setTextColor(v.getResources().getColor(R.color.White));
        MediumText.setLayoutParams(CreateMediumTextLayoutParams(screenheight,screenwidth));
        SmallTexr = (TextView) v.findViewById(R.id.SmallText);
        SmallTexr.setTextColor(v.getResources().getColor(R.color.White));
        SmallTexr.setLayoutParams(CreateSmallTextLayoutParams(screenheight,screenwidth));
    }

    private FrameLayout.LayoutParams CreateLargeTextLayoutParams(int screenheight, int screenwidth) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.gravity = Gravity.LEFT;
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.leftMargin = (int) (screenwidth * 0.26);
        return params;

    }

    private FrameLayout.LayoutParams CreateMediumTextLayoutParams(int screenheight, int screenwidth) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.gravity = Gravity.LEFT;
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.leftMargin = (int) (screenwidth * 0.32);
        return params;

    }

    private FrameLayout.LayoutParams CreateSmallTextLayoutParams(int screenheight, int screenwidth) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.gravity = Gravity.LEFT;
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.leftMargin = (int) (screenwidth * 0.36);
        return params;

    }

    private FrameLayout.LayoutParams CreateTitleLayoutParams(int screenheight, int screenwidth) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.START;
        params.leftMargin = (int) (screenwidth * 0.02);
        return params;
    }
}
