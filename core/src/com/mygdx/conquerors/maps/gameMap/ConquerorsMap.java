package com.mygdx.conquerors.maps.gameMap;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.conquerors.maps.Map;
import com.mygdx.conquerors.maps.MapLayer;
import com.mygdx.conquerors.maps.gameMap.layers.ConquerorsMapObjectLayer;
import com.mygdx.conquerors.maps.gameMap.layers.ConquerorsMapPathingLayer;
import com.mygdx.conquerors.maps.gameMap.layers.ConquerorsMapShadowLayer;
import com.mygdx.conquerors.maps.gameMap.layers.ConquerorsMapTerrainLayer;
import com.mygdx.conquerors.maps.grid.Cell;
import com.mygdx.conquerors.maps.grid.Grid;
import com.mygdx.conquerors.maps.grid.PathingGrid;
import com.mygdx.conquerors.maps.grid.TerrainGrid;
import com.mygdx.conquerors.maps.layers.CollectionLayer;
import com.mygdx.conquerors.maps.layers.GridLayer;
import com.mygdx.conquerors.maps.layers.collection.ObjectLayer;
import com.mygdx.conquerors.maps.objects.MapObjects;
import com.mygdx.conquerors.maps.tiles.Tile;

import static com.badlogic.gdx.graphics.g2d.Batch.*;
import static com.badlogic.gdx.graphics.g2d.Batch.V4;

/**
 * Created by Lucas on 12/3/2014.
 */
public class ConquerorsMap extends Map {

    public static final int TERRAIN_LAYER = 0;
    public static final int PATHING_LAYER = 1;
    public static final int SHADOW_LAYER  = 2;
    public static final int OBJECT_LAYER  = 3;

    public ConquerorsMap(int width, int height) {
        super(width, height);

        addLayer(new ConquerorsMapTerrainLayer(width, height));
        addLayer(new ConquerorsMapPathingLayer(width, height));
        addLayer(new ConquerorsMapShadowLayer(width, height));
        addLayer(new ConquerorsMapObjectLayer(width, height));

        ((ObjectLayer)getLayer(OBJECT_LAYER)).addObject(1, 1, MapObjects.getMapObject(MapObjects.OBJECT_TREE));
        ((ObjectLayer)getLayer(OBJECT_LAYER)).addObject(3, 1, MapObjects.getMapObject(MapObjects.OBJECT_TREE));
        ((ObjectLayer)getLayer(OBJECT_LAYER)).addObject(4, 4, MapObjects.getMapObject(MapObjects.OBJECT_TREE));
        ((ObjectLayer)getLayer(OBJECT_LAYER)).addObject(2, 6, MapObjects.getMapObject(MapObjects.OBJECT_TREE));
    }
    @Override
    public PathingGrid getCollisionGrid() {
        return (PathingGrid)((GridLayer) getLayer(PATHING_LAYER)).getGrid();
    }

    @Override
    public TerrainGrid getWeightedGrid() {
        return (TerrainGrid)((GridLayer) getLayer(TERRAIN_LAYER)).getGrid();
    }
}
