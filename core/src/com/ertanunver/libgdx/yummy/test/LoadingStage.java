package com.ertanunver.libgdx.yummy.test;

import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.ertanunver.libgdx.yummy.framework.YMAssetManager;
import com.ertanunver.libgdx.yummy.framework.YMStage;
import com.ertanunver.libgdx.yummy.framework.YMStageManager;
import com.ertanunver.libgdx.yummy.framework.YMTestStage;

/**
 * Created by ertanunver on 10/01/16.
 */
public class LoadingStage extends YMStage {

    public LoadingStage() {
        super(new ScreenViewport());
    }

    @Override
    public void render() {
        System.out.println("LoadingStage.render");
        if (YMAssetManager.getInstance().update()) {
            YMStageManager.getInstance().pushStageWithKillingActiveStage(new YMTestStage("Second Stage"));
        }
        super.render();
    }

    @Override
    public void create() {
        System.out.println("LoadingStage.create");
    }

    @Override
    public void dispose() {
        System.out.println("LoadingStage.dispose");
    }

}
