package nyas.com.nyas_app.root.root.Fragments;

import android.app.Fragment;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import nyas.com.nyas_app.R;
import nyas.com.nyas_app.root.root.IAppConstants;
import nyas.com.nyas_app.root.root.classes.ChatBubble;
import nyas.com.nyas_app.root.root.classes.TextViewBorder;

/**
 * Created by Tom on 15/04/2015.
 */
public class FeedbackFragment extends Fragment implements IAppConstants{
    View v;
    DisplayMetrics dm;
    TextView Title;
    RatingBar Rating;
    EditText Comments;
    Button Submit;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_feedback, container, false);
        view.setPadding(0, 0, 0, 5);
        v = view;
        GetDisplayMetrics();
        SetUpViews();

        return view;
    }

    /**
     * This method sets up all of the views within this fragments
     * and also assigns their layout parameters
     * @see android.widget.FrameLayout.LayoutParams
     */
    private void SetUpViews() {
        int screenheight = dm.heightPixels;
        int screenwidth = dm.widthPixels;
        Title = (TextView) v.findViewById(R.id.Title);
        Title.setTextColor(getActivity().getResources().getColor(R.color.Black));
        Title.setLayoutParams(CreateTitleLayoutParams(screenheight,screenwidth));
        Rating = (RatingBar) v.findViewById(R.id.UserRatingBar);
        Rating.setNumStars(5);
        Rating.setMax(Rating.getNumStars());
        Rating.setStepSize(2);
        Rating.setLayoutParams(CreateRatingLayoutParams(screenheight,screenwidth));
        Comments = (EditText) v.findViewById(R.id.AdditionalComments);
        Comments.setTextColor(getActivity().getResources().getColor(R.color.Black));
        Comments.setText("Additional Comments...");
        Comments.setBackground((Drawable) CreateBorder());
        Comments.setLayoutParams(CreateCommentsLayoutParams(screenheight,screenwidth));
        Comments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comments.setText("");
            }
        });
        Submit = (Button) v.findViewById(R.id.SubmitButton);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveFeedback();
            }
        });
        Submit.setLayoutParams(CreateSubmitLayoutParams(screenheight,screenwidth));

    }

    /**
     * this method saves the feedback submitted by the user
     */
    private void SaveFeedback() {
        Toast.makeText(getActivity(),"Feedback Saved",Toast.LENGTH_LONG).show();
        Log.e("Feedback",String.valueOf(Rating.getRating()));
        Log.e("Feedback",Comments.getText().toString());
    }

    /**
     * this method creates a {@link android.graphics.drawable.ShapeDrawable} in the shape of a border
     * @return a {@link android.graphics.drawable.ShapeDrawable} in the shape of a border
     */
    private ShapeDrawable CreateBorder() {

        TextViewBorder shapeDrawable = new TextViewBorder(new RectShape());
        return shapeDrawable;

    }

    /**
     * this method creates the {@link android.widget.FrameLayout.LayoutParams} for the title TextView
     * @param screenwidth the width of the devices screen
     * @param screenheight the height of the devices screen
     * @return the {@link android.widget.FrameLayout.LayoutParams} for the title TextView
     */
    private FrameLayout.LayoutParams CreateTitleLayoutParams(int screenheight, int screenwidth) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = (int) (screenheight * 0.00);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        return params;
    }

    /**
     * this method creates the {@link android.widget.FrameLayout.LayoutParams} for the Rating View
     * @param screenwidth the width of the devices screen
     * @param screenheight the height of the devices screen
     * @return the {@link android.widget.FrameLayout.LayoutParams} for the Rating View
     */
    private FrameLayout.LayoutParams CreateRatingLayoutParams(int screenheight, int screenwidth) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = (int) (screenheight * 0.05);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        return params;
    }

    /**
     * this method creates the {@link android.widget.FrameLayout.LayoutParams} for the comments EditText
     * @param screenwidth the width of the devices screen
     * @param screenheight the height of the devices screen
     * @return the {@link android.widget.FrameLayout.LayoutParams} for the comments EditText
     */
    private FrameLayout.LayoutParams CreateCommentsLayoutParams(int screenheight, int screenwidth) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.width = FrameLayout.LayoutParams.MATCH_PARENT;
        params.height = (int) (screenheight * 0.30);
        params.topMargin = (int) (screenheight * 0.15);
        params.rightMargin = (int) (screenwidth * 0.05);
        params.leftMargin = (int) (screenwidth * 0.05);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        return params;
    }

    /**
     * this method creates the {@link android.widget.FrameLayout.LayoutParams} for the submit button
     * @param screenwidth the width of the devices screen
     * @param screenheight the height of the devices screen
     * @return the {@link android.widget.FrameLayout.LayoutParams} for the submit button
     */
    private FrameLayout.LayoutParams CreateSubmitLayoutParams(int screenheight, int screenwidth) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth, screenheight);
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = (int) (screenheight * 0.48);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        return params;
    }
    /**
     * this method gets the {@link android.util.DisplayMetrics} associated with the device that the app
     * is currently running on
     */
    private void GetDisplayMetrics() {
        dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
    }
    
}
