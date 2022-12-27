package ru.javarush.cryptoanalyzer.konovalov.controller;


import ru.javarush.cryptoanalyzer.konovalov.Commands.*;
import ru.javarush.cryptoanalyzer.konovalov.data.Constants;
import ru.javarush.cryptoanalyzer.konovalov.exception.AppException;

public enum ActionContainer {
    ENCODE(new CaesarEncoder()),
    DECODE(new CaesarDecoder()),
    BRUTEFORCE(new BruteForceDecoder()),
    ANALYZE(new StatAnalyzeDecoder());

    private final Action ACTION;

    ActionContainer(Action action){
        this.ACTION = action;
    }

    public static Action getAction(String actionName) {
        try{
            ActionContainer value = ActionContainer.valueOf(actionName);
            return value.ACTION;
        }
        catch( IllegalArgumentException e){
            String message = String.format(Constants.NOT_FOUND_ACTION_FORMAT, actionName);
            throw new AppException(message,e);
        }
    }
}
