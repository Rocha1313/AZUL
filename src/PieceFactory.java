import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PieceFactory implements Factory{

    private List<Piece> pieces = new ArrayList<>();


    @Override
    public void fill(Collection<Piece> pieces) throws NotEnoughPiecesException {

    }

    @Override
    public Collection<Piece> getPieces(Piece pattern) throws PiecesNotFoundException {
        return null;
    }

    @Override
    public Collection<Piece> getLeftOverPieces() {
        return null;
    }
}
