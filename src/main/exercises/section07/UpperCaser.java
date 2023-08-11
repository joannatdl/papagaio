package exercises.section07;

public class UpperCaser {
    public String createOutputFor(String input) {
        if (input.isBlank()) return "";
        if (input.length() == 1) return input;
        String output = "";
        String currentLetter;
        char[] inputArray = input.toCharArray();
        for(int i = 0; i < inputArray.length; i++) {
            currentLetter = String.valueOf(inputArray[i]);
            output = output.concat((i % 2 == 1) ? currentLetter.toUpperCase() : currentLetter);
        }
        return output;
    }
}
