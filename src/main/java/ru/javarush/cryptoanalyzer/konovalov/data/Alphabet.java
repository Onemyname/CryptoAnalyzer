package ru.javarush.cryptoanalyzer.konovalov.data;

public enum Alphabet {

    ENGLISH_LETTERS("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

    private final String title;

    Alphabet(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
