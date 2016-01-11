package com.ertanunver.libgdx.yummy.framework;

import com.badlogic.gdx.assets.AssetManager;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * Created by ertanunver on 10/01/16.
 */
public class YMAssetManager {

    static YMAssetManager instance;

    private JsonObject config;
    private AssetManager assetManager;

    YMAssetManager(JsonObject config) {
        try {
            this.config = config.get("asset_manager").getAsJsonObject();
            assetManager = new AssetManager();
        } catch (NullPointerException e) {
            throw new YMConfigException("asset_manager config has not been set.");
        }
    }

    public static YMAssetManager getInstance() {
        if (instance != null) {
            return instance;
        }
        throw new NullPointerException("The instance of YMAssetManager has not been initialized.");
    }

    public void create() {
        try {
            JsonArray assets = config.get("assets").getAsJsonArray();
            for (int i = 0; i < assets.size(); i++) {
                JsonObject asset = assets.get(i).getAsJsonObject();
                String assetClassType = asset.get("type").getAsString();
                JsonArray paths = asset.get("paths").getAsJsonArray();
                for (int j = 0; j < paths.size(); j++) {
                    String path = paths.get(j).getAsString();
                    assetManager.load(path, Class.forName(assetClassType));
                }
            }
        } catch (NullPointerException e) {
            throw new YMConfigException("assets array has not been set.");
        } catch (ClassNotFoundException e) {
            throw new YMConfigException("asset class type has not been found");
        }
    }

    public void dispose() {
        assetManager.dispose();
    }

    public boolean update() {
        return assetManager.update();
    }

}
