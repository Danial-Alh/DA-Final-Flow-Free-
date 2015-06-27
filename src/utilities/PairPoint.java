package utilities;

import java.awt.*;
import java.util.*;

/**
 * Created by Dani on 6/27/2015.
 */
public class PairPoint
{
    private Point origin;
    private Point dest;
    private Vector<MyPoint> queue;

    public Point getOrigin()
    {
        return origin;
    }

    public Point getDest()
    {
        return dest;
    }

    public Vector<MyPoint> getQueue()
    {
        return queue;
    }

    public PairPoint(Point origin, Point dest)
    {
        this.origin = origin;
        this.dest = dest;
        init();

    }

    public void init()
    {
        queue = new Vector<MyPoint>();
    }
}
