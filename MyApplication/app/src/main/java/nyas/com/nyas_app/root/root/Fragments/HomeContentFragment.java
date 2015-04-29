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
public class HomeContentFragment extends Fragment {
    /**
     * The view object being used to render this fragment
     */
    View v;
    DisplayMetrics dm;
    TextView Title;
    TextView Subtitle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content_home, container, false);
        view.setPadding(0, 0, 0, 5);
        v = view;
        getDisplayMetrics();
//        getActivity().findViewById(R.id.ContentFrame).setVisibility(View.VISIBLE);
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

        Title = (TextView) v.findViewById(R.id.Title);
        Title.setText(R.string.welcome_to_app_string);
        Title.setTextColor(getActivity().getResources().getColor(R.color.Black));
        Title.setTextSize(TypedValue.COMPLEX_UNIT_DIP,30.0f);
        Title.setLayoutParams(CreateTitleLayoutParams(screenwidth,screenheight));
        Subtitle = (TextView) v.findViewById(R.id.Subtitle);
        Subtitle.setText(R.string.navigation_string);
        Subtitle.setTextColor(getActivity().getResources().getColor(R.color.Black));
        Subtitle.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20.0f);
        Subtitle.setLayoutParams(CreateSubTitleLayoutParams(screenwidth,screenheight));
    }
    /**
     * this method creates the {@link android.widget.FrameLayout.LayoutParams} for the title TextView
     * @param screenwidth the width of the devices screen
     * @param screenheight the height of the devices screen
     * @return the {@link android.widget.FrameLayout.LayoutParams} for the title TextView
     */
    private FrameLayout.LayoutParams CreateTitleLayoutParams(int screenwidth, int screenheight) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = (int) (screenheight * 0.01);
        return params;
    }

    /**
     * this method creates the {@link android.widget.FrameLayout.LayoutParams} for the subtitle TextView
     * @param screenwidth the width of the devices screen
     * @param screenheight the height of the devices screen
     * @return the {@link android.widget.FrameLayout.LayoutParams} for the title TextView
     */
    private FrameLayout.LayoutParams CreateSubTitleLayoutParams(int screenwidth, int screenheight) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = (int) (screenheight * 0.30);
        return params;
    }

}

