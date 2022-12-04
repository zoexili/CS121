import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.StdOut;

public class Pic {
    public static void main(String[] args) {
        // Picture picture = new Picture(2, 2);
        // Color black = new Color(0, 0, 0);
        // Color white = new Color(255, 255, 255);
        // picture.set(0, 0, black);
        // picture.set(0, 1, white);
        // picture.set(1, 1, black);
        // picture.set(1, 0, white);
        // picture.save("somepic.png");
        // picture.show();

        String[] s = { "b", "c", "d", "a" };
        Selection.sort(s);
        for (int i = 0; i < s.length; i++) {
            StdOut.println(s[i]);
        }
    }
}
