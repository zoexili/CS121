public class QueensChecker {
    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] q = in.readAllInts();
        char[][] board = new char[5][5];
        int i;
        int j;
        // for (i = 0; i < 5; i++)
        // StdOut.print(q[i]);
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                board[i][j] = '*';
            }
        }
        board[q[0]][0] = 'Q';
        board[q[1]][1] = 'Q';
        board[q[2]][2] = 'Q';
        board[q[3]][3] = 'Q';
        board[q[4]][4] = 'Q';
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                StdOut.print(board[i][j] + " ");
            }
            StdOut.println(); // start next line
        }
        String[] check = new String[2];
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                if (i < j) {
                    if (!(q[i] == q[j]) && !(q[i] - q[j] == j - i) && !(q[j] - q[i] == j - i)) {
                        check[0] = "true";
                    }
                    else
                        check[1] = "false";
                }
            }
        }
        if (check[1] == "false") {
            StdOut.print("false");
        }
        else {
            StdOut.print("true");
        }
    }
}

        /* for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                if (i < j) {
                    if (q[i] == q[j]) {
                        StdOut.print("false1");
                        break;
                    }
                }
            }
        }
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                if (i < j) {
                    if (q[i] - q[j] == j - i) {
                        StdOut.print("false2");
                        break;
                    }
                }
            }
        }
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                if (i < j) {
                    if (q[j] - q[i] == j - i) {
                        StdOut.print("false3");
                        break;
                    }
                }
            }
        }
        StdOut.print("true");
        in.close(); */



        /* int count = 0;
        for (i = 0; i < 5; i++) {
            if (board[0][i] == 'Q') {
                count += count;
                if (count >= 2) {
                    StdOut.print("false");
                    // break;
                }
                else if (board[1][i] == 'Q') {
                    count += count;
                    if (count >= 2) {
                        StdOut.print("false");
                        // break;
                    }
                }
                else if (board[2][i] == 'Q') {
                    count += count;
                    if (count >= 2) {
                        StdOut.print("false");
                        // break;
                    }
                }
                else if (board[3][i] == 'Q') {
                    count += count;
                    if (count >= 2) {
                        StdOut.print("false");
                        // break;
                    }
                    else if (board[4][i] == 'Q') {
                        count += count;
                        if (count >= 2) {
                            StdOut.print("false");
                            // break;
                        }
                    }
                }
                count = 0;
                // major diagonal: 5* diagonal
                for (i = 0; i < 5; i++) {
                    for (j = 0; j < 5; j++) {
                        if (board[i] == board[j]) {
                            count += count;
                            if (count >= 2) {
                                StdOut.print("false");
                                // break;
                            }
                        }
                    }
                }
                count = 0;
                // minor diagonal: 2* diagonal, 3* diagonal, 4* diagonal.
                for (i = 0; i < 4; i++) {
                    for (j = 0; j < 4; j++) {
                        if (board[i][j] == 'Q' && board[i + 1][j + 1] == 'Q') {
                            StdOut.print("false");
                            // break;
                        }
                    }
                } */


