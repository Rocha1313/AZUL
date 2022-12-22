package Game.Pieces;

public class Piece {

    private final int MIN_NUMBER_OF_PIECES = 0;
    private final int MAX_NUMBER_OF_PIECES = 20;
    private Pieces patternType;
    private int number;

    //Constructor's
    public Piece() {}

    //Method's

    //Withdraw Pieces
    public void withdrawPieces(int numberOfPieces){
        if (checkMin(numberOfPieces)){
            this.number -= numberOfPieces;
            return;
        }
        System.out.println("Error: Negative number of pieces!!!");
    }

    //Increments pieces
    public void incrementerPieces(int numberOfPieces){
        if (checkMax(numberOfPieces)){
            this.number += numberOfPieces;
            return;
        }
        System.out.println("Error: Number of Pieces exceeds max number of pieces!!!");
    }

    //Check if isn't above of max Number of pieces
    public boolean checkMax(int numberOfPieces){
        return (number + numberOfPieces) <= MAX_NUMBER_OF_PIECES;
    }

    //Check if isn't below of max Number of pieces
    public boolean checkMin(int numberOfPieces){
        return (number - numberOfPieces) >= MIN_NUMBER_OF_PIECES;
    }

    //Getter's
    public Pieces getPatternType() {
        return patternType;
    }

    public int getNumber() {
        return number;
    }

    //Setter's

    public void setPatternType(Pieces patternType) {
        this.patternType = patternType;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}