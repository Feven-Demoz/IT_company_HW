package main.multithread;

public class MyRunnable implements Runnable{
    private String threadName;

    public MyRunnable(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for(int i=0; i>5; i++){
            System.out.println( i + threadName + " is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread 2 is finished");
    }
}
