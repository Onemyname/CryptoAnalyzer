package ru.javarush.cryptoanalyzer.konovalov.controller;

import ru.javarush.cryptoanalyzer.konovalov.registeruser.UserRegisterService;
import ru.javarush.cryptoanalyzer.konovalov.strategy.CryptoNavigator;
import ru.javarush.cryptoanalyzer.konovalov.strategy.CryptoStrategy;

import java.util.Arrays;
import java.util.Iterator;

import static ru.javarush.cryptoanalyzer.konovalov.controller.Menu.EXIT;
import static ru.javarush.cryptoanalyzer.konovalov.data.CryptoKey.*;
import static ru.javarush.cryptoanalyzer.konovalov.io.Printable.println;
import static ru.javarush.cryptoanalyzer.konovalov.io.Scannerable.readIntFromConsole;
import static ru.javarush.cryptoanalyzer.konovalov.io.Scannerable.readLineFromConsole;
import static ru.javarush.cryptoanalyzer.konovalov.util.PathFinder.*;

public class MainController {

    public void userRegister() {
        UserRegisterService service = new UserRegisterService();
        service.registerCorrectName();
    }

    public void execute(String command, String[] parameters) {
        Commands commands = new Commands();
        CryptoStrategy cryptoStrategy = commands.getCryptoObject(command);
        CryptoNavigator cryptoNavigator = new CryptoNavigator(cryptoStrategy);
        cryptoNavigator.codingInformation(parameters);
    }

    public String [] createParameters(){

        int totalParameters = 4;
        String [] parameters = new String[totalParameters];

        parameters[0] = selectOperationMode();
        parameters[1] = selectFile();
        parameters[2] = сreateFile();
        parameters[3] = parameters[0].equals("encode") || parameters[0].equals("decode") ? selectKey() : selectFile();

        return parameters;
    }


    public String selectOperationMode() {
String [] java = new String[];
        Iterator<String> it = Arrays.stream(java).iterator();
        it.hasNext();
        // The loop runs until the correct command is entered
        do {
            enterCorrectCommand(readIntFromConsole());
        }
        while (!isStatusCommand());

        return null;
    }
    public String selectKey() {
        do {
            setCryptKey(readIntFromConsole());
        }
        while (!isNotCorrectCryptKey());

        return getCryptKey();
    }

    public String selectFile() {
        // The loop runs until the correct filename is entered and filename exists in directory "CryptoAnalyzer/text"
        do {
            setFileName(readLineFromConsole());
        }
        while (!isFileNotExist());
        setFileExist(false);

        return getFileName();
    }

    private void handleExit() {
        println(EXIT.toString());
        System.exit(0);
    }
}