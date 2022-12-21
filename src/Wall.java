public class Wall {
    private static final Piece[][] WALL_PATTERN = {
        { Piece.SNOWMAN, Piece.GIFT, Piece.SANTA, PIECE.CHRISTMAS_TREE, Piece.REINDEER },
        { Piece.REINDEER, Piece.SNOWMAN, Piece.GIFT, Piece.SANTA, PIECE.CHRISTMAS_TREE },
        { PIECE.CHRISTMAS_TREE, Piece.REINDEER, Piece.SNOWMAN, Piece.GIFT, Piece.SANTA },
        { Piece.SANTA, PIECE.CHRISTMAS_TREE, Piece.REINDEER, Piece.SNOWMAN, Piece.GIFT },
        { Piece.GIFT, Piece.SANTA, PIECE.CHRISTMAS_TREE, Piece.REINDEER, Piece.SNOWMAN },
    };

    private boolean[][] wallStatus;

    public Wall() {
        wallStatus = new boolean[5][5];
    }

}