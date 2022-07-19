package ru.javarush.cryptoanalyzer.konovalov.exception;

public class UnknownCommandException extends Exception {
    public UnknownCommandException(String message) {
        super(message);
    }
}
