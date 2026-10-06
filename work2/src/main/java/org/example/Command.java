package org.example;

public class Command {
    private String[] commandParts;
    public Command(String str){
        commandParts = str.split(" ");
    }
//    public Command(String str,String str2){
//        this(str + " " + str2);
//
//    }

    public Command(String ... arr){
        commandParts = arr;
    }

//    public Command(String str,String str2,String str3){
//        this(str + " " + str2 + " " + str3);
//    }
    public String[] getCommand()
    {
        return commandParts;
    }
}
