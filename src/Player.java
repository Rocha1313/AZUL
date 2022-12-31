import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Player {

    public static final int NUMBER_OF_PATTERN_LINES = 5;
    public static final int NUMBER_OF_PIECES_LEFTOVER_LINE = 7;

    private int score;
    private Wall wall;
    private List<List<Piece>> patternLines;
    private Piece[] leftOverLine;

    public Player() {
        score = 0;
        wall = new Wall();
        patternLines = new ArrayList<>(NUMBER_OF_PATTERN_LINES);
        for (int i = 0; i < patternLines.size(); i++) {
            patternLines.set(i+1, new ArrayList<>(i));
        }

        leftOverLine = new Piece[NUMBER_OF_PIECES_LEFTOVER_LINE];
    }

    public PlayChoice choosePieces(Collection<Factory> factories, Garbage garbage) {
        PlayChoice finalChoice = null;

        Place place = null;
        Factory factory = null;
        Piece pattern = null;
        int patternLineIndex = -1;

        boolean validChoice = false;
        String input;

        while (!validChoice) {
            System.out.print("Choose place (factory/garbage): ");
            input = GlobalResources.sc.nextLine();
            if (Place.FACTORY.name().startsWith(input.toUpperCase()) || Place.FACTORY.ordinal() == Integer.valueOf(input) - 1) {
                place = Place.FACTORY;

                System.out.print("Choose factory: ");
                input = GlobalResources.sc.nextLine();
                Iterator<Factory> iterator = factories.iterator();
                for (int i = 0; i < factories.size(); i++) {
                    Factory f = iterator.next();
                    if (i == Integer.valueOf(input) - 1) {
                        factory = f;
                    }
                }

                validChoice = factory != null;
            } else if (Place.GARBAGE.name().startsWith(input.toUpperCase()) || Place.GARBAGE.ordinal() == Integer.valueOf(input) - 1) {
                place = Place.GARBAGE;
                validChoice = true;
            }
        }

        validChoice = false;
        while (!validChoice) {
            System.out.print("Pattern: ");
            input = GlobalResources.sc.nextLine();

            for (Piece p : Piece.values()) {
                if (p.name().startsWith(input.toUpperCase())) {
                    pattern = p;
                    validChoice = true;
                }
            }
        }

        validChoice = false;
        while (!validChoice) {
            System.out.print("Pattern Line: ");
            input = GlobalResources.sc.nextLine();

            patternLineIndex = Integer.valueOf(input) - 1;

            if (patternLineIndex >= 0 && patternLineIndex < patternLines.size()) {
                validChoice = true;
            }
        }

        switch (place) {
            case FACTORY:
                finalChoice = new PlayChoice(factory, pattern, patternLineIndex);
                break;
            case GARBAGE:
                finalChoice = new PlayChoice(garbage, pattern, patternLineIndex);
                break;
        }

        return finalChoice;
    }

    public void placePieces(int patternLineIndex, Collection<Piece> pieces) {
        // place pieces in patternLines[patternLineIndex]
        // pieces need to be all the same pattern
        // pieces need to have same pattern as existing pieces on patternLines[patternLineIndex]
        // if pieces contain starting Piece , move starting piece to leftOverLine
        // if patternLines[patternLineIndex] becomes full move remaining pieces to leftOverLine
    }

    // move pieces from pattern line to wall and return the remaining pieces from the pattern lines and from the leftover line
    public Collection<Piece> movePiecesToWall() {
        // for each pattern Line
        for(int i = 0; i < patternLines.size(); i++) {
            List<Piece> patternLine = patternLines.get(i);
            // if pattern line is full
            // move one piece of pattern line to wall and sum the points of that move to the score
            score += wall.move(piece, i);
            // add remaining pieces to the recycler
            piecesToRecycle.add();
        }
        return piecesToRecycle;
    }

    public boolean hasWallWithLineCompleted() {
        return false;
    }
}
