import java.util.LinkedList;

public class test {
    public static LinkedList<Double> initialize(int size) {
        // A LinkedList of random doubles
        // Double[] d = new Double[size];
        LinkedList<Double> d = new LinkedList<Double>();
        for (int i = 0; i < size; i++) {
            Double var = d.get(i);
            var = StdRandom.uniform();
        }
        return d;
    }

    public static long retrieve_by_index(LinkedList<Double> d) {
        int i = (int) (StdRandom.uniform() * d.size());
        return i;
    }
}
