package utilities;

import java.util.Vector;

/**
 * Created by Dani on 6/27/2015.
 */
public class PriorityQ extends Vector<MyPoint>
{
    private PairPoint org_dest;
    public PriorityQ( PairPoint org_dest )
    {
        super();
        this.org_dest = org_dest;
    }

    public void AddSorted( MyPoint point )
    {
        for( int i = 0; i < size(); i++ )
        {
            if( point.getBound() > elementAt(i).getBound() )
            {
                insertElementAt(point,i);
                return;
            }
        }
        add(point);
    }


}
