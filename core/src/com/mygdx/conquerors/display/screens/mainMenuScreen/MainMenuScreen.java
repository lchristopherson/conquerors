package com.mygdx.conquerors.display.screens.mainMenuScreen;

import com.mygdx.conquerors.MyGdxGame;
import com.mygdx.conquerors.display.screens.GameScreen;

/**
 * Created by Lucas on 12/2/2014.
 */
public class MainMenuScreen extends GameScreen {

    public MainMenuScreen(MyGdxGame ref) {
        super(ref);

        addLayer(new MainMenuUI(game, game.skin));
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

}
