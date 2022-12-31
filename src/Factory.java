import java.util.Collection;

public interface Factory {

   // fills the factory with four pieces
   void fill(Collection<Piece> pieces) throws NotEnoughPiecesException, FactoryStillHasPiecesException;

   Collection<Piece> getPieces(Piece pattern) throws PiecesNotFoundException;

   Collection<Piece> getLeftOverPieces();

   boolean isEmpty();
}
