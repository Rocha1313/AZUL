public enum Piece {
    SANTA("🎅"),
    CHRISTMAS_TREE("🎄"),
    GIFT("🎁"),
    SNOWMAN("⛄️"),
    REINDEER("🦌");

    private final String pattern;

// System.out.println("\e[" + piece.getPrintableColorCode() + "m" +  piece.getPattern() + "\e[0m")



    Piece(String pattern) {
        this.pattern = pattern;
    }
}
