package com.ertanunver.libgdx.yummy.framework;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.google.gson.JsonObject;

/**
 * Created by ertanunver on 10/01/16.
 */
public class YMStage extends Stage {

    private JsonObject data;

    public YMStage(Viewport viewport) {
        super(viewport);
        data = new JsonObject();
    }

    public JsonObject getDataFromParent() throws IllegalStateException {
        try {
            return data.get("Parent").getAsJsonObject();
        } catch (Exception e) {
            return null;
        }
    }

    public void setDataFromParent(JsonObject jsonObject) {
        data.add("Parent", jsonObject);
    }

    public JsonObject getDataFromChild() {
        try {
            return data.get("Child").getAsJsonObject();
        } catch (Exception e) {
            return null;
        }
    }

    public void setDataFromChild(JsonObject jsonObject) {
        data.add("Child", jsonObject);
    }

    public void create() {

    }

    public void dispose() {

    }

    public void show() {
        Gdx.input.setInputProcessor(this);
    }

    public void hide() {

    }

    public void pause() {

    }

    public void resume() {

    }

    public void resize(int width, int height) {

    }

    public void render() {
        act(Gdx.graphics.getDeltaTime());
        draw();
    }

}
