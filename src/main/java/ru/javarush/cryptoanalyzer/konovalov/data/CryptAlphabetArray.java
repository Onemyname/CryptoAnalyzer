package ru.javarush.cryptoanalyzer.konovalov.data;

import java.util.List;

import static ru.javarush.cryptoanalyzer.konovalov.data.Alphabet.*;

public class CryptAlphabetArray {

    private static final String ALL_ALPHABET = ENGLISH_LETTERS.toString().toLowerCase();

    private static final char[] CRYPT_ALPHABET_ARRAY = ALL_ALPHABET.toCharArray();

    public static List<Character> getAllAlphabetList() {
        return allAlphabetList;
    }

    private static List<Character> allAlphabetList = ALL_ALPHABET.chars().mapToObj(c -> (char) c).toList();

    public static List<Character> getAlphabetList() {
        return alphabetList;
    }

    private static List<Character> alphabetList = ENGLISH_LETTERS.toString().toLowerCase().chars().mapToObj(c -> (char) c).toList();

    public static char[] getCryptArrayAlphabet() {
        return CRYPT_ALPHABET_ARRAY;
    }

    public static int getCryptAlphabetArrayLength() {
        return CRYPT_ALPHABET_ARRAY.length;
    }

}
