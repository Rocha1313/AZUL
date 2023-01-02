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

        for (Piece piece : garbagePieces) {
            if (piece.equals(pattern)) {
                patternGarbagePieces.add(piece);
                garbagePieces.remove(piece);
            }

            if (garbagePieces.contains(Piece.STARTING_PIECE)) {
                patternGarbagePieces.add(piece);
            }
        }

        // TODO: check pieces with pattern were found and if need to include starting pieces
        if (patternGarbagePieces.isEmpty()) {
            throw new PiecesNotFoundException("Failure: Pattern not found in Garbage.");
        }

        return patternGarbagePieces;
    }
}
