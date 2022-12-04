import edu.princeton.cs.algs4.CC;
import edu.princeton.cs.algs4.DepthFirstSearch;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.LinkedList;

public class SPOF {
    Graph G;

    public SPOF(String arg) { // construct SPOF
        In in = new In(arg); // read .txt
        G = new Graph(in); // create a Graph object from in.
    }

    private static class Edge implements Comparable<Edge> {
        // initiate instance variables
        int i;
        int j;

        // constructor
        public Edge(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public boolean equals(Object that) {
            if (that == this) {
                return true;
            }
            if (that == null) {
                return false;
            }
            if (that.getClass() != this.getClass()) { // objects must be in the same class.
                return false;
            }
            Edge e = (Edge) that;
            if (this.i != e.i) {
                return false;
            }
            if (this.j != e.j) {
                return false;
            }
            return true;
        }

        public int compareTo(Edge e) {
            if (!this.equals(e))
                return -1;
            return 0; // if this.equals(e), return 0.
        }
    }

    private static LinkedList<Integer> vertices(Graph g) {
        LinkedList<Integer> vlist = new LinkedList<Integer>();
        for (int i = 0; i < g.V(); i++) { // assume i = 0, and increases at step of 1
            Graph gcopy = new Graph(g.V());
            for (int v = 0; v < g.V(); v++) {
                if (v != i) {  // when v != i, so != 0
                    for (int w : g.adj(v)) {
                        if (w != i) {  // when w != i, so w != 0
                            gcopy.addEdge(v, w);
                        }
                    }
                }
            }
            CC gcopycc = new CC(gcopy);
            if (gcopycc.count() > 2) { // > 1 does not work, but 2 does. Don't know why.
                vlist.add(i);
            }
        }
        return vlist;
    }

    private static LinkedList<Edge> edges(Graph g) {
        LinkedList<Edge> elist = new LinkedList<Edge>();
        LinkedList<Edge> failurelist = new LinkedList<Edge>();
        for (int v = 0; v < g.V(); v++) {
            for (int w : g.adj(v)) {
                elist.add(new Edge(v, w)); // add all the edges, twice.
                // StdOut.println(v + "-" + w);
            }
        }
        for (Edge e : elist) { // assume e = 0-1
            Graph gcopy = new Graph(g.V());
            for (Edge ee : elist) {
                if (!e.equals(ee)) { // e != 0-1, excluding edge 0-1.
                    if (ee.i < ee.j) { // avoid duplicates
                        gcopy.addEdge(ee.i, ee.j);
                    }
                }
            }
            // StdOut.println(e.i + "," + e.j + " " + gcopy);
            CC gcopyedgecc = new CC(gcopy);
            if (gcopyedgecc.count() > 1) {
                failurelist.add(e);
            }
        }
        return failurelist;
    }

    public static void main(String[] args) {
        SPOF spof = new SPOF("exam.txt");
        DepthFirstSearch dfs = new DepthFirstSearch(spof.G, 0);
        for (int i = 0; i < spof.G.V(); i++) {
            for (int w : spof.G.adj(i)) {
                StdOut.println(i + "-" + w);
            }
        }

        // for (int i = 0; i > spof.G.V(); i++) {
        //     if (dfs.marked(i)) {
        //         StdOut.println(i + " ");
        //     }
        // }

        // SPOF spof = new SPOF(args[0]);
        // CC cc = new CC(spof.G);
        // if (cc.count() > 1) {
        //     StdOut.println("ERROR: Graph is not connected");
        // }
        // else {
        //     StdOut.println("SPOF vertices: ");
        //     for (int i : vertices(spof.G)) {
        //         StdOut.println(i);
        //     }
        //     StdOut.println();
        //     StdOut.println("SPOF edges: ");
        //     for (Edge e : edges(spof.G)) {
        //         StdOut.println(e.i + " " + e.j);
        //     }
        // }

    }
}

// Graph g = new Graph(new In(args[0]));
// StdOut.println(g.E());
// StdOut.println(SPOF.vertices(g));
// StdOut.println(SPOF.edges(g));


// In in = new In(args[0]);
// int Vertices = in.readInt();
// int Edges = in.readInt();
// Graph g = new Graph(Vertices);
// for (int i = 0; i < Edges; i++) {
//     g.addEdge(in.readInt(), in.readInt());
// }
// StdOut.println(SPOF.vertices(g));


// CC gcc = new CC(g);
// StdOut.println("gcc: " + gcc.count());

// exclude 0
// Graph grm0 = new Graph(g.V());
// grm0.addEdge(1, 3);
// grm0.addEdge(1, 2);
// grm0.addEdge(2, 3);
// grm0.addEdge(3, 4);
// grm0.addEdge(4, 5);
// StdOut.println(grm0);
// CC grm0cc = new CC(grm0);
// StdOut.println("grm0cc: " + grm0cc.count());

// exclude 1
// Graph grm1 = new Graph(g.V());
// grm1.addEdge(0, 3);
// grm1.addEdge(2, 3);
// grm1.addEdge(3, 4);
// grm1.addEdge(4, 5);
//
// // exclude 2
// Graph grm2 = new Graph(g.V());
// grm2.addEdge(0, 3);
// grm2.addEdge(0, 1);
// grm2.addEdge(1, 3);
// grm2.addEdge(3, 4);
// grm2.addEdge(4, 5);
//
// // exclude 3
// Graph grm3 = new Graph(g.V());
// grm3.addEdge(0, 1);
// grm3.addEdge(1, 2);
// grm3.addEdge(4, 5);
//
// // exclude 4
// Graph grm4 = new Graph(g.V());
// grm4.addEdge(0, 3);
// grm4.addEdge(0, 1);
// grm4.addEdge(1, 3);
// grm4.addEdge(1, 2);
// grm4.addEdge(2, 3);
//
// // exclude 5
// Graph grm5 = new Graph(g.V());
// grm5.addEdge(0, 3);
// grm5.addEdge(0, 1);
// grm5.addEdge(1, 3);
// grm5.addEdge(1, 2);
// grm5.addEdge(2, 3);
// grm5.addEdge(3, 4);

