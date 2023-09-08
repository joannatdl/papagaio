package exercises.section11;

import java.awt.*;

public abstract class Piece {
    Color color;
    Coordinates coordinates;
    ChessBoard board;
    int movesCounter = 0;

    public Piece(Color color) {
        this.color = color;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
        this.movesCounter++;
    }
    
    public boolean canMove(Coordinates coordinates) {
        if (this.board.fieldOccupiedByColor(coordinates, this.color)) { throw new RuntimeException("Field occupied by your piece!"); }
        return Coordinates.isMoveFoundInArray(getValidMoves(), coordinates);
    }

    protected abstract Coordinates[] getValidMoves();

    enum Color {
        WHITE,
        BLACK;
    }
}
