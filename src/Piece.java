public enum PIECE {
    SANTA('🎅'),
    CHRISTMAS_TREE('🎄'),
    GIFT('🎁'),
    SNOWMAN('⛄️'),
    REINDEER('🦌');

    private final char pattern;

// System.out.println("\e[" + piece.getPrintableColorCode() + "m" +  piece.getPattern() + "\e[0m")

    public Piece(char pattern) {
        this.pattern = pattern;
    }
}