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

    public MyPoint(int x, int y, Point dest)
    {
        super(x, y);
        this.dest = dest;
        bound = calcBound();
    }

    private int calcBound()
    {
        return Math.abs( x-dest.x ) + Math.abs(y-dest.y);
    }
}
