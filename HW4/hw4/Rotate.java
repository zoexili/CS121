public class Rotate {
    public static void main(String[] args) {
        Picture picture = new Picture(args[0]);
        int width = picture.width();
        // StdOut.println("width = " + width);
        int height = picture.height();
        // StdOut.println("height = " + height);
        // when flipping 90 deg, it is important to reset the frame because
        // height becomes width, and width becomes height.
        Picture newpic = new Picture(height, width);
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                newpic.set(height - row - 1, col, picture.get(col, row));
                // newpic.set(col, height - row - 1, picture.get(col, row)); // flip upside down
            }
        }
        newpic.show();
        newpic.save("newpic.jpg");
    }
}
