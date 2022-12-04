public class RandomWalkers {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        double[] d = new double[10000000];
        double totalSquaredDistance = 0.0;
        /* 0: North, 1: East, 2: South, 3: West */
        for (int trial = 0; trial < trials; trial++) {
            int x = 0;
            int y = 0;
            for (int t = 0; t < n; t++) {
                double r = Math.random();
                int direction = (int) (r * 4);
                if (direction == 0)
                    y = y + 1;
                else if (direction == 1)
                    x = x + 1;
                else if (direction == 2)
                    y = y - 1;
                else if (direction == 3)
                    x = x - 1;
                /*System.out.println("(" + x + ", " + y + ")");*/
                double distance = Math.pow(x, 2) + Math.pow(y, 2);
                int dist = (int) (distance);
                if (t == n - 1)
                    d[trial] = dist;
            }
            totalSquaredDistance += d[trial];
            double meanSquaredDistance = totalSquaredDistance / trials;
            if (trial == trials - 1)
                System.out.println("mean squared distance = " + meanSquaredDistance);
            /*System.out.println("trial ends"); */
        }
        /*System.out.println(d[0]);
        System.out.println(d[1]);
        System.out.println(d[2]);*/
    }
}
