package com.ertanunver.libgdx.yummy.framework;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Created by ertanunver on 12/01/16.
 */
public class YMNetworkData {

    private JsonObject jsonObject;

    public YMNetworkData() {
        jsonObject = new JsonObject();
    }

    public YMNetworkData(String name) {
        this();
        setName(name);
    }

    public YMNetworkData(String name, String data) {
        this();
        setName(name);
        setData(data);
    }

    public YMNetworkData(String name, Boolean data) {
        this();
        setName(name);
        setData(data);
    }

    public YMNetworkData(String name, Character data) {
        this();
        setName(name);
        setData(data);
    }

    public YMNetworkData(String name, Number data) {
        this();
        setName(name);
        setData(data);
    }

    public YMNetworkData(String name, JsonObject data) {
        this();
        setName(name);
        setData(data);
    }

    public YMNetworkData(String name, JsonArray data) {
        this();
        setName(name);
        setData(data);
    }

    public String getName() {
        try {
            return jsonObject.get("name").getAsString();
        } catch (NullPointerException e) {
            return null;
        }
    }

    public void setName(String data) {
        jsonObject.addProperty("name", data);
    }

    public String getDataAsString() {
        try {
            return jsonObject.get("data").getAsString();
        } catch (NullPointerException e) {
            return null;
        }
    }

    public void setData(String data) {
        jsonObject.addProperty("data", data);
    }

    public Boolean getDataAsBoolean() {
        try {
            return jsonObject.get("data").getAsBoolean();
        } catch (NullPointerException e) {
            return null;
        }
    }

    public void setData(Boolean data) {
        jsonObject.addProperty("data", data);
    }

    public Character getDataAsCharacter() {
        try {
            return jsonObject.get("data").getAsCharacter();
        } catch (NullPointerException e) {
            return null;
        }
    }

    public void setData(Character data) {
        jsonObject.addProperty("data", data);
    }

    public Number getDataAsNumber() {
        try {
            return jsonObject.get("data").getAsNumber();
        } catch (NullPointerException e) {
            return null;
        }
    }

    public void setData(Number data) {
        jsonObject.addProperty("data", data);
    }

    public JsonObject getDataAsJsonObject() {
        try {
            return jsonObject.get("data").getAsJsonObject();
        } catch (NullPointerException e) {
            return null;
        }
    }

    public void setData(JsonObject data) {
        jsonObject.add("data", data);
    }

    public JsonArray getDataAsJsonArray() {
        try {
            return jsonObject.get("data").getAsJsonArray();
        } catch (NullPointerException e) {
            return null;
        }
    }

    public void setData(JsonArray data) {
        jsonObject.add("data", data);
    }

    @Override
    public String toString() {
        return jsonObject.toString();
    }

}
