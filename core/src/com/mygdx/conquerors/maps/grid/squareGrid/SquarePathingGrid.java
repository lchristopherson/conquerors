package com.mygdx.conquerors.maps.grid.squareGrid;

import com.mygdx.conquerors.maps.grid.Cell;
import com.mygdx.conquerors.maps.grid.PathingGrid;
import com.mygdx.conquerors.maps.grid.cell.PathingCell;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Lucas on 12/5/2014.
 */
public class SquarePathingGrid extends PathingGrid {

    protected PathingCell[][] grid;

    public SquarePathingGrid(int width, int height) {
        super(width, height);

        grid = new PathingCell[width][height];
        for(int w = 0; w < width; w++) {
            for(int h = 0; h < height; h++) {
                grid[w][h] = new PathingCell(w, h);
                addActor(grid[w][h]);
            }
        }
    }

    @Override
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

        if(x - 1 > 0 && grid[x - 1][y].walkable())
            neighbors.add(grid[x - 1][y]);
        if(x + 1 < width && grid[x + 1][y].walkable())
            neighbors.add(grid[x + 1][y]);
        if(y - 1 > 0 && grid[x][y - 1].walkable())
            neighbors.add(grid[x][y - 1]);
        if(y + 1 < height && grid[x][y + 1].walkable())
            neighbors.add(grid[x][y + 1]);

        if(x - 1 > 0 && y - 1 > 0 && grid[x - 1][y - 1].walkable())
            neighbors.add(grid[x - 1][y - 1]);
        if(x - 1 > 0 && y + 1 < height && grid[x - 1][y + 1].walkable())
            neighbors.add(grid[x - 1][y + 1]);
        if(x + 1 < width && y - 1 > 0 && grid[x + 1][y - 1].walkable())
            neighbors.add(grid[x + 1][y - 1]);
        if(x + 1 < width && y + 1 < height && grid[x + 1][y + 1].walkable())
            neighbors.add(grid[x + 1][y + 1]);

        return neighbors;
    }
}
