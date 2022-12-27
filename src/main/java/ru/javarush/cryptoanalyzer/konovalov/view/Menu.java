package ru.javarush.cryptoanalyzer.konovalov.view;

import java.util.Scanner;

import static ru.javarush.cryptoanalyzer.konovalov.view.Messages.*;

public class Menu {
    private final Scanner SCANNER;

    public Menu(Scanner scanner) {
        this.SCANNER = scanner;
    }

    public String[] getArgs() {
        int mode = getMode(SCANNER);
        String [] args = new String[QUESTIONS[mode].length];
        args[0] = QUESTIONS[mode][0][0];
        for (int i = 1; i < args.length; i++) {
            String quest = QUESTIONS[mode][i][0];
            System.out.println(quest);
            String answer = SCANNER.nextLine();
            args[i] = "".equals(answer.trim()) ? QUESTIONS[mode][i][1] : answer;
        }
            return args;
    }

    private int getMode(Scanner scanner) {
        int mode;

        do {
            System.out.println(MESSAGE_SELECT_MODE);
            String input = scanner.nextLine();
            mode = switch (input) {
                case "1" -> 0;
                case "2" -> 1;
                case "3" -> 2;
                case "4" -> 3;
                case "5" -> 4;
                default -> {
                    System.out.println(INCORRECT_SELECTION_MODE);
                    yield -1;
                }
            };
        } while (mode < 0);
        return mode;


    }
}
