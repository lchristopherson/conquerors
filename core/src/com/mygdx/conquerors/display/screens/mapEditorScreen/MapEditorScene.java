package com.mygdx.conquerors.display.screens.mapEditorScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.conquerors.MyGdxGame;
import com.mygdx.conquerors.display.layers.Scene;
import com.mygdx.conquerors.tools.mapEditor.MapEditor;

/**
 * Created by Lucas on 12/8/2014.
 */
public class MapEditorScene extends Scene {

    private static final float ZOOM_RATE = 0.05f;

    MapEditor editor;

    public MapEditorScene(MyGdxGame ref, Skin skin, MapEditor edit) {
        super(ref, skin);

        this.editor = edit;

        stage.addActor(editor);

        ((OrthographicCamera)stage.getCamera()).zoom = 3.0f;
        float x = 3 * Gdx.graphics.getWidth() / 2;
        float y = 3 * Gdx.graphics.getHeight() / 2;

        //System.out.println(x + ", " + y);

        stage.getCamera().position.set(x, y, 0);
        stage.getCamera().update();


        /*
        stage.addListener(new InputListener() {

            @Override
            public boolean scrolled(InputEvent event, float x, float y, int amount) {
                // negative dif means zooming in, positive dif means zooming out
                OrthographicCamera cam = (OrthographicCamera) event.getStage().getCamera();
                cam.zoom += amount * ZOOM_RATE;
                //if (cam.zoom > 3.0f) {
                //    cam.zoom = 3.0f;
                //}
                if (cam.zoom < 0.5f) {
                    cam.zoom = 0.5f;
                }
                cam.update();
                return true;
            }

        });
        */

    }
}
