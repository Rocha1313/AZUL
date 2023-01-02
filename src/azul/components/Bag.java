package azul.components;

import azul.exceptions.NotEnoughPiecesException;
import azul.exceptions.PieceBagWithEnoughPiecesToFillFactoriesException;

import java.util.Collection;

public interface Bag {

    int getAmount();

    void reFill(Collection<Piece> pieces) throws PieceBagWithEnoughPiecesToFillFactoriesException;

    //return FACTORY_PIECE_CAPACITY pieces from the bag or throw an exception if not possible
    Collection<Piece> getPieces() throws NotEnoughPiecesException;
}
