package exercises.section03;

public class Playground {
    public static void main(String[] args) {

//    2. Write code that replaces the word “cat” with the word “dog” wherever it shows up in a
//    sentence.
        String replacedSentence = "This is a sentence with two words: 'cat' and 'dog'.".replace("cat", "dog");
        System.out.println(replacedSentence);

//        3. How can you make sure when people enter text into a program, there are no unintended
//        spaces at the beginning or end of the text?
        String textWithNoUnintendedSpaces = "    In this text there were unintended spaces at the beginning.".stripLeading();
        System.out.println(textWithNoUnintendedSpaces);

//        4. If someone enters “ alphabet “ (notice the spaces) as input into a method, make that
//    method output “alphabeT” instead.
        System.out.println(capitalizeLastAndStrip(" alphabet "));

//        5. Given the String “12345 Big St., Alphabet City, CA 90210” or any other address with the
//        same format, can you write code that can parse and print out:
        String[] splittedAddress = "12345 Big St., Alphabet City, CA 90210".split(",");
        String buildingNumber = splittedAddress[0].split(" ")[0];
        String streetName = splittedAddress[0].replace(buildingNumber, "").trim();
        String city = splittedAddress[1].trim();
        String state = splittedAddress[2].trim().split(" ")[0];
        String postalCode = splittedAddress[2].replace(state, "").trim();

//        1. The building number: 12345
        System.out.println(buildingNumber);

//        2. The Street: “Big St.”
        System.out.println(streetName);

//        3. City: “Alphabet City”
        System.out.println(city);

//        4. State: “CA”
        System.out.println(state);

//        5. Postal Code: 90210
        System.out.println(postalCode);
    }

//    4. If someone enters “ alphabet “ (notice the spaces) as input into a method, make that
//    method output “alphabeT” instead.
    public static String capitalizeLastAndStrip(String text) {
        String result = text.strip();
        int lenghtOfStrippedText = result.length();
        char lastChar = result.charAt(lenghtOfStrippedText - 1);
        String lastUpperCasedChar = String.valueOf(lastChar).toUpperCase();
        return result.substring(0, lenghtOfStrippedText - 1).concat(lastUpperCasedChar);
    }


}
