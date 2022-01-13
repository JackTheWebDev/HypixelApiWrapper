# Hypixel Api Wrapper
This is a simple api wrapper for the Hypixel api, that aims 
to be as easy to use as possible


### Usage 
In this example, we get data from the /player endpoint and print it out to the console
```java

import com.jackthewebdev.hypixelapiwrapper.HypixelApiWrapper;

public class example{
    public static void main(String [] args){
        String apiKey = "XXXXXXXXXXXX";
        HypixelApiWrapper wrapper = new HypixelApiWrapper(apiKey);
        String data = wrapper.player(uuid);
        System.out.println(data);        
    }
}

```

More infomation can be found [here, at the Hypixel api docs](https://api.hypixel.net) 


### Endpoints
* Player - Gets information about the player 
* Friends - Gets information about the players friends 
* Status -gets the players online status and gamemode




### TODO
* Add the rest of the endpoints
* Return Java Objects instead of JSON
* Some sort of basic error handling? 
* 