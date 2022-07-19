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
import static ru.javarush.cryptoanalyzer.konovalov.registeruser.UserRegisterService.enterCorrectUserName;
import static ru.javarush.cryptoanalyzer.konovalov.strategy.Navigator.*;
import static ru.javarush.cryptoanalyzer.konovalov.util.PathFinder.*;
import static ru.javarush.cryptoanalyzer.konovalov.printer.Printable.println;
import static ru.javarush.cryptoanalyzer.konovalov.scanner.Scannerable.readIntFromConsole;
import static ru.javarush.cryptoanalyzer.konovalov.scanner.Scannerable.readLineFromConsole;

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

    public static void execute(int command, String[] parameters) throws IOException {
        switch (command) {
            case 0:
                runCaesarEncoder(parameters);
                break;
            case 1:
                runCaesarDecoder(parameters);
                break;
            case 2:
                runBruteForceDecoder(parameters);
                break;
            case 3:
                runStatisticalAnalysisDecoder(parameters);
                break;
            case 4:
                handleExit();

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
        if (getChosenCommand() == 4) {
            handleExit();
        } else {
            switch (getChosenCommand()) {
                case 0:
                    println(CAESAR_ENCODER.toString());
                    break;
                case 1:
                    println(CAESAR_DECODER.toString());
                    break;
                case 2:
                    println(BRUTE_FORCE_DECODER.toString());
                    break;
                case 3:
                    println(STATISTICAL_ANALYSIS_DECODER.toString());
            }
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
                println(COMMAND_MUST_BE_NUMERIC + "(value from 1 to 100)");
            }
        }
        while (!isCorrectCryptKey());
        return getCryptKey();
    }

    public static String selectFile() {
        String filename;
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
