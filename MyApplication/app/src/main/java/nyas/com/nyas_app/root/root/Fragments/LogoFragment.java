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
 * Created by 22416714 on 25/03/2015.
 */
public class LogoFragment extends Fragment {

    View v;
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

    private ImageView createLogo(int screenwidth, int screenheight) {
       ImageView img = (ImageView) v.findViewById(R.id.Logo);
        img.setLayoutParams(createLogoLayoutParameters(screenwidth,screenheight));
        img.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.logo_2));
        return img;
    }

    private RelativeLayout.LayoutParams createLogoLayoutParameters(int screenwidth, int screenheight) {
        RelativeLayout.LayoutParams lparams = new RelativeLayout.LayoutParams(screenwidth,screenheight);
        lparams.width = (int) (screenwidth * 0.5f);
        lparams.height = (int) (screenheight * 0.5f);
        return lparams;
    }


}
