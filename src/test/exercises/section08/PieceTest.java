package exercises.section08;

public class PieceTest {
    protected boolean isMoveFoundInArray(Coordinates[] moves, Coordinates expectedMove) {
        for (int x=0; x < moves.length; x++) {
            if (moves[x].equals(expectedMove)) return true;
        }
        return false;
    }
}