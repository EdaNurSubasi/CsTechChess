//This class is for Queen piece in chess board
public class Queen extends ChessPiece implements ILineMovement, ICrossMovement{

    // Constructor
    public Queen(char side) {
        setSide(side);// Setting the side of Queen piece.
        setValue(9);// Setting the value of Queen piece.
        setPiece('v');// Setting the piece type of Queen piece
    }

    // Override method from parent class ChessPiece to define the movement of Queen piece.
    @Override
    public ChessPiece[][] movementPlacements(int xAxis, int yAxis, ChessPiece[][] board) {
        // Queen piece moves directional or cross in the board
        board = leftMovement(xAxis, yAxis, board).clone();
        board = rigthMovement(xAxis, yAxis, board).clone();
        board = upMovement(xAxis, yAxis, board).clone();
        board = downMovement(xAxis, yAxis, board).clone();
        board = upLeftCrossMovement(xAxis, yAxis, board).clone();
        board = downLeftCrossMovement(xAxis, yAxis, board).clone();
        board = upRightCrossMovement(xAxis, yAxis, board).clone();
        board = downRigthCrossMovement(xAxis, yAxis, board).clone();
        return board;
    }

    // Cross movement functions
    // In cross movement both x axis and y axis decreases or increases at the same time
    @Override
    public ChessPiece[][] upRightCrossMovement(int xAxis, int yAxis, ChessPiece[][] board) {
        int newyAxis = yAxis+1; // Starting place to move in y axis.
        int newxAxis = xAxis-1; // Starting place to move in x axis.
        while(newxAxis>-1&&newyAxis<8){ // x axis cannot be negative and y axis cannot be more than seven.
            if(board[newxAxis][newyAxis]!=null){ // If board place has a piece in it.
                if(board[newxAxis][newyAxis].getSide() != board[xAxis][yAxis].getSide()){ // If detected piece side is different from the original piece.
                    board[newxAxis][newyAxis].setThreat(); // Detected piece is threating by the original piece.
                }
                break; // If original piece acrossed with any chess piece in the way, o need to look rest of the way.
            }
            newxAxis--;// Update the x axis according to movement type
            newyAxis++;// Update the y axis according to movement type
        }
        return board;
    }

    @Override
    public ChessPiece[][] downRigthCrossMovement(int xAxis, int yAxis, ChessPiece[][] board) {
        int newyAxis = yAxis+1; // Starting place to move in y axis.
        int newxAxis = xAxis+1; // Starting place to move in x axis.
        while(newxAxis<8&&newyAxis<8){ // x axis and y axis cannot be more than seven.
            if(board[newxAxis][newyAxis]!=null){ // If board place has a piece in it.
                if(board[newxAxis][newyAxis].getSide() != board[xAxis][yAxis].getSide()){ // If detected piece side is different from the original piece.
                    board[newxAxis][newyAxis].setThreat(); // Detected piece is threating by the original piece.
                }
                break; // If original piece acrossed with any chess piece in the way, o need to look rest of the way.
            }
            newxAxis++;// Update the x axis according to movement type
            newyAxis++;// Update the y axis according to movement type
        }
        return board;
    }

    @Override
    public ChessPiece[][] upLeftCrossMovement(int xAxis, int yAxis, ChessPiece[][] board) {
        int newyAxis = yAxis-1; // Starting place to move in y axis.
        int newxAxis = xAxis-1; // Starting place to move in x axis.
        while(newxAxis>-1&&newyAxis>-1){ // x axis and y axis cannot be negative.
            if(board[newxAxis][newyAxis]!=null){ // If board place has a piece in it.
                if(board[newxAxis][newyAxis].getSide() != board[xAxis][yAxis].getSide()){ // If detected piece side is different from the original piece.
                    board[newxAxis][newyAxis].setThreat(); // Detected piece is threating by the original piece.
                }
                break; // If original piece acrossed with any chess piece in the way, o need to look rest of the way.
            }
            newxAxis--;// Update the x axis according to movement type
            newyAxis--;// Update the y axis according to movement type
        }
        return board;
    }

