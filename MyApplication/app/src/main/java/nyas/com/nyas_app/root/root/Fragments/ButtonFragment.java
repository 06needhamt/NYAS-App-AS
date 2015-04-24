package nyas.com.nyas_app.root.root.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import nyas.com.nyas_app.R;
import nyas.com.nyas_app.root.root.Activities.MainActivity;
import nyas.com.nyas_app.root.root.classes.ButtonCreator;

/**
 * Created by 22416714 on 25/03/2015.
 */
public class ButtonFragment extends Fragment {

    View v;
    Fragment[] fragments;
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
        fragments = createFragments();
        createButtons();
        return view;
    }

    /**
     * creates an array of {@link android.app.Fragment} objects for use with the navigation buttons
     * @return an array of {@link android.app.Fragment} objects for use with the navigation buttons
     */
    private Fragment[] createFragments()
    {
        fragments = new Fragment[6];
        fragments[0] = new HomeContentFragment();
        fragments[1] = new UserProfileContentFragment();
        fragments[2] = new ContactDetailsFragment();
        fragments[3] = new GroupChatFragment();
        fragments[4] = new FeedbackFragment();
        fragments[5] = new InformationFragment();
        return fragments;

    }

    /**
     * this method creates the navigation buttons that are displayed at the bottom of the screen
     * and allow the user to navigate through the app
     */
    private void createButtons() {

        TableLayout table = (TableLayout) v.findViewById(R.id.TableForButtons);
        ButtonCreator btnCreator = new ButtonCreator((MainActivity) this.getActivity(),getids(),table,fragments);
        btnCreator.createButtons();

    }

    /**
     * creates an integer array containing the ids from {@link nyas.com.nyas_app.R.drawable}
     * which represent the icons which are placed on the navigation buttons
     * @return an integer array containing the ids from {@link nyas.com.nyas_app.R.drawable}
     * which represent the icons which are placed on the navigation buttons
     */
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
