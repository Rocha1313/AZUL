public class Player {

    public static final int NUMBER_OF_PATTERN_LINES = 5;
    public static final int NUMBER_OF_PIECES_LEFTOVER_LINE = 7;

    private int score;
    private Wall wall;
    private Piece[][] patternLines;
    private Piece[] leftOverLine;

    public Player() {
        score = 0;
        wall = new Wall();
        patternLines = new Piece[NUMBER_OF_PATTERN_LINES][];
        for (int i = 0; i < patternLines.length; i++) {
            patternLines[i] = new Piece[i + 1];
        }

        leftOverLine = new Piece[NUMBER_OF_PIECES_LEFTOVER_LINE];
    }
}
