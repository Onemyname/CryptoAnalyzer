package ru.javarush.cryptoanalyzer.konovalov.strategy;

import ru.javarush.cryptoanalyzer.konovalov.strategy.caesar.BruteForceDecoder;
import ru.javarush.cryptoanalyzer.konovalov.strategy.caesar.CaesarDecoder;
import ru.javarush.cryptoanalyzer.konovalov.strategy.caesar.CaesarEncoder;
import ru.javarush.cryptoanalyzer.konovalov.strategy.statisticalanalyze.StatAnalyzeDecoder;

public class CryptoNavigator {
    private static CryptoNavigator navigator;
    private final CryptoStrategy strategy;

    public CryptoNavigator(CryptoStrategy strategy) {
        this.strategy = strategy;
    }

    public void codingInformation(String[] parameters){
            strategy.codingInformation(parameters);
    }
    //encode with Caesar method
    public static void runCaesarEncoder(String[] parameters){
        navigator = new CryptoNavigator(new CaesarEncoder());
        navigator.codingInformation(parameters);
    }
    //decode with Caesar method
    public static void runCaesarDecoder(String[] parameters){
        navigator = new CryptoNavigator(new CaesarDecoder());
        navigator.codingInformation(parameters);
    }
    //decode with founding Caesar key
    public static void runBruteForceDecoder(String[] parameters){
        navigator = new CryptoNavigator(new BruteForceDecoder());
        navigator.codingInformation(parameters);
    }
    //decode using statistic of characters
    public static void runStatAnalyzeDecoder(String[] parameters){
        navigator = new CryptoNavigator(new StatAnalyzeDecoder());
        navigator.codingInformation(parameters);
    }
}
