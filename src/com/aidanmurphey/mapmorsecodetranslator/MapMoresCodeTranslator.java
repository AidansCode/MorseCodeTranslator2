package com.aidanmurphey.mapmorsecodetranslator;

public class MapMoresCodeTranslator {

    public static void main(String[] args) {
        Translator translator = new Translator();

        String original = "I LOVE PROGRAMMING";
        String asMorseCode = translator.toMorseCode(original);
        String backToEnglish = translator.toEnglish(asMorseCode);

        System.out.println("Original: " + original);
        System.out.println("To Morse Code: " + asMorseCode);
        System.out.println("Back to English: " + backToEnglish);
    }

}
