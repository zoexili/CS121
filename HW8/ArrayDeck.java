import java.util.Iterator;

/**
 * Provides an array based implementation of the Deck interface
 */
public class ArrayDeck implements Deck, Iterable<Card> {

    private final int MAX_SUIT = 4;
    private final char[] SUITS = { 'C', 'D', 'H', 'S' };
    private final int MAX_RANK = 13;
    private Card[] arraydeck;
    private int maxRank;

    /**
     * Ensure that no one OUTSIDE of this class and its subclasses invokes the
     * no-argument constructor. Don't make any change to this method.
     */
    protected ArrayDeck() {

    }

    /**
     * Construct a deck includes all four-suit cards up to the specified {maxRank}
     * in the factory order.
     * <p>
     * Note that the suites are ordered Club < Diamond < Hearts < Spades.
     * <p>
     * At the end of this method, your array of cards representing a deck should
     * look like the following (if maxRank is 3).
     * <p>
     * AC 2C 3C AD 2D 3D AH 2D 3H AS 2S 3S
     * <p>
     * Note your deck will have 4 * maxRank cards.
     * <p>
     * Required Time Performance: Theta(maxRank)
     *
     * @param maxRank the maximum rank of the cards in the deck, must be >=1
     * @throws IllegalArgumentException if maxRank is less than 1 or greater
     *                                  than 13
     */
    public ArrayDeck(int maxRank) {
        // TODO Complete for part 1
        if (maxRank < 1 || maxRank > 13) {
            throw new IllegalArgumentException("maxRank must be between 1 and 13");
        }

        this.maxRank = maxRank;
        int count = 0;
        arraydeck = new Card[maxRank * 4];
        for (int j = 0; j < MAX_SUIT; j++) { // C, D, H, S.
            for (int i = 1; i < maxRank + 1; i++) { // 1 - 3
                arraydeck[count] = new Card(i, SUITS[j]);
                count++;
            }
        }
    }

    /**
     * returns the top card in the deck, but does not remove it
     * <p>
     * Required Time Performance: Theta(1)
     */
    public Card peekTop() {
        // TODO Complete for part 1
        Card topcard = arraydeck[0]; // return the first card.
        return topcard;
    }

    /**
     * creates a new, independent deck, with the cards in the same order as
     * this deck.
     *
     * @return a copy of this deck
     * <p>
     * Required Time Performance: Theta(N) where N is the number of cards in the deck.
     */
    public Deck copy() {
        // TODO Complete for part 1
        // No need to shuffle copy.
        ArrayDeck copy = new ArrayDeck(maxRank);
        copy.arraydeck = new Card[size()]; // copy is separate from the original arraydeck.
        for (int i = 0; i < size(); i++) {
            copy.arraydeck[i] = this.arraydeck[i];
        }
        return copy;
    }

    /**
     * Returns the number of cards in the deck.
     *
     * @returns the number of cards in the deck
     * <p>
     * Required Time Performance: Theta(1)
     */
    public int size() {
        // TODO Complete for part 1
        return arraydeck.length;
    }

    /**
     * Does a faro out-shuffle that splits a deck in half, interleaves the cards
     * of the two halves, and leaves the original top card at the top and the
     * original bottom card at the bottom.
     * <p>
     * Refer to the problem description and the following wikipedia page for
     * more information: https://en.wikipedia.org/wiki/Faro_shuffle
     * <p>
     * For a deck with the following 12 cards
     * <p>
     * AC 2C 3C AD 2D 3D AH 2H 3H AS 2S 3S
     * <p>
     * An out-shuffle would conceptually look like this:
     * <p>
     * 1st half:    AC    2C    3C    AD    2D    3D
     * 2nd half:       AH    2H    3H    AS    2S    3S
     * <p>
     * RESULT:      AC AH 2C 2H 3C 3H AD AS 2D 2S 3D 3S
     * <p>
     * Required Time Performance: Theta(N) where N is the number of cards in the deck.
     */
    public void outShuffle() {
        // TODO Complete for part 1
        Card[] outs = new Card[size()];
        for (int i = 0; i < size() / 2; i++) {
            outs[i * 2] = arraydeck[i]; // 1st half
            outs[i * 2 + 1] = arraydeck[i + size() / 2]; // 2nd half
        }
        for (int i = 0; i < size(); i++) {
            arraydeck[i] = outs[i];
        }
    }


