package com.mygdx.conquerors.display.layers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.conquerors.MyGdxGame;

/**
 * Created by Lucas on 12/2/2014.
 */
public abstract class Scene extends Layer {

    public Scene(MyGdxGame ref, Skin skin) {
        super(ref, skin);

        stage = new Stage(new ScreenViewport(), game.batch);
    }

}
