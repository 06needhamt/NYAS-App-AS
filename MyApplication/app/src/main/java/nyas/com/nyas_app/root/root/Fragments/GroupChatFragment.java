package nyas.com.nyas_app.root.root.Fragments;

import android.app.Fragment;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nyas.com.nyas_app.R;
import nyas.com.nyas_app.root.root.IAppConstants;
import nyas.com.nyas_app.root.root.classes.AppointmentList;
import nyas.com.nyas_app.root.root.classes.ChatBubble;
import nyas.com.nyas_app.root.root.classes.TextViewBorder;
import nyas.com.nyas_app.root.root.classes.Time;
import nyas.com.nyas_app.root.root.classes.Tuple;

/**
 * Created by Tom on 15/04/2015.
 * This class creates and displays the group chat fragment where app users can chat to each other
 */
public class GroupChatFragment extends Fragment implements IAppConstants {
    View v;
    DisplayMetrics dm;
    ScrollView lv;
    EditText Message;
    Button Send;
    LinearLayout Chatlinear;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_group_chat, container, false);
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
        lv = (ScrollView) v.findViewById(R.id.Chatitems);
        lv.setBackground(new TextViewBorder(new RectShape()));
        lv.setLayoutParams(CreateItemsLayoutParams(screenwidth,screenheight));
        Chatlinear = new LinearLayout(getActivity());
        Chatlinear.setOrientation(LinearLayout.VERTICAL);

        lv.addView(Chatlinear);
        Message = (EditText) v.findViewById(R.id.Message);
        Message.setLayoutParams(CreateMessageLayoutParams(screenwidth,screenheight));
        Message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message.setText("");
            }
        });
        Send = (Button) v.findViewById(R.id.SendButton);
        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendMessage();
            }
        });
        Send.setLayoutParams(CreateSendLayoutParams(screenwidth,screenheight));

    }

    /**
     * this method sends a message
     */
    private void SendMessage() {

        TextView tv = new TextView(getActivity());
        tv.setTextColor(getActivity().getResources().getColor(R.color.Black));
        tv.setText(Message.getText().toString());
        tv.setLayoutParams(createMessageLayoutParams());
        tv.setBackground(new ChatBubble(new RectShape()));
        Chatlinear.addView(tv);

    }

    /**
     * this method creates the {@link android.widget.LinearLayout.LayoutParams} for chat messages
     * @return the {@link android.widget.LinearLayout.LayoutParams} for chat messages
     */
    public LinearLayout.LayoutParams createMessageLayoutParams()
    {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(Message.getWidth(),Message.getHeight());
        params.height = LinearLayout.LayoutParams.WRAP_CONTENT;
        params.width = LinearLayout.LayoutParams.MATCH_PARENT;
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.topMargin = 2;
        params.rightMargin = 2;
        return params;
    }

    /**
     * this method creates the {@link android.widget.FrameLayout.LayoutParams} for the chat items
     * @param screenwidth the width of the devices screen
     * @param screenheight the height of the devices screen
     * @return the {@link android.widget.FrameLayout.LayoutParams} for the chat items
     */
    FrameLayout.LayoutParams CreateItemsLayoutParams(int screenwidth,int screenheight)
    {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.topMargin = (int) (screenheight * 0.01);
        params.width = FrameLayout.LayoutParams.MATCH_PARENT;
        params.height = (int) (screenheight * 0.50);
        return params;
    }

    /**
     * this method creates the {@link android.widget.FrameLayout.LayoutParams} for the message edit text
     * @param screenwidth the width of the devices screen
     * @param screenheight the height of the devices screen
     * @return the {@link android.widget.FrameLayout.LayoutParams} for the message edit text
     */
    FrameLayout.LayoutParams CreateMessageLayoutParams(int screenwidth,int screenheight)
    {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.gravity = Gravity.START;
        params.topMargin = (int) (screenheight * 0.52);
        params.leftMargin = (int) (screenwidth * 0.05);
        params.width = (int) (screenwidth * 0.60);
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        return params;
    }

    /**
     * this method creates the {@link android.widget.FrameLayout.LayoutParams} for the send button
     * @param screenwidth the width of the devices screen
     * @param screenheight the height of the devices screen
     * @return the {@link android.widget.FrameLayout.LayoutParams} for the send button
     */
    FrameLayout.LayoutParams CreateSendLayoutParams(int screenwidth,int screenheight)
    {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.gravity = Gravity.END;
        params.topMargin = (int) (screenheight * 0.50);
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.leftMargin = (int) (screenwidth * 0.05);
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        return params;
    }

    /**
     * this method gets the {@link android.util.DisplayMetrics} associated with the device that the app
     * is currently running on
     */
    public void GetDisplayMetrics()
    {
        dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
    }
}
