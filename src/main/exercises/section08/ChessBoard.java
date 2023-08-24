package exercises.section08;

import static exercises.section08.Coordinates.convertLocation;

public class ChessBoard {
    private Piece[][] state = new Piece[8][8];
    private Piece[] whiteCapturedPieces = new Piece[16];

    public ChessBoard() {

    public void add(Piece piece, String location) {
        piece.board = this;
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
        Coordinates newCoordinates = Coordinates.convertLocation(location);
        if (knight.canMove(newCoordinates)) {
            remove(knight.coordinates);
            fight(knight, newCoordinates);
            add(knight, location);
        }
    }

    private void fight(Knight knight, Coordinates coordinates) {
        if (this.state[coordinates.getX()][coordinates.getY()] != null && !this.state[coordinates.getX()][coordinates.getY()].color.equals(knight.color)) {
            for(int i=0; i < 16; i++) {
                if (this.whiteCapturedPieces[i] == null) {
                    this.whiteCapturedPieces[i] = this.state[coordinates.getX()][coordinates.getY()];
                }
            }
            remove(coordinates);
        }
    }

    public boolean fieldOccupiedByColor(Coordinates field, Piece.Color color) {
        return this.state[field.getX()][field.getY()] != null && this.state[field.getX()][field.getY()].color.equals(color);
    }

    public Piece[] getWhiteCapturedPieces() {
        return this.whiteCapturedPieces;
    }
}
