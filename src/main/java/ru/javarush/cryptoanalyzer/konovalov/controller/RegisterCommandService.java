package ru.javarush.cryptoanalyzer.konovalov.controller;

import ru.javarush.cryptoanalyzer.konovalov.exception.UnknownCommandException;

import java.util.InputMismatchException;

import static ru.javarush.cryptoanalyzer.konovalov.controller.Menu.COMMAND_MUST_BE_NUMERIC;
import static ru.javarush.cryptoanalyzer.konovalov.controller.Menu.WRONG_COMMAND;
import static ru.javarush.cryptoanalyzer.konovalov.io.Printable.println;

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

    public static void enterCorrectCommand(int userCommand) {
        try {
            if (userCommand >= 0 && userCommand < CommandsInfo.values().length) {
                setChosenCommand(userCommand);
                setStatusCommand(true);
            } else {
                throw new UnknownCommandException(WRONG_COMMAND.toString());
            }
        } catch (UnknownCommandException e) {
            println(e.getMessage());
        } catch (InputMismatchException e) {
            println(COMMAND_MUST_BE_NUMERIC);
        }
    }
}
