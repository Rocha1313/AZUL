package azul.components;

import java.util.Collection;

public interface Recycler {

    // returns the pieces it contains and becomes empty
    Collection<Piece> getPieces();

    void add(Collection<Piece> pieces);
}
