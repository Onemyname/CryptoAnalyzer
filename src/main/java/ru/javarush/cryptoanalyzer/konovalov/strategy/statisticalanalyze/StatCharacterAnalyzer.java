package ru.javarush.cryptoanalyzer.konovalov.strategy.statisticalanalyze;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static ru.javarush.cryptoanalyzer.konovalov.data.CryptAlphabetArray.getAlphabetList;
import static ru.javarush.cryptoanalyzer.konovalov.reader.Reader.getReader;
import static ru.javarush.cryptoanalyzer.konovalov.util.PathFinder.getRoot;

public class StatCharacterAnalyzer {

    public static int getTotalNumberOFfCharacters() {
        return totalNumberOFfCharacters;
    }

    public static void setTotalNumberOFfCharacters(int totalNumberOFfCharacters) {
        StatCharacterAnalyzer.totalNumberOFfCharacters = totalNumberOFfCharacters;
    }

    private static int totalNumberOFfCharacters;

    private static HashMap<Character, Double> mapPercentageOfCharactersInEncryptedFile = new HashMap<>();
    private static HashMap<Character, Double> mapPercentageOfCharactersInExampleFile = new HashMap<>();

    public static HashMap<Character, Character> getMapForDecodeEncryptedText(String encryptedText, String exampleText) {

        mapPercentageOfCharactersInEncryptedFile = getMapPercentageCharactersStatistic(encryptedText);

        mapPercentageOfCharactersInExampleFile = getMapPercentageCharactersStatistic(exampleText);


        HashMap<Character, Character> mapForDecodeEncryptedText = createMapForDecodeEncryptedText(mapPercentageOfCharactersInEncryptedFile, mapPercentageOfCharactersInExampleFile);

        return mapForDecodeEncryptedText;
    }

    private static HashMap<Character, Double> getMapPercentageCharactersStatistic(String filename) {
        setTotalNumberOFfCharacters(0);
        HashMap<Character, Double> map = new HashMap<>();
        try (BufferedReader reader = getReader(getRoot() + filename)) {
            String currentLine = reader.readLine();
            while (currentLine != null) {
                analyzeLine(currentLine, map);
                currentLine = reader.readLine();
            }
            convertMapInPercentageOfTotalUsingCharacters(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    private static void analyzeLine(String line, HashMap<Character, Double> map) {

        String[] linesArray = line.split(" ");

        for (String encodedWord : linesArray) {
            for (int j = 0; j < encodedWord.length(); j++) {

                char symbol = encodedWord.charAt(j);
                setTotalNumberOFfCharacters(getTotalNumberOFfCharacters() + 1);
                if(!getAlphabetList().contains(symbol)){
                    continue;
                }
                if (map.containsKey(symbol)) {
                    map.put(symbol, (map.get(symbol) + 1));
                } else {
                    map.put(symbol, 1.0);
                }
            }
        }
    }

    private static void convertMapInPercentageOfTotalUsingCharacters(HashMap<Character, Double> map) {
        Iterator<Map.Entry<Character, Double>> itr = map.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<Character, Double> entry = itr.next();
            entry.setValue(entry.getValue() / getTotalNumberOFfCharacters());
        }
    }


    private static HashMap<Character, Character> createMapForDecodeEncryptedText(HashMap<Character, Double> encryptedMap, HashMap<Character, Double> exampleMap) {

        return null;
    }


}
