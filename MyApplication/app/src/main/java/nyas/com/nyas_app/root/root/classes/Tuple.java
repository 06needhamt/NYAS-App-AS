package nyas.com.nyas_app.root.root.classes;

/**
 * Created by Tom on 15/04/2015.
 * This class represents a tuple which contains two different objects under one name
 * @param <X> the type of the first element
 * @param <Y> the type of the second element
 */
public class Tuple <X,Y>{

    private X x;
    private Y y;

    /**
     * Constructor for a tuple
     * @param x the first value
     * @param y the second value
     */
    public Tuple(X x, Y y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * gets the first element
     * @return the first element
     */
    public X getX() {
        return x;
    }

    /**
     * sets the first element
     * @param x the first element
     */
    public void setX(X x) {
        this.x = x;
    }

    /**
     * gets the second element
     * @return the second element
     */
    public Y getY() {
        return y;
    }

    /**
     * sets the second element
     * @param y the second element
     */
    public void setY(Y y) {
        this.y = y;
    }
}
