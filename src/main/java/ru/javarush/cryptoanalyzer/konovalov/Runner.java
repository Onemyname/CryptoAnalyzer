package ru.javarush.cryptoanalyzer.konovalov;
/*
String[] args[] for this program

String [0] - number of operationMode
Caesar Encoder - {0, file.txt, resultFile.txt, key from 1 to 50}
Caesar Decoder - {1, encryptedFile.txt, resultFile.txt, key from 1 to 65 = getCryptAlphabetArrayLength()-1}
BruteForceDecoder - {2, encryptedFile.txt, resultFile.txt, Vocabulary.txt}
Statistical Analysis Decoder {3, encryptedFile.txt, resultFile.txt,example.txt }
Exit {4}
 */

import ru.javarush.cryptoanalyzer.konovalov.app.Application;
import ru.javarush.cryptoanalyzer.konovalov.controller.Commands;
import ru.javarush.cryptoanalyzer.konovalov.controller.MainController;

import java.io.IOException;

import static ru.javarush.cryptoanalyzer.konovalov.printer.Printable.println;

public class Runner {
    public static void main(String[] args) {

        MainController mainController = new MainController();
        Application application = new Application(mainController);

        application.startVerification();
        try {
            if (args.length == 0) {
                String[] parameters = new String[Commands.values().length - 1];
                parameters = application.parseParameters(parameters);
                application.runProgramCryptAnalyzer(parameters);
            } else {
                application.runProgramCryptAnalyzer(args);
            }
        } catch (IOException e) {
            println(e.getMessage());
        }
    }
}
