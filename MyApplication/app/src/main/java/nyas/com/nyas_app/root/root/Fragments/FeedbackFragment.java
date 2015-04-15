package nyas.com.nyas_app.root.root.Fragments;

import android.app.Fragment;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
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

    private void SaveFeedback() {
        Toast.makeText(getActivity(),"Feedback Saved",Toast.LENGTH_LONG).show();
        Log.e("Feedback",String.valueOf(Rating.getRating()));
        Log.e("Feedback",Comments.getText().toString());
    }

    private ShapeDrawable CreateBorder() {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
        shapeDrawable.getPaint().setARGB(0xFF,0x00,0x00,0x00);
        shapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
        shapeDrawable.getPaint().setStrokeWidth(20.0f);
        return shapeDrawable;

    }

    private FrameLayout.LayoutParams CreateTitleLayoutParams(int screenheight, int screenwidth) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = (int) (screenheight * 0.00);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        return params;
    }

    private FrameLayout.LayoutParams CreateRatingLayoutParams(int screenheight, int screenwidth) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = (int) (screenheight * 0.05);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        return params;
    }
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
    private FrameLayout.LayoutParams CreateSubmitLayoutParams(int screenheight, int screenwidth) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth, screenheight);
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = (int) (screenheight * 0.48);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        return params;
    }
    private void GetDisplayMetrics() {
        dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
    }
    
}