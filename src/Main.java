public class Main {
    public static void main(String[] args) {
        // TODO: validate num of players
        System.out.print("Number of Players (2-4): ");
        int numPlayers = GlobalResources.sc.nextInt();

        AzulGame ag = new AzulGame(numPlayers);

        // play rounds until game over
        while (!ag.playRound()) ;

        ag.getStandings();

        // Player with the biggest score Wins

    }
}

