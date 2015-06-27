package ui;

import javax.swing.*;
import java.awt.*;

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
        graphPanel = new MainPanel(10, 4, w, h);
        graphPanel.setSize(w-6, h * 3 / 4);
        graphPanel.setLocation(0, 0);
        getContentPane().add(graphPanel);
        // temp


        filePanel = new FilePanel();
        filePanel.setSize(w-6, h*1/4-27);
        filePanel.setLocation(0, h * 3 / 4-1);
        getContentPane().add(filePanel);

        getContentPane().setBackground(Color.GRAY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
    public static void main(String[] arg){
        new MainFrame("Flow Free", 800, 650);
    }
}
