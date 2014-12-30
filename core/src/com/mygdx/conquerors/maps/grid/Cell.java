package com.mygdx.conquerors.maps.grid;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.conquerors.maps.tiles.Tile;


/**
 * Created by Lucas on 12/5/2014.
 */
public abstract class Cell extends Actor {

    public static float[] vertices = new float[20];

    private int x;
    private int y;
    protected float opacity;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.opacity = 1f;

        setX(x * Tile.WIDTH);
        setY(y * Tile.WIDTH);
        setWidth(Tile.WIDTH);
        setHeight(Tile.WIDTH);
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public boolean equals(Object other) {
        if(other == null)
            return false;

        if(!(other instanceof Cell))
            return false;

        Cell otherCell = (Cell)other;

        if(otherCell.x != x)
            return false;

        if(otherCell.y != y)
            return false;

        return true;
    }

    public String toString() {
        return "X: " + x + ", Y: " + y;
    }

    public abstract void draw(Batch batch, float alpha);

    @Override
    public Actor hit(float x, float y, boolean touchable) {
        return x >= 0 && x < getWidth() && y >= 0 && y < getHeight() ? this : null;
    }
}
