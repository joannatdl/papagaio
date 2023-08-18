package exercises.section08;

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
        return Coordinates.isMoveFoundInArray(getValidMoves(), coordinates) && !this.board.fieldOccupiedByColor(coordinates, this.color);
    }

    protected abstract Coordinates[] getValidMoves();

    enum Color {
        WHITE,
        BLACK;
    }
}
