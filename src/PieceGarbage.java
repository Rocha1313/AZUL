import java.util.Collection;

public class PieceGarbage implements Garbage {
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void add(Collection<Piece> pieces) {

    }

    @Override
    public Collection<Piece> getPieces(Piece pattern) {
        return null;
    }
}
