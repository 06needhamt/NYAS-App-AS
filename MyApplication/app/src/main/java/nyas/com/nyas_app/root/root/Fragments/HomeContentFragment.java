package nyas.com.nyas_app.root.root.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nyas.com.nyas_app.R;

/**
 * Created by 22416714 on 25/03/2015.
 */
public class HomeContentFragment extends Fragment{

    View v;

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
        TextView text = (TextView) v.findViewById(R.id.ContentText);
        text.setText(R.string.home_content_placehlder);
        return view;
    }
}
