package com.ertanunver.libgdx.yummy.managers;

/**
 * Created by ertanunver on 10/01/16.
 */
public class YMAssetManager {

    private static YMAssetManager instance = new YMAssetManager();

    public static YMAssetManager getInstance() {
        return instance;
    }

    private YMAssetManager() {

    }

}
