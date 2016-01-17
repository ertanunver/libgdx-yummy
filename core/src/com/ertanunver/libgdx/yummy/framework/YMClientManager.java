package com.ertanunver.libgdx.yummy.framework;

import com.esotericsoftware.kryonet.Client;
import com.google.gson.JsonObject;

import java.io.IOException;

/**
 * Created by ertanunver on 12/01/16.
 */
public class YMClientManager {

    static YMClientManager instance;

    private JsonObject config;
    private Client client;
    private String host;
    private String port;

    YMClientManager(JsonObject config) {
        try {
            this.config = config.get("client_manager").getAsJsonObject();
            instance = this;
        } catch (NullPointerException e) { }
    }

    public static YMClientManager getInstance() {
        if (instance != null) {
            return instance;
        }
        throw new YMConfigException("client_manager config has not been set.");
    }

    void create() {
        if (instance != null) {
            try {
                host = config.get("host").getAsString();
                port = config.get("port").getAsString();
                client = new Client();
                client.getKryo().register(YMNetworkData.class);
            } catch (Exception e) {
                throw new YMConfigException("client_manager host or port has not been set.");
            }
        }
    }

    void dispose() {
        if (instance != null) {
            try {
                if (client != null) {
                    client.dispose();
                }
            } catch (IOException e) { }
        }
    }

    public Client getClient() {
        return client;
    }

    public void connect() {
        try {
            client.start();
            client.connect(5000, host, Integer.parseInt(port));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void connect(final YMConnectionErrorRunnable callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    client.start();
                    client.connect(5000, host, Integer.parseInt(port));
                    callback.run(false);
                } catch (IOException e) {
                    callback.run(true);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void disconnect() {
        client.stop();
        client.close();
    }

}
