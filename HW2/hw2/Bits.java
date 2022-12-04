public class Bits {
    public static void main(String[] args) {
        int i = 1;
        int n = Integer.parseInt(args[0]);
        while (n > 1) {
            n = n / 2;
            i++;
        }
        if (n == 0)
            System.out.println("0");
        else if (n < 0)
            System.out.println("Illegal input");
        else
            System.out.println(i);
    }

}




