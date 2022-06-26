// Used Libraries in the class
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// This class is used for read input file or files and generate a output file for results.
public class ReadWrite {
    private List<String> lines = new ArrayList<String>(); // Holds every line in the input file.
    private String[][] boardString = new String[8][8]; // Turns String board from input file values.
    private String filePath; // Holds input file path to read file and write output file.

    // Constructor
    public ReadWrite(String filePath) {
        this.filePath = filePath;
        this.readTextLines(); // Read values from input file.
        this.seperateLines(); // Generate string board from input file.
    }

    //Getter and Setter methods to use class instant variables.
    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String[][] getBoardString() {
        return boardString;
    }

    public void setBoardString(String[][] boardString) {
        this.boardString = boardString;
    }

    //Class Functions

    // Read input file Line by line and save values into lines array list variable
    private void readTextLines(){
        this.lines = Collections.emptyList();
        try{
            this.lines = Files.readAllLines(Paths.get(this.filePath), StandardCharsets.UTF_8);
        }catch (IOException exception) // If any exception accurs while reading file this catch handle this issue.
        {
            System.out.println(exception.getMessage()); // Show error message to user.
            System.exit(-1); // Exits from program if any exception accurs
        }
    }

    // Chess Boards whole puan values save into a txt file with this function.
    public void writeTextLines(double whiteScore, double blackScore){
        try {
            Path file = Paths.get(this.filePath); // Takes file path with Path library to take parent path and input file name.
            System.out.println("Result File Saved as \"results.txt\": "+file.getParent()); // Results file will save in to input file directory to access results easly. This is a information output for user.
            FileWriter fileWriter = new FileWriter(file.getParent()+"\\"+"results.txt"); // This FileWriter object creates and opens file to save output results.
            fileWriter.write("Tahta Dosya Adı\t\tSonuçlar\n"); // First line in the output file
            fileWriter.write(file.getFileName()+"\t\t"+"Siyah:"+Double.toString(blackScore)+"\t"+"Beyaz:"+ String.valueOf(whiteScore)); // Writes board results into file
            fileWriter.close(); // File saved and closed.
        }catch (IOException exception){ // If any exception accurs while opening and writing file this catch handle with that exception
            System.out.println(exception.getMessage()); // Show error message to user.
        }
    }

    // This function turns read lines into String chess board to create chess board easly.
    private void seperateLines(){
        for(int i = 0; i<this.lines.size(); i++){
            String[] line=this.lines.get(i).split(" "); // Splits every chess piece part in the line.
            for(int j=0;j<line.length;j++){
                this.boardString[i][j]=line[j]; // Saves every chess piece as string into String Chess Board structure.
            }
        }
    }
}
