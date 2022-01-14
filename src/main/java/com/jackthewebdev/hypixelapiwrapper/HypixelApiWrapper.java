package com.jackthewebdev.hypixelapiwrapper;


import com.jackthewebdev.hypixelapiwrapper.utils.Requests;
import com.jackthewebdev.hypixelapiwrapper.utils.Result;

import java.io.IOException;
import java.lang.reflect.Method;

public class HypixelApiWrapper {

    public String Token;
    public String Endpoint = "https://api.hypixel.net";

    public HypixelApiWrapper(String token){
        this.Token = token;
    }

    public Result apiKey() throws IOException {
        return new Result(new Requests().jsonRequest(this.Endpoint+"/key?key="+this.Token));
    }

    public Result getUuid(String username) throws IOException {
        return new Result(new Requests().jsonRequest(this.Endpoint+"/uuid?&key="+this.Token+"&name="+username));
    }



    /*
        @param uuid

        @return String The json response from /player endpoint

     */
    public Result player(String uuid) throws IOException {
        return new Result(new Requests().jsonRequest(this.Endpoint+"/player?uuid="+uuid+"&key="+this.Token));
    }

    /*
        @param uuid

        @return String The json response from /friends endpoint
     */
    public Result friends(String uuid) throws IOException {
        return new Result(new Requests().jsonRequest(this.Endpoint+"/friends?uuid="+uuid+"&key="+this.Token));
    }

    /*
        @param uuid

        @return String The json response from the /status endpoint
     */

    public Result status(String uuid) throws IOException {
        String key = this.Token;

        return new Result(new Requests().jsonRequest(this.Endpoint+"/status?uuid="+uuid+"&key="+key));

    }


}
