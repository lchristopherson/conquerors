package com.mygdx.conquerors.display.screens.mainMenuScreen;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.conquerors.MyGdxGame;
import com.mygdx.conquerors.display.layers.UI;
import com.mygdx.conquerors.display.screens.aboutScreen.AboutScreen;
import com.mygdx.conquerors.display.screens.mapEditorScreen.MapEditorScreen;
import com.mygdx.conquerors.display.screens.singleplayerScreen.GameAndHUD;

/**
 * Created by Lucas on 12/2/2014.
 */
public class MainMenuUI extends UI {

    public MainMenuUI(MyGdxGame ref, Skin skin) {
        super(ref, skin);

        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);

        Label titleLabel                = new Label("Conquerors", skin);
        final Button singleplayerButton = new TextButton("Singleplayer", skin);
        final Button multiplayerButton  = new TextButton("Multiplayer", skin);
        final Button onlineButton       = new TextButton("Online", skin);
        final Button editorButton       = new TextButton("Editor", skin);
        final Button settingsButton     = new TextButton("Settings", skin);
        final Button aboutButton        = new TextButton("About", skin);

        // Singleplayer Button
        singleplayerButton.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new GameAndHUD(game));
                dispose();
            }
        });

        // Multiplayer Button
        multiplayerButton.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Not yet implemented");
            }
        });

        // Online Button
        onlineButton.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Not yet implemented");
            }
        });

        // Editor Button
        editorButton.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new MapEditorScreen(game));
                dispose();
            }
        });

        // Settings Button
        settingsButton.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Not yet implemented");
            }
        });

        // About Button
        aboutButton.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new AboutScreen(game));
                dispose();
            }
        });


        table.add(titleLabel).colspan(2);
        table.row();
        table.add(singleplayerButton);
        table.add(multiplayerButton);
        table.row();
        table.add(onlineButton);
        table.add(editorButton);
        table.row();
        table.add(settingsButton);
        table.add(aboutButton);

        stage.addActor(table);
    }

}
