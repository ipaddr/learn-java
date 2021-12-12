package id.oneindoensia.javabootcamp.day3;

import java.util.concurrent.*;

class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Hi from Runnable");
    }
}

public class JavaConcurrentExample {
    public static void main(String[] args) {
        executorExample();
        try {
            executorServiceExample();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        futureExample();
    }

    private static void executorExample(){
        Executor invoker = (r) -> {System.out.println("Hi from Invoker"); r.run();};
        invoker.execute(new MyRunnable());
    }

    private static void executorServiceExample() throws InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        synchronized (service){
            service.wait(1000);
            service.execute(new MyRunnable());
            service.shutdown();
        }
    }

    private static void futureExample(){
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Future<Integer> callableResult = executorService.submit(new MyCallableMultiplication(2, 3));
        try {
            int result = callableResult.get().intValue();
            System.out.println("Result : "+result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class MyCallableMultiplication implements Callable<Integer>{

    private  int x;
    private int y;

    public MyCallableMultiplication(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(3000);
        return x * y;
    }
}

