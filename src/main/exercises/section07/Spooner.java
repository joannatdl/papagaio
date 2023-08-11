package exercises.section07;

import java.util.Arrays;

public class Spooner {
    private static final String VOWELS = "aeiou";
    public static String transpose(String input) {
        String[] words = input.split("\\s");
        if (words.length != 2) { return input; }
        StringBuilder newWordsBuilder = new StringBuilder();
        int i = 0; // i stores index of first vowel in first word
        int j = 0; // j stores index of first vowel in second word
        while (i < words[0].length() && VOWELS.indexOf(words[0].toCharArray()[i]) == -1) { i++; }
        while (j < words[1].length() && VOWELS.indexOf(words[1].toCharArray()[j]) == -1) { j++; }
        return String.format("%s%s %s%s", words[1].substring(0, j), words[0].substring(i),
                                          words[0].substring(0, i), words[1].substring(j));
    }
}
