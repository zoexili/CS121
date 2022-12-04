public class Replace {
    public static void main(String[] args) {
        // args[0] is find, args[1] is replace.
        String replace = args[1].replace("\\n", "\n"); // important line!
        while (!StdIn.isEmpty()) {
            String s = StdIn.readAll();
            String newreplace = s.replaceAll(args[0], replace);
            StdOut.println(newreplace);
        }
    }
}

