package Printers;


public class Prints {
    public static final String YELLOW_BACKGROUND = "\033[43m";

    public static void Board(){
        System.out.println("+----+");
        System.out.println("|"+YELLOW_BACKGROUND+"  0 "+ "\033[39m" + "\033[49m"+"|");
        System.out.println("+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+");
        System.out.println("|    |    |    |    |"+YELLOW_BACKGROUND+"  5 "+ "\033[39m" + "\033[49m"+"|    |    |    |    |"+YELLOW_BACKGROUND+" 10 "+ "\033[39m" + "\033[49m"+"|    |    |    |    |"+YELLOW_BACKGROUND+" 15 "+ "\033[39m" + "\033[49m"+"|    |    |    |    |"+YELLOW_BACKGROUND+" 20 "+ "\033[39m" + "\033[49m"+"|");
        System.out.println("+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+");
        System.out.println("|    |    |    |    |"+YELLOW_BACKGROUND+" 25 "+ "\033[39m" + "\033[49m"+"|    |    |    |    |"+YELLOW_BACKGROUND+" 30 "+ "\033[39m" + "\033[49m"+"|    |    |    |    |"+YELLOW_BACKGROUND+" 35 "+ "\033[39m" + "\033[49m"+"|    |    |    |    |"+YELLOW_BACKGROUND+" 40 "+ "\033[39m" + "\033[49m"+"|");
        System.out.println("+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+");
        System.out.println("|    |    |    |    |"+YELLOW_BACKGROUND+" 45 "+ "\033[39m" + "\033[49m"+"|    |    |    |    |"+YELLOW_BACKGROUND+" 50 "+ "\033[39m" + "\033[49m"+"|    |    |    |    |"+YELLOW_BACKGROUND+" 55 "+ "\033[39m" + "\033[49m"+"|    |    |    |    |"+YELLOW_BACKGROUND+" 60 "+ "\033[39m" + "\033[49m"+"|");
        System.out.println("+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+");
        System.out.println("|    |    |    |    |"+YELLOW_BACKGROUND+" 65 "+ "\033[39m" + "\033[49m"+"|    |    |    |    |"+YELLOW_BACKGROUND+" 70 "+ "\033[39m" + "\033[49m"+"|    |    |    |    |"+YELLOW_BACKGROUND+" 75 "+ "\033[39m" + "\033[49m"+"|    |    |    |    |"+YELLOW_BACKGROUND+" 80 "+ "\033[39m" + "\033[49m"+"|");
        System.out.println("+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+");
        System.out.println("|    |    |    |    |"+YELLOW_BACKGROUND+" 85 "+ "\033[39m" + "\033[49m"+"|    |    |    |    |"+YELLOW_BACKGROUND+" 90 "+ "\033[39m" + "\033[49m"+"|    |    |    |    |"+YELLOW_BACKGROUND+" 95 "+ "\033[39m" + "\033[49m"+"|    |    |    |    |"+YELLOW_BACKGROUND+" 100"+ "\033[39m" + "\033[49m"+"|");
        System.out.println("+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+");

        System.out.println("+-----+");
        System.out.println("|  🦊 |");
        System.out.println("+-----+");
    }
}
