package com.ertanunver.libgdx.yummy.test.webservicemanager;

import com.google.gson.JsonArray;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ertanunver on 18/01/16.
 */
public interface GitHubResource {

    @GET("users")
    Call<JsonArray> getUsers();

}
