package com.aidanmurphey.mapmorsecodetranslator;

import java.util.HashMap;

public class Translator {

    private HashMap<String, Character> toEnglishMap;

    public Translator() {
        //Initialize morse code -> english map
        toEnglishMap = new HashMap<>();
        toEnglishMap.put(".-", 'A');
        toEnglishMap.put("-...", 'B');
        toEnglishMap.put("-.-.", 'C');
        toEnglishMap.put("-..", 'D');
        toEnglishMap.put(".", 'E');
        toEnglishMap.put("..-.", 'F');
        toEnglishMap.put("--.", 'G');
        toEnglishMap.put("....", 'H');
        toEnglishMap.put("..", 'I');
        toEnglishMap.put(".---", 'J');
        toEnglishMap.put("-.-", 'K');
        toEnglishMap.put(".-..", 'L');
        toEnglishMap.put("--", 'M');
        toEnglishMap.put("-.", 'N');
        toEnglishMap.put("---", 'O');
        toEnglishMap.put(".--.", 'P');
        toEnglishMap.put("--.-", 'Q');
        toEnglishMap.put(".-.", 'R');
        toEnglishMap.put("...", 'S');
        toEnglishMap.put("-", 'T');
        toEnglishMap.put("..-", 'U');
        toEnglishMap.put("...-", 'V');
        toEnglishMap.put(".--", 'W');
        toEnglishMap.put("-..-", 'X');
        toEnglishMap.put("-.--", 'Y');
        toEnglishMap.put("--..", 'Z');
        toEnglishMap.put("|", ' ');
    }

    public String toEnglish(String line) {
        StringBuilder output = new StringBuilder();
        String curLetter = "";

        for(char c : line.toCharArray()) {
            if (c == '|') {
                curLetter = "";
                output.append(" ");
            } else if (c == '-' || c == '.') {
                curLetter += c;
            } else if (!curLetter.equals("") && !curLetter.equals(" ")) {
                output.append(letterToEnglish(curLetter));
                curLetter = "";
            }

        }

        return output.toString();
    }

    public String toMorseCode(String line) {
        StringBuilder output = new StringBuilder();
        for(char c : line.toUpperCase().toCharArray()) {
            output.append(letterToMorseCode(c)).append(" ");
        }

        //Replace fina
        output.replace(output.length() - 1, output.length(), "#");
        return output.toString();
    }

    private char letterToEnglish(String morseCodeLetter) {
        return toEnglishMap.getOrDefault(morseCodeLetter, ' ');
    }

    private String letterToMorseCode(char letter) {
        StringBuilder stringBuilder = new StringBuilder("");

        toEnglishMap.forEach((k, v) -> {
            if (v == letter)
                stringBuilder.append(k);
        });

        return stringBuilder.toString();
    }

}
