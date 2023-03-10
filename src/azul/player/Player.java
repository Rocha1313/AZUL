package azul.player;

import azul.GlobalResources;
import azul.components.*;
import azul.exceptions.PatternAlreadyPresentOnWallOnLineException;
import azul.exceptions.PiecesNotTheSamePatternException;
import azul.exceptions.PlayerException;

import java.util.*;

public class Player {

    public static final int NUMBER_OF_PATTERN_LINES = 5;
    public static final int NUMBER_OF_PIECES_LEFTOVER_LINE = 7;
    private static final int WALL_EXTRA_SCORE_LINE = 2;
    private static final int WALL_EXTRA_SCORE_COLUMN = 7;
    private static final int WALL_EXTRA_SCORE_PATTERN = 10;

    private int id;
    private int score;
    private Wall wall;
    private List<List<Piece>> patternLines;
    private List<Piece> leftOverLine;
    private List<Integer> leftOverLineScore;

    public Player(int id) {
        this.id = id;

        score = 0;
        wall = new Wall();
        patternLines = new ArrayList<>(NUMBER_OF_PATTERN_LINES);
        for (int i = 0; i < NUMBER_OF_PATTERN_LINES; i++) {
            patternLines.add(new ArrayList<>(i));
        }

        leftOverLine = new ArrayList<>(NUMBER_OF_PIECES_LEFTOVER_LINE);
        leftOverLineScore = new ArrayList<>(Arrays.asList(-1, -1, -2, -2, -2, -3, -3));
    }

    public int getScore() {
        return score;
    }

    public int getId() {
        return id;
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
            input = GlobalResources.SCANNER.nextLine();

            if (Place.FACTORY.name().startsWith(input.toUpperCase())) {
                place = Place.FACTORY;

                int factoryNumber = 0;
                validChoice = false;

                while (!validChoice) {
                    System.out.print("Choose factory: ");
                    try {
                        factoryNumber = Integer.valueOf(GlobalResources.SCANNER.nextLine());
                        validChoice = true;
                    } catch (NumberFormatException e) {
                        validChoice = false;
                    }
                }

                Iterator<Factory> iterator = factories.iterator();
                for (int i = 0; i < factories.size(); i++) {
                    Factory f = iterator.next();
                    if (i == factoryNumber - 1) {
                        factory = f;
                    }
                }

                validChoice = factory != null;
            } else if (Place.GARBAGE.name().startsWith(input.toUpperCase())) {
                place = Place.GARBAGE;
                validChoice = true;
            }

        }

        validChoice = false;
        while (!validChoice) {
            System.out.print("Pattern: ");
            input = GlobalResources.SCANNER.nextLine();

            for (Piece p : Piece.values()) {
                if (p.name().startsWith(input.toUpperCase())) {
                    pattern = p;
                    validChoice = true;
                }
            }
        }

