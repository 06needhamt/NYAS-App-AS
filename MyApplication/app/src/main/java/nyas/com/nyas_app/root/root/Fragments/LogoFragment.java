package nyas.com.nyas_app.root.root.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import nyas.com.nyas_app.R;

/**
 * Created by Thomas Needham on 25/03/2015.
 * This class creates and displays the Fragment in which a copy of the NYAS logo
 * from <a href = https://www.nyas.net/> Official NYAS website </a>
 */
public class LogoFragment extends Fragment {
    /**
     * The View Object used in the creation of this fragment
     */
    View v;
    /**
     * The ImageView Object that will display the NYAS logo on the screen
     */
    ImageView logo;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_logo,container,false);
        view.setPadding(0,0,0,0);
        v = view;
        DisplayMetrics dm = new DisplayMetrics();
        int screenwidth,screenheight;
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        screenheight = dm.heightPixels;
        screenwidth = dm.widthPixels;
        logo = createLogo(screenwidth, screenheight);
        return view;
    }

    /**
     * This main page creates and displays an ImageView containing the NYAS logo
     * And Also assigns its layout params
     * @param screenwidth the width of the screen on the device that the app is running on
     * @param screenheight the height of the screen on the device that the app is running on
     * @return The created ImageView Object
     */
    private ImageView createLogo(int screenwidth, int screenheight) {
       ImageView img = (ImageView) v.findViewById(R.id.Logo);
        img.setLayoutParams(createLogoLayoutParameters(screenwidth,screenheight));
        img.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.logo_2));
        return img;
    }

    /**
     * This method creates the layout params for the logo ImageView object
     * @param screenwidth the width of the screen on the device that the app is running on
     * @param screenheight the height of the screen on the device that the app is running on
     * @return The FrameLayout.LayoutParams object to be assigned to the logo ImageView
     */
    private RelativeLayout.LayoutParams createLogoLayoutParameters(int screenwidth, int screenheight) {
        RelativeLayout.LayoutParams lparams = new RelativeLayout.LayoutParams(screenwidth,screenheight);
        lparams.width = (int) (screenwidth * 0.5f);
        lparams.height = (int) (screenheight * 0.5f);
        return lparams;
    }


}
