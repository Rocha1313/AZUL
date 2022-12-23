// echo -e "without being filled: \e[0m⛄\e[0m🎁\e[0m🎅\e[0m🎄\e[0m🦌\nWall:\n\e[1;44m⛄\e[1;43m🎁\e[1;41m🎅\e[1;40m🎄\e[1;46m🦌\e[0m\n\e[1;46m🦌\e[1;44m⛄\e[1;43m🎁\e[1;41m🎅\e[1;40m🎄\e[0m\n\e[1;40m🎄\e[1;46m🦌\e[1;44m⛄\e[1;43m🎁\e[1;41m🎅\e[0m\n\e[1;41m🎅\e[1;40m🎄\e[1;46m🦌\e[1;44m⛄\e[1;43m🎁\e[0m\n\e[1;43m🎁\e[1;41m🎅\e[1;40m🎄\e[1;46m🦌\e[1;44m⛄\e[0m\n"

public class Main {
    public static void main(String[] args) {
        // TODO: validate num of players
        System.out.print("Number of Players (2-4): ");
        int numPlayers = GlobalResources.sc.nextInt();

        AzulGame ag = new AzulGame(numPlayers);

        // play rounds until game over
        while(!ag.playRound());

        ag.getStandings();

        // Player with the biggest score Wins
    }
}