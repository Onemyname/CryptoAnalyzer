package ru.javarush.cryptoanalyzer.konovalov.strategy.caesar;

import ru.javarush.cryptoanalyzer.konovalov.strategy.CryptoStrategy;

import java.util.HashMap;

public class CaesarEncoder extends Caesar implements CryptoStrategy {

    public void codingInformation(String[] parameters) { // String[] args[] = {fileToEncrypt.txt, resultFile.txt, key}

        HashMap<Character, Character> cryptMap = createCaesarCryptHashMap(Integer.parseInt(parameters[2]), getChosenCommand());
        encodeOrDecodeFile(parameters[0], parameters[1], cryptMap);
    }
}

