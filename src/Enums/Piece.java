package Enums;

public enum Piece {
    SANTA("🎅"),
    CHRISTMAS_TREE("🎄"),
    GIFT("🎁"),
    SNOWMAN("⛄️"),
    REINDEER("🦌");

    private final String pattern;

    Piece(String pattern){
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
