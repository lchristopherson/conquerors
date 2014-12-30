package com.mygdx.conquerors.display.screens.aboutScreen;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.conquerors.MyGdxGame;
import com.mygdx.conquerors.display.layers.UI;

/**
 * Created by Lucas on 12/2/2014.
 */
public class AboutUI extends UI {

    public AboutUI(MyGdxGame ref, Skin skin) {
        super(ref, skin);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        game.batch.begin();
        game.font.draw(game.batch, "Made by Luke Christopherson", game.width / 3, game.height / 2);
        game.batch.end();
    }

}
