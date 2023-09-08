package exercises.section09;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Pawn extends Piece {
    public Pawn(Color color) {
        super(color);
    }

    int moveDirection() {
        return this.color.equals(Color.WHITE) ? (-1) : 1;
    }

    public List<Coordinates> getValidMoves() {
        List<Coordinates> validMoves = new ArrayList<>();
        Coordinates newMove;
        List<Coordinates> coordinatesToMove = new ArrayList<>();
        coordinatesToMove.add(new Coordinates(0, this.moveDirection()));
        coordinatesToMove.add(new Coordinates(1, this.moveDirection()));
        coordinatesToMove.add(new Coordinates(-1, this.moveDirection()));
        for (Coordinates c : coordinatesToMove) {
            newMove = this.coordinates.moveBy(c);
            if (newMove.isInRange()) {
                validMoves.add(newMove);
            }
        }
        if (movesCounter <= 1) {
            newMove = this.coordinates.moveBy(new Coordinates(0, 2*this.moveDirection()));
            if (newMove.isInRange()) {
                validMoves.add(newMove);
            }
        }
        return validMoves;
    }
}
