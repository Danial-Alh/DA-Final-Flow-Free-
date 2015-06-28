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
    JPanel graphPanel, filePanel;

    public MainFrame(String arg0, int w, int h) {
        super(arg0);
        Dimension d = getToolkit().getScreenSize();
        setSize(w,h);
        setLocation((d.width-w)/2,(d.height-h)/2-30);
        setLayout(null);
        setResizable(false);

        //  temp
//        graphPanel = new MainPanel(10, 4, w, h);
//        graphPanel.setSize(w-6, h * 3 / 4);
//        graphPanel.setLocation(0, 0);
//        getContentPane().add(graphPanel);
        // temp


        filePanel = new FilePanel(w, h, this);
        filePanel.setSize(w-6, h*1/4-27);
        filePanel.setLocation(0, h * 3 / 4-1);
        getContentPane().add(filePanel);

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
