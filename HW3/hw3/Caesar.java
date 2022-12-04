public class Caesar {
    public static void main(String[] args) {
        // String sentence = " ";  -String does not recognize space.
        // while (StdIn.hasNextLine())  -This is not the best way here, isEmpty is better.
        // Tried using StdIn.readString, but it does not read space.
        // char letter = ' ';  This is not a good way to initialize character.
        int k = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty()) {
            char letter = StdIn.readChar();
            // StdOut.print(letter);
            int lett = letter;
            // StdOut.print("\nlett:" + lett + " " + "\n");
            // if punctuation or number or space or extended symbols, simply print it out.
            if (lett < 65 || lett > 90) {
                String sentence1 = Character.toString(letter);
                sentence1 = sentence1.replace("\n", "");
                StdOut.print(sentence1);
            }
            // if upper case, print it + k.
            else {
                int lettC = ((lett - 65) + k) % 26 + 65;
                char lettCC = (char) lettC;
                String sentence2 = Character.toString(lettCC);
                sentence2 = sentence2.replace("\n", "");
                StdOut.print(sentence2);

            }
        }
    }
}
// if ASCII>90, go back to the beginning of alphabet and count.
                /* int lettC = lett + k;
                 if (lettC > 90) {
                    lettC = 64 + (lettC - 90);  // 90 here is problematic because k can be 200.
                }
                StdOut.print(lettCC); */

// create string to with the shifted characters, and stop the program.
// when a newline ('\n') character is found.
// at end of program, print out the shifted string.

/*  (((c-65) + k) % 26 + 65)) -Prof Story's answer.
c-65 is the distance between input letter and A, (c-65) + k will be the total distance between
A and the shifted letter on N alphabets. Use the total distance to divide by the alphabet size,
we can k now N times we loop around the alphabet and also the remainder tells us the distance
between A and the shifted letter on 1 alphabet. Then plus 65 gives us the shifted letter. */

