package ru.javarush.cryptoanalyzer.konovalov;

import ru.javarush.cryptoanalyzer.konovalov.controller.MainController;
import ru.javarush.cryptoanalyzer.konovalov.view.ConsoleApp;
import ru.javarush.cryptoanalyzer.konovalov.view.Menu;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Menu menu = new Menu(input);

        MainController mainController = new MainController();

        ConsoleApp consoleApp = new ConsoleApp(mainController, menu);

        consoleApp.run(args);

    }
}
