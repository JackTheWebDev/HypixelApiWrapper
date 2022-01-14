# Hypixel Api Wrapper
This is a simple api wrapper for the Hypixel api, that aims 
to be as easy to use as possible


### Usage 
In this example, we get data from the /player endpoint and print it out to the console

```java

import com.jackthewebdev.hypixelapiwrapper.HypixelApiWrapper;
import com.jackthewebdev.hypixelapiwrapper.utils.Result;

public class example {
    public static void main(String[] args) {
        String apiKey = "XXXXXXXXXXXX";
        HypixelApiWrapper hypixel = new HypixelApiWrapper(apiKey);
        Result result = hypixel.player(uuid);
        System.out.println("Success: " + result.isSuccess());
        System.out.println("Data: "+ result.getData());
    }
}

```

More information can be found [here, at the Hypixel api docs](https://api.hypixel.net) 

### Goals
Provide an easy to use api wrapper for the Hypixel api

### Endpoints
* Player - Gets information about the player 
* Friends - Gets information about the players friends 
* Status -gets the players online status and gamemode



### TODO
Moved to the github project [here](https://github.com/JackTheWebDev/HypixelApiWrapper/projects/1)