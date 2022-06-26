//This class is for King piece in chess board
public class King extends ChessPiece{

    //Constructor
    public King(char side) {
        setSide(side); // Setting the side of King piece.
        setValue(100); // Setting the value of King piece.
        setPiece('s'); // Setting the piece type of King piece
    }

    // Override method from parent class ChessPiece to define the movement of King piece.
    @Override
    public ChessPiece[][] movementPlacements(int xAxis, int yAxis, ChessPiece[][] board) {
        return null;
    }
}
