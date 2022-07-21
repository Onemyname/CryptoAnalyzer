package ru.javarush.cryptoanalyzer.konovalov.controller;

import ru.javarush.cryptoanalyzer.konovalov.registeruser.User;

import static ru.javarush.cryptoanalyzer.konovalov.controller.CommandsInfo.*;
import static ru.javarush.cryptoanalyzer.konovalov.controller.Menu.*;
import static ru.javarush.cryptoanalyzer.konovalov.controller.RegisterCommandService.*;
import static ru.javarush.cryptoanalyzer.konovalov.data.CryptoKey.*;
import static ru.javarush.cryptoanalyzer.konovalov.io.Printable.println;
import static ru.javarush.cryptoanalyzer.konovalov.io.Scannerable.readIntFromConsole;
import static ru.javarush.cryptoanalyzer.konovalov.io.Scannerable.readLineFromConsole;
import static ru.javarush.cryptoanalyzer.konovalov.registeruser.UserRegisterService.enterCorrectUserName;
import static ru.javarush.cryptoanalyzer.konovalov.strategy.CryptoNavigator.*;
import static ru.javarush.cryptoanalyzer.konovalov.util.PathFinder.*;

public class MainController {

    public static void registerUser() {
        println(WELCOME_STRING);

        // The loop runs until the correct name is entered
        do {
            enterCorrectUserName(readLineFromConsole());
        }
        while (!User.getUserNameIsRight());

        System.out.println("Welcome, " + User.getUserName() + "!");
    }

    public void execute(int command, String[] parameters) {
        switch (command) {
            case 0 -> runCaesarEncoder(parameters);
            case 1 -> runCaesarDecoder(parameters);
            case 2 -> runBruteForceDecoder(parameters);
            case 3 -> runStatAnalyzeDecoder(parameters);
            case 4 -> handleExit();
        }
    }

    public static int selectOperationMode() {
        println(SELECT_OPERATION_MODES);

        // The loop runs until the correct command is entered
        do {
            enterCorrectCommand(readIntFromConsole());
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

        // The loop runs until the correct key is entered
        do {
            setCryptKey(readIntFromConsole());
        }
        while (!isCorrectCryptKey());

        return getCryptKey();
    }

    public static String selectFile() {
        // The loop runs until the correct filename is entered and filename exists in directory "CryptoAnalyzer/text"
        do {
            checkExistenceOfFile(readLineFromConsole());
        }
        while (!isFileExist());
        setFileExist(false);

        return getFileName();
    }

    private static void handleExit() {
        println(EXIT.toString());
        System.exit(0);
    }
}
