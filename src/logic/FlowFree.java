package logic;

import utilities.MyPoint;
import utilities.PairPoint;
import utilities.ResultGraph;

import java.awt.*;
import java.util.Vector;

/**
 * Created by Dani on 6/27/2015.
 */
public class FlowFree
{
    int[][] graph;
    Vector<PairPoint> pairPoints;
    public ResultGraph result;
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
            solve(0);
    }

    private void solve(int pairIndex)
    {
        if( pairIndex == pairPoints.size() )
        {
            updateMax();
            return;
        }

        PairPoint pairPoint = pairPoints.elementAt(pairIndex);
        MyPoint firstPoint = new MyPoint(
                (int)pairPoint.getOrigin().getX(),
                (int)pairPoint.getOrigin().getY(),
                pairPoint.getDest(),
                null );
        pairPoint.init();
        pairPoint.getQueue().add(firstPoint);
        while( !pairPoints.elementAt(pairIndex).getQueue().isEmpty() )
        {
            Vector<MyPoint> queue = pairPoint.getQueue();
            MyPoint point = queue.remove(0);
            int moves = writePathOnGraph(point, pairIndex);
//            System.out.println("****************************************\t" + pairIndex + "\t*******************************");
//            printGraph();
            for( int[] nextPoint : nextPoints)
            {
                Point dest = pairPoint.getDest();
                if( isValid(point, nextPoint, pairIndex) )
                {
                    if( point.getX_int() + nextPoint[0] == (int)dest.getX() && point.getY_int() + nextPoint[1] == (int)dest.getY() )
                    {
                        result.getMoves()[pairIndex] = moves+1;
//                        System.out.println( "****************************************\t" + pairIndex + "\t*******************************");
//                        printGraph();
//                        System.out.println("***********************************************************************");
                        solve( pairIndex+1);
                    }
                    else
                        queue.add(new MyPoint(point.getX_int() + nextPoint[0], point.getY_int() + nextPoint[1], dest, point));
                }
            }
            removePathFromGraph(point);
        }
    }

    void printGraph()
    {
        for( int i = 0; i < graph.length; i++)
        {
            for( int j = 0; j < graph[0].length; j++)
                System.out.print( graph[i][j] + " " );
            System.out.println();
        }
    }
    private boolean isValid(MyPoint point, int[] nextPoint, int pairIndex)
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
        Point dest = pairPoints.elementAt(pairIndex).getDest();
        if( graph[x][y] == pairIndex && dest.getX() == x && dest.getY() == y)
            return true;
        if( graph[x][y] == -1)
            return true;
        return false;
    }

    private void removePathFromGraph(MyPoint point)
    {
        if( point.getParent() != null )
        {
            graph[point.getX_int()][point.getY_int()] = -1;
            removePathFromGraph(point.getParent());
        }
    }

    private int writePathOnGraph(MyPoint point, int pairIndex)
    {
        if( point.getParent() != null )
        {
            graph[point.getX_int()][point.getY_int()] = pairIndex;
            return writePathOnGraph( point.getParent(), pairIndex) + 1;
        }
        return 0;
    }

    private void updateMax()
    {
        int min = 0;
        for( int move : result.getMoves() )
            min += move;
        if( min < result.getMin() )
        {
            System.out.println( "here\n");
            result.setMin( min );
            for( int i = 0; i < graph.length; i++)
            {
                for( int j = 0; j < graph[0].length; j++)
                {
                    result.getGraph()[i][j] = graph[i][j];
                    System.out.print( graph[i][j] + " " );
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
