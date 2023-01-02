package azul.components;

import utils.Color;

public enum Piece {
    SANTA("🎅", Color.RED_BACKGROUND),
    CHRISTMAS_TREE("🎄", Color.BLACK_BACKGROUND),
    GIFT("🎁", Color.YELLOW_BACKGROUND),
    SNOWMAN("⛄️", Color.BLUE_BACKGROUND),
    REINDEER("🦌", Color.CYAN_BACKGROUND),

    STARTING_PIECE("🤯", Color.RESET);

    private final String pattern;
    private final Color color;

    Piece(String pattern, Color color) {
        this.pattern = pattern;
        this.color = color;
    }

    public String getPattern() {
        return pattern;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return pattern;
    }
}
