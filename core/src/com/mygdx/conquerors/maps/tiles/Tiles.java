package com.mygdx.conquerors.maps.tiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;

/**
 * Created by Lucas on 12/8/2014.
 */
public class Tiles {

    public static final int PATHING_WALKABLE = 2;
    public static final int PATHING_NON_WALKABLE = 2;
    public static final int PATHING_INTERACTABLE = 2;

    public static final int TERRAIN_DIRT = 2;
    public static final int TERRAIN_GRASS = 3;

    public static final int OTHER_EMPTY = 100;

    private static HashMap<Integer, Tile> tileMap;
    private static boolean initialized = false;

    public static void initialize() {
        tileMap = new HashMap<Integer, Tile>();

        Texture dirtTexture = new Texture(Gdx.files.internal("data/img/dirt.jpg"));
        TextureRegion dirtRegion = new TextureRegion(dirtTexture);
        StaticTile dirtTile = new StaticTile(dirtRegion);

        tileMap.put(TERRAIN_DIRT, dirtTile);

        Texture grassTexture = new Texture(Gdx.files.internal("data/img/grass.jpg"));
        TextureRegion grassRegion = new TextureRegion(grassTexture);
        StaticTile grassTile = new StaticTile(grassRegion);

        tileMap.put(TERRAIN_GRASS, grassTile);

        Texture emptyTexture = new Texture(Gdx.files.internal("data/img/empty.png"));
        TextureRegion emptyRegion = new TextureRegion(emptyTexture);
        StaticTile emptyTile = new StaticTile(emptyRegion);

        tileMap.put(OTHER_EMPTY, emptyTile);

        initialized = true;
    }

    public static Tile getTile(int id) {
        return tileMap.get(id);
    }

    public static boolean isInitialized() {
        return initialized;
    }

}
