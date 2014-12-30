package com.mygdx.conquerors.maps.pathfinding.algorithms;

import com.mygdx.conquerors.maps.grid.Cell;
import com.mygdx.conquerors.maps.pathfinding.Pathable;
import com.mygdx.conquerors.maps.pathfinding.Pathfinder;

import java.util.Collection;

/**
 * Created by Lucas on 12/7/2014.
 */
public class AStar extends Pathfinder {

    public AStar(Pathable pathable) {
        super(pathable);
    }

    @Override
    public Collection<Cell> findPath(int startX, int startY, int endX, int endY) {
        return null;
    }
}
