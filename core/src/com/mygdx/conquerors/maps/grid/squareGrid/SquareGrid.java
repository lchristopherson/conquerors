package com.mygdx.conquerors.maps.grid.squareGrid;

import com.mygdx.conquerors.maps.grid.Cell;
import com.mygdx.conquerors.maps.grid.Grid;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Lucas on 12/5/2014.
 */
public abstract class SquareGrid extends Grid {

    //private Cell[][] grid;

    public SquareGrid(int width, int height) {
        super(width, height);

        //grid = new Cell[width][height];
    }

    /*
    public Cell getCell(int x, int y) {
        if(x < 0 || y < 0)
            return null;

        if(x >= width || y >= height)
            return null;

        return grid[x][y];
    }

    @Override
    public Collection<Cell> getNeighbors(Cell cell) {
        int x = cell.x();
        int y = cell.y();
        Collection<Cell> neighbors = new HashSet<Cell>();
        if(x - 1 > 0)
            neighbors.add(grid[x - 1][y]);
        if(x + 1 < width)
            neighbors.add(grid[x + 1][y]);
        if(y - 1 > 0)
            neighbors.add(grid[x][y - 1]);
        if(y + 1 < height)
            neighbors.add(grid[x][y + 1]);

        return neighbors;
    }
    */
}
