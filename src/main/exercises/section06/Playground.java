package exercises.section06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Playground {
    private static final String[] DAYS_OF_WEEK = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    public static void main(String[] args) {
        printWeekDays();
        printWeekDays2();
        printWeekDays3();
        printWeekDays4();
        printWeekDays5();
        printWeekDays6();
        printWeekDays7();
        printMenu();
        printMenu2();
        printMenu3();
        printMenu4();
        System.out.println(sumWeekLetters());
        printAddresses();

  }

//    1. Write a method in 4 lines of code (not including method name/signature & curly braces) that
//    outputs the days of the week, one per line, using a regular ‘for-loop’ and an array.
    private static void printWeekDays() {
        for (int i = 0; i < DAYS_OF_WEEK.length; i++) {
            System.out.println(DAYS_OF_WEEK[i]);
        }
    }

//    Do it again using the enhanced ‘for-loop’
    private static void printWeekDays2() {
        for (String day: DAYS_OF_WEEK) {
            System.out.println(day);
        }
    }

//    2. Do it again but make every other output line fully capitalized.
//            Sunday
//            MONDAY
//            Tuesday
//            WEDNESDAY
//            etc…
//    3. Do it again but use only 4 lines of code (not including method and curly braces of
//            method. - I already have 4 lines of code
    private static void printWeekDays3() {
        for (int i = 0; i < DAYS_OF_WEEK.length; i++) {
            String day = (i % 2 == 0) ? DAYS_OF_WEEK[i].toUpperCase() : DAYS_OF_WEEK[i];
            System.out.println(day);
        }
    }

//    2. Repeat all parts of exercise #1, but use ‘while-loop’ instead of ‘for-loop’ (where applicable).
    private static void printWeekDays4() {
        int i = 0;
        while (i < DAYS_OF_WEEK.length) {
            System.out.println(DAYS_OF_WEEK[i++]);
        }
    }

    private static void printWeekDays5() {
        int i = 0;
        while (i < DAYS_OF_WEEK.length) {
            String day = (i % 2 == 0) ? DAYS_OF_WEEK[i].toUpperCase() : DAYS_OF_WEEK[i];
            System.out.println(day);
            i++;
        }
    }

//    3. Do #2 again but use a ‘do-while-loop’
    private static void printWeekDays6() {
        int i = 0;
         do {
            System.out.println(DAYS_OF_WEEK[i++]);
        } while (i < DAYS_OF_WEEK.length);
    }

    private static void printWeekDays7() {
        int i = 0;
        do {
            String day = (i % 2 == 0) ? DAYS_OF_WEEK[i].toUpperCase() : DAYS_OF_WEEK[i];
            System.out.println(day);
            i++;
        }  while (i < DAYS_OF_WEEK.length);
    }

//    4. Use an array of days of the week, enhanced ‘for-loop’ and if/else to create the following
//    output.
//    We eat pot roast on Sunday
//    We eat spaghetti on Monday
//    We eat tacos on Tuesday
//    We eat chicken on Wednesday
//    We eat meatloaf on Thursday
//    We eat hamburgers on Friday
//    We eat pizza on Saturday
    private static void printMenu() {
        String food = "";
        for (String day: DAYS_OF_WEEK) {
            if (day.equals("Sunday")) {
                food = "pot roast";
            } else if (day.equals("Monday")) {
                food = "spagetti";
            } else if (day.equals("Tuesday")) {
                food = "tacos";
            } else if (day.equals("Wednesday")) {
                food = "chicken";
            } else if (day.equals("Thursday")) {
                food = "meatleaf";
            } else if (day.equals("Friday")) {
                food = "hamburgers";
            } else if (day.equals("Saturday")) {
                food = "pizza";
            }
            System.out.printf("We eat %s on %s%n", food, day);
        }
    }

//    5. Repeat exercise #4 but instead of if/else, use traditional switch/case
    private static void printMenu2() {
        String food = "";
        for (String day: DAYS_OF_WEEK) {
            switch (day) {
                case "Sunday":
                    food = "pot roast";
                    break;
                case "Monday":
                    food = "spagetti";
                    break;
                case "Tuesday":
                    food = "tacos";
                case "Wednesday":
                    food = "chicken";
                    break;
                case "Thursday":
                    food = "meatleaf";
                    break;
                case "Friday":
                    food = "hamburgers";
                    break;
                case "Saturday":
                    food = "pizza";
                    break;
                }
            System.out.printf("We eat %s on %s%n", food, day);
        }
    }

//    6. Repeat exercise #5 but use newer switch expression with as little repetition as possible
    private static void printMenu3() {
        for (String day: DAYS_OF_WEEK) {
            String food = switch (day) {
                case "Sunday" -> "pot roast";
                case "Monday" -> "spagetti";
                case "Tuesday" -> "tacos";
                case "Wednesday" -> "chicken";
                case "Thursday" -> "meatleaf";
                case "Friday" -> "hamburgers";
                case "Saturday" -> "pizza";
                default -> "";
            };
            System.out.printf("We eat %s on %s%n", food, day);
        }
    }

//    1. Add a private method that can capitalize the first letter of each word of the meal. So,
//    instead of “We eat spaghetti on Sunday”, it would print, “We eat Spaghetti on Sunday”.
//    Do not just capitalize the meal names yourself. Let your new method do it for you.
//    2. Improve on 6.1 to make it smart enough to output: “We eat Pot Roast on Sunday”, i.e.,
//    it should capitalize each word of a multi-word meal name
    private static String capitalize(String meal) {
        String[] words = meal.split(" ");
        words = Arrays.stream(words).map(word -> word.substring(0, 1).toUpperCase() + word.substring(1)).toArray(String[]::new);
        return String.join(" ", words);
    }

    private static void printMenu4() {
        for (String day: DAYS_OF_WEEK) {
            String food = switch (day) {
                case "Sunday" -> "pot roast";
                case "Monday" -> "spagetti";
                case "Tuesday" -> "tacos";
                case "Wednesday" -> "chicken";
                case "Thursday" -> "meatleaf";
                case "Friday" -> "hamburgers";
                case "Saturday" -> "pizza";
                default -> "";
            };
            System.out.printf("We eat %s on %s%n", capitalize(food), day);
        }
    }

//    7. Iterate over all the days of the week in an array and add up the total number of characters
//    in all the days of the week. E.g., “Sunday”=6, “Monday”=6, etc. therefore, answer should
//    be 50.
    private static Integer sumWeekLetters() {
        return Arrays.stream(DAYS_OF_WEEK).map(day -> day.length()).reduce(0, Integer::sum);
    }

//    8. Use Regex with named parameters and a loop to parse the addresses below and print out
//    the street address, city, state & postal code. Transfer this list of addresses into your
//    program using a Java text block “”” String.
//            12345 First Street, First City, AA 90210
//            22222 Second Street, Second City, BB 22222
//            33333 Third Street, Third City, CC 33333
//            44444 Fourth Street, Fourth City, DD 44444
//            55555 Fifth Street, Fifth City, EE 55555
//            66666 Sixth Street, Sixth City, FF 66666
//            77777 Seventh Street, Seventh City, GG 77777
//            88888 Eighth Street, Eighth City, HH 88888
//            99999 Ninth Street, Ninth City, II 99999
//            00000 Tenth Street, Tenth City, JJ 00000
    private static void printAddresses() {
        String addresses = """
                12345 First Street, First City, AA 90210
                22222 Second Street, Second City, BB 22222
                33333 Third Street, Third City, CC 33333
                44444 Fourth Street, Fourth City, DD 44444
                55555 Fifth Street, Fifth City, EE 55555
                66666 Sixth Street, Sixth City, FF 66666
                77777 Seventh Street, Seventh City, GG 77777
                88888 Eighth Street, Eighth City, HH 88888
                99999 Ninth Street, Ninth City, II 99999
                00000 Tenth Street, Tenth City, JJ 00000""";
        String regexp = """
            (?<number>[\\d]+)\\s
            (?<street>[\\w\\s]+),\\s
            (?<city>[\\w\\s]+),\\s
            (?<state>[A-Z]{2})\\s
            (?<code>[\\d]{5})
        """;
        Pattern pattern = Pattern.compile(regexp, Pattern.DOTALL | Pattern.COMMENTS);
        Matcher matcher;
        matcher = pattern.matcher(addresses);

        while (matcher.find()) {
            System.out.println(matcher.group("number"));
            System.out.println(matcher.group("street"));
            System.out.println(matcher.group("city"));
            System.out.println(matcher.group("state"));
            System.out.println(matcher.group("code"));
            System.out.println();

        }
    }
}
