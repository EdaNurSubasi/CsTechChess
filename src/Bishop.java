//This class is for Bishop piece in chess board
public class Bishop extends ChessPiece{

    //Constructor
    public Bishop(char side) {
        setSide(side); // Setting the side of Bishop piece.
        setValue(3); // Setting the value of Bishop piece.
        setPiece('f'); // Setting the piece type of Bishop piece
    }

    // Override method from parent class ChessPiece to define the movement of Bishop piece.
    @Override
    public ChessPiece[][] movementPlacements(int xAxis, int yAxis, ChessPiece[][] board) {
        return null;
    }
}
