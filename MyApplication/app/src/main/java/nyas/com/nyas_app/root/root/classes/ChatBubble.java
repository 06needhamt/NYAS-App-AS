package nyas.com.nyas_app.root.root.classes;

import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;

/**
 * Created by Tom on 17/04/2015.
 * T
 */
public class ChatBubble extends ShapeDrawable {
    public ChatBubble(Shape s)
    {
        super(s);
        SetFill();
        SetStroke();
    }

    private void SetStroke() {
        getPaint().setARGB(0xFF,0xFF,0xFF,0xFF);
        getPaint().setStyle(Paint.Style.FILL);
        getPaint().setStrokeWidth(10.0f);
    }

    private void SetFill() {
        getPaint().setARGB(0xFF,0x75,0x75,0xEF);
        getPaint().setStyle(Paint.Style.FILL);
    }
}
