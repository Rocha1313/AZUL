public class PlayChoice {

    private Place placeType;
    private Factory factory;
    private Garbage garbage;
    private Piece pattern;
    private int patternLineIndex;

    public PlayChoice(Garbage garbage, Piece pattern, int patternLineIndex) {
        this.placeType = Place.GARBAGE;
        this.garbage = garbage;
        this.pattern = pattern;
        this.patternLineIndex = patternLineIndex;
    }

    public PlayChoice(Factory factory, Piece pattern, int patternLineIndex) {
        this.placeType = Place.FACTORY;
        this.factory = factory;
        this.pattern = pattern;
        this.patternLineIndex = patternLineIndex;
    }

    public Place getPlaceType() {
        return placeType;
    }

    public Factory getFactory() {
        return factory;
    }

    public Garbage getGarbage() {
        return garbage;
    }

    public Piece getPattern() {
        return pattern;
    }

    public int getPatternLineIndex() {
        return patternLineIndex;
    }
}
