package com.jackthewebdev.hypixelapiwrapper.utils;

import com.google.gson.*;

public class Result {
    private final boolean success;
    private final JsonObject data;

    /**
     * Stores the result of the request, allows you to access the data easily
     *
     * @param result The result of the request as a string
     */
    public Result(String result){
        Gson gson = new Gson();

         this.data = gson.fromJson(result, JsonObject.class);

        this.success = data.get("success").getAsBoolean();
    }

    /**
     * Returns if the request was successful or not
     *
     * @return true if the request was successful and false if not
     */
    public boolean isSuccess(){
        return success;
    }

    /**
     * Returns the JSON data of the request
     *
     * @return String json data
     */
    public JsonObject getData(){
        return this.data;
    }


}
