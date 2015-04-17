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
 */
public class GroupChatFragment extends Fragment implements IAppConstants {
    View v;
    DisplayMetrics dm;
    ScrollView lv;
    TextView Message;
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

    private void SetUpViews() {
        int screenheight = dm.heightPixels;
        int screenwidth = dm.widthPixels;
        lv = (ScrollView) v.findViewById(R.id.Chatitems);
        lv.setBackground(new TextViewBorder(new RectShape()));
        lv.setLayoutParams(CreateItemsLayoutParams(screenwidth,screenheight));
         Chatlinear = new LinearLayout(getActivity());
        Chatlinear.setOrientation(LinearLayout.VERTICAL);

        lv.addView(Chatlinear);
        Message = (TextView) v.findViewById(R.id.Message);
        Message.setLayoutParams(CreateMessageLayoutParams(screenwidth,screenheight));
        Send = (Button) v.findViewById(R.id.SendButton);
        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendMessage();
            }
        });
        Send.setLayoutParams(CreateSendLayoutParams(screenwidth,screenheight));

    }

    private void SendMessage() {

        TextView tv = new TextView(getActivity());
        tv.setText(Message.getText().toString());
        tv.setBackground(new ChatBubble(new RectShape()));
        Chatlinear.addView(tv);

    }

    private void GetDisplayMetrics() {
        dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
    }

    FrameLayout.LayoutParams CreateItemsLayoutParams(int screenwidth,int screenheight)
    {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(screenwidth,screenheight);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.topMargin = (int) (screenheight * 0.20);
        params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.height = (int) (screenheight * 0.60);
        return params;
    }

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
}
