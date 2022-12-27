package ru.javarush.cryptoanalyzer.konovalov.view;

import ru.javarush.cryptoanalyzer.konovalov.Commands.Action;
import ru.javarush.cryptoanalyzer.konovalov.data.Constants;

public interface Messages {
    String[][][] QUESTIONS = new String[][][]{
            {
                    {Action.ENCODE},
                    {"Enter source (full path OR only filename OR Enter for text.txt) :", "text.txt"},
                    {"Enter destination (full path OR only filename OR Enter for encrypted.txt) :", "encrypted.txt"},
                    {"Enter key (int number OR Enter for key = 1) :", "1"},
            },
            {
                    {Action.DECODE},
                    {"Enter source (full path OR only filename OR Enter for encrypted.txt) :", "encrypted.txt"},
                    {"Enter destination (full path OR only filename OR Enter for decrypted.txt) :", "decrypted.txt"},
                    {"Enter key (int number OR Enter for key = 1) :", "1"},
            },
            {
                    {Action.BRUTEFORCE},
                    {"Enter source (full path OR only filename OR Enter for encrypted.txt) :", "encrypted.txt"},
                    {"Enter destination (full path OR only filename OR Enter for bruteforce.txt) :", "bruteforce.txt"},
            },
            {
                    {Action.ANALYZE},
                    {"Enter source (full path OR only filename OR Enter for encrypted.txt) :", "encrypted.txt"},
                    {"Enter dictionary  (full path OR only filename OR Enter for dictionary.txt) :", "dictionary.txt"},
                    {"Enter destination (full path OR only filename OR Enter for analyzed.txt) :", "analyzed.txt"},
            },
            {
                    {"Exit"},
            }
    };
    String INCORRECT_SELECTION_MODE = "Incorrect selection!";

    String LINE = "-".repeat(20);
    String ANSI_RESET = "\u001B[0m";
    String ANSI_BLUE = "\u001B[34m";
    String ANSI_CYAN = "\u001B[36m";
    String ANSI_PURPLE = "\u001B[35m";
    String ANSI_GREEN = "\u001B[32m";

    String OK_FORMAT = ANSI_GREEN + """
            Operation complete
            Result: %s
            """+ ANSI_RESET;
    String ERROR_FORMAT = ANSI_PURPLE + """
            Operation not completed. Error.
            Message: %s
            """+ ANSI_RESET;;


    String MESSAGE_SELECT_MODE = LINE +
            ANSI_BLUE + "\nPlease select mode:\n" + ANSI_CYAN + """
            1. Encrypt
            2. Decrypt
            3. Brute force
            4. Analyze
            5. Exit
            """ + ANSI_RESET + LINE;
}
