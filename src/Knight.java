//This class is for Knight piece in chess board
public class Knight extends ChessPiece implements ILineMovement{

    // Constructor
    public Knight(char side) {
        setSide(side);// Setting the side of Knight piece.
        setValue(3);// Setting the value of Knight piece.
        setPiece('a');// Setting the piece type of Knight piece
    }

    // Override method from parent class ChessPiece to define the movement of Knight piece.
    @Override
    public ChessPiece[][] movementPlacements(int xAxis, int yAxis, ChessPiece[][] board) {
        // Knight piece moves L shape in the board
        board = leftMovement(xAxis, yAxis, board).clone();
        board = rigthMovement(xAxis, yAxis, board).clone();
        board = upMovement(xAxis, yAxis, board).clone();
        board = downMovement(xAxis, yAxis, board).clone();
        return board;
    }

    // Movement functions
    // Ever L movement knight can face up or down in left and right movements
    public ChessPiece[][] leftMovement(int xAxis, int yAxis, ChessPiece[][] board) {
        int newyAxis = yAxis - 2;
        int newxAxisup = xAxis - 1;
        int newxAxisdown = xAxis + 1;

        if(newyAxis>-1){ // y axis cannot be negative.
            if(newxAxisdown<8){ // x axis cannot be more than seven.
                if (board[newxAxisdown][newyAxis] != null && // If board place has a piece in it.
                        board[newxAxisdown][newyAxis].getSide() != board[xAxis][yAxis].getSide()) { // If detected piece side is different from the original piece.
                    board[newxAxisdown][newyAxis].setThreat(); // Detected piece is threating by the original piece.
                }
            }
            if(newxAxisup>-1){ // x axis cannot be negative.
                if (board[newxAxisup][newyAxis] != null &&  // If board place has a piece in it.
                        board[newxAxisup][newyAxis].getSide() != board[xAxis][yAxis].getSide()) { // If detected piece side is different from the original piece.
                    board[newxAxisup][newyAxis].setThreat(); // Detected piece is threating by the original piece.
                }
            }
        }
        return board;
    }

    public ChessPiece[][] rigthMovement(int xAxis, int yAxis, ChessPiece[][] board) {
        int newyAxis = yAxis + 2;
        int newxAxisup = xAxis - 1;
        int newxAxisdown = xAxis + 1;

        if(newyAxis<8){ // y axis cannot be more than seven.
            if(newxAxisup>-1){ // x axis cannot be negative.
                if (board[newxAxisup][newyAxis] != null &&  // If board place has a piece in it.
                        board[newxAxisup][newyAxis].getSide() != board[xAxis][yAxis].getSide()) { // If detected piece side is different from the original piece.
                    board[newxAxisup][newyAxis].setThreat(); // Detected piece is threating by the original piece.
                }
            }
            if(newxAxisdown<8){ // x axis cannot be more than seven.
                if (board[newxAxisdown][newyAxis] != null &&  // If board place has a piece in it.
                        board[newxAxisdown][newyAxis].getSide() != board[xAxis][yAxis].getSide()) { // If detected piece side is different from the original piece.
                    board[newxAxisdown][newyAxis].setThreat(); // Detected piece is threating by the original piece.
                }
            }
        }
        return board;
    }

    // Ever L movement knight can face left or right in up and down movements
    public ChessPiece[][] upMovement(int xAxis, int yAxis, ChessPiece[][] board) {
        int newyAxisRigth = yAxis + 1;
        int newyAxisLeft = yAxis - 1;
        int newxAxis = xAxis - 2;
        if(newxAxis>-1){ // x axis cannot be negative.
            if(newyAxisRigth<8){ // x axis cannot be more than seven.
                if (board[newxAxis][newyAxisRigth] != null &&  // If board place has a piece in it.
                        board[newxAxis][newyAxisRigth].getSide() != board[xAxis][yAxis].getSide()) { // If detected piece side is different from the original piece.
                    board[newxAxis][newyAxisRigth].setThreat(); // Detected piece is threating by the original piece.
                }
            }
            if(newyAxisLeft>-1){ // y axis cannot be negative.
                if (board[newxAxis][newyAxisLeft] != null &&  // If board place has a piece in it.
                        board[newxAxis][newyAxisLeft].getSide() != board[xAxis][yAxis].getSide()) { // If detected piece side is different from the original piece.
                    board[newxAxis][newyAxisLeft].setThreat(); // Detected piece is threating by the original piece.
                }
            }
        }
        return board;
    }

    public ChessPiece[][] downMovement(int xAxis, int yAxis, ChessPiece[][] board) {
        int newyAxisLeft = yAxis - 1;
        int newyAxisRigth = yAxis + 1;
        int newxAxis = xAxis + 2;
        if(newxAxis<8){ // x axis cannot be more than seven.
            if(newyAxisRigth<8){ // y axis cannot be more than seven.
                if (board[newxAxis][newyAxisRigth] != null &&  // If board place has a piece in it.
                        board[newxAxis][newyAxisRigth].getSide() != board[xAxis][yAxis].getSide()) { // If detected piece side is different from the original piece.
                    board[newxAxis][newyAxisRigth].setThreat(); // Detected piece is threating by the original piece.
                }
            }
            if(newyAxisLeft>-1){ // y axis cannot be negative.
                if (board[newxAxis][newyAxisLeft] != null &&  // If board place has a piece in it.
                        board[newxAxis][newyAxisLeft].getSide() != board[xAxis][yAxis].getSide()) { // If detected piece side is different from the original piece.
                    board[newxAxis][newyAxisLeft].setThreat(); // Detected piece is threating by the original piece.
                }
            }
        }
        return board;
    }
}
