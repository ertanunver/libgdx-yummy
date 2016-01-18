package com.ertanunver.libgdx.yummy.test.webservicemanager;

import com.ertanunver.libgdx.yummy.framework.YMTestStage;
import com.ertanunver.libgdx.yummy.framework.YMWebServiceManager;
import com.google.gson.JsonArray;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ertanunver on 17/01/16.
 */
public class WebServiceManagerTestStage extends YMTestStage {

    public WebServiceManagerTestStage() {
        super("getting data from server...", true);
    }

    @Override
    public void create() {
        super.create();

        GitHubResource gitHubResource = YMWebServiceManager.getInstance().createResource(GitHubResource.class);
        Call<JsonArray> usersCall = gitHubResource.getUsers();
        usersCall.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Response<JsonArray> response) {
                if (response.isSuccess()) {
                    vMessage.setText("Success: " + response.body().get(0).getAsJsonObject().get("login").getAsString());
                } else {
                    vMessage.setText("Not success: " + response.message());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                vMessage.setText("Failure: " + t.getMessage());
            }
        });

    }

}