        validChoice = false;
        while (!validChoice) {
            int numberInput;


            while (true){
                System.out.print("Pattern Line: ");
                input = GlobalResources.SCANNER.nextLine();
                try{
                    numberInput = Integer.parseInt(input);
                }catch (NumberFormatException nfe){
                    continue;
                }
                break;
            }

            patternLineIndex = numberInput - 1;

            //
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

    public void placePieces(int patternLineIndex, Collection<Piece> pieces) throws PlayerException {
        // place pieces in patternLines[patternLineIndex]
        List<Piece> patternLine = patternLines.get(patternLineIndex);

        // if pieces contain starting azul.components.Piece , move starting piece to leftOverLine
        if (pieces.remove(Piece.STARTING_PIECE)) {
            leftOverLine.add(Piece.STARTING_PIECE);
        }

        // pieces need to be all the same pattern
        Piece pattern = null;
        boolean isPatternValid = true;
        for (Piece piece : pieces) {
            if (pattern == null) {
                pattern = piece;
            }
            if (piece != pattern) {
                isPatternValid = false;
            }
        }

        if (!isPatternValid) {
            if (isPatternLineFull(patternLineIndex)) {
                leftOverLine.addAll(pieces);
                return;
            } else {
                throw new PiecesNotTheSamePatternException(String.format("Expected all pattern pieces to be %s", pattern.name()));
            }
        }

        // pieces need to have same pattern as existing pieces on patternLines[patternLineIndex]
        Piece linePattern = null;
        if (!patternLine.isEmpty()) {
            linePattern = patternLine.get(0);
            if (linePattern != pattern) {
                throw new PiecesNotTheSamePatternException(String.format("Expected pieces to have same pattern as pattern in pattern line %s", pattern.name()));
            }
        } else if (wall.hasPatternOnLine(patternLineIndex, pattern)) {
            throw new PatternAlreadyPresentOnWallOnLineException(String.format("%s pattern is already present on the wall on the same line.", pattern));
        }

        // put pieces on pattern Line, overflow goes to leftover Line
        for (Piece p : pieces) {
            // if patternLine becomes full move remaining pieces to leftOverLine
            if (patternLine.size() <= patternLineIndex) {
                patternLine.add(p);
            } else {
                leftOverLine.add(p);
            }
        }

    }

    // move pieces from pattern line to wall and return the remaining pieces from the pattern lines and from the leftover line
    public Collection<Piece> movePiecesToWall() {
        Collection<Piece> piecesToRecycle = new ArrayList<>();

        // deal with leftover line
        // subtract from score leftover line score
        for (int i = 0; i < leftOverLine.size(); i++) {
            Piece p = leftOverLine.get(i);

            int pieceScore = 0;
            if (i < leftOverLineScore.size()) {
                pieceScore = leftOverLineScore.get(i);
            }

            score += pieceScore;
            piecesToRecycle.add(p);
        }
        // Remove pieces of leftover line
        for (Piece p : piecesToRecycle) {
            leftOverLine.remove(p);
        }

        // for each pattern Line
        for (int i = 0; i < patternLines.size(); i++) {
            List<Piece> patternLine = patternLines.get(i);
            // if pattern line is full
            if (patternLine.size() > i) {
                // move one piece of pattern line to wall and sum the points of that move to the score
                Piece p = patternLine.remove(0);
                score += wall.move(i, p);

                // add remaining pieces to the recycler
                piecesToRecycle.addAll(patternLine);
                patternLine.clear();
            }
        }

        return piecesToRecycle;
    }

    public int finalScore() {
        // lines
        score += wall.linesCompleted() * WALL_EXTRA_SCORE_LINE;

        // columns
        score += wall.columnsCompleted() * WALL_EXTRA_SCORE_COLUMN;

        // patterns
        score += wall.patternsCompleted() * WALL_EXTRA_SCORE_PATTERN;

        return score;
    }

    public boolean hasWallWithLineCompleted() {
        return wall.hasLineCompleted();
    }

    public boolean hasPattern(int patternLineIndex, Piece pattern) {
        return wall.hasPatternOnLine(patternLineIndex, pattern);
    }

    public Piece getPatternOfPatternLine(int patternLineIndex) {
        List<Piece> patternLine = patternLines.get(patternLineIndex);
        if (patternLine.isEmpty()) {
            return null;
        } else {
            return patternLine.get(0);
        }
    }

    public void printBoard(){
        Prints.Board(score, wall.getWallStatus(), patternLines, leftOverLine);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("score: ");
        sb.append(score);
        sb.append("\n");

        for (int i = 0; i < patternLines.size(); i++) {
            List<Piece> patternLine = patternLines.get(i);

            int emptySpace = patternLines.size() - i + 1;
            for (int j = 0; j < emptySpace; j++) {
                sb.append("  ");
            }

            int notFilled = i + 1 - patternLine.size();
            for (int j = 0; j < notFilled; j++) {
                sb.append("??????");
            }

            for (Piece p : patternLine) {
                sb.append(p);
            }

            sb.append(" ?????? ");
            sb.append(wall.lineToString(i));
            sb.append("\n");
        }

        sb.append("Leftover: ");
        sb.append("                                                                                    |   ???       ");
        sb.append("\n");
        sb.append("-1| -1| -2| -2| -2| -3| -3|                                               ??? ??? ??? ??? ??? ??? |+2|    |   ???       ");
        sb.append("\n");
        sb.append("                                                                        ----------------------|   ???       ");
        sb.append("\n");
        if (leftOverLine != null) {
            for (Piece p : leftOverLine) {
                sb.append(p).append("  ");
            }
        }
       sb.append("\n");
       sb.append("                                                                                   =          |   ???");
       sb.append("\n");
       sb.append("                                                                              =  |+10|  =     |   ???            ");
       sb.append("\n");
       sb.append("                                                                                =     =       |   ???            ");
       sb.append("\n");
       sb.append("                                                                                              |  |+7|               ");
       sb.append("\n");

        return sb.toString();
    }

    public boolean isPatternLineFull(int patternLineIndex) {
        return patternLines.get(patternLineIndex).size() == patternLineIndex + 1;

    }
}
