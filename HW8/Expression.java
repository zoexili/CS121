public class Expression {

    public static String postfixToInfix(String postfix) {
        Stack<String> ops = new Stack<String>(); // operator
        Stack<String> vals = new Stack<String>(); // integer
        String[] s = postfix.split(" ");
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("+")) {
                ops.push(s[i]);
                String val = vals.pop();
                val = "(" + vals.pop() + "+" + val + ")";
                vals.push(val);
            }
            else if (s[i].equals("-")) {
                ops.push(s[i]);
                String val = vals.pop();
                val = "(" + vals.pop() + "-" + val + ")";
                vals.push(val);
            }
            else if (s[i].equals("*")) {
                ops.push(s[i]);
                String val = vals.pop();
                val = "(" + vals.pop() + "*" + val + ")";
                vals.push(val);
            }
            else if (s[i].equals("/")) {
                ops.push(s[i]);
                String val = vals.pop();
                val = "(" + vals.pop() + "/" + val + ")";
                vals.push(val);
            }
            else {
                vals.push(s[i]);
            }
        }
        return String.valueOf(vals);
    }

    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            String postfix = StdIn.readLine();
            String[] s = postfix.split(" ");
            for (int i = 0; i < s.length; i++) {
                StdOut.println(s[i]);
            }
            // StdOut.println(postfixToInfix(postfix));
        }
    }
}
