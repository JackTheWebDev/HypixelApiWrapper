package com.jackthewebdev.hypixelapiwrapper.tests;

// Crappy tests that get the job done


import com.jackthewebdev.hypixelapiwrapper.HypixelApiWrapper;
import com.jackthewebdev.hypixelapiwrapper.utils.Logger;
import com.jackthewebdev.hypixelapiwrapper.utils.Result;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Tests {


    public static void main(String[] args) throws IOException, NoSuchMethodException {

        // get cwd
        String cwd = System.getProperty("user.dir");
        Logger logger = new Logger(cwd+"/logs");

        logger.log("Starting tests",0);

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
                    logger.log("[✓] "+method.getName()+" Passed",0);
                    passed ++;
                    continue;
                }
                failed ++;
                logger.log("[X] "+method.getName()+" Failed",3);
            } catch (Exception e) {
                logger.log("[X] "+method.getName()+" Failed",3);
                failed++;
            }

        }


        logger.log("Tests Finished: ",0);
        logger.log(passed+" tests passed, "+failed+" tests failed.",0);
        logger.close();
    }


}
