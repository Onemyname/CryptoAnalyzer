package ru.javarush.cryptoanalyzer.konovalov.strategy.statisticalanalyze;

import ru.javarush.cryptoanalyzer.konovalov.strategy.CryptoStrategy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static ru.javarush.cryptoanalyzer.konovalov.io.Printable.println;
import static ru.javarush.cryptoanalyzer.konovalov.io.Reader.getReader;
import static ru.javarush.cryptoanalyzer.konovalov.io.Writer.getWriter;
import static ru.javarush.cryptoanalyzer.konovalov.util.PathFinder.getRoot;


public class StatAnalyzeDecoder implements CryptoStrategy {


    private HashMap<Character, Character> mapForDecodeEncryptedText = new HashMap<>();

    public void codingInformation(String[] args) { // {encryptedFile.txt, resultFile.txt, example.txt}


        mapForDecodeEncryptedText = getMapForDecodeEncryptedText(args[0], args[2]);
        decodeEncryptedText(args[0], args[1]);

    }

    private void decodeEncryptedText(String encryptedText, String resultFile) {

        try (BufferedReader reader = getReader(getRoot() + encryptedText);
             BufferedWriter writer = getWriter(getRoot() + resultFile)) {

            String currentLine = reader.readLine().toLowerCase();

            while (currentLine != null) {
                String cryptoLine = decodeLine(currentLine);
                writer.write(cryptoLine);
                writer.append('\n');
                currentLine = reader.readLine()!=null? reader.readLine().toLowerCase() : null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String decodeLine(String line) {

        String[] linesArray = line.split(" ");

        StringBuilder newWord = new StringBuilder();
        ArrayList<StringBuilder> encodedLine = new ArrayList<>();
        Character newSymbol;

        for (String encodedWord : linesArray) {
            for (int j = 0; j < encodedWord.length(); j++) {

                char symbol = encodedWord.charAt(j);
                newSymbol = mapForDecodeEncryptedText.getOrDefault(symbol,symbol);
                newWord.append(newSymbol.toString());
            }
            encodedLine.add(newWord);
            newWord = new StringBuilder();
        }

        return String.join(" ", encodedLine);
    }
}
