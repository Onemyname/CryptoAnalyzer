package ru.javarush.cryptoanalyzer.konovalov.strategy;


import java.io.*;


public interface Actionable {


    void action(String[] args) throws IOException;
}