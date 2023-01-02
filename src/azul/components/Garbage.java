package azul.components;

import azul.exceptions.PiecesNotFoundException;

import java.util.Collection;

public interface Garbage {

    boolean isEmpty();

    void add(Collection<Piece> pieces);

    Collection<Piece> getPieces(Piece pattern) throws PiecesNotFoundException;

    boolean hasPattern(Piece pattern);
}
