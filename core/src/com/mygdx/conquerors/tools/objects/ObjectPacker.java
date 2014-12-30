package com.mygdx.conquerors.tools.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

/**
 * Created by Lucas on 12/9/2014.
 */
public class ObjectPacker {

    public static void main(String[] args) {
        System.out.println("Packing Objects...");

        packObjects();

        System.out.println("Finished Packing Objects...");
    }

    public static void packObjects() {
        FileHandle file = Gdx.files.internal("data/objects/objlist.json");
        JsonReader json = new JsonReader();
        JsonValue dom = json.parse(file);

        JsonValue objects = dom.child;
        JsonValue obj = objects.child;
        while(obj != null) {
            JsonValue child = obj.child;
            while(child != null) {
                System.out.println(child);
                child = child.next;
            }
            obj = obj.next;
        }

        //System.out.println(objects.name + " " + objects);
        JsonValue prop = objects.child;
        //System.out.println(prop);
        //System.out.println(prop.next());
        //System.out.println(objects.next());

        //for (JsonValue entry = dom.child; entry != null; entry = entry.next)
        //    System.out.println(entry.name + " = " + entry.asString());
    }
}
