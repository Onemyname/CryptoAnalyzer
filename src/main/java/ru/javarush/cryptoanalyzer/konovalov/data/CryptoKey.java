package ru.javarush.cryptoanalyzer.konovalov.data;

import ru.javarush.cryptoanalyzer.konovalov.exception.WrongValueOfCryptoKeyException;

import java.util.InputMismatchException;

import static ru.javarush.cryptoanalyzer.konovalov.controller.Menu.COMMAND_MUST_BE_NUMERIC;
import static ru.javarush.cryptoanalyzer.konovalov.data.CryptAlphabetArray.getCryptAlphabetArrayLength;
import static ru.javarush.cryptoanalyzer.konovalov.io.Printable.println;

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

    public static void setCryptKey(int key) {
        try {
            if (key > 0 && key <= getCryptAlphabetArrayLength() - 1) {
                setCorrectCryptKey(true);
                cryptKey = key;
            } else {
                throw new WrongValueOfCryptoKeyException("You have entered a non-correct value");
            }
        } catch (WrongValueOfCryptoKeyException e) {
            println(e.getMessage());
        } catch (InputMismatchException e) {
            println(COMMAND_MUST_BE_NUMERIC);
        }
    }
}
