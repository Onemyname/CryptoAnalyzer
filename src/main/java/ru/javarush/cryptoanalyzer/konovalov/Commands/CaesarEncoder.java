package ru.javarush.cryptoanalyzer.konovalov.Commands;

import ru.javarush.cryptoanalyzer.konovalov.entity.Result;

public class CaesarEncoder implements CaesarAction {
    @Override
    public Result execute(String[] parameters) {
        String mainText = parameters[0];
        String encryptedText = parameters[1];
        int key = Integer.parseInt(parameters[2]);

        return applyCipherKey(mainText, encryptedText, key);
    }
}
