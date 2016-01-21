package com.ertanunver.libgdx.yummy.framework;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import retrofit2.Response;

/**
 * Created by ertanunver on 21/01/16.
 */
public class YMWebServiceErrorUtil {

    public static JsonObject parseError(Response<?> response) {
        try {
            JsonObject jsonObject = new Gson().fromJson(response.errorBody().string(), JsonObject.class);
            return jsonObject;
        } catch (Exception e) {
            return null;
        }
    }

}
