import java.util.Arrays;

public class Wall {
    private static final Piece[][] WALL_PATTERN = {
        { Piece.SNOWMAN, Piece.GIFT, Piece.SANTA, Piece.CHRISTMAS_TREE, Piece.REINDEER },
        { Piece.REINDEER, Piece.SNOWMAN, Piece.GIFT, Piece.SANTA, Piece.CHRISTMAS_TREE },
        { Piece.CHRISTMAS_TREE, Piece.REINDEER, Piece.SNOWMAN, Piece.GIFT, Piece.SANTA },
        { Piece.SANTA, Piece.CHRISTMAS_TREE, Piece.REINDEER, Piece.SNOWMAN, Piece.GIFT },
        { Piece.GIFT, Piece.SANTA, Piece.CHRISTMAS_TREE, Piece.REINDEER, Piece.SNOWMAN },
    };

    private boolean[][] wallStatus;

    public Wall() {
        wallStatus = new boolean[5][5];
    }

    public int move(Piece p, int line) {
        // find index of pattern in given line
        int indexOfPiece = findIndexOf(WALL_PATTERN[line], p);
        // mark piece field on the wall
        wallStatus[line][indexOfPiece] = true;

        // calculate piece score and return the score
        int pieceScore = 0;

        return pieceScore;
    }

    public boolean[][] getWallStatus() {
        return wallStatus;
    }
}