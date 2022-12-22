package Game.Bag;

import Game.Pieces.*;
import GlobalResources.GlobalResources;

import java.util.ArrayList;

public class Bag {
    private final int MAX_NUMBER_OF_PIECES_ON_BAG = 100;

    private ArrayList<Piece> bag = new ArrayList<>();
    private int numberBagPieces;

    //Constructor's
    public Bag(){
        this.bag.add(new SantaPiece());
        this.bag.add(new GiftPiece());
        this.bag.add(new ChristmasTreePiece());
        this.bag.add(new SnowManPiece());
        this.bag.add(new ReindeerPiece());

        this.bag.forEach(e -> e.setNumber(MAX_NUMBER_OF_PIECES_ON_BAG / 5));
        this.numberBagPieces = this.MAX_NUMBER_OF_PIECES_ON_BAG;
    }

    //Method's

    //Withdraw 4 random Pieces on Bag
    public Piece[] withDrawForFactory(){
        int currentMaxNumber = 4;
        int random;

        SantaPiece santaPiece = new SantaPiece();
        GiftPiece giftPiece = new GiftPiece();
        ChristmasTreePiece christmasTreePiece = new ChristmasTreePiece();
        SnowManPiece snowManPiece = new SnowManPiece();
        ReindeerPiece reindeerPiece = new ReindeerPiece();

        santaPiece.setNumber(0);
        giftPiece.setNumber(0);
        christmasTreePiece.setNumber(0);
        snowManPiece.setNumber(0);
        reindeerPiece.setNumber(0);

        while (currentMaxNumber != 0){
            random = GlobalResources.random.nextInt(1, 5);

            switch (random){
                //Santa Piece
                case 1 ->{
                    if (this.bag.get(0).checkMin(1)) {
                        do {
                            random = GlobalResources.random.nextInt(1, currentMaxNumber);
                        } while (!this.bag.get(0).checkMin(random));
                        currentMaxNumber -= random;
                        this.bag.get(0).withdrawPieces(random);
                        santaPiece.incrementerPieces(random);
                    }
                }
                //Gift Piece
                case 2 ->{
                    if (this.bag.get(1).checkMin(1)) {
                        do {
                            random = GlobalResources.random.nextInt(1, currentMaxNumber);
                        } while (!this.bag.get(1).checkMin(random));
                        currentMaxNumber -= random;
                        this.bag.get(1).withdrawPieces(random);
                        giftPiece.incrementerPieces(random);
                    }
                }
                //Christmas Tree Piece
                case 3 ->{
                    if (this.bag.get(2).checkMin(1)) {
                        do {
                            random = GlobalResources.random.nextInt(1, currentMaxNumber);
                        } while (!this.bag.get(2).checkMin(random));
                        currentMaxNumber -= random;
                        this.bag.get(2).withdrawPieces(random);
                        christmasTreePiece.incrementerPieces(random);
                    }
                }
                //SnowMan Piece
                case 4 ->{
                    if (this.bag.get(3).checkMin(1)) {
                        do {
                            random = GlobalResources.random.nextInt(1, currentMaxNumber);
                        } while (!this.bag.get(3).checkMin(random));
                        currentMaxNumber -= random;
                        this.bag.get(3).withdrawPieces(random);
                        snowManPiece.incrementerPieces(random);
                    }
                }
                //Reindeer Piece
                case 5 ->{
                    if (this.bag.get(4).checkMin(1)) {
                        do {
                            random = GlobalResources.random.nextInt(1, currentMaxNumber);
                        } while (!this.bag.get(4).checkMin(random));
                        currentMaxNumber -= random;
                        this.bag.get(4).withdrawPieces(random);
                        reindeerPiece.incrementerPieces(random);
                    }
                }
            }
        }

        updateNumberBagPieces();
        return new Piece[]{santaPiece, giftPiece, christmasTreePiece, snowManPiece, reindeerPiece};
    }

    //Increments pieces on Bag
    //
    //
    // Maybe this is nice to do in the recycler
    //
    //

    //Update number of pieces on Bag
    private void updateNumberBagPieces(){
        this.numberBagPieces = this.bag.stream()
                .mapToInt(Piece::getNumber)
                .sum();
    }

    //Getter's
    public ArrayList<Piece> getBag() {
        return this.bag;
    }

    public int getNumberBagPieces() {
        return this.numberBagPieces;
    }

    //Setter's
    public void setBag(ArrayList<Piece> bag) {
        this.bag = bag;
    }
}