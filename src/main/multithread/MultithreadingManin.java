package main.multithread;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;


import java.util.concurrent.Semaphore;

public class MultithreadingManin {
    public static void main(String[] args) {

        // implementing thread and runnable
        for (int i = 0; i < 2; i++) {
            MyThread thread = new MyThread("First Thread");
            thread.start();
        }

        for (int i = 0; i < 2; i++) {
            MyRunnable runnable1 = new MyRunnable("Second Thread");
            Thread runnableThread = new Thread(runnable1);
            runnableThread.start();
        }

        ConnectionPool connectionPool = ConnectionPool.getInstance();

        ExecutorService executorService = Executors.newFixedThreadPool(7);
        CompletionService<Void> completionService = new ExecutorCompletionService<>(executorService);
        //creating connection
        for (int i = 0; i < 5; i++) {
            Callable<Void> getConnectionTask = () -> {
                try {
                    Thread connection = connectionPool.getConnection();
                    System.out.println("Thread" + Thread.currentThread().getName() + " Got connection:" + connection);
                    Thread.sleep(1000);
                    connectionPool.releaseConnection(connection);
                    System.out.println("Thread" + Thread.currentThread().getName() + "Releases connection:" + connection);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            };

            completionService.submit(getConnectionTask);
        }

        for (int i = 0; i < 2; i++) {
            Callable<Void> waitTask = () -> {
                try {

                    Thread connection = connectionPool.getConnection();
                    System.out.println("Thread" + Thread.currentThread().getName() + " Got connection:" + connection);
                    Thread.sleep(1000);
                    connectionPool.releaseConnection(connection);
                    System.out.println("Thread" + Thread.currentThread().getName() + "Releases connection:" + connection);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            };

            completionService.submit(waitTask);
        }

        executorService.shutdown();


        for (int i = 0; i < 7; i++) {
            try {
                Future<Void> future = completionService.take();
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}






