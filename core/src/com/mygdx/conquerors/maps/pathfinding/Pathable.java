package com.mygdx.conquerors.maps.pathfinding;

import com.mygdx.conquerors.maps.grid.Grid;
import com.mygdx.conquerors.maps.grid.PathingGrid;
import com.mygdx.conquerors.maps.grid.TerrainGrid;

/**
 * Created by Lucas on 12/5/2014.
 */
public interface Pathable {

    public PathingGrid getCollisionGrid();

    public TerrainGrid getWeightedGrid();

}
