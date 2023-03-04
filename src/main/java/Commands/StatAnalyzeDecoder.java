package ru.javarush.cryptoanalyzer.konovalov.Commands;

import ru.javarush.cryptoanalyzer.konovalov.data.Constants;
import ru.javarush.cryptoanalyzer.konovalov.entity.Result;
import ru.javarush.cryptoanalyzer.konovalov.entity.ResultCode;
import ru.javarush.cryptoanalyzer.konovalov.exception.AppException;
import ru.javarush.cryptoanalyzer.konovalov.util.PathBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;


public class StatAnalyzeDecoder extends AnalyzeHelper implements Action {

    private static HashMap<Character, Character> charPairs;

    @Override
    public Result execute(String[] parameters) {
        String encryptedText = parameters[0];
        String dictionary = parameters[1];
        String analyzedText = parameters[2];

        charPairs = createPairsForSwap(encryptedText, analyzedText);

        decodeEncryptedText(encryptedText, dictionary);

        return new Result(ResultCode.OK, analyzedText);
    }


    private void decodeEncryptedText(String encryptedText, String resultText) {

        Path source = PathBuilder.getPath(encryptedText);
        Path target = PathBuilder.getPath(resultText);

        try (BufferedReader reader = Files.newBufferedReader(source);
             BufferedWriter writer = Files.newBufferedWriter(target)) {

            String currentLine = reader.readLine().toLowerCase();

            while (currentLine != null) {
                String cryptoLine = decodeLine(currentLine);
                writer.write(cryptoLine);
                writer.append('\n');
                currentLine = reader.readLine() != null ? reader.readLine().toLowerCase() : null;
            }

        } catch (NullPointerException e) {
            throw new AppException(Constants.EMPTY_FILE + e.getMessage(), e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String decodeLine(String line) {

        String[] linesArray = line.split(" ");

        StringBuilder newWord = new StringBuilder();
        ArrayList<StringBuilder> encodedLine = new ArrayList<>();
        Character newSymbol;
        char symbol;

        for (String encodedWord : linesArray) {
            for (int j = 0; j < encodedWord.length(); j++) {

                symbol = encodedWord.charAt(j);
                newSymbol = charPairs.getOrDefault(symbol, symbol);
                newWord.append(newSymbol.toString());
            }
            encodedLine.add(newWord);
            newWord = new StringBuilder();
        }

        return String.join(" ", encodedLine);
    }


}

