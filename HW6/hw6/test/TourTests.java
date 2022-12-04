import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TourTests {

    @Test
    void emptySize() {
        Tour t = new Tour();
        Assertions.assertEquals(t.size(), 0);
    }

    @Test
    void squareSize() {
        Tour t = new Tour();
        Assertions.assertEquals(t.size(), Math.pow(t.size(), 2));
    }

    @Test
    void emptyLength() {
        Tour t = new Tour();
        Assertions.assertEquals(t.length(), 0);
    }

    @Test
    void squareLength() {
        Tour t = new Tour();
        Assertions.assertEquals(t.length(), Math.pow(t.length(), 2));
    }

    @Test
    void emptyToString() {
        Tour t = new Tour();
        Assertions.assertEquals(t.toString(), "");
    }

    @Test
    void squareToString() {
        Tour t = new Tour();
        Assertions.assertEquals(t.toString(), t.toString() + t.toString());
    }

    @Test
    void insertNearest() {
        Tour t = new Tour();
        Point p = new Point(5, 4);
        t.insertNearest(p);
        Assertions.assertEquals(t.size(), 1);
    }

    @Test
    void insertSmallest() {
        Tour t = new Tour();
        Point p = new Point(5, 4);
        t.insertSmallest(p);
        Assertions.assertEquals(t.size(), 1);
    }


}
