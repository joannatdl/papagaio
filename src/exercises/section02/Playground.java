package exercises.section02;

import exercises.section02.Car;

import static java.lang.System.out;

public class Playground {
    public static void main(String[] args) {
//      Exercises from  udemy.com/course/neutrino-java-foundations/learn/lecture/

//        1. Create a new Java project and try modeling a domain you’re comfortable with. It could be
//        something like: Sports, Business, Mathematics, Online Shopping, etc. For example, if you
//        modeled online shopping, you might create classes to represent: Customer, Product, Order,
//                etc. These classes would likely have properties and you may think of a few methods that
//        might make sense for them too.

//       >> the classes outside of this package are the solution for this exercise

//      2. Create an array and initialize it with the days of the week.
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

//        2.1.Use System.out.println() to print:
//          2.1.1.The number of items in the array
        out.println(daysOfWeek.length);

//          2.1.2.The 4th day in the array
        out.println(daysOfWeek[3]);

//      3. Create an array and initialize it with numbers, 1-10
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

//      4. Try creating an array to represent the tic-tac-toe board to the right
        char[][] ticTacToe = {
                {'o', 'x', 'x'},
                {'x', 'o', 'o'},
                {'x', 'o', 'o'}
        };

//        4.1.How would you access the value in the bottom right square with Java code?
        char value = ticTacToe[2][2];

//      7. Create an instance of a Car, pass it to System.out.println() so that its properties will be printed.
        Car car = new Car("green", 50);
        out.println(car);
    }

//  5. Write a method that allows you to pass any number of Strings as parameter inputs without using an array.
    public void varargsMethod(String... args) {
        // blablabla
    }

//  6. How can you create a method that can be called without creating an instance of its class?
    public static void staticMethod() {
        // blablabla
    }
}
