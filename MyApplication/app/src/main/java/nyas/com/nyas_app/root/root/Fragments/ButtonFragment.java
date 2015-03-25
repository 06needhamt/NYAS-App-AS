package nyas.com.nyas_app.root.root.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import nyas.com.nyas_app.R;
import nyas.com.nyas_app.root.root.classes.ButtonCreator;

/**
 * Created by 22416714 on 25/03/2015.
 */
public class ButtonFragment extends Fragment {

    View v;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_button,container,false);
        view.setPadding(0,0,0,0);
        v = view;
        createButtons();
        return view;
    }

    private void createButtons() {

        TableLayout table = (TableLayout) v.findViewById(R.id.TableForButtons);
        ButtonCreator btnCreator = new ButtonCreator(this.getActivity(),getids(),table);
        btnCreator.createButtons();

    }

    private int[] getids() {
        int[] ids = new int[6];
        ids[0] = R.drawable.picture1;
        ids[1] = R.drawable.picture3;
        ids[2] = R.drawable.picture4;
        ids[3] = R.drawable.picture5;
        ids[4] = R.drawable.picture6;
        ids[5] = R.drawable.picture8;
        return ids;

    }
}
