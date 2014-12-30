package com.mygdx.conquerors.maps.grid.squareGrid;

import com.mygdx.conquerors.maps.grid.Cell;
import com.mygdx.conquerors.maps.grid.TerrainGrid;
import com.mygdx.conquerors.maps.grid.cell.TerrainCell;
import com.mygdx.conquerors.maps.tiles.Tiles;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Lucas on 12/5/2014.
 */
public class SquareTerrainGrid extends TerrainGrid {

    private TerrainCell[][] grid;

    public SquareTerrainGrid(int width, int height) {
        super(width, height);

        grid = new TerrainCell[width][height];
        for(int w = 0; w < width; w++) {
            for(int h = 0; h < height; h++) {
                grid[w][h] = new TerrainCell(w, h, Tiles.TERRAIN_GRASS);
                addActor(grid[w][h]);
            }
        }
    }

    @Override
    public int getWeight(int startX, int startY, int endX, int endY) {
        TerrainCell start = grid[startX][startY];
        TerrainCell end   = grid[endX][endY];
        int dx = end.x() - start.x();
        int dy = end.y() - start.y();

        if(dx > 1 || dx < -1)
            return 0;

        if(dy > 1 || dy < -1)
            return 0;

        if(dx == 0 || dy == 0)
            return CARDINAL_WEIGHT + start.getWeight();

        return DIAGONAL_WEIGHT + start.getWeight();
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
        if(x - 1 > 0)
            neighbors.add(grid[x - 1][y]);
        if(x + 1 < width)
            neighbors.add(grid[x + 1][y]);
        if(y - 1 > 0)
            neighbors.add(grid[x][y - 1]);
        if(y + 1 < height)
            neighbors.add(grid[x][y + 1]);

        if(x - 1 > 0 && y - 1 > 0)
            neighbors.add(grid[x - 1][y - 1]);
        if(x - 1 > 0 && y + 1 < height)
            neighbors.add(grid[x - 1][y + 1]);
        if(x + 1 < width && y - 1 > 0)
            neighbors.add(grid[x + 1][y - 1]);
        if(x + 1 < width && y + 1 < height)
            neighbors.add(grid[x + 1][y + 1]);

        return neighbors;
    }
}
