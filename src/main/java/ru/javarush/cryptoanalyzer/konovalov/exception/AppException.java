package ru.javarush.cryptoanalyzer.konovalov.exception;

public class AppException extends RuntimeException{
    String reason;
    public AppException(String reason) {
        this.reason = reason;
    }

    public AppException(String reason, Throwable cause){
        super(cause);
        this.reason = reason;
    }

    public String getReason(){
        return this.reason;
    }
}
