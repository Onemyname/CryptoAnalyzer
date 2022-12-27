package ru.javarush.cryptoanalyzer.konovalov;
/*
String[] args[] for this program

String [0] - number of operationMode
Caesar Encoder - {0, file.txt, resultFile.txt, key from 1 to 50}
Caesar Decoder - {1, encryptedFile.txt, resultFile.txt, key from 1 to 65 = getCryptAlphabetArrayLength()-1}
BruteForceDecoder - {2, encryptedFile.txt, resultFile.txt, vocabulary.txt}
Statistical Analysis Decoder {3, encryptedFile.txt, resultFile.txt,example.txt }
Exit {4}
 */

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
