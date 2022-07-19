package ru.javarush.cryptoanalyzer.konovalov.data;

import static ru.javarush.cryptoanalyzer.konovalov.data.Alphabet.*;

public class CryptAlphabetArray {

    private static final String ALL_ALPHABET = NUMBERS.toString() + RUSSIAN_LETTERS +
            RUSSIAN_LETTERS.toString().toLowerCase() + SYMBOLS;

    private static final char[] CRYPT_ALPHABET_ARRAY = ALL_ALPHABET.toCharArray();

    public static char[] getCryptArrayAlphabet() {
        return CRYPT_ALPHABET_ARRAY;
    }

    public static int getCryptAlphabetArrayLength() {
        return CRYPT_ALPHABET_ARRAY.length;
    }

}
