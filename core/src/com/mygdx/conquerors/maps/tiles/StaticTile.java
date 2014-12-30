package com.mygdx.conquerors.maps.tiles;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Lucas on 12/8/2014.
 */
public class StaticTile extends Tile {

    private TextureRegion region;

    public StaticTile(TextureRegion region) {
        this.region = region;
    }

    public TextureRegion getTextureRegion() {
        return region;
    }

}
