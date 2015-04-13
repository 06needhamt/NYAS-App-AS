package nyas.com.nyas_app.root.root.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import nyas.com.nyas_app.R;

import static android.view.ViewTreeObserver.OnGlobalLayoutListener;

/**
 * Created by 22416714 on 25/03/2015.
 * This class creates and displays the content pane for the home page
 * @author Tom Needham
 */
public class HomeContentFragment extends Fragment{
    /**
     * The view object being used to render this fragment
     */
    View v;
    TextView Row1;
    TextView Row2;
    DisplayMetrics dm;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_content_home,container,false);
        view.setPadding(0,0,0,5);
        v = view;
        dm = new DisplayMetrics();
        getActivity().findViewById(R.id.ContentFrame).setVisibility(View.VISIBLE);
        SetUpViews();
        v.requestLayout();
        return view;
    }

    /**
     * this method initialises and draws all of the objects within the fragment and displays them
     */
    private void SetUpViews() {
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        Row1 = (TextView) v.findViewById(R.id.Row1);
        Row1.setBackgroundColor(getActivity().getResources().getColor(R.color.Blue));
        Row1.setTextColor(getActivity().getResources().getColor(R.color.White));
        Row1.setTextSize(TypedValue.COMPLEX_UNIT_SP,15.0f);
        Row1.setLayoutParams(CreateRow1Params());

        Row2 = (TextView) v.findViewById(R.id.Row2);
        Row2.setBackgroundColor(getActivity().getResources().getColor(R.color.Yellow));
        Row2.setTextColor(getActivity().getResources().getColor(R.color.Black));
        Row2.setTextSize(TypedValue.COMPLEX_UNIT_SP,15.0f);
        Row2.setLayoutParams(CreateRow2Params());


    }

    /**
     * Create the layout params for a row of the ui by getting the height and width
     * of the fragment
     */

    private FrameLayout.LayoutParams CreateRow1Params()
    {

        int screenwidth = dm.widthPixels;
        int screenheight = dm.heightPixels;
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        //params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.width = FrameLayout.LayoutParams.MATCH_PARENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = (int) (screenheight * 0.10);
        params.leftMargin = (int) (screenwidth * 0.05);
        params.rightMargin = (int) (screenwidth * 0.05);
        return params;
    }


    /**
     * Create the layout params for a row of the ui by getting the height and width
     * of the fragment
     */
    private FrameLayout.LayoutParams CreateRow2Params()
    {
        int screenwidth = dm.widthPixels;
        int screenheight = dm.heightPixels;
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
}
