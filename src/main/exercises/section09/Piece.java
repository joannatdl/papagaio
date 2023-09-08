package exercises.section09;

import java.util.List;

public abstract class Piece {
    ChessBoard board;
    Color color;
    Coordinates coordinates;
    int movesCounter = 0;

    public Piece(Color color) {
        this.color = color;
    }

    public void setBoard(ChessBoard board) {
        this.board = board;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
        this.movesCounter++;
    }
    
    public boolean canMove(Coordinates coordinates) {
        return getValidMoves().contains(coordinates) && !this.board.fieldOccupiedByColor(coordinates, this.color);
    }

    protected abstract List<Coordinates> getValidMoves();

    enum Color {
        WHITE,
        BLACK;
    }
}
