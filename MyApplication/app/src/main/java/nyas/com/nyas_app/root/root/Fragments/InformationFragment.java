package nyas.com.nyas_app.root.root.Fragments;

import android.app.Fragment;
import android.content.Context;
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
 * Created by Tom on 13/04/2015.
 */
public class InformationFragment extends Fragment {

    View v;
    ImageView HomeImage;
    TextView HomeText;
    ImageView InformationImage;
    TextView InformationText;
    ImageView ContactImage;
    TextView ContactText;
    ImageView ProfileImage;
    TextView ProfileText;
    ImageView ChatImage;
    TextView ChatText;
    ImageView FeedbackImage;
    ImageView FeedbackText;
    DisplayMetrics dm;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_information,container,false);
        view.setPadding(0,0,0,5);
        v = view;
        dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        getActivity().findViewById(R.id.LogoFrame).setVisibility(View.GONE);
        getActivity().findViewById(R.id.AccessibilityFrame).setVisibility(View.GONE);
        getActivity().findViewById(R.id.SpeechFrame).setVisibility(View.GONE);
        SetUpViews();
        return view;
    }

    private void SetUpViews() {
        SetUpImageViews();
        SetUpTextViews();

    }

    private void SetUpTextViews() {
        int screenwidth = dm.widthPixels;
        int screenheight = dm.heightPixels;

        HomeText = (TextView) v.findViewById(R.id.homeText);
        HomeText.setTextColor(getActivity().getResources().getColor(R.color.Black));
        HomeText.setText(R.string.home_page_info);
        HomeText.setLayoutParams(CreateHomeTextLayoutParams(screenheight,screenwidth));
        InformationText = (TextView) v.findViewById(R.id.informationText);
        InformationText.setTextColor(getActivity().getResources().getColor(R.color.Black));
        InformationText.setText(R.string.info_page_info);
        InformationText.setLayoutParams(CreateInformationTextLayoutParams(screenheight, screenwidth));
        ContactText = (TextView) v.findViewById(R.id.contactText);
        ContactText.setTextColor(getActivity().getResources().getColor(R.color.Black));
        ContactText.setText(R.string.contact_page_info);
        ContactText.setLayoutParams(CreateContactTextLayoutParams(screenheight, screenwidth));
        ProfileText = (TextView) v.findViewById(R.id.profileText);
        ProfileText.setTextColor(getActivity().getResources().getColor(R.color.Black));
        ProfileText.setText(R.string.profile_page_info);
        ProfileText.setLayoutParams(CreateProfileTextLayoutParams(screenheight, screenwidth));

    }

    private void SetUpImageViews() {
        int screenwidth = dm.widthPixels;
        int screenheight = dm.heightPixels;
        float scale = 1.5f;
        HomeImage = (ImageView) v.findViewById(R.id.homeImage);
        HomeImage.setImageResource(R.drawable.picture1);
        HomeImage.setScaleY(scale);
        HomeImage.setScaleX(scale);
        HomeImage.setLayoutParams(CreateHomeImageLayoutParams(screenheight, screenwidth));
        InformationImage = (ImageView) v.findViewById(R.id.informationImage);
        InformationImage.setImageResource(R.drawable.picture8);
        InformationImage.setScaleY(scale);
        InformationImage.setScaleX(scale);
        InformationImage.setLayoutParams(CreateInformationImageLayoutParams(screenheight,screenwidth));
        ContactImage = (ImageView) v.findViewById(R.id.contactImage);
        ContactImage.setImageResource(R.drawable.picture4);
        ContactImage.setScaleY(scale);
        ContactImage.setScaleX(scale);
        ContactImage.setLayoutParams(CreateContactImageLayoutParams(screenheight,screenwidth));
        ProfileImage = (ImageView) v.findViewById(R.id.profileImage);
        ProfileImage.setImageResource(R.drawable.picture3);
        ProfileImage.setScaleY(scale);
        ProfileImage.setScaleX(scale);
        ProfileImage.setLayoutParams(CreateProfileImageLayoutParams(screenheight,screenwidth));
    }

    private FrameLayout.LayoutParams CreateHomeTextLayoutParams(int screenheight, int screenwidth) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.RIGHT;
        params.leftMargin = (int) (screenwidth * 0.10) + HomeImage.getDrawable().getIntrinsicWidth();
        params.topMargin = (int) (screenheight * 0.05);
        return params;
    }
    private FrameLayout.LayoutParams CreateHomeImageLayoutParams(int screenheight, int screenwidth) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.LEFT;
        params.leftMargin = (int) (screenwidth * 0.05);
        params.topMargin = (int) (screenheight * 0.05);
        return params;
    }

    private FrameLayout.LayoutParams CreateInformationTextLayoutParams(int screenheight, int screenwidth) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.RIGHT;
        params.leftMargin = (int) (screenwidth * 0.10) + InformationImage.getDrawable().getIntrinsicWidth();
        params.topMargin = (int) (screenheight * 0.20);
        return params;
    }
    private FrameLayout.LayoutParams CreateInformationImageLayoutParams(int screenheight, int screenwidth) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.LEFT;
        params.leftMargin = (int) (screenwidth * 0.05);
        params.topMargin = (int) (screenheight * 0.20);
        return params;
    }

    private FrameLayout.LayoutParams CreateContactTextLayoutParams(int screenheight, int screenwidth) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.RIGHT;
        params.leftMargin = (int) (screenwidth * 0.10) + ContactImage.getDrawable().getIntrinsicWidth();
        params.topMargin = (int) (screenheight * 0.35);
        return params;
    }
    private FrameLayout.LayoutParams CreateContactImageLayoutParams(int screenheight, int screenwidth) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.LEFT;
        params.leftMargin = (int) (screenwidth * 0.05);
        params.topMargin = (int) (screenheight * 0.35);
        return params;
    }

    private FrameLayout.LayoutParams CreateProfileTextLayoutParams(int screenheight, int screenwidth) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.RIGHT;
        params.leftMargin = (int) (screenwidth * 0.10) + ProfileImage.getDrawable().getIntrinsicWidth();
        params.topMargin = (int) (screenheight * 0.50);
        return params;
    }
    private FrameLayout.LayoutParams CreateProfileImageLayoutParams(int screenheight, int screenwidth) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.LEFT;
        params.leftMargin = (int) (screenwidth * 0.05);
        params.topMargin = (int) (screenheight * 0.55);
        return params;
    }

}
