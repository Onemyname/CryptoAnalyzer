package ru.javarush.cryptoanalyzer.konovalov.exception;

public class NameContainsNumbersOrSymbolsException extends Exception {
    public NameContainsNumbersOrSymbolsException(String message) {
        super(message);
    }
}
