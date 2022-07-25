package ru.javarush.cryptoanalyzer.konovalov.app;

import ru.javarush.cryptoanalyzer.konovalov.controller.MainController;

import java.util.Arrays;


public class Application {
    private MainController mainController;

    public Application(MainController mainController) {
        this.mainController = mainController;
    }

    public void runCryptoAnalyzer(String[] args) {
        mainController.userRegister();

        String command = args[0];
        String[] parameters = Arrays.copyOfRange(args, 1, args.length);
        mainController.execute(command, parameters);
    }

    /**
     * Collects the necessary data from user for encryption or decryption
     * @return Filled array with data to perform specific mode
     */
    public String[] fillParameters() {

        return mainController.createParameters();
    }


    public String[] checkValidParameters(String [] parameters){
    return null;
    }
}
