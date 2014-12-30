package com.mygdx.conquerors.maps.layers;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.conquerors.maps.MapLayer;
import com.mygdx.conquerors.maps.tiles.Tile;

/**
 * Created by Lucas on 12/10/2014.
 */
public class GridOverlayLayer extends MapLayer {

    ShapeRenderer renderer;

    public GridOverlayLayer(int width, int height) {
        super("Grid_Overlay_Layer", width, height);

        renderer = new ShapeRenderer();
    }

    @Override
    public void draw(Batch batch, float alpha) {
        super.draw(batch, alpha);

        renderer.setProjectionMatrix(getStage().getCamera().combined);

        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.setColor(0, 0, 0, 1);

        for(int x = 0; x < width; x++) {
            renderer.line(x * Tile.WIDTH, 0, x * Tile.WIDTH, height * Tile.WIDTH);
        }
        for(int y = 0; y < height; y++) {
            renderer.line(0, y * Tile.WIDTH, width * Tile.WIDTH, y * Tile.WIDTH);
        }
        renderer.end();
    }
}
