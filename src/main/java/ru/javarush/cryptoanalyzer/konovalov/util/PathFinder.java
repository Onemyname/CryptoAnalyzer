package ru.javarush.cryptoanalyzer.konovalov.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PathFinder {


    public static void setFileExist(boolean fileExist) {
        PathFinder.fileExist = fileExist;
    }

    private static boolean fileExist = false;
    private static String fileName;

    public static String getFileName() {
        return fileName;
    }

    public static void setFileName(String fileName) {
        try {
            if (isFileExist(fileName)) {
                PathFinder.fileName = fileName;
            } else {
                throw new FileNotFoundException("File doesn`t exist!");
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static boolean isFileExist(String fileName) {
        Files.exists(Path.of(getRoot() + fileName));
        return fileExist;
    }
    public static String getRoot() {
        String root = System.getProperty("user.dir");
        return root + File.separator + "text" + File.separator;
    }

    public static void createFile(String filename){
        if(!isFileExist(filename)){
            File newFile = new File(getRoot()+filename);
        }
    }

    }
