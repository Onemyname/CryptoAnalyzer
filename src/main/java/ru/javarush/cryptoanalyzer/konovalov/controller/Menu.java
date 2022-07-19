package ru.javarush.cryptoanalyzer.konovalov.controller;

import static ru.javarush.cryptoanalyzer.konovalov.data.CryptAlphabetArray.getCryptAlphabetArrayLength;

public enum Menu {
    WELCOME_STRING("Welcome to the ENGLISH-Crypt-analyser \"Onemyname\".\nTo use this program you have to register." +
            "\nEnter your real name (example - Ivan Ivanov or Ivan):"),
    SELECT_OPERATION_MODES("Select the operating mode:\n0 - Caesar encryption\n1 - Caesar Decryption" +
            "\n2 - Brute Force decryption\n3 - Decryption method of statistical analysis\n4 - Close the program"),
    WRONG_COMMAND("You entered an unknown command!"),
    COMMAND_MUST_BE_NUMERIC("You have entered a non-correct value"),
    SELECT_CRYPT_KEY("Enter key  for encryption/decryption from 1 to " + (getCryptAlphabetArrayLength()-1)),
    SELECT_FILE("Enter  name of file.txt for encryption or decryption"),
    SELECT_RESULT_FILE("Enter name of file name where to save the result of encryption or decryption");

    private final String title;

    Menu(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }


}
