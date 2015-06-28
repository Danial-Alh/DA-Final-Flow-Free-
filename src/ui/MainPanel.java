package ui;

import utilities.ResultGraph;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Dani on 6/27/2015.
 */
public class MainPanel extends JPanel
{
    int myOffsetX;
    int myOffsetY;
    Tile[][] tiles;
    //int [][] values;

    public MainPanel(int graphX, int graphY, int w, int h, ResultGraph result)
    {
        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.black));

        myOffsetX = (w-6 - graphX*50) / 2;
        myOffsetY = (h * 3 / 4 - graphY*50) / 2;

        tiles = new Tile[graphX][graphY];
        for(int j=0; j<graphY; j++)
        {
            for(int i=0; i<graphX; i++)
            {
                tiles[i][j] = new Tile(result.getGraph()[i][j]);
                tiles[i][j].setLocation(myOffsetX + i*50, myOffsetY + j*50);
                add(tiles[i][j]);
            }
        }

    }

}
