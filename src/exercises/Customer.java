package exercises;

import exercises.bank.Bank;

//  8. Model a Customer
public class Customer {
    Bank bank;
    String name;
    double initialDeposit;

//    11. Model a class with data that enumerates (associates with a number) the first names of three
//    friends, classmates or coworkers. Make it so that this name data will be shared among all
//    instances of the class
    public static Object[][] initialDeposits = new Object[][] {{"Jan", 0}, {"Stefan", 1000}, {"Janina", -1000}};

//    9. How can you ensure that a Customer instance can not be created without a name and an
//    initial deposit?
    public Customer(String name, double initialDeposit) {
        this.name = name;
        this.initialDeposit = initialDeposit;
    }

//    8. Ensure the Customer can not access the Bank’s vault directly
//    public double getVault() {
//        this.bank.getVault(); - doesn't work and it's right
//    }
}
