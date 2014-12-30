package com.mygdx.conquerors.display.layers;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.conquerors.MyGdxGame;

/**
 * Created by Lucas on 12/2/2014.
 */
public abstract class UI extends Layer {

    public UI(MyGdxGame ref, Skin skin) {
        super(ref, skin);

        stage = new Stage(new ScreenViewport(), game.batch);
    }

}
