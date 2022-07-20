package ru.javarush.cryptoanalyzer.konovalov.data;

import ru.javarush.cryptoanalyzer.konovalov.exception.WrongValueOfCryptoKeyException;

import static ru.javarush.cryptoanalyzer.konovalov.data.CryptAlphabetArray.getCryptAlphabetArrayLength;

public class CryptoKey {


    private static int cryptKey = 0;
    private static boolean correctCryptKey = false;

    public static boolean isCorrectCryptKey() {
        return correctCryptKey;
    }

    public static void setCorrectCryptKey(boolean correctCryptKey) {
        CryptoKey.correctCryptKey = correctCryptKey;
    }

    public static int getCryptKey() {
        return cryptKey;
    }

    public static void setCryptKey(int key) throws WrongValueOfCryptoKeyException {
        if (key > 0 && key <= getCryptAlphabetArrayLength()-1) {
            setCorrectCryptKey(true);
            cryptKey = key;
        } else {
            throw new WrongValueOfCryptoKeyException("You have entered a non-correct value");
        }
    }
}
