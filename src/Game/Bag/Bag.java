package Game.Bag;

import Game.Pieces.Piece;
import Game.Pieces.SantaPiece;

import java.util.ArrayList;


public class Bag {

    ArrayList<Piece> bag = new ArrayList<>();

    public Bag(){

        bag.add(new SantaPiece());
        bag.get(0).setNumber(20);
    }
}