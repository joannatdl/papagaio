package exercises.section11;

import java.util.Arrays;
import java.util.Objects;

public class Knight extends Piece {
    public Knight(Color color) {
        super(color);
    }

    public Coordinates[] getValidMoves() {
        Coordinates[] validMoves = new Coordinates[8];
        Coordinates newMove;
        Coordinates[] coordinatesToMove = new Coordinates[8];
        coordinatesToMove[0] = new Coordinates(1, -2);
        coordinatesToMove[1] = new Coordinates(2, -1);
        coordinatesToMove[2] = new Coordinates(-1, -2);
        coordinatesToMove[3] = new Coordinates(-2, -1);
        coordinatesToMove[4] = new Coordinates(1, 2);
        coordinatesToMove[5] = new Coordinates(2, 1);
        coordinatesToMove[6] = new Coordinates(-1, 2);
        coordinatesToMove[7] = new Coordinates(-2, 1);
        for (int i=0; i < 8; i++) {
            newMove = this.coordinates.moveBy(coordinatesToMove[i]);
            if (newMove.isInRange()) {
                validMoves[i] = newMove;
            }
        }
        return Arrays.stream(validMoves).filter(Objects::nonNull).toArray(Coordinates[]::new);
    }
}
