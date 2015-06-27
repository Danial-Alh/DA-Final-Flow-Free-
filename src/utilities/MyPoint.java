package utilities;

import java.awt.*;

/**
 * Created by Dani on 6/27/2015.
 */
public class MyPoint extends Point
{
    public int getBound()
    {
        return bound;
    }

    private int bound;
    private Point dest;
    private MyPoint parent;

    public MyPoint getParent()
    {
        return parent;
    }

    public MyPoint(int x, int y, Point dest, MyPoint parent)
    {
        super(x, y);

        this.dest = dest;
        this.parent = parent;
        this.bound = calcBound();
    }

    private int calcBound()
    {
        return Math.abs( x-dest.x ) + Math.abs(y-dest.y);
    }

    public int getX_int()
    {
        return (int)super.getX();
    }

    public int getY_int()
    {
        return (int)super.getY();
    }
}
