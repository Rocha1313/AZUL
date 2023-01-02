package azul.components;

import azul.exceptions.PiecesNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PieceGarbage implements Garbage {

    List<Piece> garbagePieces = new ArrayList<>();

    @Override
    public boolean isEmpty() {

        int amount = 0;

        for (int i = 0; i < garbagePieces.size(); i++) {
            amount++;
        }

        if (amount == 0) {
            return true;
        }

        return false;
    }

    @Override
    public void add(Collection<Piece> pieces) {
        garbagePieces.addAll(pieces);
    }

    @Override
    public Collection<Piece> getPieces(Piece pattern) throws PiecesNotFoundException {
        Collection<Piece> patternGarbagePieces = new ArrayList<>();

        if (garbagePieces.contains(Piece.STARTING_PIECE)) {
            patternGarbagePieces.add(Piece.STARTING_PIECE);
            garbagePieces.remove(Piece.STARTING_PIECE);
        }

        for (Piece piece : garbagePieces) {
            if (piece.equals(pattern)) {
                patternGarbagePieces.add(piece);
            }
        }
        for (Piece piece : patternGarbagePieces) {
            garbagePieces.remove(piece);
        }

        // TODO: check pieces with pattern were found and if need to include starting pieces
        if (patternGarbagePieces.isEmpty()) {
            throw new PiecesNotFoundException("Failure: Pattern not found in azul.components.Garbage.");
        }

        return patternGarbagePieces;
    }

    @Override
    public boolean hasPattern(Piece pattern) {
        return garbagePieces.contains(pattern);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Piece p : garbagePieces) {
            sb.append(p);
        }
        return sb.toString();
    }
}
