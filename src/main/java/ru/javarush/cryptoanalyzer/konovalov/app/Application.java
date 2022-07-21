package ru.javarush.cryptoanalyzer.konovalov.app;

import ru.javarush.cryptoanalyzer.konovalov.controller.CommandsInfo;
import ru.javarush.cryptoanalyzer.konovalov.controller.MainController;

import java.util.Arrays;

import static ru.javarush.cryptoanalyzer.konovalov.controller.RegisterCommandService.getChosenCommand;


public class Application {
    private static MainController mainController;

    public Application(MainController mainController) {
        Application.mainController = mainController;
    }

    public void runProgramCryptAnalyzer(String[] args) {
        int command = Integer.parseInt(args[0]);
        String[] parameters = Arrays.copyOfRange(args, 1, args.length);

        mainController.execute(command, parameters);
    }

    public void startVerification() {
        mainController.registerUser();
    }

    /**
     * Collects the necessary data from user for encryption or decryption
     * @return Filled array with data to perform specific mode
     */
    public String[] parseParameters() {
        String[] parameters = new String[CommandsInfo.values().length - 1];

        parameters[0] = String.valueOf(mainController.selectOperationMode());
        parameters[1] = mainController.selectFile();
        parameters[2] = mainController.selectFile();
        //For Caesar Encoder-Decoder need key
        if (getChosenCommand() == 0 || getChosenCommand() == 1) {
            parameters[3] = String.valueOf(mainController.selectKey());
        }
        //For BrutForce need vocabulary, for StatAnalyzeDecoder need text by the same author
        else if (getChosenCommand() == 2 || getChosenCommand() == 3) {
            parameters[3] = mainController.selectFile();
        }

        return parameters;
    }
}
