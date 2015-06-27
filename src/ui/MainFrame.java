package ui;

import javax.swing.*;
import java.awt.*;

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
        new MainFrame("Flow Free", 800, 650);
    }
}
