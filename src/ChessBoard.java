// Thiss is the Chess Board class. This class used to handle board operations.
public class ChessBoard {

    // Instant Variables
    private ChessPiece[][] board = new ChessPiece[8][8];
    private String[][] lines;
    private double blackPiecesScore = 0;
    private double whitePiecesScore = 0;

    // Constructor
    public ChessBoard(String[] args) {
        ReadWrite readWrite = new ReadWrite(args[0]); // Creates ReadWrite class object to handle input file.
        this.lines = readWrite.getBoardString().clone(); // Takes created String board file from ReadWrite Class.
        setBoard(); // Sets board with using String board.
        MovementScoreCalculate(); // Awakes movement for chess pieces.
        totalBoardScores(); // Calculates chess pieces values for whole board structure.
        readWrite.writeTextLines(this.whitePiecesScore,this.blackPiecesScore); // Saves total board puan into output file.
    }

    // Getter and Setter functions for instant variables.
    public ChessPiece[][] getBoard() {
        return board;
    }

    public double getBlackPiecesScore() {
        return blackPiecesScore;
    }

    public double getWhitePiecesScore() {
        return whitePiecesScore;
    }

    // Seting Board with chess piece classes.
    public void setBoard() {
        for(int i=0;i<this.board.length;i++){
            for (int j=0; j<this.board.length;j++){
                ChessPiece piece = this.createPiece(this.lines[i][j]); // Creates suitable chess piece
                this.board[i][j] = piece; // Saves into board every chess piece.
            }
        }
    }

    // This function awakes every piece movement function to determinate if piece threating another piece in the board.
    public void MovementScoreCalculate(){
        for(int i=0;i<this.board.length;i++){
            for (int j=0; j<this.board.length;j++){
                if(this.board[i][j]!=null){
                    ChessPiece[][] tempBoard = this.board[i][j].movementPlacements(i,j,this.board); // Takes movement results for piece and saves it into local variable.
                    if(tempBoard!=null) // Some pieces movement functions won't codded so we are handling null returns.
                        this.board = tempBoard.clone(); // After every movement functions board is updated so we are copied into original board structure.
                }
            }
        }
    }

    // This function calculates total value of board pieces.
    public void totalBoardScores(){
        for (ChessPiece[] pieces:this.board) {
            for (ChessPiece piece: pieces) {
                if(piece==null) continue; // If box is empty in the board continuous with next piece box.
                else if(piece.getSide()=='s'){ // If piece side is black
                    if(piece.isThreat()) // If piece has threat from another chess piece
                        this.blackPiecesScore+=piece.getValue()/2; // Threated piece value decreases half.
                    else
                        this.blackPiecesScore+=piece.getValue(); // takes normal value of piece.
                }
                else if(piece.getSide()=='b'){ // If piece side is white
                    if(piece.isThreat()) // If piece has threat from another chess piece
                        this.whitePiecesScore+=piece.getValue()/2; // Threated piece value decreases half.
                    else
                        this.whitePiecesScore+=piece.getValue(); // takes normal value of piece.
                }
            }
        }
    }

    // This function creates proper chess piece object with using input chess piece values.
    private ChessPiece createPiece(String piece){
        char pieceType = piece.charAt(0);
        switch (pieceType) {
            case 'p': return new Pawn(piece.charAt(1)); // If piece is pawn
            case 'a': return new Knight(piece.charAt(1)); // If piece is knight
            case 'f': return new Bishop(piece.charAt(1)); // If piece is bishop
            case 'k': return new Rook(piece.charAt(1)); // If piece is rook
            case 'v': return new Queen(piece.charAt(1)); // If piece is queen
            case 's': return new King(piece.charAt(1)); // If piece is king
            default: return null; // If pice is empty in the board or another input value detected
        }
    }

    // This function is to print board
    public void print(){
        for (ChessPiece[] pic:this.board) {
            for (ChessPiece picc: pic) {
                if(picc == null){
                    System.out.print("E-E\t");
                    continue;
                }
                System.out.print(picc.getPiece()+ "-" + picc.getSide()+"\t");
            }
            System.out.println();
        }
    }
}
