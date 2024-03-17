package All.queueInterface;

import java.util.LinkedList;
import java.util.Queue;

public class QueueUsage {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("Apple");
        queue.offer("Banana");
        queue.offer("Orange");
        // Printing all elements in the queue
        System.out.println("Elements in the queue:");
        System.out.println(queue);
        // Removing and printing the head of the queue
        System.out.println("Removed element from the queue: " + queue.poll());

        // Printing the head of the queue without removing it
        System.out.println("Peeked element from the queue: " + queue.peek());

        // Iterating over the queue using a while loop
        System.out.println("Elements in the queue (using while loop):");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
