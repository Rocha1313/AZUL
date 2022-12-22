package Game.Pieces;

public class Piece {

    private Pieces patternType;
    private int number;

    public Piece() {}

    public Pieces getPatternType() {
        return patternType;
    }

    public int getNumber() {
        return number;
    }

    public void setPatternType(Pieces patternType) {
        this.patternType = patternType;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}