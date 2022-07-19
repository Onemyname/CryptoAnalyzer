package ru.javarush.cryptoanalyzer.konovalov.strategy.CaesarMethod;

import ru.javarush.cryptoanalyzer.konovalov.strategy.Actionable;

import java.io.IOException;
import java.util.HashMap;

import static ru.javarush.cryptoanalyzer.konovalov.controller.RegisterCommandService.getChosenCommand;
import static ru.javarush.cryptoanalyzer.konovalov.strategy.CaesarMethod.CaesarMainCommandService.createCaesarCryptHashMap;
import static ru.javarush.cryptoanalyzer.konovalov.strategy.CaesarMethod.CaesarMainCommandService.encodeOrDecodeFile;
import static ru.javarush.cryptoanalyzer.konovalov.printer.Printable.println;

public class CaesarDecoder implements Actionable {
    public void action(String[] parameters) {
        println("Decryption attempt");
        HashMap<Character, Character> cryptMap = createCaesarCryptHashMap(Integer.valueOf(parameters[2]), getChosenCommand());
        try {
            encodeOrDecodeFile(parameters[0], parameters[1], cryptMap);
        } catch (IOException e) {
            println("Error");
        }
    }
}
