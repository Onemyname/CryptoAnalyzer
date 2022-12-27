package ru.javarush.cryptoanalyzer.konovalov.data;

import java.util.List;

public class Alphabet {
    private Alphabet(){

    }

    static String ENGLISH_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String ALL_ALPHABET = ENGLISH_LETTERS.toLowerCase();

    static char[] CRYPT_ALPHABET_ARRAY = ALL_ALPHABET.toCharArray();

    static List<Character> getAlphabetList() {
        return alphabetList;
    }

    static List<Character> alphabetList = ENGLISH_LETTERS.toLowerCase().chars().mapToObj(c -> (char) c).toList();

    static char[] getCryptArrayAlphabet() {
        return CRYPT_ALPHABET_ARRAY;
    }

    static int getCryptAlphabetArrayLength() {
        return CRYPT_ALPHABET_ARRAY.length;
    }


}
