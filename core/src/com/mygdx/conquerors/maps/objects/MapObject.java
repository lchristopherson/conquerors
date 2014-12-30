package com.mygdx.conquerors.maps.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.conquerors.maps.tiles.Tile;

import static com.badlogic.gdx.graphics.g2d.Batch.*;
import static com.badlogic.gdx.graphics.g2d.Batch.V4;

/**
 * Created by Lucas on 12/4/2014.
 */
public class MapObject extends Actor {

    public static float[] vertices = new float[20];

    private CollisionBox collisionBox;
    private TextureRegion textureRegion;
    private int width;
    private int height;

    public MapObject(int width, int height) {

    }

    public MapObject(int width, int height, CollisionBox collisionBox) {

    }

    public MapObject(int width, int height, CollisionBox collisionBox, TextureRegion textureRegion) {
        this.width = width;
        this.height = height;
        setWidth(width);
        setHeight(height);
        setScale(Tile.WIDTH);
        this.collisionBox = collisionBox;
        this.textureRegion = textureRegion;
    }

    public MapObject(MapObject other) {
        this(other.width, other.height, other.collisionBox, other.textureRegion);
    }

    public MapObject copy() {
        return new MapObject(this);
    }

    public String toString() {
        return "MapObject";
    }

    public void draw(Batch batch, float alpha) {

        final Color batchColor = batch.getColor();
        final float color = Color.toFloatBits(batchColor.r, batchColor.g, batchColor.b, batchColor.a);

        float xMin = getX();
        float xMax = xMin + Tile.WIDTH * getWidth();
        float yMin = getY();
        float yMax = yMin + Tile.WIDTH * getHeight();

        float u1 = textureRegion.getU();
        float u2 = textureRegion.getU2();
        float v1 = textureRegion.getV();
        float v2 = textureRegion.getV2();

        vertices[X1] = xMin;
        vertices[Y1] = yMin;
        vertices[C1] = color;
        vertices[U1] = u1;
        vertices[V1] = v2;

        vertices[X2] = xMin;
        vertices[Y2] = yMax;
        vertices[C2] = color;
        vertices[U2] = u1;
        vertices[V2] = v1;

        vertices[X3] = xMax;
        vertices[Y3] = yMax;
        vertices[C3] = color;
        vertices[U3] = u2;
        vertices[V3] = v1;

        vertices[X4] = xMax;
        vertices[Y4] = yMin;
        vertices[C4] = color;
        vertices[U4] = u2;
        vertices[V4] = v2;

        batch.draw(textureRegion.getTexture(), vertices, 0, 20);
    }

    @Override
    public Actor hit(float x, float y, boolean touchable) {
        if(!(x >= 0 && x < getWidth() && y >= 0 && y < getHeight()))
            return null;
        return collisionBox.collidesWith(x, y) ? this : null;
    }
}
