package main.multithread;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import genericLinkedList.LicenseLinkedList;

import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    private BlockingQueue<Thread> connectionPool;
    private int POOL_SIZE = 5;
    private static ConnectionPool instance;

    private ConnectionPool() {
        connectionPool = new ArrayBlockingQueue<>(POOL_SIZE);
        for (int i = 0; i < POOL_SIZE; i++) {
            connectionPool.offer(createNewThread());
        }
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public Thread createNewThread() {
        return new Thread();
    }
    public void addConnectionThread(Thread connectionThread) {
        if (connectionThread != null) {
            try {
                connectionPool.put(connectionThread);
            } catch (InterruptedException e) {

            }
        }
    }
    public Thread getConnection() throws InterruptedException {
        return connectionPool.take();
    }

    public void releaseConnection(Thread connection) {
        try {
            connectionPool.put(connection);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

