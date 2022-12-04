public class graphexplore {
    Graph G;

    public graphexplore(String arg) {
        In in = new In(arg);
        G = new Graph(in);
    }

    public static void main(String[] args) {
        In in = new In("exam.txt");
        Graph g = new Graph(in);

    }
}
