package ui;

import logic.FlowFree;
import utilities.MyPoint;
import utilities.PairPoint;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * Created by Dani on 6/27/2015.
 */
public class MainFrame extends JFrame
{
    public MainFrame(String arg0, int w, int h) {
        super(arg0);
        Dimension d = getToolkit().getScreenSize();
        setSize(w,h);
        setLocation((d.width-w)/2,(d.height-h)/2);
        setLayout(null);

        getContentPane().setBackground(Color.GRAY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
    public static void main(String[] arg){

        int[][] graph = {
                {-1,-1,-1,-1,-1,-1},
                {-1,-1, 1,-1, 0,-1},
                {-1,-1,-1,-1,-1,-1},
                { 0,-1,-1,-1,-1, 2},
                {-1, 2,-1,-1, 1,-1},
                {-1,-1,-1,-1,-1,-1}
        };

        Vector<PairPoint> pairPoints = new Vector<PairPoint>();
        pairPoints.add( new PairPoint( new Point(3,0), new Point(1,4) ) );
        pairPoints.add( new PairPoint( new Point(1,2), new Point(4,4) ) );
        pairPoints.add( new PairPoint( new Point(4,1), new Point(3,5) ) );
        FlowFree flowFree = new FlowFree( graph, pairPoints);
        flowFree.solve();
    }
}
