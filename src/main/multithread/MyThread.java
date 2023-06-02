package main.multithread;

public class MyThread extends Thread{
    private String threadName;

    public MyThread( String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for(int i=5; i>0; i--){
            System.out.println( i + threadName + "is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread 1 is finished");
    }
}
