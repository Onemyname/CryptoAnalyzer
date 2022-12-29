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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static ru.javarush.cryptoanalyzer.konovalov.data.Alphabet.getAlphabet;
import static ru.javarush.cryptoanalyzer.konovalov.data.Alphabet.getAlphabetLength;

public class BruteForceDecoder implements Action {
    @Override
    public Result execute(String[] parameters) {

        String[] encryptedLine = readFile(parameters[0]);
        String resultFile = parameters[1];
        String[] exampleLine = readFile(parameters[2]);
        bruteForceLine(encryptedLine, exampleLine, parameters[1]);

        return new Result(ResultCode.OK, resultFile);
    }


    private String[] readFile(String file) {
        Path source = PathBuilder.getPath(file);
        StringBuilder sb = new StringBuilder();
        String currentLine;

        try (BufferedReader reader = Files.newBufferedReader(source)) {

            while ((currentLine = reader.readLine()) != null) {
                sb.append("\n").append(currentLine);
            }

        }
        catch (NullPointerException e){
            throw new AppException(Constants.EMPTY_FILE+ e.getMessage(),e);
        }
        catch (IOException e) {
            throw new AppException(Constants.INCORRECT_FILE + e.getMessage(), e);
        }

        return sb.toString().split(" ");
    }


    private void bruteForceLine(String[] encryptedLine, String[] exampleLine, String resultFile) {
        List<String> exampleArrayList = new ArrayList<>(Arrays.asList(exampleLine));
        HashMap<Character, Character> map = new HashMap<>(getAlphabetLength());
        List<StringBuilder> toCheck;
        List<String> stringsToCheck;

        char[] alphabet = getAlphabet();
        char cryptValue;

        for (int key = 1; key <= getAlphabetLength() - 1; key++) {    //for each possible key
            for (int i = 0; i < alphabet.length; i++) { // we change every symbol
                cryptValue = i - key < 0 ? alphabet[alphabet.length - (key - i)] : alphabet[i - key]; //same as in CaesarDecoding
                map.put(alphabet[i], cryptValue);
            }
            toCheck = decodeLine(encryptedLine, map);
            stringsToCheck = new ArrayList<>();

            for (StringBuilder sb : toCheck) {
                stringsToCheck.add(sb.toString());
            }
            if (stringsToCheck.stream().anyMatch(exampleArrayList::contains)) { //comparing decoded list to example list
                int countMatches = 0;
                int needMatches = 1;
                int totalWords = 100;

                if (stringsToCheck.size() > totalWords) {
                    needMatches = stringsToCheck.size() / totalWords;
                }

                for (String s : stringsToCheck) {
                    //if there is any match - check for others
                    if (exampleArrayList.contains(s)) {
                        countMatches++;
                    }

                    if (countMatches >= needMatches) {
                        writeResult(resultFile, stringsToCheck);

                        return;
                    }
                }
            }
        }
    }

    private List<StringBuilder> decodeLine(String[] encryptedLinesArray, HashMap<Character, Character> map) {
        StringBuilder newWord = new StringBuilder();
        List<StringBuilder> encodedLine = new ArrayList<>();
        Character newSymbol;
        char symbol;
        char lowerSymbol;
        boolean isLowerCase;

        for (String encodedWord : encryptedLinesArray) {

            for (int j = 0; j < encodedWord.length(); j++) {
                symbol = encodedWord.charAt(j);
                lowerSymbol = Character.toLowerCase(symbol);
                isLowerCase = symbol == lowerSymbol;
                newSymbol = map.getOrDefault(lowerSymbol, symbol);
                newWord.append(isLowerCase ? newSymbol.toString() : newSymbol.toString().toUpperCase());
            }

            encodedLine.add(newWord);
            newWord = new StringBuilder();
        }

        return encodedLine;
    }

    private void writeResult(String resultFile, List<String> toCheck) {
        Path target = PathBuilder.getPath(resultFile);

        try (BufferedWriter writer = Files.newBufferedWriter(target)) {
            String result = String.join(" ", toCheck);
            writer.write(result);
            writer.append('\n');
        } catch (IOException e) {
            throw new AppException(Constants.INCORRECT_FILE + e.getMessage(), e);
        }
    }
}
