public class Luminosity {
    private int l;

    public Luminosity(int l) {
        this.l = l;
    }

    public int getLuminosity() {
        return l;
    }

    public Luminosity brighter() {
        Luminosity lum = new Luminosity((int) (l * 0.9));
        return lum;
    }

    public Luminosity darker() {
        Luminosity lum = new Luminosity((int) (l * 1.1));
        return lum;
    }

    public String toString() {
        return "Luminosity: " + l;
    }

    public boolean equals(Luminosity m) {
        if (this.l == m.l) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Luminosity lum = new Luminosity(10);
        Luminosity lum1 = lum.brighter();
        // lum2 = lum.darker();
        System.out.println(lum);
        System.out.println(lum.equals(lum1));

    }
}
