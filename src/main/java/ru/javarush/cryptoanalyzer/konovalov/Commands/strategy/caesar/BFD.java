
//public class BruteDecoder {
//    public void codingInformation(String[] parameters) {
//
//
//        String[] encryptedLine = readFile(parameters[0]);
//        String[] exampleLine = readFile(parameters[2]);
//
//        bruteForceLine(encryptedLine, exampleLine, parameters[1]);
//
//
//    }
//    static String[] readFile(String file) {
//        StringBuilder sb = new StringBuilder();
//
//        try (BufferedReader reader = getReader(getRoot() + file)) {
//            String currentLine;
//            while ((currentLine = reader.readLine()) != null) {
//                sb.append("\n" + currentLine);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return sb.toString().split(" ");
//    }
//    static void bruteForceLine(String[] encryptedLine, String[] exampleLine, String resultFile) {
//        List<String> exampleArrayList = new ArrayList<>(Arrays.asList(exampleLine));
//        HashMap<Character, Character> map = new HashMap<>(getCryptAlphabetArrayLength());
//        char[] alphabet = getCryptArrayAlphabet();
//        char cryptValue;
//
//        for (int key = 1; key <= getCryptAlphabetArrayLength()-1; key++) {    //for each possible key
//            for (int i = 0; i < alphabet.length; i++) { // we change every symbol
//                cryptValue = i - key < 0 ? alphabet[alphabet.length - (key - i)] : alphabet[i - key]; //same as in CaesarDecoding
//                map.put(alphabet[i], cryptValue);
//            }
//            List<StringBuilder> toCheck = decodeLine(encryptedLine, map);
//            List<String> stringsToCheck = new ArrayList<>();
//
//            for(StringBuilder sb : toCheck){
//                stringsToCheck.add(sb.toString());
//            }
//            if (stringsToCheck.stream().anyMatch(exampleArrayList::contains)) { //comparing decoded list to example list
//                int countMatches = 0;
//                int needMatches = 1;
//                int totalWords = 100;
//
//                if (stringsToCheck.size() > totalWords) {
//                    needMatches = stringsToCheck.size() / totalWords;
//                }
//
//                for (String s : stringsToCheck) {
//                    //if there is any match - check for others
//                    if(exampleArrayList.contains(s)) {
//                        countMatches++;
//                    }
//
//                    if (countMatches >= needMatches) {
//                        println("Key is found! It's " + key);
//                        writeResult(resultFile, stringsToCheck);
//
//                        return;
//                    }
//                }
//            }
//        }
//    }
//    static List<StringBuilder> decodeLine(String[] encryptedLinesArray, HashMap<Character, Character> map) {
//        StringBuilder newWord = new StringBuilder();
//        List<StringBuilder> encodedLine = new ArrayList<>();
//        Character newSymbol;
//
//        for (String encodedWord : encryptedLinesArray) {
//            for (int j = 0; j < encodedWord.length(); j++) {
//
//                char symbol = encodedWord.charAt(j);
//                char lowerSymbol = Character.toLowerCase(symbol);
//                boolean isLowerCase = symbol == lowerSymbol;
//
//                newSymbol = map.getOrDefault(lowerSymbol, symbol);
//                newWord.append(isLowerCase ? newSymbol.toString() : newSymbol.toString().toUpperCase());
//            }
//            encodedLine.add(newWord);
//            newWord = new StringBuilder();
//        }
//
//        return encodedLine;
//    }
//
//    static void writeResult(String resultFile, List<String> toCheck){
//        try(BufferedWriter writer = getWriter(getRoot() + resultFile)){
//            String result = String.join(" ", toCheck);
//            writer.write(result);
//            if(result!=null) {
//                writer.append('\n');
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//}
