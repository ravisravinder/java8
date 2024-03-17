package completable;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();

        // Producer
        new Thread(() -> {
            try {
                blockingQueue.put("Item 1");
                blockingQueue.put("Item 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // Consumer
        new Thread(() -> {
            try {
                System.out.println("Consumed: " + blockingQueue.take());
                System.out.println("Consumed: " + blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

