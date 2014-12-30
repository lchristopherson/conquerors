package com.mygdx.conquerors.utils;

import java.util.TreeMap;

/**
 *
 * This class represents a set of objects on a grid. The objects are
 * maintained in ascending order based on their x, y coordinates.
 *
 */
public class GridMap<T> extends TreeMap<Integer, T>{

    private final int width;
    private final int height;

    /**
     * Creates a <code>GridMap</code> with a given width and height
     * @param width width of the grid
     * @param height height of the grid
     */
    public GridMap(int width, int height) {
        super();
        this.width    = width;
        this.height   = height;
    }

    /**
     * Inserts an element into the grid array
     * @param x
     * @param y
     * @param object
     */
    public void put(int x, int y, T object) {
        checkRange(x, y);

        super.put(key(x, y), object);
    }

    /**
     * Returns an element given x and y values
     * @param x x coordinate
     * @param y y coordinate
     * @return The value at the given coordinates, or <code>null</code> if none exists
     */
    public T get(int x, int y) {
        checkRange(x, y);

        return super.get(key(x, y));
    }

    /**
     * Removes a key from the map and returns that key. Returns <code>null</code>
     * if no value exists for the given coordinates
     * @param x x coordinate
     * @param y y coordinate
     * @return value at the given coordinates or <code>null</code> if no value exists for
     * the given coordinates
     */
    public T remove(int x, int y) {
        checkRange(x, y);

        return super.remove(key(x, y));
    }

    /**
     * Calculates a key for a given x, y pair
     * @param x x coordinate
     * @param y y coordinate
     * @return the calculated key
     */
    private int key(int x, int y) {
        checkRange(x, y);

        return x + y * width;
    }

    /**
     * Checks if coordinates are in the grid
     * @param x
     * @param y
     * @throws <code>IndexOutOfBoundsException<code/> if coordinates are out of the grid
     */
    private void checkRange(int x, int y) {
        if(x >= width || y >= height)
            throw new IndexOutOfBoundsException();
        if(x < 0 || y < 0)
            throw new IndexOutOfBoundsException();
    }
}
