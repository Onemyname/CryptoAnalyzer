package ru.javarush.cryptoanalyzer.konovalov.strategy.CaesarMethod;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import static ru.javarush.cryptoanalyzer.konovalov.io.Reader.getReader;
import static ru.javarush.cryptoanalyzer.konovalov.io.Writer.getWriter;
import static ru.javarush.cryptoanalyzer.konovalov.data.CryptAlphabetArray.getCryptAlphabetArrayLength;
import static ru.javarush.cryptoanalyzer.konovalov.data.CryptAlphabetArray.getCryptArrayAlphabet;
import static ru.javarush.cryptoanalyzer.konovalov.util.PathFinder.getRoot;

public class CaesarMainCommandService {

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

    static void encodeOrDecodeFile(String fileToEncrypt, String resultFile, HashMap<Character, Character> cryptMap) throws IOException {
        try (BufferedReader reader = getReader(getRoot() + fileToEncrypt);
             BufferedWriter writer = getWriter(getRoot() + resultFile))
        {
            String currentLine = reader.readLine().toLowerCase();
            while (currentLine != null) {
                String cryptoLine = encodeOrDecodeLine(currentLine, cryptMap);
                writer.write(cryptoLine);
                writer.append('\n');
                currentLine = reader.readLine() != null ? reader.readLine().toLowerCase() : null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String encodeOrDecodeLine(String line, HashMap<Character, Character> cryptMap) {

        String[] linesArray = line.split(" ");

        StringBuilder newWord = new StringBuilder();
        ArrayList<StringBuilder> encodedLine = new ArrayList<>();
        Character newSymbol;


        for (String encodedWord : linesArray) {
            for (int j = 0; j < encodedWord.length(); j++) {

                char symbol = encodedWord.charAt(j);

                newSymbol = cryptMap.getOrDefault(symbol, symbol);
                newWord.append(newSymbol.toString());
            }
            encodedLine.add(newWord);
            newWord = new StringBuilder();
        }
        return String.join(" ", encodedLine);
    }
}
