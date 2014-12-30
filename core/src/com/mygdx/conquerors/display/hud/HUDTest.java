package com.mygdx.conquerors.display.hud;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.conquerors.MyGdxGame;
import com.mygdx.conquerors.display.layers.HUD;

/**
 * Created by Lucas on 12/2/2014.
 */
public class HUDTest extends HUD {

    public HUDTest(MyGdxGame ref, Skin skin) {
        super(ref, skin);

        final Button bottomLeft = new TextButton("Left", skin);
        final Button bottomRight = new TextButton("Right", skin);

        bottomLeft.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("HUD Left");
            }
        });

        bottomRight.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {System.out.println("HUD Right");
            }
        });

        Table table = new Table();
        table.setFillParent(true);
        table.add(bottomLeft).bottom().left();
        table.add(bottomRight).bottom().right();

        stage.addActor(table);
    }

}
