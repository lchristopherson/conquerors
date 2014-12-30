package com.mygdx.conquerors.maps.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.JsonReader;
import com.mygdx.conquerors.maps.tiles.Tiles;

import java.util.HashMap;

/**
 * Created by Lucas on 12/9/2014.
 */
public class MapObjects {

    private static HashMap<Integer, MapObject> objectMap;

    public static int OBJECT_TREE = 0;

    public static void initialize() {
        objectMap = new HashMap<Integer, MapObject>();

        loadObjects();
    }

    private static void loadObjects() {
        //JsonReader reader =

        Texture treeTexture = new Texture(Gdx.files.internal("data/img/tree.png"));
        TextureRegion treeRegion = new TextureRegion(treeTexture);
        int[][] treeCollision = new int[][] {{0, Tiles.PATHING_NON_WALKABLE}, {0, 0}};
        CollisionBox treeCollisionBox = new CollisionBox(treeCollision);
        MapObject treeObject = new MapObject(2, 2, treeCollisionBox, treeRegion);

        objectMap.put(OBJECT_TREE, treeObject);
    }

    public static MapObject getMapObject(int id) {
        return objectMap.get(id).copy();
    }
}
