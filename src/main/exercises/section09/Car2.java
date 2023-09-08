package exercises.section09;

import java.time.Year;
import java.util.Objects;

public class Car2 {
    private String name;
    private String color;
    private Year year;

    public Car2(String name, String color, Year year) {
        this.name = name;
        this.color = color;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car2 car = (Car2) o;
        return year == car.year && Objects.equals(name, car.name) && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, year);
    }
}
