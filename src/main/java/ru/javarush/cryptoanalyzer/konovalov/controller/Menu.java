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
    SELECT_RESULT_FILE("Enter name of file name where to save the result of encryption or decryption"),
    CAESAR_ENCODER("You have chosen the Caesar encryption method.\nFirst enter the file name to encrypt. (example: \"fileTXT.txt\")\nThen the file name where to save the encrypted file.\nThe files should be in english and stored in the root folder of the project: CryptoAnalyzer/text"),
    CAESAR_DECODER("You have chosen the Caesar decryption method.\nFirst enter the file name to decrypt. (example: \"fileTXT.txt\")\nThen the file name where to save the decrypted file.\nThe files should be in english and stored in the root folder of the project: CryptoAnalyzer/text"),
    BRUTE_FORCE_DECODER("You have chosen Brute Force decryption.\nFirst enter the name of the file to encrypt. (example: \"fileTXT.txt\")\nThen the name of the file where to save the encrypted file.\nFor the third time enter a dictionary of frequently used words.\nThe files should be in english and stored in the root folder of the project: CryptoAnalyzer/text"),
    STATISTICAL_ANALYSIS_DECODER("You have chosen the decryption method of statistical analysis.\nFirst enter the name of the file to decrypt. (example: \"fileTXT.txt\")\nThen the name of the file where to save the decrypted file.\nFor the third time enter the example text of the same author.\nThe files should be in english and stored in the root folder of the project: CryptoAnalyzer/text"),
    EXIT("Quitting program");

    private final String title;

    Menu(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }


}
