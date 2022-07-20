package ru.javarush.cryptoanalyzer.konovalov.strategy.statisticalanalyze;

import ru.javarush.cryptoanalyzer.konovalov.strategy.Actionable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static ru.javarush.cryptoanalyzer.konovalov.printer.Printable.println;
import static ru.javarush.cryptoanalyzer.konovalov.reader.Reader.getReader;
import static ru.javarush.cryptoanalyzer.konovalov.strategy.statisticalanalyze.StatCharacterAnalyzer.getMapForDecodeEncryptedText;
import static ru.javarush.cryptoanalyzer.konovalov.util.PathFinder.getRoot;
import static ru.javarush.cryptoanalyzer.konovalov.writer.Writer.getWriter;


public class StatAnalyzeDecoder implements Actionable {


    private static HashMap<Character, Character> mapForDecodeEncryptedText = new HashMap<>();

    public void action(String[] args) { // {encryptedFile.txt, resultFile.txt, example.txt}
        println("Decryption attempt");

        mapForDecodeEncryptedText = getMapForDecodeEncryptedText(args[0], args [2]);

        for (Map.Entry<Character, Character> entry : mapForDecodeEncryptedText.entrySet()) {
            Character key = entry.getKey();
            System.out.print("key: " + key + " ");
            Character value = entry.getValue();
            System.out.print("value: " + value);
            System.out.println("");
        }

        decodeEncryptedText(args[0], args[1]);
    }

    private static void decodeEncryptedText(String encryptedText, String resultFile) {
        try (BufferedReader reader = getReader(getRoot() + encryptedText);
             BufferedWriter writer = getWriter(getRoot() + resultFile)) {
            String currentLine = reader.readLine();
            while (currentLine != null) {
                String cryptoLine = decodeLine(currentLine);
                writer.write(cryptoLine);
                writer.append('\n');
                currentLine = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String decodeLine(String line) {

        String[] linesArray = line.split(" ");

        StringBuilder newWord = new StringBuilder();
        ArrayList<StringBuilder> encodedLine = new ArrayList<>();
        Character newSymbol;

        for (String encodedWord : linesArray) {
            for (int j = 0; j < encodedWord.length(); j++) {

                char symbol = encodedWord.charAt(j);
                newSymbol = mapForDecodeEncryptedText.get(symbol);
                newWord.append(newSymbol.toString());
            }
            encodedLine.add(newWord);
            newWord = new StringBuilder();
        }
        return String.join(" ", encodedLine);
    }

}












/*
 System.out.println("Number of characters " + getTotalNumbersOfCharactersInText());

        for (Map.Entry<Character, Double> entry : mapPercentageOfCharactersEncryptedText.entrySet()) {
            Character key = entry.getKey();
            System.out.print("key: " + key + " ");
            Double value = entry.getValue();
            System.out.print("value: " + value);
            System.out.println("");
        }

                System.out.println("Number of characters " + getTotalNumbersOfCharactersInText());

        for (Map.Entry<Character, Double> entry : mapPercentageOfCharactersExampleText.entrySet()) {
            Character key = entry.getKey();
            System.out.print("key: " + key + " ");
            Double value = entry.getValue();
            System.out.print("value: " + value);
            System.out.println("");
        }
 */
