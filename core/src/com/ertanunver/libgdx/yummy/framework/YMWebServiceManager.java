package com.ertanunver.libgdx.yummy.framework;

import com.google.gson.JsonObject;
import okhttp3.*;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by ertanunver on 18/01/16.
 */
public class YMWebServiceManager {

    static YMWebServiceManager instance;

    private JsonObject config;
    private Retrofit retrofit;
    private String baseUrl;

    private OkHttpClient httpClient;
    private HashMap<String, String> headers;
    private HashMap<String, String> queries;

    YMWebServiceManager(JsonObject config) {
        try {
            this.config = config.get("web_service_manager").getAsJsonObject();
            instance = this;
        } catch (NullPointerException e) { }
        headers = new HashMap<String, String>();
        queries = new HashMap<String, String>();
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
                httpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        // queries
                        HttpUrl.Builder urlBuilder = chain.request().url().newBuilder();
                        Set<String> queryKeys = queries.keySet();
                        for (String queryKey : queryKeys) {
                            urlBuilder.addQueryParameter(queryKey, queries.get(queryKey));
                        }
                        HttpUrl url = urlBuilder.build();
                        // headers
                        Request.Builder requestBuilder = chain.request().newBuilder();
                        Set<String> headerKeys = headers.keySet();
                        for (String headerKey : headerKeys) {
                            urlBuilder.addQueryParameter(headerKey, headers.get(headerKey));
                        }
                        Request request = requestBuilder.url(url).build();
                        return chain.proceed(request);
                    }
                }).build();
                retrofit = new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .client(httpClient)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            } catch (Exception e) {
                System.out.println(e);
                throw new YMConfigException("web_service_manager base url has not been set.");
            }
        }
    }

    void dispose() {

    }

    public <T> T createResource(final Class<T> resource) {
        return retrofit.create(resource);
    }

    public void addHeader(String key, String value) {
        headers.put(key, value);
    }

    public void removeHeader(String key) {
        headers.remove(key);
    }

    public void addQuery(String key, String value) {
        queries.put(key, value);
    }

    public void removeQuery(String key) {
        queries.remove(key);
    }

}
