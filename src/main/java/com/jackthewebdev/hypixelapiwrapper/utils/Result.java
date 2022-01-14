package com.jackthewebdev.hypixelapiwrapper.utils;

import com.google.gson.*;

public class Result {
    private final boolean success;
    private final JsonObject data;

    public Result(String result){
        Gson gson = new Gson();

         this.data = gson.fromJson(result, JsonObject.class);

        this.success = data.get("success").getAsBoolean();
    }

    public boolean isSuccess(){
        return success;
    }

    public JsonObject getData(){
        return this.data;
    }


}
