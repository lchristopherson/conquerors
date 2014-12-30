package com.mygdx.conquerors;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.conquerors.display.screens.mainMenuScreen.MainMenuScreen;
import com.mygdx.conquerors.maps.objects.MapObjects;
import com.mygdx.conquerors.maps.tiles.Tiles;

public class MyGdxGame extends Game {

	public SpriteBatch batch;
    public BitmapFont font;
    public Skin skin;
    public int width;
    public int height;

    public InputMultiplexer multiplexer;

	@Override
	public void create () {
		batch = new SpriteBatch();
        font = new BitmapFont();
        skin = new Skin(Gdx.files.internal("data/ui/uiskin.json"));

        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();

        multiplexer = new InputMultiplexer();
        Gdx.input.setInputProcessor(multiplexer);


        //ObjectPacker.packObjects();

        Tiles.initialize();
        MapObjects.initialize();

        setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
        super.render();
	}

    @Override
    public void resize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
        skin.dispose();
    }
}
