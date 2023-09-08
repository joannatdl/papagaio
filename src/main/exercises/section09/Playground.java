package exercises.section09;

import java.time.Year;
import java.util.*;

import static java.util.Collection.*;

public class Playground {
    public static void main(String[] args) {
//        1. Write code that allows you to model and store a collection of at least 5 cars and keeps
//        them in the order in which they were entered. Print them out to the screen also.
        record Car(String name, String color, Year year) implements Comparable<Car> {
            @Override
            public int compareTo(Car o) {
                return this.name.compareTo(o.name);
            }
        }
        List<Car> carsList = new ArrayList<>();
        carsList.add(new Car("Nugget", "blue", Year.of(2020)));
        carsList.add(new Car("Volvo", "black", Year.of(2021)));
        carsList.add(new Car("Astra", "silver", Year.of(2010)));
        carsList.add(new Car("Zafira", "black", Year.of(2003)));
        carsList.add(new Car("T4", "white", Year.of(2001)));
        for (Car car : carsList) {
            System.out.println(car);
        }

//        2. Same as exercise 1 except we don’t care about retaining the order and we want to ensure
//        that duplicates will not exist
        Set<Car> carsSet = new HashSet<>();
        carsSet.add(new Car("Nugget", "blue", Year.of(2020)));
        carsSet.add(new Car("Volvo", "black", Year.of(2021)));
        carsSet.add(new Car("Astra", "silver", Year.of(2010)));
        carsSet.add(new Car("Zafira", "black", Year.of(2003)));
        carsSet.add(new Car("T4", "white", Year.of(2001)));
        carsSet.add(new Car("Nugget", "blue", Year.of(2020)));
        carsSet.add(new Car("Volvo", "black", Year.of(2021)));

        for (Car car : carsSet) {
            System.out.println(car);
        }

//        3. Same as exercise 1 but associate an owner’s first name with each car. Do not add owner’s
//        name to your car model class. Print out each owner with their car.
        Map<String, Car> carsMap = new HashMap<>();
        carsMap.put("Joanna", new Car("Nugget", "blue", Year.of(2020)));
        carsMap.put("Francisco", new Car("Volvo", "black", Year.of(2021)));
        carsMap.put("Michał", new Car("Astra", "silver", Year.of(2010)));
        carsMap.put("Franek", new Car("Zafira", "black", Year.of(2003)));
        carsMap.put("Max", new Car("T4", "white", Year.of(2001)));

        for (Map.Entry<String, Car> entry : carsMap.entrySet()) {
            // '\t' for tab space between owner name & car details - you could use anything to separate
            System.out.printf("%s\s-\s%s%n", entry.getKey(), entry.getValue());
        }

//        4. If you implemented exercise 2 with a record (instead of a class), do it again using a class or vice-versa.
        Set<Car2> carsSet2 = new HashSet<>();
        carsSet2.add(new Car2("Nugget", "blue", Year.of(2020)));
        carsSet2.add(new Car2("Volvo", "black", Year.of(2021)));
        carsSet2.add(new Car2("Astra", "silver", Year.of(2010)));
        carsSet2.add(new Car2("Zafira", "black", Year.of(2003)));
        carsSet2.add(new Car2("T4", "white", Year.of(2001)));
        carsSet2.add(new Car2("Nugget", "blue", Year.of(2020)));
        carsSet2.add(new Car2("Volvo", "black", Year.of(2021)));

        for (Car2 car : carsSet2) {
            System.out.println(car);
        }

//        5. Allow the cars from exercise 2 to be printed in “natural” order by model.
        carsSet = new TreeSet<>();
        carsSet.add(new Car("Nugget", "blue", Year.of(2020)));
        carsSet.add(new Car("Volvo", "black", Year.of(2021)));
        carsSet.add(new Car("Astra", "silver", Year.of(2010)));
        carsSet.add(new Car("Zafira", "black", Year.of(2003)));
        carsSet.add(new Car("T4", "white", Year.of(2001)));
        carsSet.add(new Car("Nugget", "blue", Year.of(2020)));
        carsSet.add(new Car("Volvo", "black", Year.of(2021)));

        for (Car car : carsSet) {
            System.out.println(car);
        }

//        1. Store the same cars in a List and sort them. (No code solution provided)
        Collections.sort(carsList);

//        2. Store the same cars in a List and sort them without implementing any interfaces on the Car class.
        carsList.sort((c1, c2) -> {
            return c1.compareTo(c2);
        });

//        3. How could you reverse the sort order?
        Collections.sort(carsList, Collections.reverseOrder());

//        6. Same as exercise 5 but allow program to remove a model by passing the model name as
//        an argument to the main() method.
        for (Iterator<Car> it = carsSet.iterator(); it.hasNext();) {
            if (it.next().name().equals(args[0])) {
                it.remove();
            }
        }
        for (Car car : carsSet) {
            System.out.println(car);
        }

//        7. What might be a more memory-efficient collection to use to store millions or billions of
//        objects in the order in which they come, if you don’t know exactly how many objects you’ll
//        need to store before-hand?
//        LinkedList

//        8. How could you take your collection of cars from exercise 6 and store them in an array
//        efficiently? How could you convert that array of cars back into a list again? (Solution is
//        included in solution to exercise 6)
        Car[] carArray = carsSet.toArray(new Car[0]);
        List<Car> carList = Arrays.asList(carArray);


    }
}

