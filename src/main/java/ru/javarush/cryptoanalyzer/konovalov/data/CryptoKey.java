package ru.javarush.cryptoanalyzer.konovalov.data;

import ru.javarush.cryptoanalyzer.konovalov.exception.WrongValueOfCryptoKeyException;

import java.util.InputMismatchException;

import static ru.javarush.cryptoanalyzer.konovalov.data.CryptAlphabetArray.getCryptAlphabetArrayLength;

public class CryptoKey {


    private static int cryptKey = 0;
    private static boolean correctCryptKey = false;

    public static boolean isNotCorrectCryptKey() {
        return correctCryptKey;
    }

    public static void setCorrectCryptKey(boolean correctCryptKey) {
        CryptoKey.correctCryptKey = correctCryptKey;
    }

    public static String getCryptKey() {
        return String.valueOf(cryptKey);
    }

    public static void setCryptKey(int key) {
        try {
            if (key > 0 && key <= getCryptAlphabetArrayLength() - 1) {
                setCorrectCryptKey(true);
                cryptKey = key;
            } else {
                throw new WrongValueOfCryptoKeyException("You have entered a non-correct value");
            }
        } catch (WrongValueOfCryptoKeyException | InputMismatchException e) {
            e.printStackTrace();
        }
    }
}
