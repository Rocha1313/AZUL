
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PieceBag implements Bag {

    private final List<Piece> pieces = new ArrayList<>();

    public PieceBag() {
        for (Piece piece : Piece.values() ) {
            for(int i = 0; i < 20; i++) {
                pieces.add(piece);
            }
        }
    }

    @Override
    public int getAmount() {
        return 0;
    }

    @Override
    public void reFill(Collection<Piece> pieces) {

    }

    @Override
    public Collection<Piece> getPieces() throws NotEnoughPiecesException {
        return null;
    }
}
