package nyas.com.nyas_app.root.root.classes;

import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;

/**
 * Created by Tom on 17/04/2015.
 * This class represents a chat buuble text view
 */
public class ChatBubble extends ShapeDrawable {
    /**
     * Constructor for the chat bubble
     * @param s the shape of the created bubble
     */
    public ChatBubble(Shape s){
        super(s);
        SetFill();
        SetStroke();
    }

    /**
     * this method sets the stroke colour and width on the chat bubble
     */
    private void SetStroke() {
        getPaint().setARGB(0xFF,0xFF,0xFF,0xFF);
        getPaint().setStyle(Paint.Style.FILL);
        getPaint().setStrokeWidth(10.0f);
    }

    /**
     * this method sets the fill colour of the chat bubble
     */
    private void SetFill() {
        getPaint().setARGB(0xFF,0x75,0x75,0xEF);
        getPaint().setStyle(Paint.Style.FILL);
    }
}
