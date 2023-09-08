package exercises.section11;

import java.util.Arrays;
import java.util.Objects;

public class Pawn extends Piece {
    private ChessBoard board;


    public Pawn(Color color) {
        super(color);
    }

    int moveDirection() {
        return this.color.equals(Color.WHITE) ? (-1) : 1;
    }

    public Coordinates[] getValidMoves() {
        Coordinates[] validMoves = new Coordinates[4];
        Coordinates newMove;
        Coordinates[] coordinatesToMove = new Coordinates[3];
        coordinatesToMove[0] = new Coordinates(0, this.moveDirection());
        coordinatesToMove[1] = new Coordinates(1, this.moveDirection());
        coordinatesToMove[2] = new Coordinates(-1, this.moveDirection());
        for (int i=0; i < 3; i++) {
            newMove = this.coordinates.moveBy(coordinatesToMove[i]);
            if (newMove.isInRange()) {
                validMoves[i] = newMove;
            }
        }
        if (movesCounter <= 1) {
            newMove = this.coordinates.moveBy(new Coordinates(0, 2*this.moveDirection()));
            if (newMove.isInRange()) {
                validMoves[3] = newMove;
            }
        }
        return Arrays.stream(validMoves).filter(Objects::nonNull).toArray(Coordinates[]::new);
    }
}
