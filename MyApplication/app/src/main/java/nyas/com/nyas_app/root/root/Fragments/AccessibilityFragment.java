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
import android.widget.TextView;

import nyas.com.nyas_app.R;


/**
 * Created by Tom Needham on 25/03/2015.
 * This class creates and displays the accessibility fragment
 * @author Tom Needham
 */
public class AccessibilityFragment extends Fragment{

    View v;
    TextView TitleText;
    TextView LargeText;
    TextView MediumText;
    TextView SmallTexr;
    TextView TextOnly;
    float defaultsize = 0.0f;
    ImageView Pink;
    ImageView Blue;
    ImageView Yellow;
    ImageView Black;
    ImageView Cream;
    ImageView Grey;
    ImageView White;
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
        SetupViews();
        return view;
    }

    /**
     * This method sets up all of the views within this fragments
     * and also assigns their layout parameters
     * @see android.widget.FrameLayout.LayoutParams
     */
    private void SetupViews() {
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenheight = dm.heightPixels;
        int screenwidth = dm.widthPixels;
        CreateTextViews(screenheight,screenwidth);
        CreateImageViews(screenheight,screenwidth);

    }

    /**
     * This method creates and displays all of the ImageView objects within this fragment
     * And assigns their layout parameters
     * @param screenheight the height of the screen in pixels on the device that the app is running on
     * @param screenwidth the width of the screen in pixels on the device that the app is running on
     */

    private void CreateImageViews(int screenheight, int screenwidth) {
        Pink = (ImageView) v.findViewById(R.id.Pink);
        Pink.setBackgroundColor(v.getResources().getColor(R.color.Pink));
        Pink.setLayoutParams(CreatePinkLayoutParams(screenheight,screenwidth));
        Blue = (ImageView) v.findViewById(R.id.Blue);
        Blue.setBackgroundColor(v.getResources().getColor(R.color.Blue));
        Blue.setLayoutParams(CreateBlueLayoutParams(screenheight,screenwidth));
        Yellow = (ImageView) v.findViewById(R.id.Yellow);
        Yellow.setBackgroundColor(v.getResources().getColor(R.color.Yellow));
        Yellow.setLayoutParams(CreateYellowLayoutParams(screenheight,screenwidth));
        Black = (ImageView) v.findViewById(R.id.Black);
        Black.setBackgroundColor(v.getResources().getColor(R.color.Black));
        Black.setLayoutParams(CreateBlackLayoutParams(screenheight,screenwidth));
        Cream = (ImageView) v.findViewById(R.id.Cream);
        Cream.setBackgroundColor(getResources().getColor(R.color.Cream));
        Cream.setLayoutParams(CreateCreamLayoutParams(screenheight,screenwidth));
        Grey = (ImageView) v.findViewById(R.id.Grey);
        Grey.setBackgroundColor(getResources().getColor(R.color.Grey));
        Grey.setLayoutParams(CreateGreyLayoutParams(screenheight,screenwidth));
        White = (ImageView) v.findViewById(R.id.White);
        White.setBackgroundColor(v.getResources().getColor(R.color.White));
        White.setLayoutParams(CreateWhiteLayoutParams(screenheight,screenwidth));

    }

    /**
     * This method creates and displays all of the TextView objects within this fragment
     * And assigns their layout parameters
     * @param screenheight the height of the screen in pixels on the device that the app is running on
     * @param screenwidth the width of the screen in pixels on the device that the app is running on
     */
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
        TextOnly = (TextView) v.findViewById(R.id.TextOnly);
        TextOnly.setTextColor(v.getResources().getColor(R.color.White));
        TextOnly.setLayoutParams(CreateTextOnlyLayoutParams(screenheight,screenwidth));
    }


    /**
     * This method creates the layout params for the Pink ImageView object within this fragment
     * @param screenheight the height of the screen in pixels on the device that the app is running on
     * @param screenwidth the width of the screen in pixels on the device that the app is running on
     * @return The layout FrameLayout.LayoutParams to be assigned to the object
     */
    private FrameLayout.LayoutParams CreatePinkLayoutParams(int screenheight, int screenwidth) {

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.gravity = Gravity.LEFT;
        params.width = (int) (screenwidth * 0.03);
        params.height = (int) (screenwidth * 0.03);
        params.topMargin = (int) (screenwidth * 0.015);
        params.leftMargin = (int) (screenwidth * 0.40);
        return params;
    }

    /**
     * This method creates the layout params for the Blue ImageView object within this fragment
     * @param screenheight the height of the screen in pixels on the device that the app is running on
     * @param screenwidth the width of the screen in pixels on the device that the app is running on
     * @return The layout FrameLayout.LayoutParams to be assigned to the object
     */
    private FrameLayout.LayoutParams CreateBlueLayoutParams(int screenheight, int screenwidth) {

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.gravity = Gravity.LEFT;
        params.width = (int) (screenwidth * 0.03);
        params.height = (int) (screenwidth * 0.03);
        params.topMargin = (int) (screenwidth * 0.015);
        params.leftMargin = (int) (screenwidth * 0.44);
        return params;
    }

    /**
     * This method creates the layout params for the Yellow ImageView object within this fragment
     * @param screenheight the height of the screen in pixels on the device that the app is running on
     * @param screenwidth the width of the screen in pixels on the device that the app is running on
     * @return The layout FrameLayout.LayoutParams to be assigned to the object
     */
    private FrameLayout.LayoutParams CreateYellowLayoutParams(int screenheight, int screenwidth) {

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.gravity = Gravity.LEFT;
        params.width = (int) (screenwidth * 0.03);
        params.height = (int) (screenwidth * 0.03);
        params.topMargin = (int) (screenwidth * 0.015);
        params.leftMargin = (int) (screenwidth * 0.48);
        return params;
    }

    /**
     * This method creates the layout params for the Black ImageView object within this fragment
     * @param screenheight the height of the screen in pixels on the device that the app is running on
     * @param screenwidth the width of the screen in pixels on the device that the app is running on
     * @return The layout FrameLayout.LayoutParams to be assigned to the object
     */
    private FrameLayout.LayoutParams CreateBlackLayoutParams(int screenheight, int screenwidth) {

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.gravity = Gravity.LEFT;
        params.width = (int) (screenwidth * 0.03);
        params.height = (int) (screenwidth * 0.03);
        params.topMargin = (int) (screenwidth * 0.015);
        params.leftMargin = (int) (screenwidth * 0.52);
        return params;
    }

    /**
     * This method creates the layout params for the Cream ImageView object within this fragment
     * @param screenheight the height of the screen in pixels on the device that the app is running on
     * @param screenwidth the width of the screen in pixels on the device that the app is running on
     * @return The layout FrameLayout.LayoutParams to be assigned to the object
     */
    private FrameLayout.LayoutParams CreateCreamLayoutParams(int screenheight, int screenwidth) {

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.gravity = Gravity.LEFT;
        params.width = (int) (screenwidth * 0.03);
        params.height = (int) (screenwidth * 0.03);
        params.topMargin = (int) (screenwidth * 0.015);
        params.leftMargin = (int) (screenwidth * 0.56);
        return params;
    }

    /**
     * This method creates the layout params for the Grey ImageView object within this fragment
     * @param screenheight the height of the screen in pixels on the device that the app is running on
     * @param screenwidth the width of the screen in pixels on the device that the app is running on
     * @return The layout FrameLayout.LayoutParams to be assigned to the object
     */
    private FrameLayout.LayoutParams CreateGreyLayoutParams(int screenheight, int screenwidth) {

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.gravity = Gravity.LEFT;
        params.width = (int) (screenwidth * 0.03);
        params.height = (int) (screenwidth * 0.03);
        params.topMargin = (int) (screenwidth * 0.015);
        params.leftMargin = (int) (screenwidth * 0.60);
        return params;
    }

    /**
     * This method creates the layout params for the White ImageView object within this fragment
     * @param screenheight the height of the screen in pixels on the device that the app is running on
     * @param screenwidth the width of the screen in pixels on the device that the app is running on
     * @return The layout FrameLayout.LayoutParams to be assigned to the object
     */
    private FrameLayout.LayoutParams CreateWhiteLayoutParams(int screenheight, int screenwidth) {

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.gravity = Gravity.LEFT;
        params.width = (int) (screenwidth * 0.03);
        params.height = (int) (screenwidth * 0.03);
        params.topMargin = (int) (screenwidth * 0.015);
        params.leftMargin = (int) (screenwidth * 0.64);
        return params;
    }

    /**
     * This method creates the layout params for the Large Text TextView object within this fragment
     * @param screenheight the height of the screen in pixels on the device that the app is running on
     * @param screenwidth the width of the screen in pixels on the device that the app is running on
     * @return The layout FrameLayout.LayoutParams to be assigned to the object
     */
    private FrameLayout.LayoutParams CreateLargeTextLayoutParams(int screenheight, int screenwidth) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.gravity = Gravity.LEFT;
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.leftMargin = (int) (screenwidth * 0.26);
        return params;

    }

    /**
     * This method creates the layout params for the Medium Text TextView object within this fragment
     * @param screenheight the height of the screen in pixels on the device that the app is running on
     * @param screenwidth the width of the screen in pixels on the device that the app is running on
     * @return The layout FrameLayout.LayoutParams to be assigned to the object
     */
    private FrameLayout.LayoutParams CreateMediumTextLayoutParams(int screenheight, int screenwidth) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.gravity = Gravity.LEFT;
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.leftMargin = (int) (screenwidth * 0.32);
        return params;

    }

    /**
     * This method creates the layout params for the Small Text TextView object within this fragment
     * @param screenheight the height of the screen in pixels on the device that the app is running on
     * @param screenwidth the width of the screen in pixels on the device that the app is running on
     * @return The layout FrameLayout.LayoutParams to be assigned to the object
     */
    private FrameLayout.LayoutParams CreateSmallTextLayoutParams(int screenheight, int screenwidth) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.gravity = Gravity.LEFT;
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.leftMargin = (int) (screenwidth * 0.36);
        return params;

    }

    /**
     * This method creates the layout params for the Title TextView object within this fragment
     * @param screenheight the height of the screen in pixels on the device that the app is running on
     * @param screenwidth the width of the screen in pixels on the device that the app is running on
     * @return The layout FrameLayout.LayoutParams to be assigned to the object
     */
    private FrameLayout.LayoutParams CreateTitleLayoutParams(int screenheight, int screenwidth) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.START;
        params.leftMargin = (int) (screenwidth * 0.02);
        return params;
    }

    /**
     * This method creates the layout params for the Text Only TextView object within this fragment
     * @param screenheight the height of the screen in pixels on the device that the app is running on
     * @param screenwidth the width of the screen in pixels on the device that the app is running on
     * @return The layout FrameLayout.LayoutParams to be assigned to the object
     */

    private FrameLayout.LayoutParams CreateTextOnlyLayoutParams(int screenheight, int screenwidth) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.START;
        params.leftMargin = (int) (screenwidth * 0.70);
        return params;
    }
}
