package logic;

import utilities.MyPoint;
import utilities.PairPoint;
import utilities.ResultGraph;

import java.util.Vector;

/**
 * Created by Dani on 6/27/2015.
 */
public class FlowFree
{
    int[][] graph;
    Vector<PairPoint> pairPoints;
    ResultGraph result;
    private static int[][] nextPoints =
            {
                    {0,1},
                    {1,0},
                    {0,-1},
                    {-1,0}
            };

    public FlowFree(int[][] graph, Vector<PairPoint> pairPoints)
    {
        this.graph = graph;
        this.pairPoints = pairPoints;
        result = new ResultGraph( graph.length, graph[0].length, pairPoints.size() );
    }

    public void solve()
    {
        if( pairPoints.size() > 0 )
            solve(0, 0);
    }

    private void solve( int pairIndex, int moves )
    {
        if( pairIndex == pairPoints.size() )
        {
            updateMax();
            return;
        }

        PairPoint pairPoint = pairPoints.elementAt(pairIndex);
        MyPoint firstPoint = new MyPoint(
                pairPoint.getOrigin().getX_int(),
                pairPoint.getOrigin().getY_int(),
                pairPoint.getDest(),
                null );
       pairPoint.init();
       pairPoint.getQueue().add(firstPoint);
        while( !pairPoints.elementAt(pairIndex).getQueue().isEmpty() )
        {
            Vector<MyPoint> queue = pairPoint.getQueue();
            MyPoint point = queue.remove(0);
            writePathOnGraph(point, pairIndex);

            for( int[] nextPoint : nextPoints)
            {
                if( isValid(point, nextPoint) )
                {
                    MyPoint dest = pairPoint.getDest();
                    if( point.getX_int() == dest.getX_int() && point.getY_int() == dest.getY_int() )
                    {
                        result.getMoves()[pairIndex] = moves+1;
                        solve( pairIndex+1, 0 );
                    }
                    else
                        queue.add(new MyPoint(point.getX_int() + nextPoint[0], point.getY_int() + nextPoint[1], dest, point));
                }
            }
            removePathFromGraph( point );
        }
    }

    private boolean isValid(MyPoint point, int[] nextPoint)
    {
        int x =point.getX_int() + nextPoint[0],
            y = point.getY_int() + nextPoint[1];

        if( x >= graph.length )
            return false;
        if( y >= graph[0].length )
            return false;
        if( x < 0 )
            return false;
        if( y < 0 )
            return false;
        if( graph[x][y] != -1 )
            return false;
        return true;
    }

    private void removePathFromGraph(MyPoint point)
    {
        if( point.getParent() != null )
        {
            graph[point.getX_int()][point.getY_int()] = -1;
            removePathFromGraph(point.getParent());
        }
    }

    private void writePathOnGraph(MyPoint point, int pairIndex)
    {
        if( point.getParent() != null )
        {
            graph[point.getX_int()][point.getY_int()] = pairIndex;
            writePathOnGraph( point.getParent(), pairIndex);
        }
    }

    private void updateMax()
    {
        int min = 0;
        for( int move : result.getMoves() )
            min += move;
        if( min < result.getMin() )
        {
            result.setMin( min );
            for( int i = 0; i < graph.length; i++)
                for( int j = 0; j < graph[0].length; j++)
                    result.getGraph()[i][j] = graph[i][j];
        }
    }
}
