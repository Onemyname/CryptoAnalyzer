package ru.javarush.cryptoanalyzer.konovalov.controller;

import ru.javarush.cryptoanalyzer.konovalov.exception.UnknownCommandException;

import static ru.javarush.cryptoanalyzer.konovalov.controller.Menu.WRONG_COMMAND;

public class RegisterCommandService {

    private static boolean statusCommand = false;
    private static int chosenCommand;

    public static boolean isStatusCommand() {
        return statusCommand;
    }

    public static void setStatusCommand(boolean statusCommand) {
        RegisterCommandService.statusCommand = statusCommand;
    }

    public static int getChosenCommand() {
        return chosenCommand;
    }

    public static void setChosenCommand(int chosenCommand) {
        RegisterCommandService.chosenCommand = chosenCommand;
    }

    public static void enterCorrectCommand(int userCommand) throws UnknownCommandException {
        if (userCommand >= 0 && userCommand < Commands.values().length) {
            setChosenCommand(userCommand);
            setStatusCommand(true);
        } else {
            throw new UnknownCommandException(WRONG_COMMAND.toString());
        }


    }
}
