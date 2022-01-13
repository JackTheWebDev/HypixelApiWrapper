package com.jackthewebdev.hypixelapiwrapper.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Requests {

    public String jsonRequest(String url) throws IOException {
        String response = "";

        URL requestUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type","Application/json");

        connection.connect();


        Scanner scanner = new Scanner(connection.getInputStream());

        while(scanner.hasNext()){
            response += scanner.nextLine();
        }

        return response;
    }


}
