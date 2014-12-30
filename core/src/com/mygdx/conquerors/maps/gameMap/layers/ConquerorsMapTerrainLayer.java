package com.mygdx.conquerors.maps.gameMap.layers;

import com.mygdx.conquerors.maps.grid.squareGrid.SquareTerrainGrid;
import com.mygdx.conquerors.maps.layers.grid.TerrainLayer;

/**
 * Created by Lucas on 12/3/2014.
 */
public class ConquerorsMapTerrainLayer extends TerrainLayer {

    public ConquerorsMapTerrainLayer(int width, int height) {
        super("terrainLayer", width, height, new SquareTerrainGrid(width, height));
    }
}
