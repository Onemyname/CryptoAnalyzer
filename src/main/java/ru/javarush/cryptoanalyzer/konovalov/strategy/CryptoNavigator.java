package ru.javarush.cryptoanalyzer.konovalov.strategy;

public class CryptoNavigator {

    private final CryptoStrategy strategy;

    public CryptoNavigator(CryptoStrategy strategy) {
        this.strategy = strategy;
    }

    public void codingInformation(String[] parameters){
            strategy.codingInformation(parameters);
    }
}