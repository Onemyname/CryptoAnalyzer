package ru.javarush.cryptoanalyzer.konovalov.strategy.CaesarMethod;

/*
(Brute Force)
 */


import ru.javarush.cryptoanalyzer.konovalov.strategy.Actionable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

import static ru.javarush.cryptoanalyzer.konovalov.data.CryptAlphabetArray.getCryptAlphabetArrayLength;
import static ru.javarush.cryptoanalyzer.konovalov.data.CryptAlphabetArray.getCryptArrayAlphabet;
import static ru.javarush.cryptoanalyzer.konovalov.printer.Printable.println;
import static ru.javarush.cryptoanalyzer.konovalov.reader.Reader.getReader;
import static ru.javarush.cryptoanalyzer.konovalov.util.PathFinder.getRoot;
import static ru.javarush.cryptoanalyzer.konovalov.writer.Writer.getWriter;

public class BruteForceDecoder implements Actionable {
    public void action(String[] parameters) { //{ encryptedFile.txt, resultFile.txt, example.txt}
        println("Brute force decryption attempt");
        String[] encryptedLine = readFile(parameters[0]);
        String[] exampleLine = readFile(parameters[2]); //set of language key words like he she it and but the etc
        bruteForceLine(encryptedLine,exampleLine,parameters[1]);
    }
    static String[] readFile(String file) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader readerE = getReader(getRoot() + file)) {
            String currentLine;
            while ((currentLine = readerE.readLine()) != null) {
                sb.append("\n" + currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] splitedLine = sb.toString().split(" ");
        return splitedLine;
    }
    static void bruteForceLine(String[] encryptedLine, String[] exampleLine, String resultFile) {
        List<String> exampleArrayList = new ArrayList<>();
        for (String s : exampleLine) {
            exampleArrayList.add(s);
        }
        char[] alphabet = getCryptArrayAlphabet();
        HashMap<Character, Character> map = new HashMap<>(getCryptAlphabetArrayLength());
        char cryptValue;
        for (int key = 1; key <= 50; key++) {    //for each possible key
            for (int i = 0; i < alphabet.length; i++) { // we change every symbol
                if (i - key < 0){
                    cryptValue = alphabet[alphabet.length - (key - i)];
                } else {
                    cryptValue = alphabet[i-key];
                }
                //cryptValue = i - key < 0 ? alphabet[alphabet.length - (key - i)] : alphabet[i - key]; //same as in CaesarDecoding
                map.put(alphabet[i], cryptValue);
            }
            List<StringBuilder> toCheck = decodeLine(encryptedLine, map);
            List<String> stringsToCheck = new ArrayList<>();
            for(StringBuilder sb : toCheck){
                stringsToCheck.add(sb.toString());
            }
            if (stringsToCheck.stream().anyMatch(exampleArrayList::contains)) { //comparing decoded list to example list
                int countMatches = 0;
                int needMatches = 1;
                if (stringsToCheck.size() > 100) {
                    needMatches = stringsToCheck.size()/100;
                }
                for (String s : stringsToCheck) { //if there is any match - check for others
                    if(exampleArrayList.contains(s)) {
                        countMatches++;
                    }
                    if (countMatches >= needMatches) {
                        println("Key is found! It's " + key);
                        writeResult(resultFile, stringsToCheck);
                        return;
                    }
                }
            }
        }
    }
    static List<StringBuilder> decodeLine(String[] encryptedLinesArray, HashMap<Character, Character> map) {
        StringBuilder newWord = new StringBuilder();
        List<StringBuilder> encodedLine = new ArrayList<>();
        Character newSymbol;
        for (String encodedWord : encryptedLinesArray) {
            for (int j = 0; j < encodedWord.length(); j++) {
                char symbol = encodedWord.charAt(j);
                newSymbol = map.getOrDefault(symbol, symbol);
                newWord.append(newSymbol.toString());
            }
            encodedLine.add(newWord);
            newWord = new StringBuilder();
        }
        return encodedLine;
        //return
    }
    static void writeResult(String resultFile, List<String> toCheck){
        try(BufferedWriter writer = getWriter(getRoot() + resultFile)){
            String result = String.join(" ", toCheck);
            writer.write(result.toString());
            writer.append('\n');
        }catch (IOException e){
            System.out.println("resultFile not found!");
        }
    }
}
