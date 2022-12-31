import java.util.Collection;

public interface Garbage {

    boolean isEmpty();

    void add(Collection<Piece> pieces);

    Collection<Piece> getPieces(Piece pattern) throws PiecesNotFoundException;

}
