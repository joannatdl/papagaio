package exercises.section10;

import org.apiguardian.api.API;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class Playground {
    public static void main(String[] args) {
        //    1. Using the same car collection approach as in the last section’s exercises, create a
//    collection of cars but use the Streams API to print out only the cars’ model names
        record Car(String name, String color, Year year, int price){}

        List<Car> carsList = new ArrayList<>();
        carsList.add(new Car("Nugget", "blue", Year.of(2020), 0));
        carsList.add(new Car("Volvo", "black", Year.of(2021), 0));
        carsList.add(new Car("Astra", "silver", Year.of(2010), 0));
        carsList.add(new Car("Zafira", "black", Year.of(2003), 0));
        carsList.add(new Car("T4", "white", Year.of(2001), 0));
        carsList.stream()
                .map(Car::name)
                .forEach(System.out::println);

//        2. How could you use the Streams API to filter out (not show) all cars made before a certain
//        year? (If you modeled Car year using the Year date/time class, it has a method isAfter())
        carsList.stream()
                .filter(c -> c.year.isAfter(Year.of(2010)))
                .forEach(System.out::println);

//        3. How could you create a stream of cars without first explicitly creating a collection of cars?
        Stream.of(new Car("Nugget", "blue", Year.of(2020), 0), new Car("Volvo", "black", Year.of(2021), 0));

//        4. Add an additional integer price field to your Car class/record. Use Streams to add total cost
//        of all cars in your collection/stream. (Two ways to do this)
        int sum = Stream.of(
                new Car("Nugget", "blue", Year.of(2020), 60000), new Car("Volvo", "black", Year.of(2021), 30000))
                .mapToInt(Car::price)
                .sum();
        System.out.println(sum);

//        1. Use Streams to find average price of all cars
        OptionalDouble avg = Stream.of(
                new Car("Nugget", "blue", Year.of(2020), 60000), new Car("Volvo", "black", Year.of(2021), 30000))
                .mapToInt(Car::price)
                .average();
        System.out.println(avg);

//        2. How could you do exercise 4 with Streams & BigDecimal (for decimal accuracy)?
        record CarBD(String name, String color, Year year, BigDecimal price){}
        BigDecimal sumBD =
                Stream.of(
                        new CarBD("Nugget", "blue", Year.of(2020), new BigDecimal("60000.0")),
                                new CarBD("Volvo", "black", Year.of(2021), new BigDecimal(30000)))
                        .map(CarBD::price)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(sumBD);

//        3. How could you do exercise 4.2 but output a formatted money String still using only the Streams API?
        String sumS = Stream.of(
                        new CarBD("Nugget", "blue", Year.of(2020), new BigDecimal(60000)), new CarBD("Volvo", "black", Year.of(2021), new BigDecimal(30000)))
                .map(CarBD::price)
                .collect(Collectors.collectingAndThen(reducing(BigDecimal.ZERO, BigDecimal::add), NumberFormat.getCurrencyInstance()::format));
        System.out.println(sumS);

//        5. Use the Streams API to sort a stream of cars in reverse order by model
        carsList.stream()
                .sorted(comparing(Car::name).reversed())
                .forEach(System.out::println);

//        1. Do so by sorting by make, then model, then year - all in one
        carsList.stream()
                .sorted(
                        comparing(Car::name).reversed()
                                .thenComparing(Car::year)
                )
                .forEach(System.out::println);

//        6. Use only the Streams API and a collection or Stream of Car objects to produce the
//        following output: “S, X, 3, Y, Roadster”
        List<Car> carsList2 = new ArrayList<>();
        carsList2.add(new Car("Tesla", "S", Year.of(2014), 0));
        carsList2.add(new Car("Tesla", "X", Year.of(2015), 0));
        carsList2.add(new Car("Tesla", "3", Year.of(2016), 0));
        carsList2.add(new Car("Tesla", "Y", Year.of(2017), 0));
        carsList2.add(new Car("Tesla", "Roadster", Year.of(2009), 0));

        StringBuilder sb = new StringBuilder();

        Optional<String> colors = carsList2.stream()
                .map(Car::color)
                .reduce((a, b) -> a.concat(", ").concat(b));
        System.out.println(colors.get());

//        7. Add more different makes of cars to your collection of cars and then
//        1. Determine total price by make
        List<CarBD> carsList3 = List.of(
                new CarBD("Tesla", "S", Year.of(2014), new BigDecimal("90000.99")),
                new CarBD("Tesla", "X", Year.of(2015), new BigDecimal("110000.99")),
                new CarBD("Tesla", "3", Year.of(2016), new BigDecimal("55000.99")),
                new CarBD("Tesla", "Y", Year.of(2017), new BigDecimal("60000.99")),
                new CarBD("Tesla", "Roadster", Year.of(2009), new BigDecimal("135000.99")),
                new CarBD("Lucid", "Air", Year.of(2021), new BigDecimal("77399.99")),
                new CarBD("Hyundai", "Ioniq", Year.of(2021), new BigDecimal("34250.00")),
                new CarBD("Hyundai", "Kona", Year.of(2021), new BigDecimal("38575.00")),
                new CarBD("Porsche", "Taycan", Year.of(2021), new BigDecimal("81250.00")),
                new CarBD("Audi", "e-tron", Year.of(2021), new BigDecimal("66995.00")),
                new CarBD("Volkswagen", "ID.4", Year.of(2021), new BigDecimal("41190")));
        Map<String, BigDecimal> sumByColor = carsList3.stream()
                        .collect(groupingBy(
                                CarBD::color,
                                reducing(BigDecimal.ZERO, CarBD::price, BigDecimal::add)));
        System.out.println(sumByColor);

//        2. Determine average car price by make
//        1. This one will be fun/challenging. You’ll want to take a look at the Collectors.teeing()
//        function, which I did not explicitly teach but have a look at its javadoc. If this proves
//        to be too hard but you want to still try it without looking @ my solution, it will be
//        MUCH easier if you convert the prices to any other numeric type before using
//        Streams API (but not as much fun…)
        Map<String, BigDecimal> averageByColor = carsList3.stream()
                .collect(groupingBy(
                        CarBD::color,
                        teeing(
                                reducing(BigDecimal.ZERO, CarBD::price, BigDecimal::add),
                                counting(),
                                (sum2, count) -> sum2.divide(new BigDecimal(count))
                        )
                ));
        System.out.println(averageByColor);

//        2. Did you get 7.2.1? Let’s make it even more fun. Format the average prices for
//        currency, within the Streams API.
        Map<String, String> formattedAverageByColor = carsList3.stream()
                .collect(groupingBy(
                        CarBD::color,
                        collectingAndThen(teeing(
                                reducing(BigDecimal.ZERO, CarBD::price, BigDecimal::add),
                                counting(),
                                (sum3, count) -> sum3.divide(new BigDecimal(count))
                        ), NumberFormat.getCurrencyInstance()::format)
                ));
        System.out.println(formattedAverageByColor);

//        3. Determine number of cars by year and then by make
        Map<Year, Map<String, Long>> countByYearAndColor = carsList3.stream()
                .collect(groupingBy(CarBD::year,
                                groupingBy(CarBD::color, counting())
                        )
                );
        System.out.println(countByYearAndColor);

//        4. Determine number of cars by make by first creating a new, empty Map, then iterating
//        over the collection of cars (you’ve been using for previous exercises) and using a
//        functional method of the Map interface to populate your empty Map.
        Map<String, Integer> countsByColor = new HashMap<>();
        carsList3.stream()
                .forEach(car -> countsByColor.merge(car.color, 1, Integer::sum));
        System.out.println(countsByColor);
    }

}
