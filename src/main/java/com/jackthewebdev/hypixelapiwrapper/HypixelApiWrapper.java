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
    public String player(String uuid) throws IOException {
        String key = this.Token;

        Requests request = new Requests();

        return request.jsonRequest(this.Endpoint+"/player?uuid="+uuid+"&key="+key);

    }

    public String friends(String uuid) throws IOException {
        String key = this.Token;

        Requests request = new Requests();

        return request.jsonRequest(this.Endpoint+"/player?uuid="+uuid+"&key="+key);

    }

}
