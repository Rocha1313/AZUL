package Game;

import Game.Azul.Azul;
import GlobalResources.GlobalResources;

public class Game {

    public static void start(){
        int numPlayers = getNumberOfPlayersInput();

        Azul azul = new Azul(numPlayers);
        azul.start();
    }

    //Return a valid input
    private static int getNumberOfPlayersInput(){
        int numPlayers;
        System.out.println("Number of Players (2-4): ");
        String input = GlobalResources.sc.next();

        try {
            numPlayers = Integer.parseInt(input);
        }catch (NumberFormatException nfe){
            System.out.println("Invalid Input!!!");
            return getNumberOfPlayersInput();
        }

        if (!(numPlayers >= 2) || !(numPlayers <= 4)){
            System.out.println("Invalid Input!!!");
            return getNumberOfPlayersInput();
        }

        return numPlayers;
    }
}
