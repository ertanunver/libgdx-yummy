package com.ertanunver.libgdx.yummy.test.assetmanager;

import com.badlogic.gdx.utils.Timer;
import com.ertanunver.libgdx.yummy.framework.YMAssetManager;
import com.ertanunver.libgdx.yummy.framework.YMStageManager;
import com.ertanunver.libgdx.yummy.framework.YMTestStage;
import com.ertanunver.libgdx.yummy.test.MenuStage;

/**
 * Created by ertanunver on 14/01/16.
 */
public class AssetManagerTestStage extends YMTestStage {

    public AssetManagerTestStage() {
        super("", false);
    }

    @Override
    public void render() {
        YMAssetManager assetManager = YMAssetManager.getInstance();
        if (assetManager.getProcess() != 1) {
            vMessage.setText(Float.toString(Math.round(assetManager.getProcess() * 100f)) + " / 100");
            assetManager.update();
        } else {
            vMessage.setText("Finished.");
            YMStageManager.getInstance().pushStageWithKillingActiveStage(new MenuStage());
        }
        super.render();
    }

}
