package ru.javarush.cryptoanalyzer.konovalov.controller;


import ru.javarush.cryptoanalyzer.konovalov.exception.EnteredFileNotExistException;
import ru.javarush.cryptoanalyzer.konovalov.exception.NameContainsNumbersOrSymbolsException;
import ru.javarush.cryptoanalyzer.konovalov.exception.UnknownCommandException;
import ru.javarush.cryptoanalyzer.konovalov.exception.WrongValueOfCryptoKeyException;
import ru.javarush.cryptoanalyzer.konovalov.registeruser.User;

import java.io.IOException;
import java.util.InputMismatchException;

import static ru.javarush.cryptoanalyzer.konovalov.controller.Commands.*;
import static ru.javarush.cryptoanalyzer.konovalov.controller.Menu.*;
import static ru.javarush.cryptoanalyzer.konovalov.controller.RegisterCommandService.*;
import static ru.javarush.cryptoanalyzer.konovalov.data.CryptoKey.*;
import static ru.javarush.cryptoanalyzer.konovalov.io.Printable.println;
import static ru.javarush.cryptoanalyzer.konovalov.registeruser.UserRegisterService.enterCorrectUserName;
import static ru.javarush.cryptoanalyzer.konovalov.io.Scannerable.readIntFromConsole;
import static ru.javarush.cryptoanalyzer.konovalov.io.Scannerable.readLineFromConsole;
import static ru.javarush.cryptoanalyzer.konovalov.strategy.Navigator.*;
import static ru.javarush.cryptoanalyzer.konovalov.util.PathFinder.*;

public class MainController {

    public static void registerUser() {
        println(WELCOME_STRING);
        do {                                                // The loop runs until the correct name is entered
            try {
                enterCorrectUserName(readLineFromConsole());
            } catch (NameContainsNumbersOrSymbolsException e) {
                System.out.println(e.getMessage());
            }
        }
        while (!User.getUserNameIsRight());
        System.out.println("Welcome, " + User.getUserName() + "!");
    }

    public  void execute(int command, String[] parameters) throws IOException {
        switch (command) {
            case 0 -> runCaesarEncoder(parameters);
            case 1 -> runCaesarDecoder(parameters);
            case 2 -> runBruteForceDecoder(parameters);
            case 3 -> runStatisticalAnalysisDecoder(parameters);
            case 4 -> handleExit();
        }
    }

    public static int selectOperationMode() {
        println(SELECT_OPERATION_MODES);
        do {
            try {
                enterCorrectCommand(readIntFromConsole());
            } catch (UnknownCommandException e) {
                println(e.getMessage());
            } catch (InputMismatchException e) {
                println(COMMAND_MUST_BE_NUMERIC);
            }
        }
        while (!isStatusCommand());

        switch (getChosenCommand()) {
            case 0 -> println(CAESAR_ENCODER.toString());
            case 1 -> println(CAESAR_DECODER.toString());
            case 2 -> println(BRUTE_FORCE_DECODER.toString());
            case 3 -> println(STATISTICAL_ANALYSIS_DECODER.toString());
            case 4 -> handleExit();
        }

        return getChosenCommand();
    }

    public static int selectKey() {
        println(SELECT_CRYPT_KEY);

        do {
            try {
                setCryptKey(readIntFromConsole());
            } catch (WrongValueOfCryptoKeyException e) {
                println(e.getMessage());
            } catch (InputMismatchException e) {
                println(COMMAND_MUST_BE_NUMERIC);
            }
        }
        while (!isCorrectCryptKey());

        return getCryptKey();
    }

    public static String selectFile() {
        do {
            try {
                checkExistenceOfFile(readLineFromConsole());
            } catch (EnteredFileNotExistException e) {
                println(e.getMessage());
            }
        }
        while (!isFileExist());
        setFileExist(false);

        return getFileName();
    }

    public static void handleExit() {
        println(EXIT.toString());
        System.exit(0);
    }
}
