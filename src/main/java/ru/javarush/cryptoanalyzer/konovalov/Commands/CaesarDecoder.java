package ru.javarush.cryptoanalyzer.konovalov.Commands;

import ru.javarush.cryptoanalyzer.konovalov.entity.Result;

public class CaesarDecoder implements CaesarAction {

    @Override
    public Result execute(String[] parameters) {
        String encryptedText = parameters[0];
        String decryptedText = parameters[1];
        int key = Integer.parseInt(parameters[2]);

        return applyCipherKey(encryptedText,decryptedText,key*(-1));

    }

}
