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
 * Created by 22416714 on 22/04/2015.
 */
public class ContactDetailsFragment extends Fragment {

    View v;
    TextView Title;
    TextView Content;
    DisplayMetrics dm;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_content_details,container,false);
        view.setPadding(0,0,0,0);
        v = view;
        getDisplayMetrics();
        CreateViews();
        return view;
    }

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

    private FrameLayout.LayoutParams CreateTitleLayoutParams(int screenwidth, int screenheight) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.topMargin = (int) (screenheight * 0.05);
        return params;
    }

    private FrameLayout.LayoutParams CreateContentLayoutParams(int screenwidth, int screenheight) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.width = FrameLayout.LayoutParams.MATCH_PARENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.topMargin = (int) (screenheight * 0.15);
        return params;
    }

    private void getDisplayMetrics()
    {
        dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
    }
}
