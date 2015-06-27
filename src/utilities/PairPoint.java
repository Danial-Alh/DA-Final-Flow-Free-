package utilities;

import java.awt.*;
import java.util.*;

/**
 * Created by Dani on 6/27/2015.
 */
public class PairPoint
{
    private MyPoint origin;
    private MyPoint dest;
    private Vector<MyPoint> queue;

    public MyPoint getOrigin()
    {
        return origin;
    }

    public MyPoint getDest()
    {
        return dest;
    }

    public Vector<MyPoint> getQueue()
    {
        return queue;
    }

    public PairPoint(MyPoint origin, MyPoint dest)
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
