package com.ertanunver.libgdx.yummy.framework;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * Created by ertanunver on 11/01/16.
 */
public class YMTestStage extends YMStage {

    protected Skin skin;

    protected Table vTable;
    protected TextButton vBack;
    protected Label vMessage;

    private boolean back;
    private String message;

    public YMTestStage() {
        this("Test Stage", true);
    }

    public YMTestStage(String message, boolean back) {
        super(new ScreenViewport());
        this.message = message;
        this.back = back;
    }

    @Override
    public void create() {
        // skin
        skin = YMSkinManager.getInstance().getSkin();
        // table
        vTable = new Table(skin);
        vTable.setFillParent(true);
        vTable.align(Align.topLeft);;
        addActor(vTable);
        // widgets
        if (back) {
            vTable.row().expandX().align(Align.left);
            vBack = new TextButton("Back", skin);
            vBack.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    YMStageManager.getInstance().popStage();
                }
            });
            vTable.add(vBack);
        }
        if (message != null) {
            vTable.row().expand().align(Align.center);
            vMessage = new Label(message, skin);
            vTable.add(vMessage);
        }
    }

}
