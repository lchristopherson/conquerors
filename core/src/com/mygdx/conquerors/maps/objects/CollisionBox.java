package com.mygdx.conquerors.maps.objects;

import com.mygdx.conquerors.maps.tiles.Tiles;

/**
 * Created by Lucas on 12/9/2014.
 */
public class CollisionBox {

    public int[][] collisionBox;

    public CollisionBox(int width, int height) {
        this(new int[width][height]);
    }

    public CollisionBox(int[][] collisionBox) {
        this.collisionBox = collisionBox;
    }

    public boolean collidesWith(float x, float y) {
        int value = collisionBox[(int)y][(int)x];
        return value == Tiles.PATHING_NON_WALKABLE || value == Tiles.PATHING_INTERACTABLE;
    }
}
