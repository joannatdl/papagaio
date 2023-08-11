package exercises.section07;

import java.util.Arrays;

public class Spooner {
    private static final Character[] VOWELS = {'a', 'e', 'i', 'o', 'u'};
    public static String transpose(String input) {
        String[] words = input.split("\\s");
        if (words.length != 2) { return input; }
        String[] newWords  = new String[2];
        int i = 0; // i stores index of first vowel in first word
        int j = 0; // j stores index of first vowel in second word
        for (i = 0; i < words[0].length(); i++) {
            if (Arrays.asList(VOWELS).contains(words[0].toCharArray()[i])) {
                for (j = 0; j < words[1].length(); j++) {
                    if (Arrays.asList(VOWELS).contains(words[1].toCharArray()[j])) {
                        break;
                    }
                }
                break;
            }
        }
        newWords[0] = words[1].substring(0, j) + words[0].substring(i);
        newWords[1] = words[0].substring(0, i) + words[1].substring(j);
        return String.join(" ", newWords);
    }
}
