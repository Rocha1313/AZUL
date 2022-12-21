public class AzulGame {
    
    public static final int MIN_PLAYERS = 2;
    public static final int MAX_PLAYERS = 4;
    private Player[] players; 
    private PieceBag bag;
    private PieceFactory[] factories;
    private PieceGarbage garbage;
    private PieceRecycler recycler;
    private int startingPlayer;

    public AzulGame(int numPlayers) {
        // check num of players is valid
        if(numPlayers < MIN_PLAYERS || numPlayers > MAX_PLAYERS) {
            throw new IllegalArgumentException("Number of players invalid.");
        }

        players = new Player[numPlayers];
        for(int i =0 ; i < players.length; i++) {
            players[i] = new Player();
        }

        startingPlayer = GlobalResources.random.nextInt(numPlayers);

        switch(numPlayers) {
            case 2:
                factories = new PieceFactory[5];
                break;
            case 3:
                factories = new PieceFactory[7];
                break;
            case 4:
                factories = new PieceFactory[9];
                break;
        }

        for(int i = 0; i < factories.length; i++) {
            factories[i] = new PieceFactory();
        }

        bag = new PieceBag();
        garbage = new PieceGarbage();
        recycler = new PieceRecycler();
    }

    public void play() {
        // prepare round
        //   - fill FACTORIES with pieces from bag
        //     - if bag becomes empty, recycle pieces (put all pieces from recycler into bag)
        //   - put starting piece in GARBAGE 
        // Player round
        //   - while FACTORIES/GARBAGE have pieces
        //     - current player pick pieces
        //        - choose FACTORY/GARBAGE and pattern 
        //        - choose PATTERN LINES to place pieces
        //          - validate PATTERN LINES
        //          - excess goes to LEFTOVER LINE
        //        - move pieces from FACTORY/GARBAGE to PATTERN LINE
                    // piecesTaken[] = factories[chosenFactory].takePieces(chosenPattern);
                    // player.putPieces(piecesTaken[0], chosenPatternLine);
                    // garbage.putPieces(piecesTaken[1]);
        //        - remaining FACTORY pieces go to GARBAGE 
        //        - if first from GARBAGE, give starting piece 
        //        - nextPlayer
        //   - end round
        //     - for each player
        //       - move completed PATTERN LINES to WALL
        //       - calculate piece points and add to score 
        //       - calculate LEFTOVER LINE points(negative points) and add to score 
        //       - discard extra pieces to RECYCLER
        //       - check if line completed on WALL
        //   - if no line completed on WALL 
        //     - next round
        //   - calculate final bonus points
        //     - lines +2
        //     - columns +7
        //     - All pieces of a pattern +10
        //   - Player with biggest score Wins


    }
}