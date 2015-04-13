package nyas.com.nyas_app.root.root.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyas.com.nyas_app.R;

/**
 * Created by Tom on 13/04/2015.
 */
public class InformationFragment extends Fragment {

    View v;
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
        getActivity().findViewById(R.id.LogoFrame).setVisibility(View.GONE);
        getActivity().findViewById(R.id.AccessibilityFrame).setVisibility(View.GONE);
        getActivity().findViewById(R.id.SpeechFrame).setVisibility(View.GONE);
        //SetUpViews();
        return view;
    }

}
