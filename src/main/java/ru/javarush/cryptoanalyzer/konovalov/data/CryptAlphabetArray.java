package ru.javarush.cryptoanalyzer.konovalov.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static ru.javarush.cryptoanalyzer.konovalov.data.Alphabet.*;

public class CryptAlphabetArray {

    private static final String ALL_ALPHABET = NUMBERS.toString() + ENGLISH_LETTERS +
            ENGLISH_LETTERS.toString().toLowerCase() + SYMBOLS;

    private static final char[] CRYPT_ALPHABET_ARRAY = ALL_ALPHABET.toCharArray();

    public static List<Character> getAlphabetList() {
        return alphabetList;
    }

    public static void setAlphabetList(List<Character> alphabetList) {
        CryptAlphabetArray.alphabetList = alphabetList;
    }

    private static List<Character> alphabetList = ALL_ALPHABET.chars().mapToObj(c -> (char) c).toList();

    public static char[] getCryptArrayAlphabet() {
        return CRYPT_ALPHABET_ARRAY;
    }

    public static int getCryptAlphabetArrayLength() {
        return CRYPT_ALPHABET_ARRAY.length;
    }

}
