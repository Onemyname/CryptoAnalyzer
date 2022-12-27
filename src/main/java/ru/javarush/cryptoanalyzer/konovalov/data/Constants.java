package ru.javarush.cryptoanalyzer.konovalov.data;

import java.io.File;

public interface Constants {

    String TXT_FOLDER = System.getProperty("user.dir") +
            File.separator +
            "text" +
            File.separator;
    String INCORRECT_FILE = "Incorrect file: ";
    String APPLICATION_CLOSED = "application closed";


}
