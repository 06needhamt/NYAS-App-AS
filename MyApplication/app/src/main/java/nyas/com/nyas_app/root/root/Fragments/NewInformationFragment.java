package nyas.com.nyas_app.root.root.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import nyas.com.nyas_app.R;

/**
 * Created by Tom on 29/04/2015.
 */
public class NewInformationFragment extends Fragment{
    /**
     * The view object being used to render this fragment
     */
    View v;
    TextView Row1;
    TextView Row2;
    TextView Row3;
    TextView Row4;
    DisplayMetrics dm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_information, container, false);
        view.setPadding(0, 0, 0, 5);
        v = view;
        getDisplayMetrics();
        getActivity().findViewById(R.id.ContentFrame).setVisibility(View.VISIBLE);
        SetUpViews();
        v.requestLayout();
        return view;
    }

    /**
     * this class gets the {@link android.util.DisplayMetrics} associated with the device that the app
     * is currently running on
     */
    private void getDisplayMetrics() {
        dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);

    }

    /**
     * this method sets up all of the necessary views to display this fragment
     */
    private void SetUpViews() {
        int screenwidth = dm.widthPixels;
        int screenheight = dm.heightPixels;
        Row1 = (TextView) v.findViewById(R.id.Row1);
        Row1.setBackgroundColor(getActivity().getResources().getColor(R.color.White));
        Row1.setText(R.string.first_information_string);
        Row1.setTextColor(getActivity().getResources().getColor(R.color.Black));
        Row1.setTextSize(TypedValue.COMPLEX_UNIT_SP,15.0f);
        Row1.setLayoutParams(CreateRow1Params(screenwidth,screenheight));

        Row2 = (TextView) v.findViewById(R.id.Row2);
        Row2.setBackgroundColor(getActivity().getResources().getColor(R.color.Grey));
        Row2.setText(R.string.second_information_string);
        Row2.setTextColor(getActivity().getResources().getColor(R.color.White));
        Row2.setTextSize(TypedValue.COMPLEX_UNIT_SP,15.0f);
        Row2.setLayoutParams(CreateRow2Params(screenwidth,screenheight));

        Row3 = (TextView) v.findViewById(R.id.Row3);
        Row3.setBackgroundColor(getActivity().getResources().getColor(R.color.Info_Green));
        Row3.setText(R.string.third_information_string);
        Row3.setTextColor(getActivity().getResources().getColor(R.color.White));
        Row3.setTextSize(TypedValue.COMPLEX_UNIT_SP,15.0f);
        Row3.setLayoutParams(CreateRow3Params(screenwidth,screenheight));

        Row4 = (TextView) v.findViewById(R.id.Row4);
        Row4.setBackgroundColor(getActivity().getResources().getColor(R.color.Info_Pink));
        Row4.setText(R.string.forth_information_string);
        Row4.setTextColor(getActivity().getResources().getColor(R.color.White));
        Row4.setTextSize(TypedValue.COMPLEX_UNIT_SP,15.0f);
        Row4.setLayoutParams(CreateRow4Params(screenwidth,screenheight));


    }

    /**
     * this method creates the {@link android.widget.FrameLayout.LayoutParams} for the first row of the UI
     * @param screenwidth the width of the devices screen
     * @param screenheight the height of the devices screen
     * @return the {@link android.widget.FrameLayout.LayoutParams} for the first row of the UI
     */

    private FrameLayout.LayoutParams CreateRow1Params(int screenwidth,int screenheight)
    {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        //params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.width = FrameLayout.LayoutParams.MATCH_PARENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = (int) (screenheight * 0.01);
        params.leftMargin = (int) (screenwidth * 0.05);
        params.rightMargin = (int) (screenwidth * 0.05);
        return params;
    }


    /**
     * this method creates the {@link android.widget.FrameLayout.LayoutParams} for the second row of the UI
     * @param screenwidth the width of the devices screen
     * @param screenheight the height of the devices screen
     * @return the {@link android.widget.FrameLayout.LayoutParams} for the second row of the UI
     */
    private FrameLayout.LayoutParams CreateRow2Params(int screenwidth, int screenheight)
    {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        //params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.width = FrameLayout.LayoutParams.MATCH_PARENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = (int) (screenheight * 0.20);
        params.leftMargin = (int) (screenwidth * 0.05);
        params.rightMargin = (int) (screenwidth * 0.05);
        return params;
    }

    /**
     * this method creates the {@link android.widget.FrameLayout.LayoutParams} for the third row of the UI
     * @param screenwidth the width of the devices screen
     * @param screenheight the height of the devices screen
     * @return the {@link android.widget.FrameLayout.LayoutParams} for third row of the UI
     */
    private FrameLayout.LayoutParams CreateRow3Params(int screenwidth, int screenheight)
    {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        //params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.width = FrameLayout.LayoutParams.MATCH_PARENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = (int) (screenheight * 0.30);
        params.leftMargin = (int) (screenwidth * 0.05);
        params.rightMargin = (int) (screenwidth * 0.05);
        return params;
    }

    /**
     * this method creates the {@link android.widget.FrameLayout.LayoutParams} for the forth row of the UI
     * @param screenwidth the width of the devices screen
     * @param screenheight the height of the devices screen
     * @return the {@link android.widget.FrameLayout.LayoutParams} for forth row of the UI
     */
    private FrameLayout.LayoutParams CreateRow4Params(int screenwidth, int screenheight)
    {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        //params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.width = FrameLayout.LayoutParams.MATCH_PARENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = (int) (screenheight * 0.40);
        params.leftMargin = (int) (screenwidth * 0.05);
        params.rightMargin = (int) (screenwidth * 0.05);
        return params;
    }
}
