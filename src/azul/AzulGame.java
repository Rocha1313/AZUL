package azul;

import azul.components.*;
import azul.exceptions.*;
import azul.player.PlayChoice;
import azul.player.Player;

import java.util.*;

import utils.Color;

public class AzulGame {

    public static final int MIN_PLAYERS = 2;
    public static final int MAX_PLAYERS = 4;
    private Player[] players;
    private Bag bag;
    private Factory[] factories;
    private Garbage garbage;
    private Recycler recycler;

    private int startingPlayerIndex;

    public AzulGame(int numPlayers) {
        // check num of players is valid
        if (numPlayers < MIN_PLAYERS || numPlayers > MAX_PLAYERS) {
            throw new IllegalArgumentException("Number of players invalid.");
        }

        players = new Player[numPlayers];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(i);
        }

        // Choose randomly who starts the game
        startingPlayerIndex = GlobalResources.RANDOM.nextInt(players.length);

        switch (numPlayers) {
            case 2 -> factories = new PieceFactory[5];
            case 3 -> factories = new PieceFactory[7];
            case 4 -> factories = new PieceFactory[9];
        }

        for (int i = 0; i < factories.length; i++) {
            factories[i] = new PieceFactory();
        }

        bag = new PieceBag();
        garbage = new PieceGarbage();
        garbage.add(List.of(Piece.STARTING_PIECE));
        recycler = new PieceRecycler();
    }

    // PLays a round of Azul
    // Fill factories with pieces and players pick pieces into their boards until there are no more pieces to be picked.
    // returns true if the game is over, false if there are more rounds to be played.
    public boolean playRound() throws GameStateException {
        ////////////////////
        // Prepare Round
        ////////////////////

        try {
            // fill factories with pieces from bag
            for (Factory factory : factories) {
                Collection<Piece> pieces;

                // if bag doesn't have enough pieces, recycle pieces (put all pieces from recycler into bag)
                if (bag.getAmount() < AzulConstants.FACTORY_PIECE_CAPACITY) {
                    bag.reFill(recycler.getPieces());
                }

                // fill the factories with pieces
                pieces = bag.getPieces();
                factory.fill(pieces);
            }
        } catch (FactoryException | BagException e) {
            throw new GameStateException("Failure in preparing Round", e);
        }

        ////////////////////
        // azul.player.Player round
        ////////////////////
        //TODO: surround player round logic with try/catch
        //the majority of exceptions should not occur because the player logic is validated and hopefully the code doesn't make calls into a bad state.
        // starting player to play

        int currentPlayerIndex = startingPlayerIndex;
        // while FACTORIES/GARBAGE have pieces
        while (!garbage.isEmpty() || !areFactoriesEmpty()) {

            try {
                Player currentPlayer = players[currentPlayerIndex];

                // ask current player for
                // - pattern
                // - place(a factory or garbage)
                // - pattern line
                // and validate this is a valid play
                PlayChoice choice;
                do {
                    display();
                    displayFactoriesAndGarbage();
                    System.out.println();
                    System.out.printf("Player #%d to play%n", currentPlayerIndex + 1);
                    choice = currentPlayer.choosePieces(Arrays.asList(factories), garbage);
                } while (!validateChoice(choice, currentPlayer));

                Collection<Piece> pieces = null;
                // take pieces with chosen pattern from chosen place
                switch (choice.getPlaceType()) {
                    case FACTORY:
                        pieces = choice.getFactory().getPieces(choice.getPattern());

                        garbage.add(choice.getFactory().getLeftOverPieces());
                        break;

                    case GARBAGE:
                        pieces = choice.getGarbage().getPieces(choice.getPattern());
                        break;
                }

                // player places pieces on its board on the chosen line
                currentPlayer.placePieces(choice.getPatternLineIndex(), pieces);

                // switch players turn
                currentPlayerIndex++;
                if (currentPlayerIndex >= players.length) {
                    currentPlayerIndex = 0;
                }
            } catch (PlayerException | PiecesNotFoundException e) {
                throw new GameStateException("Failure in player round", e);
            }
        }
        ////////////////////
        // End round
        ////////////////////
        //TODO: surround player round logic with try/catch
        //the majority of exceptions should not occur because the player logic is validated and hopefully the code doesnt make calls into a bad state.
        for (int i = 0; i < players.length; i++) {
            Player player = players[i];
            // the player itself moves pieces from completed pattern lines to the wall
            // as each piece moves the score goes up
            // any pieces on the leftover line are subtracted from the score.
            // the remaining pieces from the pattern lines and from the leftover line are returned
            Collection<Piece> pieces = player.movePiecesToWall();

            // Check if discarded pieces contain the starting piece
            for (Piece piece : pieces) {
                if (Piece.STARTING_PIECE.equals(piece)) {
                    startingPlayerIndex = i;
                    // put starting piece in GARBAGE
                    garbage.add(List.of(Piece.STARTING_PIECE));
                }
            }
            pieces.remove(Piece.STARTING_PIECE);

            // and put them into the recycler
            recycler.add(pieces);
        }
        // Check if any player has completed one line on the wall to determine if the game is over
        boolean gameOver = false;
        for (Player player : players) {
            if (player.hasWallWithLineCompleted()) {
                gameOver = true;
                break;
            }
        }

        return gameOver;
    }

    // TODO: FINAL
    //   - calculate final bonus points
    //     - lines +2
    //     - columns +7
    //     - All pieces of a pattern +10
    //   - return array sorted by position
    public List<Player> getStandings() {
        // copy players
        List<Player> playerStandings = new ArrayList<>();
        for (Player p : players) {
            playerStandings.add(p);
        }

        Comparator<Player> playerComparatorByScore = new Comparator<Player>() {
            @Override
            public int compare(Player onePlayer, Player anotherPlayer) {
                if (onePlayer.getScore() < anotherPlayer.getScore()) {
                    return -1;
                } else if (onePlayer.getScore() == anotherPlayer.getScore()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        };

        Collections.sort(playerStandings, playerComparatorByScore);

        return playerStandings;
    }

    public void displayFactoriesAndGarbage() {
        int i = 0;
        for (Factory factory : factories) {
            System.out.printf("Factory #%d: %s%n", i + 1, factory);
            i++;
        }

        System.out.printf("Garbage: %s%n", garbage);
    }

    private void display() {
        int i = 0;
        for (Player player : players) {
            System.out.println("========================================");
            System.out.printf("%sPlayer #%d%s%n", Color.RED_BACKGROUND, i + 1, Color.RESET);
            System.out.println();

            player.printBoard();

            /*System.out.println(player);*/
            i++;
        }

        System.out.println("========================================");
        System.out.println("========================================");

    }

    private boolean validateChoice(PlayChoice choice, Player player) {

        // validate if place(factory/garbage) has pieces with that pattern
        switch (choice.getPlaceType()) {
            case FACTORY -> {
                if (!choice.getFactory().hasPattern(choice.getPattern())) {
                    return false;
                }
            }
            case GARBAGE -> {
                if (!choice.getGarbage().hasPattern(choice.getPattern())) {
                    return false;
                }
            }
        }

        Piece patternOnPatternLine = player.getPatternOfPatternLine(choice.getPatternLineIndex());
        if (patternOnPatternLine != null) {
            // validate if pattern line has pieces, the chosen pattern have to correspond to the pattern line
            if (!player.isPatternLineFull(choice.getPatternLineIndex())) {
                if (choice.getPattern() != patternOnPatternLine) {
                    return false;
                }
            }
        } else {
            // validate if pattern line is empty, pattern isn't present on the wall
            if (player.hasPattern(choice.getPatternLineIndex(), choice.getPattern())) {
                return false;
            }
        }

        // valid choice
        return true;
    }

    private boolean areFactoriesEmpty() {
        boolean emptyFactories = true;

        for (Factory factory : factories) {
            if (!factory.isEmpty()) {
                emptyFactories = false;
            }
        }

        return emptyFactories;
    }

}
