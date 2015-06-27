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
        setLocation((d.width-w)/2,(d.height-h)/2);
        setLayout(null);

        graphPanel = new JPanel();
        graphPanel.setSize(w-16, h * 3 / 4);
        graphPanel.setLocation(0, 0);
        graphPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        getContentPane().add(graphPanel);

        filePanel = new JPanel();
        filePanel.setSize(w, h*1/4);
        filePanel.setLocation(0, h*3/4);
        filePanel.setBackground(Color.green);
        getContentPane().add(filePanel);

        getContentPane().setBackground(Color.GRAY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
    public static void main(String[] arg){
        new MainFrame("Flow Free", 800, 650);
    }
}
