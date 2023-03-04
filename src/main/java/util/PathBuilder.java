package ru.javarush.cryptoanalyzer.konovalov.util;

import java.io.File;
import java.nio.file.Path;

public class PathBuilder {
    private PathBuilder() {

    }

    public static String getTXT_FOLDER() {
        return TXT_FOLDER;
    }

    private static final String TXT_FOLDER = System.getProperty("user.dir") + File.separator + "text" + File.separator;

    public static Path getPath(String filename) {
        Path path = Path.of(filename);
        return path.isAbsolute() ? path : Path.of(getTXT_FOLDER() + filename);

    }
}
