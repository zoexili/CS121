import java.util.Comparator;
import java.util.LinkedList;

public class LinkedListExperiments {
    public static LinkedList<Double> initialize(int size) {
        // A LinkedList of random doubles
        LinkedList<Double> d = new LinkedList<Double>();
        for (int i = 0; i < size; i++) {
            d.addLast(StdRandom.uniform());
        }
        return d;
    }

    public static long retrieve_by_index(LinkedList<Double> d) {
        int i = (int) (StdRandom.uniform() * d.size()); // get a random index within the list bound.
        long startTime = System.nanoTime();
        double r = d.get(i);
        StdOut.println("element at index: " + r);
        return (System.nanoTime() - startTime);
    }

    public static long retrieve_by_element(LinkedList<Double> d) {
        int i = (int) (StdRandom.uniform() * d.size());
        double r = d.get(i);
        long startTime = System.nanoTime();
        StdOut.println("index of element: " + d.indexOf(r));
        return (System.nanoTime() - startTime);
    }

    public static long insert_element_middle(LinkedList<Double> d) {
        long startTime = System.nanoTime();
        d.add(d.size() / 2, StdRandom.uniform());
        return (System.nanoTime() - startTime);
    }

    public static long insert_element_begin(LinkedList<Double> d) {
        long startTime = System.nanoTime();
        d.addFirst(StdRandom.uniform());
        return (System.nanoTime() - startTime);
    }

    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        long trials = Long.parseLong(args[1]);

        LinkedList<Double> d = initialize(size);
        System.out.println("Timing retrieval by index...");
        long index_retrieval = 0;
        for (long t = 0; t < trials; t++) {
            index_retrieval += retrieve_by_index(d);
        }
        System.out.println(
                "Retrieval by index: " + (index_retrieval / ((double) trials))
                        + " nanoseconds on average");

        System.out.println("Sorting array...");
        d.sort(Comparator.naturalOrder());


        System.out.println("Timing retrieval by element...");
        long element_retrieval = 0;
        for (long t = 0; t < trials; t++) {
            element_retrieval += retrieve_by_element(d);
        }
        System.out.println(
                "Retrieval by element: " + element_retrieval / ((double) trials)
                        + " nanoseconds on average");

        System.out.println("Timing insert element middle...");
        long insert_middle = 0;
        for (long t = 0; t < trials; t++) {
            insert_middle += insert_element_middle(d); // add up running time of each trial
        }
        System.out.println(
                "Insert element in middle: " + insert_middle / ((double) trials)
                        + " nanoseconds on average");

        System.out.println("Timing insert element begin...");
        long insert_begin = 0;
        for (long t = 0; t < trials; t++) {
            insert_begin += insert_element_begin(d);
        }
        System.out.println(
                "Insert element in begin: " + insert_begin / ((double) trials)
                        + "nanoseconds on average");

    }
}
