import java.util.Arrays;

public class SystemClassExample {
    public static void main(String[] args) {
        // array copy
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {6, 7, 8, 9, 10};

        System.arraycopy(a, 3, b, 3, 2);

        // array b after arraycopy operation
        System.out.println(Arrays.toString(b));

        // current time milis
        System.out.println("difference between the "
                + "current time and midnight,"
                + " January 1, 1970 UTC is: " +
                System.currentTimeMillis());
        System.out.println("current time in "
                + "nano sec: " +
                System.nanoTime());
    }
}
