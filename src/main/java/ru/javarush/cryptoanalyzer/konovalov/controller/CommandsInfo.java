package ru.javarush.cryptoanalyzer.konovalov.controller;

public enum CommandsInfo {
    CAESAR_ENCODER("You have chosen the Caesar encryption method.\nFirst enter the file name to encrypt. (example: \"fileTXT.txt\")\nThen the file name where to save the encrypted file.\nThe files should be in english and stored in the root folder of the project: CryptoAnalyzer/text"),
    CAESAR_DECODER("You have chosen the Caesar decryption method.\nFirst enter the file name to decrypt. (example: \"fileTXT.txt\")\nThen the file name where to save the decrypted file.\nThe files should be in english and stored in the root folder of the project: CryptoAnalyzer/text"),
    BRUTE_FORCE_DECODER("You have chosen Brute Force decryption.\nFirst enter the name of the file to encrypt. (example: \"fileTXT.txt\")\nThen the name of the file where to save the encrypted file.\nFor the third time enter a dictionary of frequently used words.\nThe files should be in english and stored in the root folder of the project: CryptoAnalyzer/text"),
    STATISTICAL_ANALYSIS_DECODER("You have chosen the decryption method of statistical analysis.\nFirst enter the name of the file to decrypt. (example: \"fileTXT.txt\")\nThen the name of the file where to save the decrypted file.\nFor the third time enter the example text of the same author.\nThe files should be in english and stored in the root folder of the project: CryptoAnalyzer/text"),
    EXIT("Quitting program");

    private final String title;

    CommandsInfo(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
