package azul.components;

import azul.AzulConstants;
import azul.components.Factory;
import azul.exceptions.FactoryStillHasPiecesException;
import azul.exceptions.NotEnoughPiecesException;
import azul.exceptions.PiecesNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PieceFactory implements Factory {


    private List<Piece> pieces = new ArrayList<>();

    @Override
    public void fill(Collection<Piece> piecesToFill) throws NotEnoughPiecesException, FactoryStillHasPiecesException {
        // assertions
        // need to have FACTORY_PIECE_CAPACITY pieces to fill the factory.
        if (piecesToFill.size() != AzulConstants.FACTORY_PIECE_CAPACITY) {
            throw new NotEnoughPiecesException(String.format("azul.components.Factory cannot be filled with %d pieces.", pieces.size()));
        }

        // factory needs to be empty to fill with new pieces.
        if (!pieces.isEmpty()) {
            throw new FactoryStillHasPiecesException(String.format("azul.components.Factory with %d pieces already.", pieces.size()));
        }

        this.pieces.addAll(piecesToFill);
    }

    @Override
    public Collection<Piece> getPieces(Piece pattern) throws PiecesNotFoundException {
        Collection<Piece> tempList = new ArrayList<>();

        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).equals(pattern)) {
                tempList.add(pieces.get(i));
            }
        }
        for (Piece p : tempList) {
            pieces.remove(p);
        }


        if (tempList.isEmpty()) {
            throw new PiecesNotFoundException(String.format("Could not find piece with pattern %s", pattern));
        }

        return tempList;
    }

    @Override
    public Collection<Piece> getLeftOverPieces() {
        if (pieces.size() == AzulConstants.FACTORY_PIECE_CAPACITY) {
            // no leftover pieces because it wasn't picked
        }

        Collection<Piece> tempList = new ArrayList<>();
        tempList.addAll(pieces);
        pieces.clear();
        return tempList;
    }

    @Override
    public boolean isEmpty() {
        return pieces.isEmpty();
    }

    @Override
    public boolean hasPattern(Piece pattern) {
        return pieces.contains(pattern);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Piece p : pieces) {
            sb.append(p);
        }
        return sb.toString();
    }
}
