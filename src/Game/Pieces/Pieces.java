package Game.Pieces;

public enum Pieces {
    SANTA("🎅"),
    CHRISTMAS_TREE("🎄"),
    GIFT("🎁"),
    SNOWMAN("⛄️"),
    REINDEER("🦌");

    private final String pattern;

    Pieces(String pattern){
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
