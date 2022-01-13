package com.jackthewebdev.hypixelapiwrapper.tests;

// Crappy tests that get the job done


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.jackthewebdev.hypixelapiwrapper.HypixelApiWrapper;

import java.io.IOException;

public class Tests {


    private static boolean uuidTest(String key, String username) throws IOException {

        HypixelApiWrapper wrapper = new HypixelApiWrapper(key);

        String data = wrapper.getuuid(username);

        Gson gson = new Gson();
        JsonObject obj = gson.fromJson(data,JsonObject.class);


        return obj.has("name");
    }

    private static boolean apiKeyTest(String key) throws IOException {
        HypixelApiWrapper wrapper = new HypixelApiWrapper(key);

        String data = wrapper.apiKey();

        Gson gson = new Gson();
        JsonObject obj = gson.fromJson(data,JsonObject.class);

        JsonElement success = obj.get("success");


        return success.getAsBoolean();
    }
    private static boolean playerTest(String key,String uuid) throws IOException {

        HypixelApiWrapper wrapper = new HypixelApiWrapper(key);

        String data = wrapper.player(uuid);

        Gson gson = new Gson();
        JsonObject obj = gson.fromJson(data,JsonObject.class);

        JsonElement success = obj.get("success");


        return success.getAsBoolean();
    }
    private static boolean friendTest(String key,String uuid) throws IOException {

        HypixelApiWrapper wrapper = new HypixelApiWrapper(key);

        String data = wrapper.friends(uuid);

        Gson gson = new Gson();
        JsonObject obj = gson.fromJson(data,JsonObject.class);

        JsonElement success = obj.get("success");




        return success.getAsBoolean();
    }

    private static boolean statusTest(String key,String uuid) throws IOException {
        HypixelApiWrapper wrapper = new HypixelApiWrapper(key);

        String data = wrapper.status(uuid);

        Gson gson = new Gson();
        JsonObject obj = gson.fromJson(data,JsonObject.class);

        JsonElement success = obj.get("success");

        return success.getAsBoolean();
    }

    // Some crappy tests that get the job done
    public static void main(String[] args) throws IOException {
        System.out.println("Starting tests");

        int failed = 0;
        int passed = 0;

        String apiKey = "ff1e7b5b-a03c-4e90-9cae-e4d99d914823";
        String uuid = "1a6ce94a-9c71-4b4e-907a-d61972f8570b";
        String username = "Technoblade";

        System.out.println("Running UUID Test...");
        if(uuidTest(apiKey,username)){
            System.out.println("[✓] Player Passed");
            passed++;
        }else{
            System.out.println("[X] Player Failed");
            failed++;
        }


        System.out.println("Running ApiKey...");
        if(apiKeyTest(apiKey)){
            System.out.println("[✓] ApiKey Passed");
            passed++;
        }else{
            System.out.println("[X] ApiKey Failed");
            failed++;
        }

        System.out.println("Running Player...");
        if(playerTest(apiKey,uuid)){
            System.out.println("[✓] Player Passed");
            passed++;
        }else{
            System.out.println("[X] Player Failed");
            failed++;
        }

        System.out.println("Running Friends...");
        if(friendTest(apiKey,uuid)){
            System.out.println("[✓] Player Passed");
            passed++;
        }else{
            System.out.println("[X] Player Failed");
            failed++;
        }

        System.out.println("Running Status...");
        if(statusTest(apiKey,uuid)){
            System.out.println("[✓] Player Passed");
            passed++;
        }else{
            System.out.println("[X] Player Failed");
            failed++;
        }



        System.out.println("Tests Finished: ");
        System.out.println(passed+" tests passed, "+failed+" tests failed.");

    }


}
