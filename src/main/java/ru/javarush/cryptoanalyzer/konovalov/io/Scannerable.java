package ru.javarush.cryptoanalyzer.konovalov.io;

import java.util.Scanner;

public interface Scannerable {

    static String readLineFromConsole() {
        Scanner console = new Scanner(System.in);
        return console.nextLine();
    }
    static int readIntFromConsole(){
        Scanner console = new Scanner(System.in);
        return console.nextInt();
    }
}