package com.mygdx.conquerors.maps.grid.cell;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.conquerors.maps.grid.Cell;
import com.mygdx.conquerors.maps.tiles.Tile;
import com.mygdx.conquerors.maps.tiles.Tiles;

import static com.badlogic.gdx.graphics.g2d.Batch.*;
import static com.badlogic.gdx.graphics.g2d.Batch.V4;

/**
 * Created by Lucas on 12/5/2014.
 */
public class TerrainCell extends Cell {

    private Tile tile;
    private int weight;

    public TerrainCell(int x, int y, int type) {
        super(x, y);

        tile = Tiles.getTile(type);

        weight = 0;
    }

    public int getWeight() {
        return weight;
    }

    public void draw(Batch batch, float alpha) {

        final Color batchColor = batch.getColor();
        final float color = Color.toFloatBits(batchColor.r, batchColor.g, batchColor.b, batchColor.a * opacity);

        float xMin = getX();
        float xMax = xMin + Tile.WIDTH;
        float yMin = getY();
        float yMax = yMin + Tile.WIDTH;

        TextureRegion region = tile.getTextureRegion();
        float u1 = region.getU();
        float u2 = region.getU2();
        float v1 = region.getV();
        float v2 = region.getV2();

        vertices[X1] = xMin;
        vertices[Y1] = yMin;
        vertices[C1] = color;
        vertices[U1] = u1;
        vertices[V1] = v1;

        vertices[X2] = xMin;
        vertices[Y2] = yMax;
        vertices[C2] = color;
        vertices[U2] = u1;
        vertices[V2] = v2;

        vertices[X3] = xMax;
        vertices[Y3] = yMax;
        vertices[C3] = color;
        vertices[U3] = u2;
        vertices[V3] = v2;

        vertices[X4] = xMax;
        vertices[Y4] = yMin;
        vertices[C4] = color;
        vertices[U4] = u2;
        vertices[V4] = v1;

        batch.draw(region.getTexture(), vertices, 0, 20);
    }
}
