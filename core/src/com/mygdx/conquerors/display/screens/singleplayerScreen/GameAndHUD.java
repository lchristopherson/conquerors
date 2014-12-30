package com.mygdx.conquerors.display.screens.singleplayerScreen;

import com.mygdx.conquerors.MyGdxGame;
import com.mygdx.conquerors.display.hud.HUDTest;
import com.mygdx.conquerors.display.screens.GameScreen;

/**
 * Created by Lucas on 12/2/2014.
 */
public class GameAndHUD extends GameScreen {

    public GameAndHUD(MyGdxGame ref) {
        super(ref);

        //addLayer(new SceneMap(game, game.skin));
        addLayer(new HUDTest(game, game.skin));
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
