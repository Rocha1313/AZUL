
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PieceBag implements Bag {

    private final List<Piece> pieces = new ArrayList<>();

    public PieceBag() {
        for (Piece piece : Piece.values()) {
            for (int i = 0; i < AzulConstants.PIECES_PER_PATTERN; i++) {
                pieces.add(piece);
            }
        }
    }

    @Override
    public int getAmount() {
        return pieces.size();
    }

    @Override
    public void reFill(Collection<Piece> recyclerPieces) throws PieceBagWithEnoughPiecesToFillFactoriesException {
        if(pieces.size() >= AzulConstants.FACTORY_PIECE_CAPACITY) {
            throw new PieceBagWithEnoughPiecesToFillFactoriesException();
        }
        pieces.addAll(recyclerPieces);
    }

    @Override
    public Collection<Piece> getPieces() throws NotEnoughPiecesException {
        // Choose randomly FACTORY_PIECE_CAPACITY pieces from the bag

        List<Piece> piecesToFactory = new ArrayList<>();

        if (pieces.size() < AzulConstants.FACTORY_PIECE_CAPACITY) {
            throw new NotEnoughPiecesException(String.format("Warning: only %d pieces in the bag.", pieces.size()));
        }

        for (int i = 0; i < AzulConstants.FACTORY_PIECE_CAPACITY; i++) {
            int randPiece = GlobalResources.random.nextInt(pieces.size());

            piecesToFactory.add(pieces.remove(randPiece));
        }

        return piecesToFactory;
    }
}
