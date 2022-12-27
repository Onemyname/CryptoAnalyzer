package ru.javarush.cryptoanalyzer.konovalov.Commands;

import ru.javarush.cryptoanalyzer.konovalov.entity.Result;

public interface Action {
    String ENCODE = "encode";
    String DECODE = "decode";
    String BRUTEFORCE = "bruteforce";
    String ANALYZE = "analyze";
    Result execute(String[] parameters);
}
