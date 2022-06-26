// Every piece in the chess board has a directional movement. This Interface is used to declare the directional movements for the piece.
public interface ILineMovement {

    ChessPiece[][] leftMovement(int xAxis, int yAxis, ChessPiece[][] board); // Left directional move function in 2D board.
    ChessPiece[][] rigthMovement(int xAxis, int yAxis, ChessPiece[][] board); // Right directional move function in 2D board.
    ChessPiece[][] upMovement(int xAxis, int yAxis, ChessPiece[][] board); // Up directional move function in 2D board.
    ChessPiece[][] downMovement(int xAxis, int yAxis, ChessPiece[][] board); // Down directional move function in 2D board.

}
