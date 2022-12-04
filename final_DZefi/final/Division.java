public class Division {

    public static double divide(double x, double y) {
        double xy = x / y;
        return xy;
    }

    public static void main(String[] args) {
        try {
            double x = Double.parseDouble(args[0]);
            double y = Double.parseDouble(args[1]);
            if (y == 0) {
                System.out.println("Error: division by zero");
            }
            System.out.println(x / y);
        }
        catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Usage: java Division DOUBLE_X DOUBLE_Y");
        }
        // catch (ArithmeticException e) {
        //     System.out.println("Error: division by zero");
    }
}



