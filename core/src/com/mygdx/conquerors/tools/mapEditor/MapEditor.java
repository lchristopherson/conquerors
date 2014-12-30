package com.mygdx.conquerors.tools.mapEditor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.conquerors.maps.gameMap.ConquerorsMap;
import com.mygdx.conquerors.maps.grid.Cell;
import com.mygdx.conquerors.maps.layers.GridOverlayLayer;
import com.mygdx.conquerors.maps.objects.MapObject;

/**
 * Created by Lucas on 12/3/2014.
 */
public class MapEditor extends Group {

    private static final float PAN_RATE = 1.5f;

    private ConquerorsMap map;
    private GridOverlayLayer gridOverlay;

    public MapEditor(int width, int height) {
        map = new ConquerorsMap(width, height);

        gridOverlay = new GridOverlayLayer(width, height);
        map.addLayer(gridOverlay);

        addActor(map);

        addListener(new InputListener() {
            float dragX;
            float dragY;
            Vector3 position;
            float minWidth = 3 * Gdx.graphics.getWidth() / 2;
            float minHeight = 3 * Gdx.graphics.getHeight() / 2;
            //float maxWidth =

            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                dragX = x;
                dragY = y;
                return true;
            }

            @Override
            public void touchDragged (InputEvent event, float x, float y, int pointer) {
                float dX = (dragX-x) * PAN_RATE;
                float dY = (dragY-y) * PAN_RATE;

                position = event.getStage().getCamera().position;
                if(position.x + dX < minWidth) {
                    position.x = minWidth;
                    dX = 0;
                }
                //if(position.x + dX > )
                if(position.y + dY < minHeight) {
                    position.y = minHeight;
                    dY = 0;
                }
                event.getStage().getCamera().position.add(dX, dY, 0f);
                event.getStage().getCamera().update();

                //System.out.println(event.getStage().getCamera().position);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                Actor actor = event.getTarget();
                if (actor instanceof Cell)
                    mapCellClicked((Cell) actor);
                else if (actor instanceof MapObject) {
                    mapObjectClicked((MapObject) actor);
                    gridOverlay.setVisible(!gridOverlay.isVisible());
                }
            }
        });

    }

    public ConquerorsMap getMap() {
        return map;
    }

    public void mapObjectClicked(MapObject object) {
        System.out.println(object);
    }

    public void mapCellClicked(Cell cell) {
        System.out.println(cell);
    }

}
