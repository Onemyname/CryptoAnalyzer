package ru.javarush.cryptoanalyzer.konovalov.io;

import java.io.*;

public class Reader {
    public static BufferedReader getReader(String filePath) throws FileNotFoundException {
    FileReader fileReader = new FileReader(filePath);

        return new BufferedReader(fileReader);
}
}
