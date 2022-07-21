package ru.javarush.cryptoanalyzer.konovalov.strategy.caesar;

import ru.javarush.cryptoanalyzer.konovalov.strategy.CryptoStrategy;

import java.util.HashMap;

import static ru.javarush.cryptoanalyzer.konovalov.controller.RegisterCommandService.getChosenCommand;
import static ru.javarush.cryptoanalyzer.konovalov.strategy.caesar.CaesarService.createCaesarCryptHashMap;
import static ru.javarush.cryptoanalyzer.konovalov.strategy.caesar.CaesarService.encodeOrDecodeFile;
import static ru.javarush.cryptoanalyzer.konovalov.io.Printable.println;

public class CaesarDecoder implements CryptoStrategy {
    public void codingInformation(String[] parameters) {
        println("Decryption attempt");

        HashMap<Character, Character> cryptMap = createCaesarCryptHashMap(Integer.parseInt(parameters[2]), getChosenCommand());
        encodeOrDecodeFile(parameters[0], parameters[1], cryptMap);

        println("The text is decrypted!");
    }
}
