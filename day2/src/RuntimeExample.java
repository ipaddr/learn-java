public class RuntimeExample {
    public static void main(String[] args) {
        // get the current runtime associated with this process
        Runtime run = Runtime.getRuntime();
        // print the current free memory for this runtime
        System.out.println("" + run.freeMemory());

        // print the number of free bytes
        System.out.println("" + Runtime.getRuntime().freeMemory());

        // print the number of total bytes
        System.out.println("" + Runtime.getRuntime().totalMemory());

        // check the number of processors available
        System.out.println("" + Runtime.getRuntime()
                .availableProcessors());
    }
}
