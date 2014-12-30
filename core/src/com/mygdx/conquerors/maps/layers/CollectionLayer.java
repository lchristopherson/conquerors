package com.mygdx.conquerors.maps.layers;

import com.mygdx.conquerors.maps.MapLayer;
import com.mygdx.conquerors.maps.objects.MapObject;
import com.mygdx.conquerors.maps.tiles.Tile;
import com.mygdx.conquerors.utils.GridMap;

/**
 * Created by Lucas on 12/3/2014.
 */
public abstract class CollectionLayer extends MapLayer {

    GridMap<MapObject> mapObjects;

    public CollectionLayer(String name, int width, int height) {
        super(name, width, height);

        this.mapObjects = new GridMap<MapObject>(width, height);
    }

    /**
     * Adds an object to the layer at the given coordinates
     * @param x x coordinate
     * @param y y coordinate
     * @param object <code>GameObject<code/> to be added
     */
    public void addObject(int x, int y, MapObject object) {
        mapObjects.put(x, y, object);
        //object.setZIndex(x + width * y);
        object.setX(x * Tile.WIDTH);
        object.setY(y * Tile.WIDTH);
        addActor(object);
    }

    /**
     * Removes an object from the layer at the given coordinates
     * @param x x coordinate
     * @param y y coordinate
     * @return <code>GameObject</code> that has been removed, or <code>null</code> if
     * no object exists at the given coordinates
     */
    public MapObject removeObject(int x, int y) {
        MapObject object = mapObjects.remove(x, y);
        removeActor(object);
        return object;
    }

}
