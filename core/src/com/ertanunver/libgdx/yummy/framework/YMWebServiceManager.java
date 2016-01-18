package com.ertanunver.libgdx.yummy.framework;

import com.google.gson.JsonObject;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by ertanunver on 18/01/16.
 */
public class YMWebServiceManager {

    static YMWebServiceManager instance;

    private JsonObject config;
    private Retrofit retrofit;
    private String baseUrl;

    YMWebServiceManager(JsonObject config) {
        try {
            this.config = config.get("web_service_manager").getAsJsonObject();
            instance = this;
        } catch (NullPointerException e) { }
    }

    public static YMWebServiceManager getInstance() {
        if (instance != null) {
            return instance;
        }
        throw new YMConfigException("web_service_manager config has not been set.");
    }

    void create() {
        if (instance != null) {
            try {
                baseUrl = config.get("base_url").getAsString();
                retrofit = new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            } catch (Exception e) {
                throw new YMConfigException("web_service_manager base url has not been set.");
            }
        }
    }

    void dispose() {

    }

    public <T> T createResource(final Class<T> resource) {
        return retrofit.create(resource);
    }

}
