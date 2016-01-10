package com.ertanunver.libgdx.yummy.managers;

/**
 * Created by ertanunver on 10/01/16.
 */
public class YMStageManager {

    private static YMStageManager instance = new YMStageManager();

    public static YMStageManager getInstance() {
        return instance;
    }

    private YMStageManager() {

    }

}
