package com.jackthewebdev.hypixelapiwrapper;


import com.jackthewebdev.hypixelapiwrapper.utils.Requests;

import java.io.IOException;

public class HypixelApiWrapper {

    public String Token;
    public String Endpoint = "https://api.hypixel.net";

    public HypixelApiWrapper(String token){
        this.Token = token;
    }

    public String apiKey() throws IOException {
        String key = this.Token;

        Requests request = new Requests();

        return request.jsonRequest(this.Endpoint+"/key?key="+key);

    }

    /*
        Other various functions
     */
    public String getuuid(String username) throws IOException {

        Requests request = new Requests();

        return request.jsonRequest("https://api.mojang.com/users/profiles/minecraft/"+username);

    }


    /*
                        Hypixel API Endpoints
     */
    /*
        @param uuid

        @return String The json response from /player endpoint

     */
    public String player(String uuid) throws IOException {
        String key = this.Token;

        Requests request = new Requests();

        return request.jsonRequest(this.Endpoint+"/player?uuid="+uuid+"&key="+key);

    }

    /*
        @param uuid

        @return String The json response from /friends endpoint
     */
    public String friends(String uuid) throws IOException {
        String key = this.Token;

        Requests request = new Requests();

        return request.jsonRequest(this.Endpoint+"/player?uuid="+uuid+"&key="+key);

    }

    /*
        @param uuid

        @return String The json response from the /status endpoint
     */

    public String status(String uuid) throws IOException {
        String key = this.Token;

        Requests request = new Requests();

        return request.jsonRequest(this.Endpoint+"/status?uuid="+uuid+"&key="+key);

    }

}
