package com.mygdx.conquerors.display.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.conquerors.MyGdxGame;
import com.mygdx.conquerors.display.layers.Layer;

import java.util.ArrayList;

/**
 * Created by Lucas on 12/2/2014.
 */
public abstract class GameScreen implements Screen {

    protected final MyGdxGame game;
    private ArrayList<Layer> layers;

    public GameScreen(MyGdxGame ref) {
        game   = ref;
        layers = new ArrayList<Layer>();
    }

    public void addLayer(Layer layer) {
        layer.registerInput(0);
        layers.add(layer);
    }

    /**
     * Adds a <code>Layer</code> at a given index, 0 being the lowest layer.
     * @param layer to be added
     * @param index
     */
    public void addLayer(Layer layer, int index) {
        layer.registerInput(layers.size() - index);
        layers.add(index, layer);
    }

    public void removeLayer(Layer layer) {
        if(!layers.remove(layer))
            return;

        layer.unregisterInput();
    }

    public void removeLayer(int index) {
        if(index >= layers.size())
            return;

        layers.remove(index).unregisterInput();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //game.batch.begin();

        for(Layer layer : layers)
            layer.render(delta);

        //game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
        for(Layer layer : layers)
            layer.resize(width, height);
    }

    @Override
    public abstract void show();

    @Override
    public abstract void hide();

    @Override
    public abstract void pause();

    @Override
    public abstract void resume();

    @Override
    public void dispose() {
        for(Layer layer : layers)
            layer.dispose();
    }
}
