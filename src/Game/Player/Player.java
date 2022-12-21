package Game.Player;

import Game.Player.Board.Board;

public class Player {

    private int score;
    private Board board;

    public Player() {
        score = 0;
        board = new Board();
    }
}
