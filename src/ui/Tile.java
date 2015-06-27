package ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Dani on 6/27/2015.
 */
public class Tile extends JButton
{
    int value;
    public Tile(int value)
    {
        this.value = value;
        setSize(50, 50);
        setEnabled(false);
    }




    public void setValue(int val)
    {
        value = val;
    }
    public int getValue()
    {
        return value;
    }
}
