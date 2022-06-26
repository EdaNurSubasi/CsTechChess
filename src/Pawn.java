//This class is for Pawn piece in chess board
public class Pawn extends ChessPiece implements ICrossMovement{

    // Constructor
    public Pawn(char side) {
        setSide(side);// Setting the side of Pawn piece.
        setValue(1);// Setting the value of Pawn piece.
        setPiece('p');// Setting the piece type of Pawn piece
    }

    // Override method from parent class ChessPiece to define the movement of Pawn piece.
    @Override
    public ChessPiece[][] movementPlacements(int xAxis, int yAxis, ChessPiece[][] board) {
        // Pawn piece moves one box cross in the board
        ChessPiece piece = board[xAxis][yAxis];
        // White pawns move only up, black pawns move only down
        if(piece.getSide()=='b'){ // If piece is white
            board = upLeftCrossMovement(xAxis, yAxis, board).clone();
            board = upRightCrossMovement(xAxis, yAxis, board).clone();
        }
        else{ // If piece is black
            board = downRigthCrossMovement(xAxis, yAxis, board).clone();
            board = downLeftCrossMovement(xAxis, yAxis, board).clone();
        }
        return board;
    }

    // Cross movement functions
    // In cross movement both x axis and y axis decreases or increases at the same time
    public ChessPiece[][] upRightCrossMovement(int xAxis, int yAxis, ChessPiece[][] board) {
        int newyAxis = yAxis + 1; // Starting place to move in y axis.
        int newxAxis = xAxis - 1; // Starting place to move in x axis.
        if(newyAxis<8){ // y axis cannot be more than seven.
            if (board[newxAxis][newyAxis] != null &&  // If board place has a piece in it.
                    board[newxAxis][newyAxis].getSide() != 'b') { // If detected piece side is black.
                board[newxAxis][newyAxis].setThreat(); // Detected piece is threating by the original piece.
            }
        }
        return board;
    }

    public ChessPiece[][] upLeftCrossMovement(int xAxis, int yAxis, ChessPiece[][] board) {
        int newyAxis = yAxis - 1; // Starting place to move in y axis.
        int newxAxis = xAxis - 1; // Starting place to move in x axis.
        if(newyAxis>-1){ // y axis cannot be negative.
            if (board[newxAxis][newyAxis] != null &&  // If board place has a piece in it.
                    board[newxAxis][newyAxis].getSide() != 'b') { // If detected piece side is black.
                board[newxAxis][newyAxis].setThreat(); // Detected piece is threating by the original piece.
            }
        }
        return board;
    }

    public ChessPiece[][] downRigthCrossMovement(int xAxis, int yAxis, ChessPiece[][] board) {
        int newyAxis = yAxis + 1; // Starting place to move in y axis.
        int newxAxis = xAxis + 1; // Starting place to move in x axis.
        if(newyAxis<8){ // y axis cannot be more than seven.
            if (board[newxAxis][newyAxis] != null &&  // If board place has a piece in it.
                    board[newxAxis][newyAxis].getSide() != 's') { // If detected piece side is white.
                board[newxAxis][newyAxis].setThreat(); // Detected piece is threating by the original piece.
            }
        }
        return board;
    }

    public ChessPiece[][] downLeftCrossMovement(int xAxis, int yAxis, ChessPiece[][] board) {
        int newyAxis = yAxis - 1; // Starting place to move in y axis.
        int newxAxis = xAxis + 1; // Starting place to move in x axis.
        if(newyAxis>-1){ // y axis cannot be negative.
            if (board[newxAxis][newyAxis] != null &&  // If board place has a piece in it.
                    board[newxAxis][newyAxis].getSide() != 's') { // If detected piece side is white.
                board[newxAxis][newyAxis].setThreat(); // Detected piece is threating by the original piece.
            }
        }
        return board;
    }
}
