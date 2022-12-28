import java.util.Collection;

public interface Bag {

    int getAmount();

    void reFill(Collection<Piece> pieces);

    //return 4 pieces from the bag or throw an exception if not possible
    Collection<Piece> getPieces() throws NotEnoughPiecesException;
}
