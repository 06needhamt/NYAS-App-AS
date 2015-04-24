package nyas.com.nyas_app.root.root.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import nyas.com.nyas_app.R;

/**
 * Created by Tom Needham on 22/04/2015.
 * This class creates and displays the fragment witch contains contact information for NYAS
 */
public class ContactDetailsFragment extends Fragment {

    View v;
    TextView Title;
    TextView Content;
    DisplayMetrics dm;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_content_details,container,false);
        view.setPadding(0,0,0,0);
        v = view;
        getDisplayMetrics();
        CreateViews();
        return view;
    }

    /**
     * This method sets up all of the views within this fragments
     * and also assigns their layout parameters
     * @see android.widget.FrameLayout.LayoutParams
     */
    private void CreateViews() {
        int screenwidth = dm.widthPixels;
        int screenheight = dm.heightPixels;
        Title = (TextView) v.findViewById(R.id.Title);
        Title.setText(R.string.contact_title);
        Title.setTextColor(getActivity().getResources().getColor(R.color.Black));
        Title.setLayoutParams(CreateTitleLayoutParams(screenwidth,screenheight));
        Content = (TextView) v.findViewById(R.id.Content);
        Content.setText(R.string.contact_information);
        Content.setTextColor(getActivity().getResources().getColor(R.color.Black));
        Content.setLayoutParams(CreateContentLayoutParams(screenwidth,screenheight));
        Content.setMovementMethod(new ScrollingMovementMethod());
        Content.setMaxLines(10);
    }

    /**
     * this method creates the {@link android.widget.FrameLayout.LayoutParams} for the title TextView
     * @param screenwidth the width of the devices screen
     * @param screenheight the height of the devices screen
     * @return the {@link android.widget.FrameLayout.LayoutParams} for the title TextView
     */
    private FrameLayout.LayoutParams CreateTitleLayoutParams(int screenwidth, int screenheight) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.topMargin = (int) (screenheight * 0.05);
        return params;
    }
    /**
     * this method creates the {@link android.widget.FrameLayout.LayoutParams} for the content TextView
     * @param screenwidth the width of the devices screen
     * @param screenheight the height of the devices screen
     * @return the {@link android.widget.FrameLayout.LayoutParams} for the content TextView
     */
    private FrameLayout.LayoutParams CreateContentLayoutParams(int screenwidth, int screenheight) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.width = FrameLayout.LayoutParams.MATCH_PARENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.topMargin = (int) (screenheight * 0.15);
        return params;
    }
    /**
     * this method gets the {@link android.util.DisplayMetrics} associated with the device that the app
     * is currently running on
     */
    private void getDisplayMetrics()
    {
        dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
    }
}
