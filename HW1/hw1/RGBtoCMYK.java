public class RGBtoCMYK {
    public static void main(String[] args) {
        int red = Integer.parseInt(args[0]);
        int green = Integer.parseInt(args[1]);
        int blue = Integer.parseInt(args[2]);
        System.out.println("red = " + args[0]);
        System.out.println("green = " + args[1]);
        System.out.println("blue = " + args[2]);
        System.out.println(" ");
        Double cmykred = Double.parseDouble(args[0]) / 255;
        Double cmykgreen = Double.parseDouble(args[1]) / 255;
        Double cmykblue = Double.parseDouble(args[2]) / 255;
        Double white = Math.max(Math.max(cmykred, cmykgreen), cmykblue);
        Double cyan = (white - cmykred) / white;
        Double magenta = (white - cmykgreen) / white;
        Double yellow = (white - cmykblue) / white;
        Double black = 1 - white;
        System.out.println("cyan = " + cyan);
        System.out.println("magenta = " + magenta);
        System.out.println("yellow = " + yellow);
        System.out.println("black = " + black);

    }
}
