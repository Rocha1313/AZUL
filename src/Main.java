
import azul.AzulGame;
import azul.GlobalResources;
import azul.player.Player;
import utils.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int player = 0;
        int statusMenu = 0;
        int menuprin = 1;
        int numberInput;

        switch (menuprin) {
            case 1:
                System.out.println("\t\t\t\t\t          +------+------+------+------+------+");
                System.out.println("\t\t\t\t\t          |" + Color.WHITE_BACKGROUND + "  🦌  " + "\033[39m" + "\033[49m" + "|" + Color.YELLOW_BACKGROUND + "  🎁  " + "\033[39m" + "\033[49m" + "|" + Color.BLUE_BACKGROUND + "  ⛄  " + "\033[39m" + "\033[49m" + "|" + Color.CYAN_BACKGROUND + "  🎄  " + "\033[39m" + "\033[49m" + "|" + Color.RED_BACKGROUND + "  🎅  " + "\033[39m" + "\033[49m" + "|");
                System.out.println("\t\t\t\t\t          +------+------+------+------+------+");
                System.out.println("\n" +
                        Color.BLUE + "\t\t\t\t\t\t     █████╗ ███████╗██╗   ██╗██╗     \n" +
                        "\t\t\t\t\t\t     ██╔══██╗╚══███╔╝██║   ██║██║     \n" +
                        "\t\t\t\t\t\t     ███████║  ███╔╝ ██║   ██║██║     \n" +
                        "\t\t\t\t\t\t     ██╔══██║ ███╔╝  ██║   ██║██║     \n" +
                        "\t\t\t\t\t\t     ██║  ██║███████╗╚██████╔╝███████╗\n" +
                        "\t\t\t\t\t\t     ╚═╝  ╚═╝╚══════╝ ╚═════╝ ╚══════╝\n" + "\033[39m" + "\033[49m" +
                        "                                     \n");
                for (int i = 0; i <= 50; i++) {
                    System.out.print("\t\t  [");
                    for (int k = 0; k < i; k++) {
                        System.out.print("⛄");
                    }
                    for (int j = 50; j > i; j--) {
                        System.out.print("-");
                    }
                    System.out.print("] " + (i + i) + "% ");
                    Thread.sleep(30);
                    System.out.print("\r");
                }
                Thread.sleep(500);
                System.out.println("\n\n\n");
                System.out.print("\t\t\t\t\t\t\t     [PRESS ENTER] ");
                System.out.println("\n\n\n\n");
                scanner.nextLine();
        }
        System.out.println("\t\t\t\t\t\t\t      +-------+-+");
        System.out.println("\t\t\t\t\t\t\t      |" + Color.RED_BACKGROUND + "Play 🎅" + "\033[39m" + "\033[49m" + "|1|");
        System.out.println("\t\t\t\t\t\t\t      +-------+-+");
        System.out.println("\t\t\t\t\t\t\t      |" + Color.BLUE_BACKGROUND + "Quit ⛄" + "\033[39m" + "\033[49m" + "|0|");
        System.out.println("\t\t\t\t\t\t\t      +-------+-+");
        while (true){
            try{
                System.out.print("\t\t\t\t\t\t Choose: ");
                numberInput = Integer.parseInt(GlobalResources.SCANNER.nextLine());
            }catch (NumberFormatException nfe){
                continue;
            }

            if (numberInput == 1 || numberInput == 0){
                break;
            }
        }

        player = numberInput;


        switch (player) {
            case 1:
                while (true){
                    try{
                        System.out.print("Number of Players (2-4): ");
                        numberInput = Integer.parseInt(GlobalResources.SCANNER.nextLine());
                    }catch (NumberFormatException nfe){
                        continue;
                    }

                    if (numberInput >= 2 && numberInput <= 4){
                        break;
                    }
                }

                int numPlayers = numberInput;

                AzulGame ag = new AzulGame(numPlayers);

                // play rounds until game over
                while (!ag.playRound()) ;

                List<Player> playerStandings = ag.getStandings();

                for (int i = 0; i < playerStandings.size(); i++) {
                    Player p = playerStandings.get(i);

                    if (i == 0) {
                        System.out.printf("%dst place: Player#%d%n - %d points", i + 1, p.getId(), p.getScore());
                        System.out.println();
                    } else if (i == 1) {
                        System.out.printf("%dnd place: Player#%d%n - %d points", i + 1, p.getId(), p.getScore());
                        System.out.println();
                    } else if (i == 2) {
                        System.out.printf("%drd place: Player#%d%n - %d points", i + 1, p.getId(), p.getScore());
                        System.out.println();
                    } else {
                        System.out.printf("%dth place: Player#%d%n - %d points", i + 1, p.getId(), p.getScore());
                        System.out.println();
                    }
                    break;
                }

            case 0:
                System.exit(0);
                statusMenu = 0;
                break;

        }
        while (statusMenu != 0) ;
    }

}



