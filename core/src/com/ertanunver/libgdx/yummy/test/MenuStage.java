package com.ertanunver.libgdx.yummy.test;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.ertanunver.libgdx.yummy.framework.YMSkinManager;
import com.ertanunver.libgdx.yummy.framework.YMStage;
import com.ertanunver.libgdx.yummy.framework.YMStageManager;
import com.ertanunver.libgdx.yummy.test.clientmanager.ClientManagerTestStage;
import com.ertanunver.libgdx.yummy.test.skinmanager.SkinManagerTestStage;
import com.ertanunver.libgdx.yummy.test.stagemanager.StageManagerTestStage;
import com.ertanunver.libgdx.yummy.test.webservicemanager.WebServiceManagerTestStage;

/**
 * Created by ertanunver on 14/01/16.
 */
public class MenuStage extends YMStage {

    private Skin skin;

    private Table vTable;
    private TextButton vClientManager;
    private TextButton vSkinManager;
    private TextButton vStageManager;
    private TextButton vWebServiceManager;

    public MenuStage() {
        super(new ScreenViewport());
    }

    @Override
    public void create() {
        // skin
        skin = YMSkinManager.getInstance().getSkin();
        // views
        // table
        vTable = new Table(skin);
        vTable.setFillParent(true);
//        vTable.setDebug(true, true);
        addActor(vTable);
        // buttons
        vTable.row();
        vClientManager = new TextButton("Client Manager", skin);
        vTable.add(vClientManager).pad(10, 0, 10, 0).size(200, 40).align(Align.center);
        vTable.row();
        vSkinManager = new TextButton("Skin Manager", skin);
        vTable.add(vSkinManager).pad(10, 0, 10, 0).size(200, 40).align(Align.center);
        vTable.row();
        vStageManager = new TextButton("Stage Manager", skin);
        vTable.add(vStageManager).pad(10, 0, 10, 0).size(200, 40).align(Align.center);
        vTable.row();
        vWebServiceManager = new TextButton("Web Service Manager", skin);
        vTable.add(vWebServiceManager).pad(10, 0, 10, 0).size(200, 40).align(Align.center);
        // button click listeners
        vClientManager.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                YMStageManager.getInstance().pushStage(new ClientManagerTestStage());
            }
        });
        vSkinManager.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                YMStageManager.getInstance().pushStage(new SkinManagerTestStage());
            }
        });
        vStageManager.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                YMStageManager.getInstance().pushStage(new StageManagerTestStage());
            }
        });
        vWebServiceManager.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                YMStageManager.getInstance().pushStage(new WebServiceManagerTestStage());
            }
        });
    }


}
