public class Count {
    public static class HashMap<Key, Value> {
        private int N; // number of key-value pairs
        private int M; // number of chains
        private Node[] hm; // array of linked list symbol tables


        private class Node {
            private Object key;
            private Object val;
            private Node next;

            public Node(Object key, Object val, Node next) {
                this.key = key;
                this.val = val;
                this.next = next;
            }
        }

        // hash value btn 0 and M-1.
        private int hash(Key key) {
            return (key.hashCode() & 0x7fffffff) % M;
        }

        public HashMap() {
            N = 0;
            M = 5; // ?
            hm = (Node[]) new Object[M];
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public int size() {
            return N;
        }

        public void put(Key key, Value val) {
            if (key == null) {
                throw new IllegalArgumentException("Null Argument");
            }
            else {
                int i = hash(key);
                StdOut.println(i);
                for (Node x = hm[i]; x.next != null; x = x.next) {
                    if (key.equals(x.key)) {
                        x.val = val;
                        StdOut.println(x.val);
                    }
                }
                N++;
                hm[i] = new Node(key, val, hm[i]);
            }
        }

        public Value get(Key key) {
            if (key == null) {
                throw new IllegalArgumentException("Null Argument");
            }
            else {
                int i = hash(key);
                for (Node x = hm[i]; x != null; x = x.next) {
                    if (key.equals(x.key)) {
                        return (Value) x.val;
                    }
                }
            }
            return null; // ? why return null here
        }

        public boolean contains(Key key) {
            return get(key) != null;
        }

        public void delete(Key key) {
            put(key, null);
        }

        public Iterable<Key> keys() {
            Queue<Key> q = new Queue<Key>();
            int i = 0;
            for (Node x = hm[i]; x != null; x = x.next) {
                q.enqueue((Key) x.key);
            }
            return q;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
        hashmap.put("abc", 1);
        hashmap.put("def", 2);
        hashmap.put("g", 3);
        StdOut.println(hashmap.isEmpty());
        // for (int i = 0; !StdIn.isEmpty(); i++) {
        //     String s = StdIn.readLine();
        //     s = s.toLowerCase();
        //     hm.put(s, i);
        // }
        for (String s : hashmap.keys()) {
            StdOut.println(s + " " + hashmap.get(s));
        }
    }
}


