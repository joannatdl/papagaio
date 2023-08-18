package exercises.section08;

import java.util.Random;

public class Playground {
    public static void main(String[] args) {
//        1. Use an Enum to model the days of the week and print them using a loop.
        for (WeekDay day: WeekDay.values()) {
            System.out.println(day);
        }

//        1. Print them with the first letter capitalized (without changing the Enum constants).
        for (WeekDay day: WeekDay.values()) {
            String dayName = day.toString();
            System.out.println(day.capitalized());
        }

//        2. Alternate between printing the first letter capitalized or whatever letter is approximately
//        in the middle of the word. For example: Sunday, monDay, Tuesday, wednEsday, etc.
        for (WeekDay day: WeekDay.values()) {
            String dayName = day.toString();
            String formattedDayName = (day.ordinal() % 2 == 1) ? day.capitalized() : day.middleized();
            System.out.println(formattedDayName);
        }

//        3. Print 10 randomly-chosen days of the week
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int dayNumber = random.nextInt(7);
            System.out.println(WeekDay.values()[dayNumber]);
        }

//       2. Write code to print the following using only an Enum & loop without using any conditionals
//                (if/else/switch/etc.)
//        We eat pot roast on Sunday
//        We eat spaghetti on Monday
//        We eat tacos on Tuesday
//        We eat chicken on Wednesday
//        We eat meatloaf on Thursday
//        We eat hamburgers on Friday
//        We eat pizza on Saturday
        String[] foods = {"spaghetti", "tacos", "chicken", "meatloaf", "hamburgers", "pizza", "pot roast"};
        StringBuilder sb;
        for (int i = 0; i < 7; i++) {
            sb = new StringBuilder();
            sb.append("We eat ").append(foods[i]).append(" on ").append(WeekDay.values()[i].capitalized());
            System.out.println(sb.toString());
        }

//        1. Do it again but capitalize the meal names too. “pot roast” should become “Pot Roast”.
        for (int i = 0; i < 7; i++) {
            sb = new StringBuilder();
            sb.append("We eat ");
            for (String foodWord: foods[i].split("\\s")) {
                sb.append(foodWord.substring(0, 1).toUpperCase());
                sb.append(foodWord.substring(1));
                sb.append(" ");
            }
            sb.append("on ");
            sb.append(WeekDay.values()[i].capitalized());
            System.out.println(sb.toString());
        }

        //    3. Write a method that takes the following input String (in bold) and returns the following
//    output String using an Enum like (print the output):
//    getMealsForDays(“friday, thursday, monday, saturday, tuesday”)
//    Output: hamburgers, meatloaf, spaghetti, etc…
        getMealsForDays("friday, thursday, monday, saturday, tuesday");

        // a8 -> 0,0
        // h1 -> 7,7
        // g5 -> 6,3
        // d4 -> 3,4
        System.out.println(chessFieldAsArray("a8"));
        System.out.println(chessFieldAsArray("h1"));
        System.out.println(chessFieldAsArray("g5"));
        System.out.println(chessFieldAsArray("d4"));
    }

    private static void getMealsForDays(String days) {
        String[] daysArray = days.split(",\\s");
        StringBuilder sb = new StringBuilder();
        for (String day: daysArray) {
            WeekDay weekDay = WeekDay.valueOf(day.toUpperCase());
            sb.append(weekDay.getFood());
            sb.append(", ");
        }
        sb.delete(sb.length() - 3, sb.length());
        System.out.println(sb.toString());
    }

    //     4.   Write a method that takes an input of 1 lowercase letter (and only 1 letter), like a - b - c - z,
//                etc., and returns that letter’s ordinal position in the alphabet, i.e. a = 1, b = 2, c = 3… z =
//                26. Do NOT use any conditionals (if/then/else/switch/etc.). Do not use an array. Write unit
//        tests to test out the following inputs: a, z, w, f, c, h - which should return: 1, 26, 23, 6, 3, 8
//        respectively
    static String getOrdinalPositions(String input) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length(); i = i + 3) {
            sb.append(Letter.valueOf(java.lang.String.valueOf(input.toCharArray()[i]).toUpperCase()).ordinal() + 1);
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
        //the authors solution was much easier but had nothing to do with enums which was the topic of the class
    }

//    5. Write a method that does the opposite of #4 - taking a number, 1-26, and returns a
//    lowercase letter. 1 would return a, 2 = b, 26 = z, etc
    static String getLetterFromOrdinalPositions(String input) {
        StringBuilder sb = new StringBuilder();
        for(String numberAsString: input.split(",\\s")) {
            sb.append(Letter.values()[Integer.parseInt(numberAsString) - 1].toString().toLowerCase());
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
        //the authors solution was much easier but had nothing to do with enums which was the topic of the class
    }

//    6. Write a method that takes the following inputs and returns the corresponding outputs:
//            8->0, 7->1, 6->2, 5->3, 4->4, 3->5, 2->6, 1->7
    public static int subtractEight(int input) {
        return 8 - input;
    }

//    7. If you modeled a chess board in Java using a two-dimensional array, how could you
//    convert chess notation, or coordinate notation of chess, to an element in that twodimensional array? For example,
//    in the chess board image below, square a8 might map to array[0][0], and h1 might map to array[7][7]. Make a method that takes an input String of a
//    chess coordinate and returns array coordinates. This exercise simply builds on the previous
//    two. Use the following test data:
    // a8 -> 0,0
    // h1 -> 7,7
    // g5 -> 6,3
    // d4 -> 3,4
    public static String chessFieldAsArray(String input) {
        StringBuilder sb = new StringBuilder();
        sb.append((int) input.toCharArray()[0] - 97);
        sb.append(",");
        sb.append((Integer.parseInt(String.valueOf(input.toCharArray()[1])) - 8) * (-1));
        return sb.toString();
    }

}
