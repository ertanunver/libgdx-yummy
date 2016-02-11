package com.ertanunver.libgdx.yummy.framework;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Created by ertanunver on 10/01/16.
 */
public class YMGame implements ApplicationListener {

    private JsonObject config;

    private YMAssetManager assetManager;
    private YMWebServiceManager webServiceManager;
    private YMClientManager clientManager;
    private YMSkinManager skinManager;
    private YMStageManager stageManager;

    private JsonObject loadConfig() {
        try {
            JsonObject jsonObject = new Gson().fromJson(Gdx.files.internal("config.json").readString("UTF-8"), JsonObject.class);
            return jsonObject;
        } catch (GdxRuntimeException e) {
            throw new YMConfigException("config.json file has not been found.");
        } catch (Exception e) {
            throw new YMConfigException("config.json file has syntax error.");
        }
    }

    @Override
    public void create() {
        config = loadConfig();
        assetManager = new YMAssetManager(config);
        assetManager.create();
        webServiceManager = new YMWebServiceManager(config);
        webServiceManager.create();
        clientManager = new YMClientManager(config);
        clientManager.create();
        skinManager = new YMSkinManager(config);
        skinManager.create();
        stageManager = new YMStageManager(config);
        stageManager.create();

    }

    @Override
    public void dispose() {
        stageManager.dispose();
        skinManager.dispose();
        clientManager.dispose();
        webServiceManager.dispose();
        assetManager.dispose();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void resize(int width, int height) {
        try {
            YMStageManager.getInstance().resize();
        } catch (Exception e) { }
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        YMStageManager.getInstance().render();
    }

}
