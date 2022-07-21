package ru.javarush.cryptoanalyzer.konovalov.strategy.caesar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static ru.javarush.cryptoanalyzer.konovalov.data.CryptAlphabetArray.getCryptAlphabetArrayLength;
import static ru.javarush.cryptoanalyzer.konovalov.data.CryptAlphabetArray.getCryptArrayAlphabet;
import static ru.javarush.cryptoanalyzer.konovalov.io.Reader.getReader;
import static ru.javarush.cryptoanalyzer.konovalov.io.Writer.getWriter;
import static ru.javarush.cryptoanalyzer.konovalov.util.PathFinder.getRoot;

public class CaesarService {

    static HashMap<Character, Character> createCaesarCryptHashMap(int key, int command) {
        HashMap<Character, Character> map = new HashMap<>(getCryptAlphabetArrayLength());
        char[] alphabet = getCryptArrayAlphabet();
        char cryptValue;

        if (command == 0) {
            for (int i = 0; i < alphabet.length; i++) {
                cryptValue = i + key <= alphabet.length - 1 ? alphabet[i + key] : alphabet[(key - (alphabet.length - i))];
                map.put(alphabet[i], cryptValue);
            }
        } else if (command == 1) {
            for (int i = 0; i < alphabet.length; i++) {
                cryptValue = i - key < 0 ? alphabet[alphabet.length - (key - i)] : alphabet[i - key];
                map.put(alphabet[i], cryptValue);
            }
        }

        return map;
    }

    static void encodeOrDecodeFile(String fileToEncrypt, String resultFile, HashMap<Character, Character> cryptMap) {
        try (BufferedReader reader = getReader(getRoot() + fileToEncrypt);
             BufferedWriter writer = getWriter(getRoot() + resultFile)) {
            String currentLine = reader.readLine().toLowerCase();

            while (currentLine != null) {

                String cryptoLine = encodeOrDecodeLine(currentLine, cryptMap);
                writer.write(cryptoLine);
                currentLine = reader.readLine();
                String lowerCaseLine = currentLine != null ? currentLine.toLowerCase() : null;
                if (lowerCaseLine != null) {
                    writer.append('\n');
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String encodeOrDecodeLine(String line, HashMap<Character, Character> cryptMap) {
        char newSymbol;
        StringBuilder newLine = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {

            Character lowerCaseSymbol = Character.toLowerCase(line.charAt(i));
            boolean isLowerCase = line.charAt(i) == lowerCaseSymbol;
            newSymbol = cryptMap.getOrDefault(lowerCaseSymbol, lowerCaseSymbol);
            newLine.append(isLowerCase ? newSymbol : Character.toUpperCase(newSymbol));
        }
        return newLine.toString();
    }
}

