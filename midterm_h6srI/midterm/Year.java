public class Year {
    private final int year;

    public Year(int year) {
        this.year = year;
    }

    public boolean equals(Object y) {
        if (y == this)
            return true;
        if (y == null)
            return false;
        if (y.getClass() != this.getClass()) {
            return false;
        }
        Year yy = (Year) y;
        if (this.year != yy.year) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
