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
import java.util.HashMap;

import static ru.javarush.cryptoanalyzer.konovalov.data.Alphabet.*;


import java.nio.file.Path;

public interface CaesarAction extends Action {

    default Result applyCipherKey(String mainText, String resultText, int key) {

        HashMap<Character, Character> caesarCipherMap = createCharPairs(key);

        doCaesarCiphering(mainText, resultText, caesarCipherMap);

        return new Result(ResultCode.OK, resultText);
    }


    private HashMap<Character, Character> createCharPairs(int key) {

        HashMap<Character, Character> map = new HashMap<>(getAlphabetLength());

        char[] alphabet = getAlphabet();

        char cryptValue;

        if (key >= 0) {
            for (int i = 0; i < alphabet.length; i++) {
                cryptValue = i + key <= alphabet.length - 1 ? alphabet[i + key] : alphabet[(key - (alphabet.length - i))];
                map.put(alphabet[i], cryptValue);
            }
        } else {
            for (int i = 0; i < alphabet.length; i++) {
                cryptValue = i - key < 0 ? alphabet[alphabet.length - (key - i)] : alphabet[i - key];
                map.put(alphabet[i], cryptValue);
            }
        }

        return map;
    }


    private void doCaesarCiphering(String mainText, String resultText, HashMap<Character, Character> cryptMap) {
        Path source = PathBuilder.getPath(mainText);
        Path target = PathBuilder.getPath(resultText);

        try (BufferedReader reader = Files.newBufferedReader(source);
             BufferedWriter writer = Files.newBufferedWriter(target)) {

            String currentLine = reader.readLine().toLowerCase();

            while (currentLine != null) {

                String cryptoLine = cipherLine(currentLine, cryptMap);
                writer.write(cryptoLine);
                currentLine = reader.readLine();
                String lowerCaseLine = currentLine != null ? currentLine.toLowerCase() : null;
                if (lowerCaseLine != null) {
                    writer.append('\n');
                }
            }
        }
        catch (NullPointerException e){
            throw new AppException(Constants.EMPTY_FILE+ e.getMessage(),e);
        }
        catch (IOException  e) {
            throw new AppException(Constants.INCORRECT_FILE + e.getMessage(), e);
        }
    }

    private String cipherLine(String line, HashMap<Character, Character> cryptMap) {
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
