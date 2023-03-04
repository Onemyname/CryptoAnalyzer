package ru.javarush.cryptoanalyzer.konovalov.Commands;

import ru.javarush.cryptoanalyzer.konovalov.data.Constants;
import ru.javarush.cryptoanalyzer.konovalov.entity.Result;
import ru.javarush.cryptoanalyzer.konovalov.entity.ResultCode;

public class EXIT implements Action {
    @Override
    public Result execute(String[] parameters) {
        return new Result(ResultCode.OK, Constants.APPLICATION_CLOSED);
    }
}
