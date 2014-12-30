package com.mygdx.conquerors.maps.layers;

import com.mygdx.conquerors.maps.grid.Grid;
import com.mygdx.conquerors.maps.MapLayer;

/**
 * Created by Lucas on 12/3/2014.
 */
public abstract class GridLayer extends MapLayer {

    Grid grid;

    public GridLayer(String name, int width, int height, Grid grid) {
        super(name, width, height);

        this.grid = grid;
        addActor(grid);
    }

    public Grid getGrid() {
        return grid;
    }

}
