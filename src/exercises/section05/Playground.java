package exercises.section05;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Random;

public class Playground {
    public static int sum = 0;

    public static void main(String[] args) throws ParseException {
//  1.  If you could receive up to eight different types of radio signals simultaneously (into your
//      computer & a program you wrote) and you needed to be able to record which of those eight
//      you received at any given time, what would be a highly compact (or compressed - using
//      the least amount of memory or storage) way to record them (using what you learned in this
//      module)? For example, you could receive signals A + B + C simultaneously, or A + D, or just G, etc.
//      boolean seem to need same memory as byte :/ so an array of booleans which i wanted to use
//      is more memory consuming than one byte
        byte signals = Byte.parseByte("00001101", 2);
//        1. If you received signals A + D + C simultaneously, how could you efficiently determine
//           that D was one of the signals you received - based on your solution above?
        if ((Byte.parseByte("00001000", 2) & signals) > 0) {
            System.out.println("Received D!");
        }
//  2.  What’s an alternative way you could add 2 + 4 without using “+” symbol?
        Integer.sum(2, 4);
        System.out.println(2 | 4); // is what they wanted
//  5.  Make a method, next(), that can be called 10 times and generate a random integer between
//      0 & 10 (non-inclusive). This method keep a running sum of all random numbers it generates
//      and return that sum each time. If first time next() is called, it generates 5, and second time
//      it’s called it generates 3, it should return 8 from the second call - for example.
        System.out.println(next());
        System.out.println(next());
        System.out.println(next());
        System.out.println(next());
        System.out.println(next());

//  6.  Write a function that takes a String like “149.32” and formats it as money for wherever you
//      live. So, if you live in the United States, it would return “$149.32”, Korea = ₩149, France/
//      EU = 149,32 €, etc
        System.out.println(formatMoney("149.32"));

//  7.  Write a function that takes a String input of “$12,345.83” and prints out that value divided
//      by 32.19. It should return $383.53.
        System.out.println(divide("$12,345.83"));

//  8.  Use printf() to format the following inputs to print out the following outputs
        System.out.printf("%,+.1f%n", -9876.35532);
//      123456.783                $123,456.78
        System.out.printf(Locale.US, "$%,.2f%n", 123456.783);
//      -9876.32532               (9,876.325)
        System.out.printf(Locale.US, "%(,.3f%n", -9876.32532);
//      23.19283928394829182      2.319284e+01f
        System.out.printf(Locale.US, "%e%n", 23.19283928394829182);
//      123456                    0000123456
        System.out.printf("%010d%n", 123456);
//      -9876.35532               -9,876.4
        System.out.printf(Locale.US, "%,.1f%n", -9876.35532);

//  9.  How could you format each of the inputs in the table above and store them in String
//      variables instead of just printing them out directly?
//      123456.783                $123,456.78
        String formattedInput = String.format(Locale.US, "$%,.2f%n", 123456.783);
//      -9876.32532               (9,876.325)
        formattedInput = String.format(Locale.US, "%(,.3f%n", -9876.32532);
//      23.19283928394829182      2.319284e+01f
        formattedInput = String.format(Locale.US, "%e%n", 23.19283928394829182);
//      123456                    0000123456
        formattedInput = String.format("%010d%n", 123456);
//      -9876.35532               -9,876.4
        formattedInput = String.format(Locale.US, "%,.1f%n", -9876.35532);

//  10. Use instances of DecimalFormat to perform the same conversions in the table above.
        NumberFormat cf = DecimalFormat.getCurrencyInstance(Locale.US);
//      123456.783                $123,456.78
        System.out.println(cf.format(123456.783));
//      -9876.32532               (9,876.325)
        NumberFormat df = new DecimalFormat(",###.###;(#)"); // for some reason it treats . as , and , as spaces
        System.out.println(df.format( -9876.32532));
//      23.19283928394829182      2.319284e+01f
        df = new DecimalFormat("0.0E0"); // this one is not working as well
        System.out.println(df.format(23.19283928394829182));
//      123456                    0000123456
        df = new DecimalFormat("0000000000");
        System.out.println(df.format(123456));
//      -9876.35532               -9,876.4
        df = new DecimalFormat("#,###.#"); // the same again
        System.out.println(df.format(-9876.35532));

//  11. Write a method that takes the String inputs, “37” & “13”, and returns an integer of their sum, 50.
        System.out.println(sum("37", "13"));
    }

//  5. Make a method, next(), that can be called 10 times and generate a random integer between
//     0 & 10 (non-inclusive). This method keep a running sum of all random numbers it generates
//     and return that sum each time. If first time next() is called, it generates 5, and second time
//     it’s called it generates 3, it should return 8 from the second call - for example.
    public static int next() {
        Random random = new Random();
        int number = random.nextInt(10);
        sum += number;
        return sum;
    }

//  6. Write a function that takes a String like “149.32” and formats it as money for wherever you
//     live. So, if you live in the United States, it would return “$149.32”, Korea = ₩149, France/EU = 149,32 €, etc
    public static String formatMoney(String input) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(new BigDecimal(input));
    }

//  7. Write a function that takes a String input of “$12,345.83” and prints out that value divided
//     by 32.19. It should return $383.53.
    public static String divide(String input) throws ParseException {
        double divider = 32.19;
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        Number money = formatter.parse(input);
        BigDecimal result = new BigDecimal(money.toString()).divide(new BigDecimal("32.19"), MathContext.DECIMAL32);
        return formatter.format(result);
    }

//  11. Write a method that takes the String inputs, “37” & “13”, and returns an integer of their sum, 50.
    public static Integer sum(String string1, String string2) {
        int number1 = Integer.parseInt(string1);
        int number2 = Integer.parseInt(string2);
        return number1 + number2;
    }
}
