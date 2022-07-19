package ru.javarush.cryptoanalyzer.konovalov.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    public static BufferedWriter getWriter(String filePath) throws IOException {

        FileWriter fIleWriter = new FileWriter(filePath);
        BufferedWriter writer = new BufferedWriter(fIleWriter);
        return writer;
        }

    }
