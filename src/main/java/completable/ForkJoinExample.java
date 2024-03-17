package completable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        // Example: Summing an array using ForkJoinPool
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        long sum = forkJoinPool.invoke(new SumTask(array, 0, array.length));
        System.out.println("Sum: " + sum);

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
    }

    static class SumTask extends RecursiveTask<Long> {
        private final int[] array;
        private final int start;
        private final int end;

        public SumTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start <= 3) {
                // Perform the task directly if small enough
                long sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                return sum;
            } else {
                // Split the task into smaller subtasks
                int mid = (start + end) / 2;
                SumTask leftTask = new SumTask(array, start, mid);
                SumTask rightTask = new SumTask(array, mid, end);

                // Fork and join subtasks
                leftTask.fork();
                long rightResult = rightTask.compute();
                long leftResult = leftTask.join();

                // Combine results
                return leftResult + rightResult;
            }
        }
    }
}
