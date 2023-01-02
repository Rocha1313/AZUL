package utils;

public enum Colors {
    BLUE_BACKGROUND("\u001B[1;44m"),
    CYAN_BACKGROUND("\u001B[1;46m"),
    YELLOW_BACKGROUND("\u001B[1;43m"),
    BLACK_BACKGROUND("\u001B[1;40m"),
    RED_BACKGROUND("\u001B[1;41m"),
    RESET("\u001B[0m");

    String sequence;

    Colors(String sequence) {
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        return sequence;
    }
}
