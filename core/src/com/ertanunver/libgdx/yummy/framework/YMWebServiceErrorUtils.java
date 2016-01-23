package com.ertanunver.libgdx.yummy.framework;

import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import retrofit2.Response;

/**
 * Created by ertanunver on 21/01/16.
 */
public class YMWebServiceErrorUtils {

    public static JsonObject parseError(Response<?> response) {
        try {
            JsonObject jsonObject = new Gson().fromJson(response.errorBody().string(), JsonObject.class);
            return jsonObject;
        } catch (Exception e) {
            return null;
        }
    }

    public static void displayError(YMStage stage, JsonObject jsonObject) {
        JsonArray errors = jsonObject.get("errors").getAsJsonArray();
        for (int i = 0; i < errors.size(); i++) {
            Label messageLabel = new Label(errors.get(i).getAsString(), YMSkinManager.getInstance().getSkin());
            messageLabel.setFontScale(0.83f);
            messageLabel.setAlignment(Align.center);
            messageLabel.setPosition(0, i * 15);
            messageLabel.setSize(320, 25);
            messageLabel.setColor(1, 1, 1, 0);
            messageLabel.addAction(Actions.sequence(
                    Actions.fadeIn(0.25f),
                    Actions.delay(5),
                    Actions.fadeOut(2),
                    Actions.removeActor()
            ));
            stage.addActor(messageLabel);
        }
    }

}
