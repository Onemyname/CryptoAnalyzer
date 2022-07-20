package ru.javarush.cryptoanalyzer.konovalov.strategy;

import ru.javarush.cryptoanalyzer.konovalov.strategy.CaesarMethod.BruteForceDecoder;
import ru.javarush.cryptoanalyzer.konovalov.strategy.CaesarMethod.CaesarDecoder;
import ru.javarush.cryptoanalyzer.konovalov.strategy.CaesarMethod.CaesarEncoder;
import ru.javarush.cryptoanalyzer.konovalov.strategy.statisticalanalyze.StatAnalyzeDecoder;

import java.io.IOException;

public class Navigator {

    private Actionable actionable;

    public Navigator(Actionable actionable) {
        this.actionable = actionable;
    }

    public void action(String[] args) throws IOException {
            actionable.action(args);
    }

    private static Navigator navigator = null;

    public static void runCaesarEncoder(String[] parameters) throws IOException {
        navigator = new Navigator(new CaesarEncoder());
        navigator.action(parameters);                                           //encode with Caesar method
    }

    public static void runCaesarDecoder(String[] args) throws IOException {
        navigator = new Navigator(new CaesarDecoder());
        navigator.action(args);                                                 //decode with Caesar method
    }

    public static void runBruteForceDecoder(String[] args)throws IOException {
        navigator = new Navigator(new BruteForceDecoder());
        navigator.action(args);                                                 //decode with founding Caesar key
    }

    public static void runStatisticalAnalysisDecoder(String[] args) throws IOException{
        navigator = new Navigator(new StatAnalyzeDecoder());
        navigator.action(args);                                                 //decode using statistic of characters
    }
}
