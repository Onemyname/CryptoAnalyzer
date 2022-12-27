package ru.javarush.cryptoanalyzer.konovalov.data;

import java.util.List;

public interface Constants {

    String NOT_FOUND_ACTION_FORMAT = "Command not found!";

    String ENGLISH_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String ALL_ALPHABET = ENGLISH_LETTERS.toLowerCase();

    char[] CRYPT_ALPHABET_ARRAY = ALL_ALPHABET.toCharArray();

    static List<Character> getAlphabetList() {
        return alphabetList;
    }

    List<Character> alphabetList = ENGLISH_LETTERS.toLowerCase().chars().mapToObj(c -> (char) c).toList();

    static char[] getCryptArrayAlphabet() {
        return CRYPT_ALPHABET_ARRAY;
    }

    static int getCryptAlphabetArrayLength() {
        return CRYPT_ALPHABET_ARRAY.length;
    }

}
