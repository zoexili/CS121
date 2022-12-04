/* *****************************************************************************
 *
 *  Description: This client class of Deck does various shuffling operations
 *               on deck and computes shuffle based properties.
 *
 **************************************************************************** */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Shuffling {

    /**
     * For a deck of maxRank starting in the factory order,
     * find the minimum number of out shuffles needed to get the deck
     * back to its original order.
     *
     * @param maxRank the max rank of the cards in the deck
     * @return the smallest number of out-shuffles needed to get the deck
     * back to its original order
     */
    public int minOutShuffles(int maxRank) {
        ArrayDeck ad = new ArrayDeck(maxRank);
        Deck adcopy = ad.copy();
        ad.outShuffle();
        int count = 1;
        while (!ad.equals(adcopy)) {
            ad.outShuffle();
            count++;
        }
        return count;
    }

    /**
     * For a deck of maxRank starting in the factory order,
     * find the minimum number of in shuffles needed to get the deck
     * back to its original order.
     *
     * @param maxRank the max rank of the cards in the deck
     * @return the smallest number of in-shuffles needed to get the deck
     * to its original order
     */
    public int minInShuffles(int maxRank) {
        ArrayDeck ad = new ArrayDeck(maxRank);
        Deck adcopy = ad.copy();
        ad.inShuffle();
        int count = 1;
        while (!ad.equals(adcopy)) {
            ad.inShuffle();
            count++;
        }
        return count;
    }

    /**
     * computes and returns a queue of decks, starting with the specified
     * deck and going through the shuffling sequence
     *
     * @param deck            the start deck
     * @param shuffleSequence a String representing a shuffling sequence, with
     *                        'I' representing in-shuffle and 'O' representing
     *                        out-shuffle
     * @return a queue of decks starting with the given deck and going through
     * the shuffling sequence, including each intermediate deck
     */
    public Queue<Deck> computeDeckSequence(Deck deck, String shuffleSequence) {
        // Queue<Deck> queue = new LinkedList<>();
        // you cannot implement a queue interface directly, but you can implement a class
        // that implements the interface, such as LinkedList.
        Queue<Deck> queue = new LinkedList<Deck>();
        queue.add(deck);
        Deck dcopy = deck.copy();
        for (int i = 0; i < shuffleSequence.length(); i++) {
            if (shuffleSequence.charAt(i) == 'I') {
                dcopy.inShuffle();
                queue.add(dcopy);
            }
            else {
                dcopy.outShuffle();
                queue.add(dcopy);
            }
            // create a copy separate from the previous dcopy deck saved in queue.
            dcopy = dcopy.copy();
        }
        return queue;
    }

    private class DeckShufflePair {
        private final Deck deck;
        private final String shuffle;

        public DeckShufflePair(Deck deck, String shuffle) {
            this.deck = deck;
            this.shuffle = shuffle;
        }
    }

    /**
     * For a deck of maxRank starting in the factory order,
     * Find the shortest shuffle sequence that brings each card to the top.
     *
     * @param maxRank the max rank of the cards in the deck
     * @return a hashmap, with Card as the Key and String as the value,
     * showing the shortet shuffle sequence to bring each card to the top
     */
    public HashMap<Card, String> findShortestShuffles(int maxRank) {
        Queue<DeckShufflePair> queue = new LinkedList<DeckShufflePair>();
        Deck deck = new ArrayDeck(maxRank);
        DeckShufflePair pair = new DeckShufflePair(deck, "");
        queue.add(pair);

        // declare and create a hashmap, to save card - shortest shuffle sequence
        HashMap<Card, String> shortestShuffles = new HashMap<Card, String>();
        shortestShuffles.put(pair.deck.peekTop(), pair.shuffle);

        // don't hard code, try using deck.size(), or maxRank * 4. Don't + 1.
        // ask Prof, when 4 < 5, then the loop never stops, because 4 will never be 5.
        // when 4 < 4, then the while loop stops because 4 is not < 4 and it meets the condition.
        while (shortestShuffles.size() < deck.size()) {
            DeckShufflePair Pair = queue.poll(); // dequeue on queue, now queue is empty.
            if (!shortestShuffles.containsKey(Pair.deck.peekTop())) {
                shortestShuffles.put(Pair.deck.peekTop(), Pair.shuffle);
            }
            // inshuffle
            Deck dequeI = Pair.deck.copy();
            dequeI.inShuffle(); // inshuffle copy 1
            DeckShufflePair dequeIpair = new DeckShufflePair(dequeI,
                                                             Pair.shuffle + "I");
            queue.add(dequeIpair);
            // outshuffle
            Deck dequeO = Pair.deck.copy();
            dequeO.outShuffle(); // outshuffle copy2
            DeckShufflePair dequeOpair = new DeckShufflePair(dequeO,
                                                             Pair.shuffle + "O");
            queue.add(dequeOpair); // add to queue.
        }
        return shortestShuffles;
    }


    /*
     * Print the states of a deck as the specified shuffle sequence is
     * performed on it.
     *
     * @param maxRank         the initial deck state is a new deck with the
     *                        specified rank
     * @param shuffleSequence a String representing a shuffling sequence, with
     *                        'I' representing in-shuffle and 'O' representing
     *                        out-shuffle
     */
    private static void printSequence(int maxRank, String shuffleSequence) {
        String FORMAT_STRING = "  maxRank=%s, shuffleSequence=\"%s\"\n";
        Shuffling shuffling = new Shuffling();
        System.out.printf(FORMAT_STRING, maxRank, shuffleSequence);
        for (Deck deck : shuffling.computeDeckSequence(new ArrayDeck(maxRank),
                                                       shuffleSequence)) {
            System.out.println("    " + deck);
        }
    }

    /*
     * Print the shortest combination of shuffles needed to bring each card to
     * the top of a factor order deck
     *
     * @param maxRank the factory order deck has the specified rank
     */
    private static void printShortestShuffles(int maxRank) {
        Shuffling shuffling = new Shuffling();
        System.out.println("  maxRank=" + maxRank);
        String FORMAT_STRING = "    %-5s %s\n";
        System.out.printf(FORMAT_STRING, "Card", "Shuffle Sequence");
        HashMap<Card, String> shortestShuffles =
                shuffling.findShortestShuffles(maxRank);
        for (Card c : shortestShuffles.keySet()) {
            System.out.printf(FORMAT_STRING, c, shortestShuffles.get(c));
        }
    }

    public static void main(String[] args) {
        Shuffling shuffling = new Shuffling();
        // Queue<Deck> q = shuffling.computeDeckSequence(new ArrayDeck(2), "IIIIII");
        // for (Deck d : q) {
        //     StdOut.println(d);
        // }
        // StdOut.println(shuffling.minOutShuffles(2));

        // HashMap<Card, String> h = shuffling.findShortestShuffles(1);
        // for (Card c : h.keySet()) {
        //     StdOut.println(c + " " + h.get(c));
        // }

        int highestRank = Integer.parseInt(args[0]);

        System.out.println("Minimum Numbers of Shuffles");
        String FORMAT_STRING = "  %-10s %-17s %-17s\n";
        System.out.printf(FORMAT_STRING,
                          "maxRank",
                          "Min Out Shuffles",
                          "Min In Shuffles");
        for (int i = 1; i <= highestRank; i++) {
            System.out.printf(FORMAT_STRING,
                              i,
                              shuffling.minOutShuffles(i),
                              shuffling.minInShuffles(i));
        }

        System.out.println("\nShuffle Sequences");
        printSequence(1, "OO");
        printSequence(2, "IIIIII");
        printSequence(1, "OIOI");

        System.out.println("\nShortest Shuffles");
        for (int i = 1; i <= highestRank; i++) {
            printShortestShuffles(i);
        }
    }
}

