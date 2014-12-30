package com.mygdx.conquerors.maps.gameMap.layers;

import com.mygdx.conquerors.maps.grid.squareGrid.SquarePathingGrid;
import com.mygdx.conquerors.maps.layers.grid.PathingLayer;

/**
 * Created by Lucas on 12/5/2014.
 */
public class ConquerorsMapPathingLayer extends PathingLayer {

    public ConquerorsMapPathingLayer(int width, int height) {
        super("pathingLayer", width, height, new SquarePathingGrid(width, height));
    }
}
