package ru.javarush.cryptoanalyzer.konovalov.registeruser;

import ru.javarush.cryptoanalyzer.konovalov.exception.NameContainsNumbersOrSymbolsException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ru.javarush.cryptoanalyzer.konovalov.io.Printable.println;

public class UserRegisterService {
    private static boolean isValidUsername(String userName) {

        // Regex to check valid username.
        String regex = "(?<=\\s|^)[a-zA-Z][a-z A-Z]*[a-zA-Z]*(?=[.,;:]?\\s|$)";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        if (userName == null) {
            return false;
        }

        // Pattern class contains matcher() method to find matching between given username and regular expression.
        Matcher m = p.matcher(userName);

        // Return if the username matched the ReGex
        return m.matches();
    }

    public static void enterCorrectUserName(String userName){
        try {
            if (isValidUsername(userName)) {
                User.setUserNameIsRight(true);
                User.setUserName(userName);
            } else {
                throw new NameContainsNumbersOrSymbolsException("Please enter a correct name without numbers and symbols:");
            }
        }
        catch(NameContainsNumbersOrSymbolsException e){
            println(e.getMessage());
        }
    }
}