    /**
     * Does a faro in-shuffle that split a deck in half, interleaves the cards
     * of the two halves, and moves the original top card to second and the
     * original bottom card to second from the bottom.
     * <p>
     * Refer to the problem description and the following wikipedia page for
     * more information: https://en.wikipedia.org/wiki/Faro_shuffle
     * <p>
     * For a deck with the following 12 cards
     * <p>
     * AC 2C 3C AD 2D 3D AH 2H 3H AS 2S 3S
     * <p>
     * An in-shuffle would conceptually look like this:
     * <p>
     * 1st half:    AC    2C    3C    AD    2D    3D
     * 2nd half: AH    2H    3H    AS    2S    3S
     * <p>
     * RESULT:   AH AC @H 2C 3H 3C AS AD 2S 2D 3S 3D
     * <p>
     * Required Time Performance: Theta(N) where N is the number of cards in the deck.
     */
    public void inShuffle() {
        // TODO Complete for part 1
        Card[] ins = new Card[size()];
        for (int i = 0; i < size() / 2; i++) {
            ins[i * 2 + 1] = arraydeck[i]; // 1st half
            ins[i * 2] = arraydeck[i + size() / 2]; // 2nd half
        }
        for (int i = 0; i < size(); i++) {
            arraydeck[i] = ins[i];
        }
    }

    /**
     * creates a String representation of the deck.
     * <p>
     * For a deck with maxRank 3, the String representation is:
     * AC 2C 3C AD 2D 3D AH 2H 3H AS 2S 3S
     * with no space before the first card, and no space after the last card.
     * <p>
     * Required Time Performance: Theta(N) where N is the number of cards in the deck.
     *
     * @return a String representation of the deck
     */
    public String toString() {
        // TODO Complete for part 1
        String s = "";
        for (int i = 0; i < arraydeck.length - 1; i++) {
            s += arraydeck[i] + " ";
        }
        return s + arraydeck[size() - 1];
    }

    /**
     * determines if this deck is equal to that object. Part 2
     * *
     * Required Time Performance: Theta(N) where N is the number of cards in the deck.
     *
     * @param that an object to be checked for equivalence with this deck
     * @return true if that object is a deck that is equivalent to this deck,
     * false otherwise
     */
    @Override
    public boolean equals(Object that) {
        // TODO Complete for part 2
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (that.getClass() != this.getClass()) {
            return false;
        }

        ArrayDeck t = (ArrayDeck) that;
        if (this.maxRank != t.maxRank) {
            return false;
        }
        for (int i = 0; i < size(); i++) {
            if (!this.arraydeck[i].equals(t.arraydeck[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns an iterator to this deck that iterates through the cards from
     * the top to the bottom.
     * <p>
     * The required complexity for your Iterator class's hasNext() and next()
     * is Theta(1).
     *
     * @return an iterator to this deck that iterates through the cards from
     * the top to the bottom..
     */
    public Iterator<Card> iterator() {
        // TODO Complete for part 2
        return new CardIterator();
    }

    private class CardIterator implements Iterator<Card> {
        int i = 0;

        public boolean hasNext() {
            return i >= 0 && i < size();
        }

        public Card next() {
            return arraydeck[i++];
        }
    }

    public static void main(String[] args) {
        // TODO Test your code
        ArrayDeck ad = new ArrayDeck(3);
        Deck adcopy = ad.copy();
        ad.outShuffle();
        StdOut.println("ad: " + ad);
        StdOut.println("adcopy: " + adcopy);
        StdOut.println(ad.equals(adcopy));
        ad.peekTop();
        StdOut.println(ad.size());
    }
}

