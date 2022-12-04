import java.util.ArrayList;
import java.util.Arrays;

public class ArrayExperiments {

    public static Double[] initialize(int size) {
        // An array of random doubles
        Double[] d = new Double[size];
        for (int i = 0; i < size; i++) {
            d[i] = StdRandom.uniform();
        }
        return d;
    }

    public static long retrieve_by_index(Double[] d) {
        int i = (int) (StdRandom.uniform() * d.length);
        long startTime = System.nanoTime();
        Double r = d[i];
        return (System.nanoTime() - startTime);
    }

    public static long retrieve_by_element(Double[] d) {
        Double r = d[(int) (StdRandom.uniform() * d.length)];
        long startTime = System.nanoTime();
        // TODO Find element r in Array d using a binary search
        Arrays.sort(d);
        StdOut.println(Arrays.binarySearch(d, r));
        return (System.nanoTime() - startTime);
    }

    public static long insert_element_middle(Double[] d) {
        long startTime = System.nanoTime();
        ArrayList<Double> d1_temp = new ArrayList<Double>(Arrays.asList(d));
        d1_temp.add(d1_temp.size() / 2, StdRandom.uniform());
        d = d1_temp.toArray(new Double[d1_temp.size() + 1]);
        return (System.nanoTime() - startTime);
    }

    public static long insert_element_begin(Double[] d) {
        long startTime = System.nanoTime();
        ArrayList<Double> d1_temp = new ArrayList<Double>(Arrays.asList(d));
        d1_temp.add(1, StdRandom.uniform());
        d = d1_temp.toArray(new Double[d1_temp.size() + 1]);
        return (System.nanoTime() - startTime);
    }

    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        long trials = Long.parseLong(args[1]);

        Double[] d = initialize(size);

        System.out.println("Timing retrieval by index...");
        long index_retrieval = 0;
        for (long t = 0; t < trials; t++) {
            index_retrieval += retrieve_by_index(d);
        }
        System.out.println(
                "Retrieval by index: " + (index_retrieval / ((double) trials))
                        + " nanoseconds on average");

        System.out.println("Sorting array...");
        Arrays.sort(d);

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
