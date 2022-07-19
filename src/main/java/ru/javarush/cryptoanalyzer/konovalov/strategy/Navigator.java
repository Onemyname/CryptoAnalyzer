package ru.javarush.cryptoanalyzer.konovalov.strategy;

import ru.javarush.cryptoanalyzer.konovalov.strategy.CaesarMethod.CaesarDecoder;
import ru.javarush.cryptoanalyzer.konovalov.strategy.CaesarMethod.CaesarEncoder;

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
        navigator.action(parameters);
    }

    public static void runCaesarDecoder(String[] args) throws IOException {
        navigator = new Navigator(new CaesarDecoder());
        navigator.action(args);
    }

    public static void runBruteForceDecoder(String[] args)throws IOException {
        navigator = new Navigator(new BruteForceDecoder());
        navigator.action(args);
    }

    public static void runStatisticalAnalysisDecoder(String[] args) throws IOException{
        navigator = new Navigator(new StatAnalyzeDecoder());
        navigator.action(args);
    }
}
