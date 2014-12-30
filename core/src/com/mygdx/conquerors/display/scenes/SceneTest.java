package com.mygdx.conquerors.display.scenes;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.conquerors.MyGdxGame;
import com.mygdx.conquerors.display.layers.Scene;

/**
 * Created by Lucas on 12/2/2014.
 */
public class SceneTest extends Scene {

    public SceneTest(MyGdxGame ref, Skin skin) {
        super(ref, skin);

        final Button upperLeft = new TextButton("Upper Left", game.skin);
        final Button upperRight = new TextButton("Upper Right", game.skin);

        upperLeft.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("SCENE Left");
            }
        });

        upperRight.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("SCENE Right");
            }
        });

        Table table = new Table();
        table.setFillParent(true);
        table.add(upperLeft).top().left();
        table.add(upperRight).top().right();

        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
