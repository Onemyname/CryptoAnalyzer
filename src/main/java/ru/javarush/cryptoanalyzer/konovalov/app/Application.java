package ru.javarush.cryptoanalyzer.konovalov.app;

import ru.javarush.cryptoanalyzer.konovalov.controller.MainController;

import java.io.IOException;
import java.util.Arrays;

import static ru.javarush.cryptoanalyzer.konovalov.controller.RegisterCommandService.getChosenCommand;


public class Application {
    private static MainController mainController;

    public Application(MainController mainController) {
        Application.mainController = mainController;
    }

    public void runProgramCryptAnalyzer(String[] args) throws IOException {
        int command = Integer.parseInt(args[0]);
        String[] parameters = Arrays.copyOfRange(args, 1, args.length);
        mainController.execute(command, parameters);
    }

    public void startVerification() {
        MainController.registerUser();
    }

    public String[] parseParameters(String[] parameters) {
        parameters[0] = String.valueOf(MainController.selectOperationMode());
        parameters[1] = MainController.selectFile();
        parameters[2] = MainController.selectFile();

        if (getChosenCommand() == 0 || getChosenCommand() == 1) {
            parameters[3] = String.valueOf(MainController.selectKey());
        } else if (getChosenCommand() == 2 || getChosenCommand() == 3) {
            parameters[3] = MainController.selectFile();
        }

        return parameters;
    }
}
