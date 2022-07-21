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

import ru.javarush.cryptoanalyzer.konovalov.app.Application;
import ru.javarush.cryptoanalyzer.konovalov.controller.MainController;

public class Runner {
    public static void main(String[] args) {

        MainController mainController = new MainController();
        Application application = new Application(mainController);

        //Registering the user name
        application.startVerification();

        if (args.length == 0) {
            //Requests data from user for run program
            String[] parameters = application.parseParameters();
            application.runProgramCryptAnalyzer(parameters);
        } else {
            application.runProgramCryptAnalyzer(args);
        }
    }
}
