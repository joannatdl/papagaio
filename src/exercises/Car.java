package exercises;

//  7. Model a Car
public class Car {
    private String color;
    private int speed;

    public Car(String color, int speed) {
        this.color = color;
        this.speed = speed;
    }

//  7. Create an instance of a Car, pass it to System.out.println() so that its properties will be printed.
    @Override
    public String toString() {
        return "Car: color = " + this.color + ", speed = " + this.speed + ".";
    }
}
