// This is the main class of the program.
public class Main {

    // Program starts with this function.
    public static void main(String[] args) {

        // If user gives wrong parameters into program this if block handles with this misunderstanding.
        if(args.length != 1){
            System.out.println("Please use one file to start the program!"); // Gives a start tip to user.
            System.exit(-1); // Closes the program.
        }

        // Starts the board with this object creation.
        ChessBoard board = new ChessBoard(args); // Takes program args into board class to handle chess board.
//        Test.Test(args);
    }

}
