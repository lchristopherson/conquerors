package com.mygdx.conquerors.maps.layers.grid;

import com.mygdx.conquerors.maps.grid.Grid;
import com.mygdx.conquerors.maps.layers.GridLayer;

/**
 * Created by Lucas on 12/3/2014.
 */
public class PathingLayer extends GridLayer {

    public PathingLayer(String name, int width, int height, Grid grid) {
        super(name, width, height, grid);

        visible = false;
    }
}
