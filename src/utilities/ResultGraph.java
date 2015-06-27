package utilities;

/**
 * Created by Dani on 6/27/2015.
 */
public class ResultGraph
{
    private int min;
    private int[][] graph;
    private int[] moves;

    public void setMin(int min)
    {
        this.min = min;
    }

    public int getMin()
    {

        return min;
    }

    public int[][] getGraph()
    {
        return graph;
    }

    public int[] getMoves()
    {
        return moves;
    }

    public ResultGraph(int graphXSize, int graphYSize, int pairSize)
    {
        this.min = Integer.MAX_VALUE;
        this.graph = new int[graphXSize][graphYSize];
        moves = new int[pairSize];

    }
}
