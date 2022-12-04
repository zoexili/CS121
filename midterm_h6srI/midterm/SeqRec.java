public class SeqRec {
    public static double S(int n) {
        if (n == 0) {
            return 0.0;
        }
        if (n == 1) {
            return 1.1;
        }
        if (n == 2) {
            return 2.2;
        }
        return S(n - 1) + S(n - 3);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdOut.println(S(n));
    }
}
