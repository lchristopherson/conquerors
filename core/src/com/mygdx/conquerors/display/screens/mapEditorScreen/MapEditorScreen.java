package com.mygdx.conquerors.display.screens.mapEditorScreen;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.mygdx.conquerors.MyGdxGame;
import com.mygdx.conquerors.display.screens.GameScreen;
import com.mygdx.conquerors.tools.mapEditor.MapEditor;

/**
 * Created by Lucas on 12/3/2014.
 */
public class MapEditorScreen extends GameScreen {

    MapEditor mapEditor;

    public MapEditorScreen(MyGdxGame ref) {
        super(ref);

        mapEditor = new MapEditor(64, 64);

        addLayer(new MapEditorScene(game, game.skin, mapEditor));
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
