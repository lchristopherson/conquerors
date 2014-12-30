package com.mygdx.conquerors.maps.pathfinding;

import com.mygdx.conquerors.maps.grid.Cell;

import java.util.Collection;

/**
 * Created by Lucas on 12/5/2014.
 */
public abstract class Pathfinder {

    protected Pathable pathable;

    public Pathfinder(Pathable pathable) {
        this.pathable = pathable;
    }

    public abstract Collection<Cell> findPath(int startX, int startY, int endX, int endY);
}
