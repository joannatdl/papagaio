package exercises.section08;

//1. Use an Enum to model the days of the week and print them using a loop.

public enum WeekDay {
    MONDAY("spaghetti"),
    TUESDAY("tacos"),
    WEDNESDAY("chicken"),
    THURSDAY("meatloaf"),
    FRIDAY("hamburgers"),
    SATURDAY("pizza"),
    SUNDAY("pot roast");

    private String food;

    public String capitalized() {
        return this.toString().substring(0, 1).concat(this.toString().substring(1).toLowerCase());
    }

    public String middleized() {
        String dayName = this.toString();
        byte middleIndex = (byte) (dayName.length() / 2);
        return dayName.substring(0, middleIndex).toLowerCase().concat(
                dayName.substring(middleIndex, middleIndex + 1)).concat(
                dayName.substring(middleIndex + 1).toLowerCase());
    }

    WeekDay(String food) {
        this.food = food;
    }

    public String getFood() {
        return food;
    }
}
