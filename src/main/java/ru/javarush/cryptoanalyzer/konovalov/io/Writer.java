package ru.javarush.cryptoanalyzer.konovalov.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    public static BufferedWriter getWriter(String filePath) throws IOException {

        FileWriter fIleWriter = new FileWriter(filePath);

        return new BufferedWriter(fIleWriter);
        }

    }
