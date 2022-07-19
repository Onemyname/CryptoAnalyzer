package ru.javarush.cryptoanalyzer.konovalov.data;

public enum Alphabet {
    NUMBERS("0123456789"),

    ENGLISH_LETTERS("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
    SYMBOLS(",.!?");

    private final String title;

    Alphabet(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
