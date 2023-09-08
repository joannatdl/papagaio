package exercises.section09;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
    public Knight(Color color) {
        super(color);
    }

    public List<Coordinates> getValidMoves() {
        List<Coordinates> validMoves = new ArrayList<>();
        Coordinates newMove;
        List<Coordinates> coordinatesToMove = new ArrayList<>();
        coordinatesToMove.add(new Coordinates(1, -2));
        coordinatesToMove.add(new Coordinates(2, -1));
        coordinatesToMove.add(new Coordinates(-1, -2));
        coordinatesToMove.add(new Coordinates(-2, -1));
        coordinatesToMove.add(new Coordinates(1, 2));
        coordinatesToMove.add(new Coordinates(2, 1));
        coordinatesToMove.add(new Coordinates(-1, 2));
        coordinatesToMove.add(new Coordinates(-2, 1));
        for(Coordinates c : coordinatesToMove) {
            newMove = this.coordinates.moveBy(c);
            if (newMove.isInRange()) {
                validMoves.add(newMove);
            }
        }
        return validMoves;
    }
}
