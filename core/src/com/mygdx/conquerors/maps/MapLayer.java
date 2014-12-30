package com.mygdx.conquerors.maps;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;

/**
 * Created by Lucas on 12/3/2014.
 */
public class MapLayer extends Group {

    private static int counter = 0;

    protected String name;
    protected boolean visible;
    protected int width;
    protected int height;
    protected float opacity;

    public MapLayer(int width, int height) {
        this("Layer_" + counter++, width, height);
    }

    public MapLayer(String name, int width , int height) {
        this(name, width, height, true);
    }

    public MapLayer(String name, int width, int height, boolean visible) {
        this(name, width, height, visible, 1f);
    }

    public MapLayer(String name, int width, int height, boolean visible, float opacity) {
        this.name    = name;
        this.width   = width;
        this.height  = height;
        this.visible = visible;
        this.opacity = opacity;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public float getOpacity() {
        return opacity;
    }

    @Override
    public void draw(Batch batch, float alpha) {
        if(!visible)
            return;

        super.draw(batch, alpha);
    }
}
