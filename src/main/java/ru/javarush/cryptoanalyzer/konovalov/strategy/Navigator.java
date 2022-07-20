package ru.javarush.cryptoanalyzer.konovalov.strategy;

import ru.javarush.cryptoanalyzer.konovalov.strategy.caesar.BruteForceDecoder;
import ru.javarush.cryptoanalyzer.konovalov.strategy.caesar.CaesarDecoder;
import ru.javarush.cryptoanalyzer.konovalov.strategy.caesar.CaesarEncoder;
import ru.javarush.cryptoanalyzer.konovalov.strategy.statisticalanalyze.StatAnalyzeDecoder;

import java.io.IOException;

public class Navigator {
    private static Navigator navigator = null;
    private final CryptoStrategy strategy;

    public Navigator(CryptoStrategy strategy) {
        this.strategy = strategy;
    }

    public void codingInformation(String[] parameters) throws IOException {
        strategy.codingInformation(parameters);
    }

    public static void runCaesarEncoder(String[] parameters) throws IOException {
        navigator = new Navigator(new CaesarEncoder());
        navigator.codingInformation(parameters);                                           //encode with Caesar method
    }

    public static void runCaesarDecoder(String[] parameters) throws IOException {
        navigator = new Navigator(new CaesarDecoder());
        navigator.codingInformation(parameters);                                                 //decode with Caesar method
    }

    public static void runBruteForceDecoder(String[] parameters) throws IOException {
        navigator = new Navigator(new BruteForceDecoder());
        navigator.codingInformation(parameters);                                                 //decode with founding Caesar key
    }

    public static void runStatisticalAnalysisDecoder(String[] parameters) throws IOException {
        navigator = new Navigator(new StatAnalyzeDecoder());
        navigator.codingInformation(parameters);                                                 //decode using statistic of characters
    }
}
