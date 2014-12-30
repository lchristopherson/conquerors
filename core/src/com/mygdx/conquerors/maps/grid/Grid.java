package com.mygdx.conquerors.maps.grid;

import com.badlogic.gdx.scenes.scene2d.Group;

import java.util.Collection;

/**
 * Created by Lucas on 12/5/2014.
 */
public abstract class Grid extends Group {

    protected int width;
    protected int height;

    public Grid(int width, int height) {
        this.width  = width;
        this.height = height;
    }

    public abstract Cell getCell(int x, int y);

    public abstract Collection<Cell> getNeighbors(Cell cell);

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }
}
