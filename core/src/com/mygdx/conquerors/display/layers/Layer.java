package com.mygdx.conquerors.display.layers;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.conquerors.MyGdxGame;

/**
 * Created by Lucas on 12/2/2014.
 */
public abstract class Layer implements Disposable {

    protected MyGdxGame game;
    protected Stage stage; // instantiate in subclasses
    protected Skin skin;

    public Layer(MyGdxGame game, Skin skin) {
        this.game  = game;
        this.skin  = skin;
    }

    public void registerInput(int index) {
        game.multiplexer.addProcessor(index, stage);
    }

    public void unregisterInput() {
        game.multiplexer.removeProcessor(stage);
    }

    public void render(float delta) {
        stage.act(delta);
        stage.draw();
    }

    public void resize(int width, int height) {
        //stage.getViewport().update(width, height, true);
    }

    @Override
    public void dispose() {
        unregisterInput();
        stage.dispose();
    }
}
