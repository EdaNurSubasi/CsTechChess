// This is the test class to test functions and classes functionality.
public class Test {

    public static void Test(String[] args){
        ChessBoard board = new ChessBoard(args);
        ReadWrite readWrite = new ReadWrite(args[0]);
        readWrite.writeTextLines(3,4);
//        board.print();
    }


}
