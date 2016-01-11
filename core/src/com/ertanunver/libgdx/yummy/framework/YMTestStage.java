package com.ertanunver.libgdx.yummy.framework;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * Created by ertanunver on 11/01/16.
 */
public class YMTestStage extends YMStage {

    private String message;
    private Label vLabel;

    public YMTestStage(String message) {
        super(new ScreenViewport());
        this.message = message;
    }

    @Override
    public void create() {
        vLabel = new Label(message, YMSkinManager.getInstance().getSkin());
        addActor(vLabel);
    }

}
