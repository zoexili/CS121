public class NoonSnooze {
    public static void main(String[] args) {
        int snooze = Integer.parseInt(args[0]);
        int min = snooze % 60;
        int cycle = snooze / 60 / 12; // cycles of 12 hours.
        // snooze / 60 / 12 will cast out the decimal points. The decimal digits * 12 = time.
        int time = snooze / 60 - cycle * 12;
        int separate = cycle % 2;
        // separate = 0, even, means PM, separate = 1, odd, means AM.
        if (separate == 0) {
            // PM
            if (snooze % 720 < 10) {
                // When PM, if add 12 hours or multiples of 12 and less than 10 minutes,
                // report 12 as hour instead of 0.
                StdOut.println("12:0" + min + "pm");
            }
            else if (snooze % 720 >= 10 && snooze % 720 < 60) {
                // if add 12 hours and 10-60 minutes, report 12 as hour.
                StdOut.println("12:" + min + "pm");
            }
            else if (min < 10) {
                // if hour is not 12, but min is < 10 min.
                StdOut.println(time + ":0" + min + "pm");
            }
            else {
                // if hour is not 12, but min is between 10 and 60 min.
                StdOut.println(time + ":" + min + "pm");
            }
        }
        else if (separate == 1) {
            // AM
            if (snooze % 720 < 10) {
                // When AM, if add 12 hours or multiples of 12 and less than 10 minutes,
                // report 12 as hour instead of 0.
                StdOut.println("12:0" + min + "am");
            }
            else if (snooze % 720 >= 10 && snooze % 720 < 60)
                StdOut.println("12:" + min + "am");
            else if (min < 10) {
                // if hour is not 12, but min is < 10 min.
                StdOut.println(time + ":0" + min + "am");
            }
            else {
                // if hour is not 12, but min is between 10 and 60 min.
                StdOut.println(time + ":" + min + "am");
            }
        }
    }
}
