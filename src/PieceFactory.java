import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PieceFactory implements Factory{

    private List<Piece> pieces = new ArrayList<>();


    @Override
    public void fill(Collection<Piece> pieces) throws NotEnoughPiecesException {

        if (pieces.size() < 4){
            throw new NotEnoughPiecesException();
        }

        this.pieces.addAll(pieces);
    }

    @Override
    public Collection<Piece> getPieces(Piece pattern) throws PiecesNotFoundException {
        Collection<Piece> tempList = new ArrayList<>();

         for(int i = 0; i < this.pieces.size(); i++){
             if (this.pieces.get(i).getPattern().equals(pattern.getPattern())){
                 tempList.add(this.pieces.remove(i));
             }
         }

         if (tempList.isEmpty()){
             throw new PiecesNotFoundException();
         }

         return tempList;
    }

    @Override
    public Collection<Piece> getLeftOverPieces() {
        Collection<Piece> tempList = this.pieces;
        this.pieces.clear();
        return tempList;
    }
}
