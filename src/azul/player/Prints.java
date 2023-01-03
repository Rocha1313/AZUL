package azul.player;

import azul.components.Piece;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Prints {
    public static final String WHITE_BACKGROUND = "\033[47m";
    private static final String YELLOW_BACKGROUND = "\033[43m";
    public static final String RED_BACKGROUND = "\033[41m";
    public static final String BLACK = "\033[30m";
    public static final String BLUE_BACKGROUND = "\033[44m";
    public static final String CYAN_BACKGROUND = "\033[46m";
    private static String[] score = new String[101];
    private static String[] colors = new String[]{RED_BACKGROUND, YELLOW_BACKGROUND, BLUE_BACKGROUND, WHITE_BACKGROUND, CYAN_BACKGROUND};

    private static void nextColor() {
        String firstColor = colors[colors.length - 1];
        for (int i = colors.length - 1; i > 0; i--) {
            colors[i] = colors[i - 1];
        }
        colors[0] = firstColor;
    }

    public static void Board(int playerScore, boolean[][] playerWall, List<List<Piece>> playerStairs, List<Piece> playerFloor) {

        String[][] wallBoard = new String[5][5];
        String emoji = " ";
        for (int i = 0; i < playerWall.length; i++) {
            for (int j = 0; j < playerWall[i].length; j++) {
                if (playerWall[i][j]) {
                    switch (colors[j]) {
                        case RED_BACKGROUND -> emoji = "  🎅  ";
                        case YELLOW_BACKGROUND -> emoji = "  🎁  ";
                        case BLUE_BACKGROUND -> emoji = "  ⛄  ";
                        case WHITE_BACKGROUND -> emoji = "  🦌  ";
                        case CYAN_BACKGROUND -> emoji = "  🎄  ";
                    }
                    wallBoard[i][j] = colors[j] + emoji + "\033[39m" + "\033[49m";
                    continue;
                }
                wallBoard[i][j] = colors[j] + "      " + "\033[39m" + "\033[49m";
            }
            nextColor();
        }

        String[][] stairsBoard = new String[5][5];
        for (int i = 0; i < playerStairs.size(); i++) {
            for (int j = 0; j < 5; j++) {
                if (playerStairs.get(i).size() < (j + 1)) {
                    stairsBoard[i][j] = "      ";
                    continue;
                }

                if (j >= playerStairs.get(i).size()){
                    break;
                }
                switch (playerStairs.get(i).get(j)) {
                    case SANTA -> stairsBoard[i][j] = RED_BACKGROUND + "  🎅  " + "\033[39m" + "\033[49m";
                    case GIFT -> stairsBoard[i][j] = YELLOW_BACKGROUND + "  🎁  " + "\033[39m" + "\033[49m";
                    case SNOWMAN -> stairsBoard[i][j] = BLUE_BACKGROUND + "  ⛄  " + "\033[39m" + "\033[49m";
                    case REINDEER -> stairsBoard[i][j] = WHITE_BACKGROUND + "  🦌  " + "\033[39m" + "\033[49m";
                    case CHRISTMAS_TREE -> stairsBoard[i][j] = CYAN_BACKGROUND + "  🎄  " + "\033[39m" + "\033[49m";
                }

            }

        }

        String[] floorBoard = new String[7];
        for (int i = 0; i < floorBoard.length; i++) {

            if (i >= playerFloor.size()) {
                floorBoard[i] = "      ";
                continue;
            }

            switch (playerFloor.get(i)) {
                case SANTA -> floorBoard[i] = RED_BACKGROUND + "  🎅  " + "\033[39m" + "\033[49m";
                case GIFT -> floorBoard[i] = YELLOW_BACKGROUND + "  🎁  " + "\033[39m" + "\033[49m";
                case SNOWMAN -> floorBoard[i] = BLUE_BACKGROUND + "  ⛄  " + "\033[39m" + "\033[49m";
                case REINDEER -> floorBoard[i] = WHITE_BACKGROUND + "  🦌  " + "\033[39m" + "\033[49m";
                case CHRISTMAS_TREE -> floorBoard[i] = CYAN_BACKGROUND + "  🎄  " + "\033[39m" + "\033[49m";
                case STARTING_PIECE -> floorBoard[i] = WHITE_BACKGROUND + "  1️⃣  " + "\033[39m" + "\033[49m";
            }
        }

        Arrays.fill(score, "    ");
        for (int i = 0; i < score.length; i++) {
            if (i == 100) {
                score[i] = " " + i;
                break;

            }
            if (i == playerScore) {
                score[i] = WHITE_BACKGROUND + "    " + "\033[39m" + "\033[49m";
                continue;
            }
            if (i % 5 == 0 && i < 10) {
                score[i] = "  " + i + " ";
            } else if (i % 5 == 0) {
                score[i] = " " + i + " ";
            }
        }

        System.out.println("+----+");
        System.out.println("|" + YELLOW_BACKGROUND + BLACK + score[0] + "\033[39m" + "\033[49m" + "|");
        System.out.println("+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+");
        System.out.println("|" + score[1] + "|" + score[2] + "|" + score[3] + "|" + score[4] + "|" + YELLOW_BACKGROUND + BLACK + score[5] + "\033[39m" + "\033[49m" + "|" + score[6] + "|" + score[7] + "|" + score[8] + "|" + score[9] + "|" + YELLOW_BACKGROUND + BLACK + score[10] + "\033[39m" + "\033[49m" + "|" + score[11] + "|" + score[12] + "|" + score[13] + "|" + score[14] + "|" + YELLOW_BACKGROUND + BLACK + score[15] + "\033[39m" + "\033[49m" + "|" + score[16] + "|" + score[17] + "|" + score[18] + "|" + score[19] + "|" + YELLOW_BACKGROUND + BLACK + score[20] + "\033[39m" + "\033[49m" + "|");
        System.out.println("+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+");
        System.out.println("|" + score[21] + "|" + score[22] + "|" + score[23] + "|" + score[24] + "|" + YELLOW_BACKGROUND + BLACK + score[25] + "\033[39m" + "\033[49m" + "|" + score[26] + "|" + score[27] + "|" + score[28] + "|" + score[29] + "|" + YELLOW_BACKGROUND + BLACK + score[30] + "\033[39m" + "\033[49m" + "|" + score[31] + "|" + score[32] + "|" + score[33] + "|" + score[34] + "|" + YELLOW_BACKGROUND + BLACK + score[35] + "\033[39m" + "\033[49m" + "|" + score[36] + "|" + score[37] + "|" + score[38] + "|" + score[39] + "|" + YELLOW_BACKGROUND + BLACK + score[40] + "\033[39m" + "\033[49m" + "|");
        System.out.println("+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+");
        System.out.println("|" + score[41] + "|" + score[42] + "|" + score[43] + "|" + score[44] + "|" + YELLOW_BACKGROUND + BLACK + score[45] + "\033[39m" + "\033[49m" + "|" + score[46] + "|" + score[47] + "|" + score[48] + "|" + score[49] + "|" + YELLOW_BACKGROUND + BLACK + score[50] + "\033[39m" + "\033[49m" + "|" + score[51] + "|" + score[52] + "|" + score[53] + "|" + score[54] + "|" + YELLOW_BACKGROUND + BLACK + score[55] + "\033[39m" + "\033[49m" + "|" + score[56] + "|" + score[57] + "|" + score[58] + "|" + score[59] + "|" + YELLOW_BACKGROUND + BLACK + score[60] + "\033[39m" + "\033[49m" + "|");
        System.out.println("+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+");
        System.out.println("|" + score[61] + "|" + score[62] + "|" + score[63] + "|" + score[64] + "|" + YELLOW_BACKGROUND + BLACK + score[65] + "\033[39m" + "\033[49m" + "|" + score[66] + "|" + score[67] + "|" + score[68] + "|" + score[69] + "|" + YELLOW_BACKGROUND + BLACK + score[70] + "\033[39m" + "\033[49m" + "|" + score[71] + "|" + score[72] + "|" + score[73] + "|" + score[74] + "|" + YELLOW_BACKGROUND + BLACK + score[75] + "\033[39m" + "\033[49m" + "|" + score[76] + "|" + score[77] + "|" + score[78] + "|" + score[79] + "|" + YELLOW_BACKGROUND + BLACK + score[80] + "\033[39m" + "\033[49m" + "|");
        System.out.println("+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+");
        System.out.println("|" + score[81] + "|" + score[82] + "|" + score[83] + "|" + score[84] + "|" + YELLOW_BACKGROUND + BLACK + score[85] + "\033[39m" + "\033[49m" + "|" + score[86] + "|" + score[87] + "|" + score[88] + "|" + score[89] + "|" + YELLOW_BACKGROUND + BLACK + score[90] + "\033[39m" + "\033[49m" + "|" + score[91] + "|" + score[92] + "|" + score[93] + "|" + score[94] + "|" + YELLOW_BACKGROUND + BLACK + score[95] + "\033[39m" + "\033[49m" + "|" + score[96] + "|" + score[97] + "|" + score[98] + "|" + score[99] + "|" + YELLOW_BACKGROUND + BLACK + score[100] + "\033[39m" + "\033[49m" + "|");
        System.out.println("+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+");
        System.out.println();
        System.out.println();
        System.out.println("                                    +------+           +------+------+------+------+------+  ");
        System.out.println("                                    |" + stairsBoard[0][0] + "|     ▶     |" + wallBoard[0][0] + "|" + wallBoard[0][1] + "|" + wallBoard[0][2] + "|" + wallBoard[0][3] + "|" + wallBoard[0][4] + "|  ");
        System.out.println("                                    +------+           +------+------+------+------+------+  ");
        System.out.println("                             +------+------+           +------+------+------+------+------+  ");
        System.out.println("                             |" + stairsBoard[1][1] + "|" + stairsBoard[1][0] + "|     ▶     |" + wallBoard[1][0] + "|" + wallBoard[1][1] + "|" + wallBoard[1][2] + "|" + wallBoard[1][3] + "|" + wallBoard[1][4] + "|  ");
        System.out.println("                             +------+------+           +------+------+------+------+------+  ");
        System.out.println("                      +------+------+------+           +------+------+------+------+------+  ");
        System.out.println("                      |" + stairsBoard[2][2] + "|" + stairsBoard[2][1] + "|" + stairsBoard[2][0] + "|     ▶     |" + wallBoard[2][0] + "|" + wallBoard[2][1] + "|" + wallBoard[2][2] + "|" + wallBoard[2][3] + "|" + wallBoard[2][4] + "|  ");
        System.out.println("                      +------+------+------+           +------+------+------+------+------+  ");
        System.out.println("               +------+------+------+------+           +------+------+------+------+------+  ");
        System.out.println("               |" + stairsBoard[3][3] + "|" + stairsBoard[3][2] + "|" + stairsBoard[3][1] + "|" + stairsBoard[3][0] + "|     ▶     |" + wallBoard[3][0] + "|" + wallBoard[3][1] + "|" + wallBoard[3][2] + "|" + wallBoard[3][3] + "|" + wallBoard[3][4] + "|  ");
        System.out.println("               +------+------+------+------+           +------+------+------+------+------+  ");
        System.out.println("        +------+------+------+------+------+           +------+------+------+------+------+  ");
        System.out.println("        |" + stairsBoard[4][4] + "|" + stairsBoard[4][3] + "|" + stairsBoard[4][2] + "|" + stairsBoard[4][1] + "|" + stairsBoard[4][0] + "|     ▶     |" + wallBoard[4][0] + "|" + wallBoard[4][1] + "|" + wallBoard[4][2] + "|" + wallBoard[4][3] + "|" + wallBoard[4][4] + "|  ");
        System.out.println("        +------+------+------+------+------+           +------+------+------+------+------+  ");
        System.out.println();
        System.out.println();
        System.out.println("   __     __     __     __     __     __     __                                               |   ▼       ");
        System.out.println("  (-1)   (-1)   (-2)   (-2)   (-2)   (-3)   (-3)                          ▶ ☐ ☐ ☐ ☐ ☐ |+2|    |   ☐       ");
        System.out.println("+------+------+------+------+------+------+------+                      ----------------------|   ☐       ");
        System.out.println("|" + floorBoard[0] + "|" + floorBoard[1] + "|" + floorBoard[2] + "|" + floorBoard[3] + "|" + floorBoard[4] + "|" + floorBoard[5] + "|" + floorBoard[6] + "|                                 =          |   ☐        ");
        System.out.println("+------+------+------+------+------+------+------+                            =  |+10|  =     |   ☐            ");
        System.out.println("                                                                                =     =       |   ☐            ");
        System.out.println("                                                                                              |  |+7|               ");
    }
}
