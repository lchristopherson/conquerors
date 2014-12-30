package com.mygdx.conquerors.maps.grid;

import com.mygdx.conquerors.maps.grid.cell.TerrainCell;

/**
 * Created by Lucas on 12/7/2014.
 */
public abstract class TerrainGrid extends Grid {

    public static final int CARDINAL_WEIGHT = 2;
    public static final int DIAGONAL_WEIGHT = 3;

    public TerrainGrid(int width, int height) {
        super(width, height);
    }

    public abstract int getWeight(int startX, int startY, int endX, int endY);
}
