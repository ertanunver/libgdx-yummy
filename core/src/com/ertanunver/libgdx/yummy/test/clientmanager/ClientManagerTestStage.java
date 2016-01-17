package com.ertanunver.libgdx.yummy.test.clientmanager;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.ertanunver.libgdx.yummy.framework.YMAssetManager;
import com.ertanunver.libgdx.yummy.framework.YMTestStage;

/**
 * Created by ertanunver on 17/01/16.
 */
public class ClientManagerTestStage extends YMTestStage {

    private TextField vName;
    private TextButton vSend;

    private Image mario;
    private Image luigi;

    public ClientManagerTestStage() {
        super(null, true);
    }

    @Override
    public void create() {
        super.create();

        mario = new Image(YMAssetManager.getInstance().get("sprites/mario.png", Texture.class));
        mario.setScale(4, 4);
        mario.setPosition(136, 224);
        addActor(mario);
        luigi = new Image(YMAssetManager.getInstance().get("sprites/luigi.png", Texture.class));
        luigi.setScale(4, 4);
        luigi.setPosition(456, 224);
        addActor(luigi);

    }

}
