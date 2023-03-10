package utils;

public enum Color {
    BLUE_BACKGROUND("\u001B[1;44m"),
    BLUE("\u001B[1;34m"),
    CYAN_BACKGROUND("\u001B[1;46m"),
    YELLOW_BACKGROUND("\u001B[1;43m"),
    BLACK_BACKGROUND("\u001B[1;40m"),
    RED_BACKGROUND("\u001B[1;41m"),
    WHITE_BACKGROUND( "\u001B[1;47m"),
    RESET("\u001B[0m");

    String sequence;

    Color(String sequence) {
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        return sequence;
    }
}
