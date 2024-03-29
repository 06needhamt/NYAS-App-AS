package nyas.com.nyas_app.root.root.classes;

import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.widget.TextView;

/**
 * Created by Tom on 17/04/2015.
 * This class crates a border that will be placed around a text view
 */
public class TextViewBorder extends ShapeDrawable{
    /**
     * Constructs a new border
     * @param s the shape of the border
     */
    public TextViewBorder(Shape s)
    {
        super(s);
        this.getPaint().setARGB(0xFF,0x00,0x00,0x00);
        this.getPaint().setStyle(Paint.Style.STROKE);
        this.getPaint().setStrokeWidth(5.0f);

    }
    //ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());

}
