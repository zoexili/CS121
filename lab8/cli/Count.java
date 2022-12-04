import java.util.HashMap;

public class Count {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readLine();
            s = s.toLowerCase();
            if (!hm.containsKey(s)) {
                hm.put(s, 1);
            }
            else {
                hm.put(s, hm.get(s) + 1);
            }
        }
        for (String s : hm.keySet()) {
            StdOut.println(hm.get(s) + " " + s);
        }
    }
}


