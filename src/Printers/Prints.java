package Printers;

import java.util.Arrays;

public class Prints {
    public static final String WHITE_BACKGROUND = "\033[47m";
    private static final String YELLOW_BACKGROUND = "\033[43m";
    public static final String RED_BACKGROUND = "\033[41m";
    public static final String BLACK = "\033[30m";
    public static final String BLUE_BACKGROUND = "\033[44m";
    public static final String CYAN_BACKGROUND = "\033[46m";
    private static String[] score = new String[101];

    public static void Board(int playerScore, boolean[][] playerWall) {

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
        System.out.println("|" + score[1] + "|" + score[2] + "|" + score[3] + "|" + score[4] + "|" + YELLOW_BACKGROUND + BLACK + score[5] + "\033[39m" + "\033[49m" + "|" + score[6] + "|    |    |    |" + YELLOW_BACKGROUND + BLACK + score[10] + "\033[39m" + "\033[49m" + "|    |    |    |    |" + YELLOW_BACKGROUND + BLACK + score[15] + "\033[39m" + "\033[49m" + "|    |    |    |    |" + YELLOW_BACKGROUND + BLACK + score[20] + "\033[39m" + "\033[49m" + "|");
        System.out.println("+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+");
        System.out.println("|    |    |    |    |" + YELLOW_BACKGROUND + BLACK + score[25] + "\033[39m" + "\033[49m" + "|    |    |    |    |" + YELLOW_BACKGROUND + BLACK + score[30] + "\033[39m" + "\033[49m" + "|    |    |    |    |" + YELLOW_BACKGROUND + BLACK + score[35] + "\033[39m" + "\033[49m" + "|    |    |    |    |" + YELLOW_BACKGROUND + BLACK + score[40] + "\033[39m" + "\033[49m" + "|");
        System.out.println("+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+");
        System.out.println("|    |    |    |    |" + YELLOW_BACKGROUND + BLACK + score[45] + "\033[39m" + "\033[49m" + "|    |    |    |    |" + YELLOW_BACKGROUND + BLACK + score[50] + "\033[39m" + "\033[49m" + "|    |    |    |    |" + YELLOW_BACKGROUND + BLACK + score[55] + "\033[39m" + "\033[49m" + "|    |    |    |    |" + YELLOW_BACKGROUND + BLACK + score[60] + "\033[39m" + "\033[49m" + "|");
        System.out.println("+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+");
        System.out.println("|    |    |    |    |" + YELLOW_BACKGROUND + BLACK + score[65] + "\033[39m" + "\033[49m" + "|    |    |    |    |" + YELLOW_BACKGROUND + BLACK + score[70] + "\033[39m" + "\033[49m" + "|    |    |    |    |" + YELLOW_BACKGROUND + BLACK + score[75] + "\033[39m" + "\033[49m" + "|    |    |    |    |" + YELLOW_BACKGROUND + BLACK + score[80] + "\033[39m" + "\033[49m" + "|");
        System.out.println("+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+");
        System.out.println("|    |    |    |    |" + YELLOW_BACKGROUND + BLACK + score[85] + "\033[39m" + "\033[49m" + "|    |    |    |    |" + YELLOW_BACKGROUND + BLACK + score[90] + "\033[39m" + "\033[49m" + "|    |    |    |    |" + YELLOW_BACKGROUND + BLACK + score[95] + "\033[39m" + "\033[49m" + "|    |    |    |    |" + YELLOW_BACKGROUND + BLACK + score[100] + "\033[39m" + "\033[49m" + "|");
        System.out.println("+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+");
        System.out.println();
        System.out.println();
        System.out.println("                                    +------+           +------+------+------+------+------+  ");
        System.out.println("                                    |      |     ▶     |" + RED_BACKGROUND + "      " +"\033[39m"+"\033[49m"+"|"+ YELLOW_BACKGROUND +"      "+ "\033[39m" + "\033[49m" +"|"+BLUE_BACKGROUND+"      "+ "\033[39m" + "\033[49m" +"|"+WHITE_BACKGROUND       +"      "+"\033[39m" + "\033[49m" +"|"+CYAN_BACKGROUND+"      "+ "\033[39m" + "\033[49m" +"|  ");
        System.out.println("                                    +------+           +------+------+------+------+------+  ");
        System.out.println("                             +------+------+           +------+------+------+------+------+  ");
        System.out.println("                             |      |      |     ▶     |"+CYAN_BACKGROUND+"      "+ "\033[39m" + "\033[49m" +"|" + RED_BACKGROUND + "      " + "\033[39m" + "\033[49m" + "|"+ YELLOW_BACKGROUND +"      "+ "\033[39m" + "\033[49m" +"|"+BLUE_BACKGROUND+"      "+ "\033[39m" + "\033[49m" +"|"+WHITE_BACKGROUND+"      "+"\033[39m" + "\033[49m" + "|  ");
        System.out.println("                             +------+------+           +------+------+------+------+------+  ");
        System.out.println("                      +------+------+------+           +------+------+------+------+------+  ");
        System.out.println("                      |      |      |      |     ▶     |"+WHITE_BACKGROUND+"      "+ "\033[39m" + "\033[49m" +"|"+CYAN_BACKGROUND+"      "+ "\033[39m" + "\033[49m" +"|" + RED_BACKGROUND + "      " + "\033[39m" + "\033[49m" + "|"+ YELLOW_BACKGROUND +"      "+ "\033[39m" + "\033[49m" +"|"+BLUE_BACKGROUND+"      "+ "\033[39m" + "\033[49m" +"|  ");
        System.out.println("                      +------+------+------+           +------+------+------+------+------+  ");
        System.out.println("               +------+------+------+------+           +------+------+------+------+------+  ");
        System.out.println("               |      |      |      |      |     ▶     |"+BLUE_BACKGROUND+"      "+ "\033[39m" + "\033[49m" +"|"+WHITE_BACKGROUND+"      "+ "\033[39m" + "\033[49m" +"|"+CYAN_BACKGROUND+"      "+ "\033[39m" + "\033[49m" +"|" + RED_BACKGROUND + "      " + "\033[39m" + "\033[49m" + "|"+ YELLOW_BACKGROUND +"      "+ "\033[39m" + "\033[49m" +"|  ");
        System.out.println("               +------+------+------+------+           +------+------+------+------+------+  ");
        System.out.println("        +------+------+------+------+------+           +------+------+------+------+------+  ");
        System.out.println("        |      |      |      |      |      |     ▶     |"+ YELLOW_BACKGROUND +"      "+ "\033[39m" + "\033[49m" +"|"+BLUE_BACKGROUND+"      "+"\033[39m" + "\033[49m" +"|"+WHITE_BACKGROUND+"      "+ "\033[39m" + "\033[49m" +"|"+CYAN_BACKGROUND+"      "+ "\033[39m" + "\033[49m" +"|" + RED_BACKGROUND + "      " + "\033[39m" + "\033[49m" + "|  ");
        System.out.println("        +------+------+------+------+------+           +------+------+------+------+------+  ");
        System.out.println();
        System.out.println();
        System.out.println("   __     __     __     __     __     __     __                                               |   ▼       ");
        System.out.println("  (-1)   (-1)   (-2)   (-2)   (-2)   (-3)   (-3)                          ▶ ☐ ☐ ☐ ☐ ☐ |+2|    |   ☐       ");
        System.out.println("+------+------+------+------+------+------+------+                      ----------------------|   ☐       ");
        System.out.println("|      |      |      |      |      |      |      |                                 =          |   ☐        ");
        System.out.println("+------+------+------+------+------+------+------+                            =  |+10|  =     |   ☐            ");
        System.out.println("                                                                                =     =       |   ☐            ");
        System.out.println("                                                                                              |  |+7|               ");
    }
}
