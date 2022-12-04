public class Cone {
    public static void main(String[] args) {
        double r = Double.parseDouble(args[0]);
        double h = Double.parseDouble(args[1]);
        double pi = Math.PI;
        double area = pi * r * (r + Math.sqrt((Math.pow(r, 2) + Math.pow(h, 2))));
        StdOut.println(area);
    }
}
