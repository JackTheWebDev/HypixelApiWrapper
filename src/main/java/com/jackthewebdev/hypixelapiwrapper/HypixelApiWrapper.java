package com.jackthewebdev.hypixelapiwrapper;


import com.jackthewebdev.hypixelapiwrapper.utils.Requests;
import com.jackthewebdev.hypixelapiwrapper.utils.Result;

import java.io.IOException;

public class HypixelApiWrapper {

    public String Token;
    public String Endpoint = "https://api.hypixel.net";

    public HypixelApiWrapper(String token){
        this.Token = token;
    }

    public Result apiKey() throws IOException {
        return new Result(new Requests().jsonRequest(this.Endpoint+"/key?key="+this.Token));
    }

    /**
     * @param username The username of the player
     * @return Result The json response from the /uuid endpoint
     * @throws IOException
     */
    public Result getUuid(String username) throws IOException {
        return new Result(new Requests().jsonRequest(this.Endpoint+"/uuid?&key="+this.Token+"&name="+username));
    }


    /**
        @param uuid The uuid of the player

        @return String The json response from /player endpoint
     */
    public Result player(String uuid) throws IOException {
        return new Result(new Requests().jsonRequest(this.Endpoint+"/player?uuid="+uuid+"&key="+this.Token));
    }


    /**
        @param uuid The uuid of the player

        @return String The json response from /friends endpoint
     */
    public Result friends(String uuid) throws IOException {
        return new Result(new Requests().jsonRequest(this.Endpoint+"/friends?uuid="+uuid+"&key="+this.Token));
    }

    /**
        @param uuid The uuid of the player

        @return String The json response from the /status endpoint
     */
    public Result status(String uuid) throws IOException {
        String key = this.Token;

        return new Result(new Requests().jsonRequest(this.Endpoint+"/status?uuid="+uuid+"&key="+key));

    }


}
