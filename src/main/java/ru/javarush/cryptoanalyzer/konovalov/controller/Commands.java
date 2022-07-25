package ru.javarush.cryptoanalyzer.konovalov.controller;

import ru.javarush.cryptoanalyzer.konovalov.strategy.CryptoStrategy;
import ru.javarush.cryptoanalyzer.konovalov.strategy.caesar.BruteForceDecoder;
import ru.javarush.cryptoanalyzer.konovalov.strategy.caesar.CaesarDecoder;
import ru.javarush.cryptoanalyzer.konovalov.strategy.caesar.CaesarEncoder;
import ru.javarush.cryptoanalyzer.konovalov.strategy.statisticalanalyze.StatAnalyzeDecoder;

import java.util.LinkedHashMap;

public class Commands {

    private final LinkedHashMap<String, CryptoStrategy> commands = new LinkedHashMap<>()
        {{
        commands.put("encode", new CaesarEncoder());
        commands.put("decode", new CaesarDecoder());
        commands.put("brut", new BruteForceDecoder());
        commands.put("analyze", new StatAnalyzeDecoder());
    }};

    public CryptoStrategy getCryptoObject(String command){
        return commands.get(command.toLowerCase());
    }
    public boolean commandExist(String command){
        return commands.containsKey(command.toLowerCase());
    }
}


