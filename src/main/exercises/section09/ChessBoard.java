package exercises.section09;

import java.util.ArrayList;
import java.util.List;

import static exercises.section09.Coordinates.convertLocation;

public class ChessBoard {
    private Piece[][] state = new Piece[8][8];
    private List<Piece> whiteCapturedPieces = new ArrayList<>();

    public ChessBoard() {
    }

    public void add(Piece piece, String location) {
        piece.setBoard(this);
        Coordinates coordinates = convertLocation(location);
        this.state[coordinates.getX()][coordinates.getY()] = piece;
        piece.setCoordinates(coordinates);
    }

    public void remove(Coordinates coordinates) {
        this.state[coordinates.getX()][coordinates.getY()] = null;
    }

    public Piece getPieceAtCoords(String input) {
        Coordinates coordinates = convertLocation(input);
        return this.state[coordinates.getX()][coordinates.getY()];
    }

    public void move(Knight knight, String location) {
        Coordinates newCoordinates = convertLocation(location);
        if (knight.canMove(newCoordinates)) {
            remove(knight.coordinates);
            fight(knight, newCoordinates);
            add(knight, location);
        }
    }

    private void fight(Knight knight, Coordinates coordinates) {
        if (this.state[coordinates.getX()][coordinates.getY()] != null && !this.state[coordinates.getX()][coordinates.getY()].color.equals(knight.color)) {
            this.whiteCapturedPieces.add(this.state[coordinates.getX()][coordinates.getY()]);
            remove(coordinates);
        }
    }

    public boolean fieldOccupiedByColor(Coordinates field, Piece.Color color) {
        return this.state[field.getX()][field.getY()] != null && this.state[field.getX()][field.getY()].color.equals(color);
    }

    public List<Piece> getWhiteCapturedPieces() {
        return this.whiteCapturedPieces;
    }
}
