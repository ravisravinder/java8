package completable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WhyNotFuture {
    public static void main(String[] args) {
        System.out.println("f1: " + Thread.currentThread().getName());
        ExecutorService service = Executors.newFixedThreadPool(10);
        System.out.println("f2 : " + Thread.currentThread().getName());
        int numberOfCores = Runtime.getRuntime().availableProcessors();
        long l = Runtime.getRuntime().maxMemory();
        System.out.println(l+" max memory");
        System.out.println(numberOfCores+" ++++++++++++++++++++++");
        ExecutorService service1 = Executors.newFixedThreadPool(numberOfCores);
        System.out.println("service 1==="+service1);

        service.execute(()-> {
            List<Integer> integerList = Arrays.asList(1, 2, 3, 4);
            // Perform some logic with the list
            System.out.println("f3 : " + Thread.currentThread().getName());
            for (Integer num : integerList) {
                System.out.println("Processing element: " + num + " in thread: " + Thread.currentThread().getName());
                // Add your custom logic here
            }
        });

    }
}
