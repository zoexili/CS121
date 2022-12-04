import edu.princeton.cs.algs4.Heap;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.StopwatchCPU;

import java.util.Random;

public class SortingExperiment {
    private static final long SEED = 42;

    public static Integer[] getData(String order, int n) {
        Integer[] data = new Integer[n];
        if (order.equals("RANDOM")) {
            Random random = new Random(SortingExperiment.SEED);
            for (int i = 0; i < n; i++) {
                data[i] = random.nextInt(Integer.MAX_VALUE);
            }
        }
        else if (order.equals("ASCENDING")) {
            for (int i = 0; i < n; i++) {
                data[i] = i;
            }
        }
        else if (order.equals("DESCENDING")) {
            for (int i = 0; i < n; i++) {
                data[i] = n - i - 1;
            }
        }
        else {
            throw new IllegalArgumentException("ORDER must be RANDOM, ASCENDING, or DESCENDING");
        }
        return data;
    }

    public static double timeSort(String algorithm, Integer[] data) {
        StopwatchCPU stopwatch;
        if (algorithm.equals("INSERTION")) {
            stopwatch = new StopwatchCPU();
            Insertion.sort(data);
            return stopwatch.elapsedTime();
        }
        else if (algorithm.equals("SELECTION")) {
            stopwatch = new StopwatchCPU();
            Selection.sort(data);
            return stopwatch.elapsedTime();
        }
        else if (algorithm.equals("MERGE")) {
            stopwatch = new StopwatchCPU();
            Merge.sort(data);
            return stopwatch.elapsedTime();
        }
        else if (algorithm.equals("QUICK")) {
            stopwatch = new StopwatchCPU();
            Quick.sort(data);
            return stopwatch.elapsedTime();
        }
        else if (algorithm.equals("HEAP")) {
            stopwatch = new StopwatchCPU();
            Heap.sort(data);
            return stopwatch.elapsedTime();
        }
        else {
            throw new IllegalArgumentException(
                    "ALGORITHM must be INSERTION, SELECTION, MERGE, QUICK, or HEAP");
        }
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: SortingExperiment ALGORITHM ORDER N");
            java.lang.System.exit(1);
        }
        String algorithm = args[0];
        String order = args[1];
        int n;
        try {
            n = Integer.parseInt(args[2]);
            if (n < 1) {
                throw new IllegalArgumentException("N must be a positive integer");
            }
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("N must be a positive integer", e);
        }
        // Generate data in the specified order
        Integer[] data = getData(order, n);
        // Sort the data
        System.out.printf("Sorted in %.2f seconds\n", timeSort(algorithm, data));
    }
}
