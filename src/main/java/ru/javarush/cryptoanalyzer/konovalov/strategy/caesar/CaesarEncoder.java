package ru.javarush.cryptoanalyzer.konovalov.strategy.caesar;

import ru.javarush.cryptoanalyzer.konovalov.strategy.CryptoStrategy;

import java.util.HashMap;

import static ru.javarush.cryptoanalyzer.konovalov.controller.RegisterCommandService.getChosenCommand;
import static ru.javarush.cryptoanalyzer.konovalov.strategy.caesar.CaesarService.createCaesarCryptHashMap;
import static ru.javarush.cryptoanalyzer.konovalov.strategy.caesar.CaesarService.encodeOrDecodeFile;
import static ru.javarush.cryptoanalyzer.konovalov.io.Printable.println;

public class CaesarEncoder implements CryptoStrategy {


    public void codingInformation(String[] parameters) { // String[] args[] = {fileToEncrypt.txt, resultFile.txt, key}
        println("Encryption attempt");

        HashMap<Character, Character> cryptMap = createCaesarCryptHashMap(Integer.parseInt(parameters[2]), getChosenCommand());
        encodeOrDecodeFile(parameters[0], parameters[1], cryptMap);

        println("The text is encrypted!");


    }
}

