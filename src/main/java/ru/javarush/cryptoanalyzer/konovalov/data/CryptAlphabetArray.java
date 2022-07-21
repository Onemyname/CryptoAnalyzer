package ru.javarush.cryptoanalyzer.konovalov.data;

import java.util.List;

public class CryptAlphabetArray {

    //In order for the Caesar cipher and statistical analysis to work well at the same time, the alphabet contains only letters
    private static final String ENGLISH_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALL_ALPHABET = ENGLISH_LETTERS.toLowerCase();

    private static final char[] CRYPT_ALPHABET_ARRAY = ALL_ALPHABET.toCharArray();

    public static List<Character> getAlphabetList() {
        return alphabetList;
    }

    private static final List<Character> alphabetList = ENGLISH_LETTERS.toLowerCase().chars().mapToObj(c -> (char) c).toList();

    public static char[] getCryptArrayAlphabet() {
        return CRYPT_ALPHABET_ARRAY;
    }

    public static int getCryptAlphabetArrayLength() {
        return CRYPT_ALPHABET_ARRAY.length;
    }

}
