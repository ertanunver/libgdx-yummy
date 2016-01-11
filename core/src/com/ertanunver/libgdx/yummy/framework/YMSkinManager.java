package com.ertanunver.libgdx.yummy.framework;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * Created by ertanunver on 10/01/16.
 */
public class YMSkinManager {

    static YMSkinManager instance;

    private JsonObject config;
    private Skin skin;

    YMSkinManager(JsonObject config) {
        try {
            this.config = config.get("skin_manager").getAsJsonObject();
        } catch (NullPointerException e) {
            throw new YMConfigException("skin_manager config has not been set.");
        }
    }

    public static YMSkinManager getInstance() {
        if (instance != null) {
            return instance;
        }
        throw new NullPointerException("The instance of YMSkinManager has not been initialized.");
    }

    void create() {
        try {
            JsonArray skins = config.get("skins").getAsJsonArray();
            for (int i = 0; i < 1; i++) {
                skin = new Skin(Gdx.files.internal(skins.get(i).getAsString()));
            }
        } catch (NullPointerException e) {
            throw new YMConfigException("skins array has not been set.");
        }
    }

    void dispose() {
        skin.dispose();
    }

    public Skin getSkin() {
        return skin;
    }

}
