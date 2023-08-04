package exercises.section05;

// 3. Using only what you’ve learned so far in this course, create a class that contains 10
//    lowercase names and has a method that can be called 10 separate times, each time,
//    returning the next name. If the method is called “next()”, the first time it’s called, it returns
//    “name1”, the second time “next()” is called, it returns “name2”, etc.

public class Name {
    private static final String[] list = {"name1", "name2", "name3", "name4", "name5", "name6", "name7", "name8", "name9", "name10"};
    private static int i = 0;
    public static void main(String[] args) {
        next();
        next();
        next();
    }

    public static void next() {
        if (i < 10) {
//            1. Make the next() method capitalize the first letter of each name as it outputs them
            String name = list[i];
            i++;
            System.out.println(name.substring(0, 1).toUpperCase() + name.substring(1));
        }
    }
}
