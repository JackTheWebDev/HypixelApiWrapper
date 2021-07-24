# Hypixel Api Wrapper
This is a simple api wrapper for the Hypixel api, that aims 
to be as easy to use as possible


### Usage 
In this example, we get data from the /player endpoint and print it out to the console
```java
String apiKey = "XXXXXXXXXXXX"; 
HypixelApiWrapper wrapper = new HypixelApiWrapper(apiKey);
String data = wrapper.player(uuid);
System.out.println(data); 
```
