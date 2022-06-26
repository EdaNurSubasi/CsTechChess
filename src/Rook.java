//This class is for Rook piece in chess board
public class Rook extends ChessPiece{

    //Constructor
    public Rook(char side) {
        setSide(side); // Setting the side of rook piece.
        setValue(5); // Setting the value of rook piece.
        setPiece('k'); // Setting the piece type of rook piece
    }

    // Override method from parent class ChessPiece to define the movement of Rook piece.
    @Override
    public ChessPiece[][] movementPlacements(int xAxis, int yAxis, ChessPiece[][] board) {
        return null;
    }
}
