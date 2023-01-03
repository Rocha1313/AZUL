package azul.components;

import azul.components.Piece;
import azul.player.Player;
import utils.Color;
import azul.player.Player;

import java.util.List;

public class Wall {

    Player players;
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
        for (int i = lineIndex - 1; i >= 0 && wallStatus[lineIndex][i]; i--) {
            verticalCount++;
        }
        // count pieces down
        for (int i = lineIndex + 1; i < wallStatus.length && wallStatus[lineIndex][i]; i++) {
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

            if()

                if (player.getLeftOverLine().get(0) != null) {
                    score -= score - 1;
                } else if (player.getLeftOverLine().get(1) != null) {
                    score -= score - 1;
                } else if (player.getLeftOverLine().get(2) != null) {
                    score -= score - 2;
                } else if (player.getLeftOverLine().get(3) != null) {
                    score -= score - 2;
                } else if (player.getLeftOverLine().get(4) != null) {
                    score -= score - 2;
                } else if (player.getLeftOverLine().get(5) != null) {
                    score -= score - 3;
                } else if (player.getLeftOverLine().get(6) != null) {
                    score -= score - 3;
                }




        return score;
    }

    public boolean hasPatternOnLine(int lineIndex, Piece pattern) {
        int patternIndex = indexOfPattern(lineIndex, pattern);

        return wallStatus[lineIndex][patternIndex];
    }

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
}