package com.ertanunver.libgdx.yummy.framework;

import com.badlogic.gdx.Gdx;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * Created by ertanunver on 10/01/16.
 */
public class YMStageManager {

    static YMStageManager instance;

    private JsonObject config;
    private ArrayList<YMStage> stages;

    YMStageManager(JsonObject config) {
        try {
            this.config = config.get("stage_manager").getAsJsonObject();
        } catch (NullPointerException e) {
            throw new YMConfigException("stage_manager config has not been set.");
        }
        stages = new ArrayList<YMStage>();
    }

    public static YMStageManager getInstance() {
        if (instance != null) {
            return instance;
        }
        throw new NullPointerException("The instance of YMStageManager has not been initialized.");
    }

    void create() {
        try {
            YMStage startingStage = (YMStage) Class.forName(config.get("starting_stage").getAsString()).newInstance();
            if (startingStage != null) {
                pushStage(startingStage);
            }
        } catch (NullPointerException e ) {
            throw new YMConfigException("starting_stage class has not been set.");
        } catch (Exception e) {
            throw new YMConfigException("starting_stage class type has not been found.");
        }
    }

    void dispose() {
        if (!stages.isEmpty()) {
            getActiveStage().hide();
            while (!stages.isEmpty()) {
                getActiveStage().dispose();
                stages.remove(stages.size() - 1);
            }
        }
    }

    void resume() {
        YMStage activeStage = getActiveStage();
        if (activeStage != null) {
            activeStage.resume();
        }
    }

    void pause() {
        YMStage activeStage = getActiveStage();
        if (activeStage != null) {
            activeStage.pause();
        }
    }

    void resize() {
        YMStage activeStage = getActiveStage();
        if (activeStage != null) {
            activeStage.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        }
    }

    void render() {
        YMStage activeStage = getActiveStage();
        if (activeStage != null) {
            activeStage.render();
        }
    }

    public YMStage getActiveStage() {
        if (!stages.isEmpty()) {
            return stages.get(stages.size() - 1);
        }
        return null;
    }

    public void pushStage(YMStage stage) {
        if (!stages.isEmpty()) {
            getActiveStage().hide();
        }
        stage.create();
        stages.add(stage);
        getActiveStage().show();
        getActiveStage().resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    public void pushStage(YMStage stage, JsonObject jsonObject) {
        stage.setDataFromParent(jsonObject);
        pushStage(stage);
    }

    public void pushStageWithKillingActiveStage(YMStage stage) {
        if (!stages.isEmpty()) {
            getActiveStage().hide();
            getActiveStage().dispose();
            stages.remove(stages.size() - 1);
        }
        stage.create();
        stages.add(stage);
        getActiveStage().show();
        getActiveStage().resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    public void pushStageWithKillingActiveStage(YMStage stage, JsonObject jsonObject) {
        stage.setDataFromParent(jsonObject);
        pushStageWithKillingActiveStage(stage);
    }

    public void popStage() {
        popStage(null);
    }

    public void popStage(JsonObject jsonObject) {
        if (!stages.isEmpty()) {
            getActiveStage().hide();
            getActiveStage().dispose();
            stages.remove(stages.size() - 1);
            if (!stages.isEmpty()) {
                if (jsonObject != null) {
                    getActiveStage().setDataFromChild(jsonObject);
                }
                getActiveStage().show();
                getActiveStage().resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            }
        }
    }

}
