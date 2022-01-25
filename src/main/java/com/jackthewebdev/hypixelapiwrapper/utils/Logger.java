package com.jackthewebdev.hypixelapiwrapper.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {


    private File file;
    private FileWriter writer;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    /**
     * Creates a new log file with the given directory as directory/[yyyy-MM-dd HH-mm-ss].log
     *
     * <br><b>Note: </b> this will create the directory if it does not exist.
     * @param filepath
     * @throws IOException
     */
    public Logger(String filepath) throws IOException {

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;

        // Create the directory if it doesn't exist already
        File directory = new File(filepath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        File file = new File(filepath+"/"+dateFormat.format(date)+".log");
        file.createNewFile();
        this.file = file;

        FileWriter writer = new FileWriter(file);
        this.writer = writer;
        writer.write("Started logging at: " + dateFormat.format(date) + "\n");

    }

    /**
    * Logs a message to the currently used log file.
    *
    * @param message The content of the message to log
    * @param type The type of message to log (0 = info, 1 = warning, 2 = error)
     */
    public boolean log(String message,int type) throws IOException {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        String time = dateFormat.format(date);

        switch (type) {
            case 0:
                System.out.println("["+time+"]"+ANSI_GREEN+" Message: "+message + ANSI_RESET);
                writer.write( "["+time+"] Message: "+message +"\n");
                break;
            case 1:
                System.out.println("["+time+"]"+ANSI_YELLOW+" Warning: "+ message + ANSI_RESET);
                writer.write( "["+time+"] Warning: "+message + ANSI_RESET+"\n");
                break;
            case 2:
                System.out.println("["+time+"]"+ANSI_RED+" Error: " + message + ANSI_RESET);
                writer.write( "["+time+"] Error: "+message + ANSI_RESET+"\n");
                break;
        }
        return true;
    }

    public boolean close(){
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }


}
