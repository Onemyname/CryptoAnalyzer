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

    private static final String ALPHABET_WITHOUT_CIPHERS = ENGLISH_LETTERS +
            ENGLISH_LETTERS.toString().toLowerCase() + SYMBOLS;

    private static final char[] CRYPT_ALPHABET_ARRAY = ALL_ALPHABET.toCharArray();

    public static List<Character> getAlphabetList() {
        return alphabetList;
    }

    private static List<Character> alphabetList = ALPHABET_WITHOUT_CIPHERS.chars().mapToObj(c -> (char) c).toList();

    public static char[] getCryptArrayAlphabet() {
        return CRYPT_ALPHABET_ARRAY;
    }

    public static int getCryptAlphabetArrayLength() {
        return CRYPT_ALPHABET_ARRAY.length;
    }

}
