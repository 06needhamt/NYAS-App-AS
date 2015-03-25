package nyas.com.nyas_app.root.root.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyas.com.nyas_app.R;


/**
 * Created by 22416714 on 25/03/2015.
 */
public class AccessibilityFragment extends Fragment{

    View v;
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
        return view;
    }
}
