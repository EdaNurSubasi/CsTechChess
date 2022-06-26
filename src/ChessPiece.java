//Every Chess Piece inherited from this abstract class.
public abstract class ChessPiece {

    private double value; //Every chess piece has own value. This value will be used to calculate board total value.
    private char side; // This instant variable used to determinate piece is white chess piece or black chess piece. This variable defined with input value.
    private char piece; // This variable used to determinate which piece is this. This variable defined with input value.
    private boolean threat = false; // This variable used to determinate if the piece is under thread from another piece or not.

    public abstract ChessPiece[][] movementPlacements(int xAxis, int yAxis, ChessPiece[][] board); //Every Chess Piece has own movement algorithm. That's why this function has not body.

    //Getter Setter methods to access the instant variables.
    public double getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public char getSide() {
        return side;
    }

    public void setSide(char side) {
        this.side = side;
    }

    public char getPiece() {
        return piece;
    }

    public void setPiece(char piece) {
        this.piece = piece;
    }

    public boolean isThreat() {
        return threat;
    }

    public void setThreat() {
        this.threat = true;
    }

}
