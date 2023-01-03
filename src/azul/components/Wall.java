package azul.components;

import utils.Color;

public class Wall {
    private static final Piece[][] WALL_PATTERN = {
            {Piece.SNOWMAN, Piece.GIFT, Piece.SANTA, Piece.CHRISTMAS_TREE, Piece.REINDEER},
            {Piece.REINDEER, Piece.SNOWMAN, Piece.GIFT, Piece.SANTA, Piece.CHRISTMAS_TREE},
            {Piece.CHRISTMAS_TREE, Piece.REINDEER, Piece.SNOWMAN, Piece.GIFT, Piece.SANTA},
            {Piece.SANTA, Piece.CHRISTMAS_TREE, Piece.REINDEER, Piece.SNOWMAN, Piece.GIFT},
            {Piece.GIFT, Piece.SANTA, Piece.CHRISTMAS_TREE, Piece.REINDEER, Piece.SNOWMAN},
    };

    private boolean[][] wallStatus;

    public Wall() {
        wallStatus = new boolean[5][5];
    }

    public int move(int lineIndex, Piece p) {
        // find index of pattern in given line
        int indexOfPiece = indexOfPattern(lineIndex, p);

        // mark piece field on the wall
        wallStatus[lineIndex][indexOfPiece] = true;

        // calculate piece score and return the score
        return calculateScore(lineIndex, indexOfPiece);
    }

    private int calculateScore(int lineIndex, int indexOfPiece) {
        // Calculate horizontal score
        int horizontalCount = 0;

        // count pieces to the left
        for (int i = indexOfPiece - 1; i >= 0 && wallStatus[lineIndex][i]; i--) {
            horizontalCount++;
        }
        // count pieces to the right
        for (int i = indexOfPiece + 1; i < wallStatus[lineIndex].length && wallStatus[lineIndex][i]; i++) {
            horizontalCount++;
        }
        // calculate vertical score
        int verticalCount = 0;
        // count pieces up
        for (int i = lineIndex - 1; i >= 0 && wallStatus[i][indexOfPiece]; i--) {
            verticalCount++;
        }
        // count pieces down
        for (int i = lineIndex + 1; i < wallStatus.length && wallStatus[i][indexOfPiece]; i++) {
            verticalCount++;
        }

        int score = 0;
        if (horizontalCount > 0) {
            score += horizontalCount + 1;
        }
        if (verticalCount > 0) {
            score += verticalCount + 1;
        }
        // if there were no vertical or horizontal points, piece is worth only one point
        if (score == 0) {
            score = 1;
        }

        return score;
    }

    public boolean hasPatternOnLine(int lineIndex, Piece pattern) {
        int patternIndex = indexOfPattern(lineIndex, pattern);

        return wallStatus[lineIndex][patternIndex];
    }

    // returns the index of the given pattern from the given line
    private int indexOfPattern(int lineIndex, Piece pattern) {
        for (int i = 0; i < WALL_PATTERN[lineIndex].length; i++) {
            Piece p = WALL_PATTERN[lineIndex][i];
            if (p == pattern) {
                return i;
            }
        }
        return -1;
    }

    public String lineToString(int lineIndex) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < wallStatus[lineIndex].length; j++) {
            if (wallStatus[lineIndex][j]) {
                sb.append(WALL_PATTERN[lineIndex][j].getColor());
            }
            sb.append(WALL_PATTERN[lineIndex][j].getPattern());
            if (wallStatus[lineIndex][j]) {
                sb.append(Color.RESET);
            }
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wallStatus.length; i++) {
            for (int j = 0; j < wallStatus[i].length; j++) {
                if (wallStatus[i][j]) {
                    sb.append(WALL_PATTERN[i][j].getColor());
                }
                sb.append(WALL_PATTERN[i][j].getPattern());
                if (wallStatus[i][j]) {
                    sb.append(Color.RESET);
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public boolean hasLineCompleted() {
        // for each line on the wall
        for (int i = 0; i < wallStatus.length; i++){
            // Proved the current line to be completed, because there was no missing pieces on the wall
            if (isLineCompleted(i)) {
                return true;
            }
        }

        // no line was found to be completed
        return false;
    }

    private boolean isLineCompleted(int lineIndex) {
        // check if this line is completed
        boolean lineCompleted = true;
        for (int j = 0; j < wallStatus[lineIndex].length; j++) {
            // if piece is missing, it's not completed
            if (!wallStatus[lineIndex][j]) {
                lineCompleted = false;
                break;
            }
        }

        return lineCompleted;
    }

    public int linesCompleted() {
        int linesCompleted = 0;
        for(int i = 0; i < wallStatus.length; i++) {
            if(isLineCompleted(i)) {
                linesCompleted++;
            }
        }
        return linesCompleted;
    }

    public int columnsCompleted() {
        int columnsCompleted = 0;

        // starting on the first line
        if(0 < wallStatus.length) {
            // for every column in the first line
            for(int j = 0; j < wallStatus[0].length; j++) {
                // assume its completed
                boolean columnCompleted = true;
                for(int i = 0; i < wallStatus[i].length; i++) {
                    // check if piece is missing disproving the assumption
                    if(!wallStatus[i][j]) {
                        columnCompleted = false;
                    }
                }

                if(columnCompleted) {
                    columnsCompleted++;
                }
            }

        }

        return columnsCompleted;
    }

    public int patternsCompleted() {
        int patternsCompleted = 0;

        // for each piece that exists
        for(Piece p : Piece.values()) {
            boolean patternCompleted = true;
            // check that each line has this pattern
            for(int i = 0; i < wallStatus.length; i++) {
                if(!wallStatus[i][indexOfPattern(i, p)]) {
                    patternCompleted = false;
                }
            }

            if(patternCompleted) {
                patternsCompleted++;
            }
        }

        return patternsCompleted;
    }

    public boolean[][] getWallStatus() {
        return wallStatus;
    }
}