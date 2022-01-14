package com.jackthewebdev.hypixelapiwrapper.tests;

// Crappy tests that get the job done


import com.jackthewebdev.hypixelapiwrapper.HypixelApiWrapper;
import com.jackthewebdev.hypixelapiwrapper.utils.Result;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Tests {


    public static void main(String[] args) throws IOException, NoSuchMethodException {
        System.out.println("Starting tests");

        int failed = 0;
        int passed = 0;

        String apiKey = args[0];

        String uuid = "b876ec32-e396-476b-a115-8438d83c67d4";
        String username = "Technoblade";


        HypixelApiWrapper hypixel = new HypixelApiWrapper(apiKey);


        ArrayList<Method> playerTests = new ArrayList<>();


        playerTests.add(HypixelApiWrapper.class.getMethod("player", String.class));
        playerTests.add(HypixelApiWrapper.class.getMethod("friends", String.class));
        playerTests.add(HypixelApiWrapper.class.getMethod("status", String.class));

        for (Method method : playerTests) {
            try {
                Result result =(Result) method.invoke(hypixel,uuid);
                if(result.isSuccess()){
                    System.out.println("[✓] "+method.getName()+" Passed");
                    passed ++;
                    continue;
                }
                failed ++;
                System.out.println("[X] "+method.getName()+" Failed");
            } catch (Exception e) {
                System.out.println("[X] "+method.getName()+" Failed");
                failed++;
            }

        }



        System.out.println("Tests Finished: ");
        System.out.println(passed+" tests passed, "+failed+" tests failed.");

    }


}
