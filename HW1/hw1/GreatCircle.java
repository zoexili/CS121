public class GreatCircle {
    public static void main(String[] args) {
        double x1 = Double.parseDouble(args[0]);
        double y1 = Double.parseDouble(args[1]);
        double x2 = Double.parseDouble(args[2]);
        double y2 = Double.parseDouble(args[3]);
        double rx1 = Math.toRadians(x1);
        double ry1 = Math.toRadians(y1);
        double rx2 = Math.toRadians(x2);
        double ry2 = Math.toRadians(y2);
        double distdeg = Math.acos(Math.sin(rx1) * Math.sin(rx2) +
                                           Math.cos(rx1) * Math.cos(rx2) * Math.cos(ry1 - ry2));
        double distmiles = Math.toDegrees(distdeg) * 60;

        System.out.println(distmiles + " nautical miles");
    }
}
