package ru.javarush.cryptoanalyzer.konovalov.registeruser;

public class User {
    private static String userName;

    private static boolean userNameIsRight = false;

    public static void setUserNameIsRight(boolean value){
        userNameIsRight = value;
    }
    public static boolean getUserNameIsRight(){
        return userNameIsRight;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String name) {
        userName = name;
    }
}
