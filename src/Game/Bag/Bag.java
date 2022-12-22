package Game.Bag;

import Game.Pieces.*;

import java.util.ArrayList;


public class Bag {

    ArrayList<Piece> bag = new ArrayList<>();

    public Bag(){
        bag.add(new SantaPiece());
        bag.add(new GiftPiece());
        bag.add(new ChristmasTreePiece());
        bag.add(new SnowManPiece());
        bag.add(new ReindeerPiece());

        bag.forEach(e -> e.setNumber(20));
    }
}