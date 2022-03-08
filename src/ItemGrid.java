public class ItemGrid
{
    private Item[][] grid;

    /** Constructor */
    public ItemGrid(Item[][] grid)
    {
        this.grid = grid;
    }

    /** Returns true if row is a valid row index and column is a valid
     *  column index and returns false otherwise.
     *  THIS CODE WAS NOT PROVIDED IN FRQ, but here is what you would have seen if it had been
     */
    public boolean isValid(int row, int column)
    {
        if (row < 0 || row >= grid.length)
        {
            return false;
        }
        if (column < 0 || column >= grid[0].length)
        {
            return false;
        }

        return true;
    }

    /** Compares the item in row r and column c to the items to its
     *  left and to its right. Returns the name of the item with
     *  the greatest value, as described in part (a).
     *
     *  Precondition: r and c are valid indices
     */
    public String mostValuableNeighbor(int r, int c)
    {
        int max = grid [r][c].getValue();
        String name = grid [r][c].getName();
        if (isValid(r, c-1) && isValid(r, c+1))
        {
            if (grid [r][c-1].getValue() > max)
            {
                max = grid [r][c-1].getValue();
                name = grid [r][c-1].getName();
            }
            if (grid [r][c+1].getValue() > max)
            {
                max = grid [r][c+1].getValue();
                name = grid [r][c+1].getName();
            }
        }
        else if (isValid(r, c-1))
        {
            if (grid [r][c-1].getValue() > max)
            {
                name = grid [r][c-1].getName();
            }
        }
        else
        {
            if (grid [r][c+1].getValue() > max)
            {
                name = grid [r][c+1].getName();
            }
        }
        return name;
    }

    /** Returns the average value of all the items in grid,
     *  as described in part (b).
     */
    public double findAverage()
    {
        int count = 0;
        double total = 0.0;
        for (Item [] row : grid)
        {
            for (Item item : row)
            {
                total += item.getValue();
                count++;
            }
        }
        return total/count;
    }
}
