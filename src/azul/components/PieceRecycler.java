package azul.components;

import java.util.ArrayList;
import java.util.Collection;

public class PieceRecycler implements Recycler {
    private Collection<Piece> pieces = new ArrayList<>();

    @Override
    public Collection<Piece> getPieces() {
        Collection<Piece> pieces = this.pieces;
        this.pieces = new ArrayList<>();
        return pieces;
    }

    @Override
    public void add(Collection<Piece> pieces) {
        this.pieces.addAll(pieces);
    }
}
