package nyas.com.nyas_app.root.root.classes;

/**
 * Created by Tom on 15/04/2015.
 */
public class Tuple <X,Y>{
    private X x;
    private Y y;
    public Tuple(X x, Y y)
    {
        this.x = x;
        this.y = y;
    }

    public X getX() {
        return x;
    }

    public void setX(X x) {
        this.x = x;
    }

    public Y getY() {
        return y;
    }

    public void setY(Y y) {
        this.y = y;
    }
}
