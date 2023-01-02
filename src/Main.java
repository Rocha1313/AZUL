import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Piece[] idk = new Piece[7];
        ArrayList<List<Piece>>nao = new ArrayList<>();
        boolean[][] naosei = new boolean[5][5];
        naosei[2][3] = true;
        ArrayList<Piece> test1 = new ArrayList<>();
        ArrayList<Piece> test2 = new ArrayList<>();
        ArrayList<Piece> test3 = new ArrayList<>();
        ArrayList<Piece> test4 = new ArrayList<>();
        ArrayList<Piece> test5 = new ArrayList<>();
        test1.add(Piece.SANTA);
        test2.add(null);
        test2.add(null);
        test3.add(null);
        test3.add(null);
        test3.add(null);
        test4.add(null);
        test4.add(null);
        test4.add(null);
        test4.add(null);
        test5.add(null);
        test5.add(null);
        test5.add(null);
        test5.add(null);
        test5.add(null);
        nao.add(test1);
        nao.add(test2);
        nao.add(test3);
        nao.add(test4);
        nao.add(test5);
        idk[0] = Piece.STARTING_PIECE;
        idk[1] = Piece.SANTA;
        Prints.Board(57,naosei,nao,idk);
        // TODO: validate num of players
        /*System.out.print("Number of Players (2-4): ");
        int numPlayers = GlobalResources.sc.nextInt();

        AzulGame ag = new AzulGame(numPlayers);

        // play rounds until game over
        while (!ag.playRound()) ;

        ag.getStandings();

        // Player with the biggest score Wins*/

    }
}

