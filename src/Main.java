import azul.AzulGame;
import azul.GlobalResources;

public class Main {
    public static void main(String[] args) {
        // TODO: validate num of players
        System.out.print("Number of Players (2-4): ");
        int numPlayers = Integer.valueOf(GlobalResources.SCANNER.nextLine());

        AzulGame ag = new AzulGame(numPlayers);

        // play rounds until game over
        while(!ag.playRound());

        ag.getStandings();

        // azul.player.Player with the biggest score Wins
    }
}