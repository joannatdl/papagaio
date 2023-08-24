package exercises.section08;

import java.util.Objects;

public class Coordinates {
    private final int x;
    private final int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates(String location) {
        Coordinates coordinates = convertLocation(location);
        this.x = coordinates.x;
        this.y = coordinates.y;
    }

    public Coordinates moveBy(Coordinates move) {
        return new Coordinates(this.x + move.x, this.y + move.y);
    }

    public static Coordinates convertLocation(String input) {
        int x = (int) (input.toCharArray()[0]) - 97;
        int y = (Integer.parseInt(String.valueOf(input.toCharArray()[1])) - 8) * (-1);
        return new Coordinates(x, y);
    }

    public boolean isInRange() {
        return this.x >= 0 && this.x < 8 && this.y >= 0 && this.y < 8;
    }

    public static boolean isMoveFoundInArray(Coordinates[] moves, Coordinates expectedMove) {
        for (int x=0; x < moves.length; x++) {
            if (moves[x].equals(expectedMove)) return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
