import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private int N;
    private Node first;
    private Node last;

    private class Node {
        Item item; // value
        Node next; // new instance variable
        Node previous; // new instance variable
    }

    // construct an empty deque
    public Deque() {
        N = 0;
        first = null;
        last = null;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return (N == 0);
    }

    // return the number of items on the deque
    public int size() {
        return N;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Null argument");
        }
        if (first == null) {
            first = new Node();
            first.item = item;
            last = first; // assign last to first. first is last.
            N++;
        }
        else {
            Node second = first;
            first = new Node();
            first.item = item;
            first.next = second;
            second.previous = first;
            N++;
        }
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Null argument");
        }
        if (last == null) { // should not be isEmpty(), otherwise NullPointerException
            last = new Node();
            last.item = item;
            first = last; // assign first to last.
            N++;
        }
        else {
            Node oldlast = last;
            // StdOut.println("oldlast: " + oldlast.item);
            last = new Node();
            last.item = item;
            last.next = null;
            oldlast.next = last;
            last.previous = oldlast; // important to know the previous and next.
            // StdOut.println("last: " + last.item);
            N++;
        }
    }

    // remove and return the item from the front
    public Item removeFirst() {
        // if isEmpty(), throw the exception.
        // if size = 1 then first = null, last = null.
        // if size = 2 then last.previous = null, first = last;
        // if size > 2 then first = first.next; first.previous = null;
        // N-- and return item outside of ifelse loop.
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("deque is empty");
        }
        Item item = first.item;
        if (first != null) {
            if (N == 1) {
                first = null;
                last = null;
            }
            else if (N == 2) {
                last.previous = null; // remove the first node
                first = last; // there is one node left, it is first and last.
            }
            else if (N > 2) {
                first = first.next;
                first.previous = null;
            }
        }
        N--;
        return item;
    }

    // remove and return the item from the back
    // if isEmpty(), throw the exception.
    // if size = 1 then last = null, first = null.
    // if size = 2 then first.next = null, last = first.
    // if size > 2 then last = last.previous, last.next = null.
    // put N-- and return item outside of ifelse loop.
    public Item removeLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("deque is empty");
        }
        Item item = last.item;
        if (last != null) {
            if (N == 1) {
                last = null;
                first = null;
            }
            else if (N == 2) {
                first.next = null;
                last = first;
            }
            else if (N > 2) {
                last = last.previous;
                last.next = null;
            }
        }
        N--;
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (hasNext()) { // current != null
                Item item = current.item;
                current = current.next;
                return item;
            }
            else {
                throw new java.util.NoSuchElementException("No more items to return");
            }
        }

    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> d = new Deque<Integer>();
        d.addLast(193);
        d.removeFirst();
        d.addLast(58);
        Iterator<Integer> DI = d.iterator();
        while (DI.hasNext()) {
            StdOut.println(DI.next());
        }
    }
}



