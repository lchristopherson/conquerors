package com.mygdx.conquerors.display.screens.aboutScreen;

import com.mygdx.conquerors.MyGdxGame;
import com.mygdx.conquerors.display.screens.GameScreen;

/**
 * Created by Lucas on 12/2/2014.
 */
public class AboutScreen extends GameScreen {

    public AboutScreen(MyGdxGame ref) {
        super(ref);

        addLayer(new AboutUI(game, game.skin));
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
