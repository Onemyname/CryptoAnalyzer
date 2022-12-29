package ru.javarush.cryptoanalyzer.konovalov.controller;

import ru.javarush.cryptoanalyzer.konovalov.Commands.Action;
import ru.javarush.cryptoanalyzer.konovalov.entity.*;
import ru.javarush.cryptoanalyzer.konovalov.exception.AppException;

public class MainController {

    public Result doAction(String actionName, String[] parameters) {

        Action action = ActionContainer.getAction(actionName);

        try {
            return action.execute(parameters);
        }
        catch(AppException e){
            return new Result(ResultCode.ERROR, e.getMessage());
        }
    }
}
