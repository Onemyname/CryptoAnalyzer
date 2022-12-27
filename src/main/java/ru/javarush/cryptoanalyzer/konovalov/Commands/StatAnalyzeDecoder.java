//package ru.javarush.cryptoanalyzer.konovalov.Commands;
//
//import ru.javarush.cryptoanalyzer.konovalov.entity.Result;
//import ru.javarush.cryptoanalyzer.konovalov.entity.ResultCode;
//import ru.javarush.cryptoanalyzer.konovalov.util.PathBuilder;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.ArrayList;
//import java.util.HashMap;
//
//import static ru.javarush.cryptoanalyzer.konovalov.Commands.strategy.caesar.SCA.getMapForDecodeEncryptedText;
//
//public class StatAnalyzeDecoder implements Action {
//
//    private static HashMap<Character, Character> mapForDecodeEncryptedText;
//
//    @Override
//    public Result execute(String[] parameters) {
//        String encryptedText = parameters[0];
//        String dictionary = parameters[1];
//        String analyzedText = parameters[2];
//
//        return new Result(ResultCode.OK, analyzedText);
//    }
//
//
//
//
//    public void codingInformation(String[] args) { // {encryptedFile.txt, resultFile.txt, example.txt}
//
//        mapForDecodeEncryptedText = getMapForDecodeEncryptedText(args[0], args[2]);
//        decodeEncryptedText(args[0], args[1]);
//
//    }
//
//    private static void decodeEncryptedText(String encryptedText, String resultText) {
//
//        Path source = PathBuilder.getPath(encryptedText);
//        Path target = PathBuilder.getPath(resultText);
//
//        try (BufferedReader reader = Files.newBufferedReader(source);
//             BufferedWriter writer = Files.newBufferedWriter(target)) {
//
//            String currentLine = reader.readLine().toLowerCase();
//
//            while (currentLine != null) {
//                String cryptoLine = decodeLine(currentLine);
//                writer.write(cryptoLine);
//                writer.append('\n');
//                currentLine = reader.readLine() != null ? reader.readLine().toLowerCase() : null;
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static String decodeLine(String line) {
//
//        String[] linesArray = line.split(" ");
//
//        StringBuilder newWord = new StringBuilder();
//        ArrayList<StringBuilder> encodedLine = new ArrayList<>();
//        Character newSymbol;
//        char symbol;
//
//        for (String encodedWord : linesArray) {
//            for (int j = 0; j < encodedWord.length(); j++) {
//
//                symbol = encodedWord.charAt(j);
//                newSymbol = mapForDecodeEncryptedText.getOrDefault(symbol, symbol);
//                newWord.append(newSymbol.toString());
//            }
//            encodedLine.add(newWord);
//            newWord = new StringBuilder();
//        }
//
//        return String.join(" ", encodedLine);
//    }
//
//
//}
//
