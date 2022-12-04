public class IntLinkedList {
    private class Node {
        int val;
        Node next;

        public Node(int v) {
            val = v;
            next = null;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    public IntLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    public void addFirst(int val) {
        if (head != null) {
            Node oldhead = head;
            head = new Node(val);
            head.next = oldhead;
        }
        else {
            head = new Node(val);
        }
        length++;
    }

    public void addLast(int val) {
        if (tail != null) {
            tail.next = new Node(val);
        }
        else {
            tail = new Node(val);
        }
        length++;
    }

    public static void main(String[] args) {

    }
}
