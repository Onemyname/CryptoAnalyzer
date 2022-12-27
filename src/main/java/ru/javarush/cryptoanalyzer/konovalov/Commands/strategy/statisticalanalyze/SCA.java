
//public class StatCharacterAnalyzer {
//
//    public static int getTotalChars() {
//        return totalChars;
//    }
//
//    public static void setTotalChars(int totalChars) {
//        StatCharacterAnalyzer.totalChars = totalChars;
//    }
//
//    private static int totalChars;
//
//    public static HashMap<Character, Character> getMapForDecodeEncryptedText(String encryptedText, String exampleText) {
//
//        HashMap<Character, Double> encryptedCharsPercentage = getCharsPercentage(encryptedText);
//        HashMap<Character, Double> exampleCharsPercentage = getCharsPercentage(exampleText);
//
//        return createMapForDecodeEncryptedText(encryptedCharsPercentage,
//                exampleCharsPercentage);
//    }
//
//    private static HashMap<Character, Double> getCharsPercentage(String filename) {
//        setTotalChars(0);
//        HashMap<Character, Double> map = new HashMap<>();
//
//        try (BufferedReader reader = getReader(getRoot() + filename)) {
//            String lowerCaseLine = reader.readLine().toLowerCase();
//            while (lowerCaseLine != null) {
//                analyzeLine(lowerCaseLine, map);
//                String currentLine = reader.readLine();
//                lowerCaseLine = currentLine !=null? currentLine.toLowerCase() : null;
//            }
//            for (Map.Entry<Character, Double> entry : map.entrySet()) {
//                entry.setValue(entry.getValue() / getTotalChars());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return map;
//    }
//
//    private static void analyzeLine(String line, HashMap<Character, Double> map) {
//
//        String[] linesArray = line.split(" ");
//
//        for (String encodedWord : linesArray) {
//            for (int j = 0; j < encodedWord.length(); j++) {
//
//                char symbol = encodedWord.charAt(j);
//                setTotalChars(getTotalChars() + 1);
//                if (!getAlphabetList().contains(symbol)) {
//                    continue;
//                }
//                if (map.containsKey(symbol)) {
//                    map.put(symbol, (map.get(symbol) + 1));
//                } else {
//                    map.put(symbol, 1.0);
//                }
//            }
//        }
//    }
//
//    private static HashMap<Character, Character> createMapForDecodeEncryptedText(HashMap<Character, Double> encryptedMap, HashMap<Character, Double> exampleMap) {
//
//        Map<Character, Double> sortedEncryptedMap = sortMap(encryptedMap, false);
//        Map<Character, Double> sortedExampleMap = sortMap(exampleMap, false);
//
//        return compareMaps(sortedEncryptedMap, sortedExampleMap);
//    }
//
//private static Map<Character, Double> sortMap(Map<Character, Double> unsortedMap, boolean order)
//    {
//        List<Map.Entry<Character, Double>> list = new LinkedList<>(unsortedMap.entrySet());
//
//        // Sorting the list based on values
//        list.sort((o1, o2) -> order ? o1.getValue().compareTo(o2.getValue()) == 0
//                ? o1.getKey().compareTo(o2.getKey())
//                : o1.getValue().compareTo(o2.getValue()) : o2.getValue().compareTo(o1.getValue()) == 0
//                ? o2.getKey().compareTo(o1.getKey())
//                : o2.getValue().compareTo(o1.getValue()));
//
//        return list.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));
//
//    }
//    private static HashMap<Character, Character> compareMaps(Map<Character, Double> sortedEncryptedMap,
//                                                             Map<Character, Double> sortedExampleMap) {
//
//        HashMap<Character, Character> resultMap = new HashMap<>();
//        Iterator<Map.Entry<Character, Double>> itr = sortedEncryptedMap.entrySet().iterator();
//        Iterator<Map.Entry<Character, Double>> itr2 = sortedExampleMap.entrySet().iterator();
//
//        while (itr.hasNext() && itr2.hasNext()) {
//            Map.Entry<Character, Double> entry = itr.next();
//            Map.Entry<Character, Double> entryExample = itr2.next();
//            resultMap.put(entry.getKey(), entryExample.getKey());
//        }
//
//        return resultMap;
//    }
//}