    @Override
    public ChessPiece[][] downLeftCrossMovement(int xAxis, int yAxis, ChessPiece[][] board) {
        int newyAxis = yAxis-1; // Starting place to move in y axis.
        int newxAxis = xAxis+1; // Starting place to move in x axis.
        while(newxAxis<8&&newyAxis>-1){ // x axis cannot be more than seven and y axis cannot be negative.
            if(board[newxAxis][newyAxis]!=null){ // If board place has a piece in it.
                if(board[newxAxis][newyAxis].getSide() != board[xAxis][yAxis].getSide()){ // If detected piece side is different from the original piece.
                    board[newxAxis][newyAxis].setThreat(); // Detected piece is threating by the original piece.
                }
                break; // If original piece acrossed with any chess piece in the way, o need to look rest of the way.
            }
            newxAxis++;// Update the x axis according to movement type
            newyAxis--;// Update the y axis according to movement type
        }
        return board;
    }

    // Directional movements

    // During left movement x axis never changes.
    public ChessPiece[][] leftMovement(int xAxis, int yAxis, ChessPiece[][] board) {
        int newyAxis = yAxis-1; // Starting place to move in y axis.
        while(newyAxis>-1){ // y axis cannot be negative.
            if(board[xAxis][newyAxis]!=null){ // If board place has a piece in it.
                if(board[xAxis][newyAxis].getSide() != board[xAxis][yAxis].getSide()){ // If detected piece side is different from the original piece.
                    board[xAxis][newyAxis].setThreat(); // Detected piece is threating by the original piece.
                }
                break; // If original piece acrossed with any chess piece in the way, o need to look rest of the way.
            }
            newyAxis--;// Update the y axis according to movement type
        }
        return board;
    }

    // During right movement x axis never changes
    public ChessPiece[][] rigthMovement(int xAxis, int yAxis, ChessPiece[][] board) {
        int newyAxis = yAxis+1; // Starting place to move in y axis.
        while(newyAxis<8){ // y axis cannot be more than seven.
            if(board[xAxis][newyAxis]!=null){ // If board place has a piece in it.
                if(board[xAxis][newyAxis].getSide() != board[xAxis][yAxis].getSide()){ // If detected piece side is different from the original piece.
                    board[xAxis][newyAxis].setThreat(); // Detected piece is threating by the original piece.
                }
                break; // If original piece acrossed with any chess piece in the way, o need to look rest of the way.
            }
            newyAxis++;// Update the y axis according to movement type
        }
        return board;
    }

    // During up movement y axis never changes
    public ChessPiece[][] upMovement(int xAxis, int yAxis, ChessPiece[][] board) {
        int newxAxis = xAxis-1; // Starting place to move in x axis.
        while(newxAxis>-1){ // x axis cannot be negative.
            if(board[newxAxis][yAxis]!=null){ // If board place has a piece in it.
                if(board[newxAxis][yAxis].getSide() != board[xAxis][yAxis].getSide()){ // If detected piece side is different from the original piece.
                    board[newxAxis][yAxis].setThreat(); // Detected piece is threating by the original piece.
                }
                break; // If original piece acrossed with any chess piece in the way, o need to look rest of the way.
            }
            newxAxis--;// Update the x axis according to movement type
        }
        return board;
    }

    // During down movement y axis never changes.
    public ChessPiece[][] downMovement(int xAxis, int yAxis, ChessPiece[][] board) {
        int newxAxis = xAxis+1; // Starting place to move in x axis.
        while(newxAxis<8){ // x axis cannot be more than seven
            if(board[newxAxis][yAxis]!=null){ // If board place has a piece in it.
                if(board[newxAxis][yAxis].getSide() != board[xAxis][yAxis].getSide()){ // If detected piece side is different from the original piece.
                    board[newxAxis][yAxis].setThreat(); // Detected piece is threating by the original piece.
                }
                break; // If original piece acrossed with any chess piece in the way, o need to look rest of the way.
            }
            newxAxis++;// Update the x axis according to movement type
        }
        return board;
    }
}
