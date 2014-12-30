package com.mygdx.conquerors.maps;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Lucas on 12/3/2014.
 */
public class MapLayers {

    private ArrayList<MapLayer> layers;

    public MapLayers() {
        layers = new ArrayList<MapLayer>();
    }

    public void addLayer(MapLayer layer) {
        layers.add(layer);
    }

    public MapLayer getLayer(int layer) {
        return layers.get(layer);
    }

    public Collection<MapLayer> getLayers() {
        return layers;
    }

    public int numLayers() {
        return layers.size();
    }


}
