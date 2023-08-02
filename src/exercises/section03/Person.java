package exercises.section03;

//  1. Model a Person with a first name and last name and ensure that even if the first name is
//        entered all lowercase, it will be stored all uppercase.
public class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName.toUpperCase();
        this.lastName = lastName;
    }
}
