
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PieceBag implements Bag {

    private final List<Piece> pieces = new ArrayList<>();

    public PieceBag() {
        for (Piece piece : Piece.values()) {
            for (int i = 0; i < 20; i++) {
                pieces.add(piece);
            }
        }
    }

    @Override
    public int getAmount() {
        int amount = 0;

        for (int i = 0; i < pieces.size(); i++) {
            amount++;
        }
        return amount;
    }

    @Override
    public void reFill(Collection<Piece> recyclerPieces) {
        pieces.addAll(recyclerPieces);
    }

    @Override
    public Collection<Piece> getPieces() throws NotEnoughPiecesException {
        // Choose randomly 4 pieces from the bag

        List<Piece> piecesToFactory = new ArrayList<>();

        int randPiece;

        if (getAmount() < 4) {
            throw new NotEnoughPiecesException("Warning: Failure in getting/placing pieces.");
        }

        for (int i = 0; i < 4; i++) {
            randPiece = GlobalResources.random.nextInt(pieces.size());

            for (Piece piece : pieces) {
                if (i == randPiece) {
                    piecesToFactory.add(piece);
                    pieces.remove(piece);
                }
            }
        }

        return piecesToFactory;
    }
}
