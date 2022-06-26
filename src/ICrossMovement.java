// Some pieces in the chess board has a cross movement. This Interface is used to declare the cross movements for the piece.
public interface ICrossMovement {

    ChessPiece[][] upRightCrossMovement(int xAxis, int yAxis, ChessPiece[][] board); // Right and up directional move function in 2D board.
    ChessPiece[][] upLeftCrossMovement(int xAxis, int yAxis, ChessPiece[][] board); // Left and up directional move function in 2D board.
    ChessPiece[][] downRigthCrossMovement(int xAxis, int yAxis, ChessPiece[][] board); // Right and down directional move function in 2D board.
    ChessPiece[][] downLeftCrossMovement(int xAxis, int yAxis, ChessPiece[][] board); // left and down directional move function in 2D board.

}
