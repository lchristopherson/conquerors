package com.mygdx.conquerors.maps;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.conquerors.maps.pathfinding.Pathable;

import java.util.Collection;

/**
 * Created by Lucas on 12/3/2014.
 */
public abstract class Map extends Group implements Pathable {

    protected MapLayers layers;
    protected final int width;
    protected final int height;

    public Map() {
        this(64, 64);
    }

    public Map(int width, int height) {
        this.layers = new MapLayers();
        this.width  = width;
        this.height = height;
    }

    public void addLayer(MapLayer layer) {
        layers.addLayer(layer);
        layer.setZIndex(layers.numLayers());
        addActor(layer);
    }

    protected MapLayer getLayer(int layer) {
        return layers.getLayer(layer);
    }

    public Collection<MapLayer> getLayers() {
        return layers.getLayers();
    }

    /**
     * Returns the width of the map
     * @return width of map
     */
    public int width() {
        return width;
    }

    /**
     * Returns the height of the map
     * @return height of map
     */
    public int height() {
        return height;
    }

}
