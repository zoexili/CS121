public class Tour {
    private class Node {
        private Point p;
        private Node next;
    }

    private Node first; // 1st node

    // Creates an empty tour.
    public Tour() {
        // dont need to initialize the linked list because the private class Node does it.
        first = null; //
    }

    // Creates the 4-point tour a->b->c->d->a (for debugging).
    public Tour(Point a, Point b, Point c, Point d) {
        // create a node for each point
        first = new Node();
        // assign the node field the desired value.
        first.p = a;
        Node second = new Node();
        second.p = b;
        // link
        first.next = second;
        Node third = new Node();
        third.p = c;
        second.next = third;
        Node fourth = new Node();
        fourth.p = d;
        third.next = fourth;
        // circular linked
        fourth.next = first;
    }

    // Returns the number of points in this tour. Loop through tour list using do-while loop.
    public int size() {
        int size = 0;
        if (first != null) {
            Node current = first;
            do {
                current = current.next;
                size++;
            } while (current != first);
        }
        return size;
    }


    // Returns the length of this tour.
    public double length() {
        double length = 0.0;
        if (first != null) {
            Node current = first;
            do {
                current = current.next;
                double distance = current.p.distanceTo(current.next.p);
                length += distance;
            } while (current != first);
        }
        return length;
    }

    // Returns a string representation of this tour.
    public String toString() {
        String s = new String("");
        if (first != null) {
            Node current = first;
            do {
                s += current.p.toString() + "\n";
                current = current.next;
            } while (current != first);
            // s = s.trim(); // remove the whitespace at the beginning and end.
        }
        return s;
    }

    // Draws this tour to standard drawing.
    public void draw() {
        if (first != null) {
            Node current = first;
            do {
                current.p.drawTo(current.next.p);
                current = current.next;
            } while (current != first);
        }
        // for (Node i = first; i != null; i = i.next) {
        //     i.p.drawTo(i.next.p);
        // }
        // for (Node i = i.next; i != first; i = i.next) // ?
    }

    // Inserts a point using the nearest neighbor heuristic.
    public void insertNearest(Point p) {
        if (first == null) {
            first = new Node();
            first.p = p;
            first.next = first;
        }
        else {
            Node newnode = new Node();
            newnode.p = p;
            double distance = Double.POSITIVE_INFINITY;
            Node current = first;
            Node target = new Node();
            do {
                double newdistance = newnode.p.distanceTo(current.p);
                if (newdistance < distance) {
                    distance = newdistance;
                    target = current;
                }
                current = current.next;
            } while (current != first);
            newnode.next = target.next;
            target.next = newnode;
        }
    }

    // Inserts a point using the smallest increase heuristic.
    public void insertSmallest(Point p) {
        if (first == null) {
            first = new Node();
            first.p = p;
            first.next = first;
        }
        else {
            Node newnode = new Node();
            newnode.p = p;
            Node current = first;
            Node target = new Node();
            double targetdif = Double.POSITIVE_INFINITY;
            do {
                double oldlength = current.p.distanceTo(current.next.p);
                newnode.next = current.next;
                current.next = newnode;
                double newlength = current.p.distanceTo(newnode.p) +
                        newnode.p.distanceTo(newnode.next.p);
                double dif = Math.abs(newlength - oldlength);
                if (dif < targetdif) {
                    targetdif = dif;
                    target = current;
                }
                current.next = current.next.next; // delete newnode.
                current = current.next;
            } while (current != first);
            newnode.next = target.next;
            target.next = newnode;
        }
    }

    // Tests this class by calling all constructors and instance methods.
    public static void main(String[] args) {
        Point a = new Point(1, 1);
        Point b = new Point(1, 4);
        Point c = new Point(4, 4);
        Point d = new Point(4, 1);
        Tour squareTour = new Tour(a, b, c, d);
        // Tour squareTour = new Tour();
        StdOut.println("Number of points: " + squareTour.size());
        StdOut.println("Length of Tour is: " + squareTour.length());
        // test toString()
        StdOut.println(squareTour);
        // test draw ()
        StdDraw.setXscale(0, 6);
        StdDraw.setYscale(0, 6);
        // test insertNearest() / insertSmallest()
        Point e = new Point(5.0, 6.0);
        // squareTour.insertNearest(e);
        squareTour.insertSmallest(e);
        squareTour.draw();
        // StdOut.println(squareTour.size()); // new size
        // StdOut.println(squareTour.length()); // new length
        // StdOut.println(squareTour);
    }

}
