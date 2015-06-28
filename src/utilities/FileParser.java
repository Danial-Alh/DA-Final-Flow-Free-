package utilities;

import logic.FlowFree;
import ui.MainFrame;
import ui.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by Hosein on 6/28/2015.
 */
public class FileParser {

    JPanel graphPanel;
    String fileName;
    String inputData;
    int graphSize;
    int[][] graph;
    Vector<PairPoint> pairPoints;

    public FileParser(String fileName, int w, int h, MainFrame mainFrame)
    {
        this.fileName = fileName;
        inputData = "";
        getFile();
        findGraphSize();
        graph = new int[graphSize][graphSize];
        pairPoints = new Vector<PairPoint>();
        buildGraphAndPairs();

        FlowFree flowFree;
        flowFree = new FlowFree(graph, pairPoints);
        flowFree.solve();

        graphPanel = new MainPanel(graphSize, graphSize, w, h, flowFree.result);
        graphPanel.setSize(w-6, h * 3 / 4);
        graphPanel.setLocation(0, 0);
        mainFrame.getContentPane().add(graphPanel);
    }

    private void buildGraphAndPairs() {
        int i = 3;
        int point;
        int starti, startj;
        int endi, endj;
        while(inputData.charAt(i) != '*')
        {
//            if(inputData.charAt(i)!= ' ' && inputData.charAt(i)!= '\r' && inputData.charAt(i)!= '\n')
            point = inputData.charAt(i) - 48;
            i+=3;
            starti = inputData.charAt(i) - 48 - 1;
            i+=2;
            startj = inputData.charAt(i) - 48 - 1;
            i+=3;
            endi = inputData.charAt(i) - 48 - 1;
            i+=2;
            endj = inputData.charAt(i) - 48 - 1;

            graph[starti][startj] = point;
            graph[endi][endj] = point;
            pairPoints.addElement(new PairPoint( new Point(starti, startj), new Point(endi, endj) ));

            i+=5;
        }
    }

    private void findGraphSize() {
        graphSize = inputData.charAt(0) - 48;
    }

    void getFile()
    {
        try {
            inputData = new Scanner(new File(fileName)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            System.out.print("File empty!");
            System.exit(0);
        }
        inputData += "\r\n\r\n*";
    }
}
