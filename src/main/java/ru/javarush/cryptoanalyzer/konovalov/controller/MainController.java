package ru.javarush.cryptoanalyzer.konovalov.controller;

import ru.javarush.cryptoanalyzer.konovalov.Commands.Action;
import ru.javarush.cryptoanalyzer.konovalov.entity.Result;
import ru.javarush.cryptoanalyzer.konovalov.entity.ResultCode;
import ru.javarush.cryptoanalyzer.konovalov.exception.AppException;

public class MainController {

    public Result doAction(String actionName, String[] parameters) {
        try {
            Action action = ActionContainer.getAction(actionName);
            return action.execute(parameters);
        }
        catch(AppException e){
            return new Result(ResultCode.ERROR, e.getMessage());
        }
    }
}
