package completable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

class ConcurrentHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private final Segment[] segments;

    public ConcurrentHashMap() {
        this.segments = new Segment[DEFAULT_CAPACITY];
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            segments[i] = new Segment();
        }
    }

    public V get(K key) {
        int hash = key.hashCode();
        int segmentIndex = hash % segments.length;
        return (V) segments[segmentIndex].get(key);
    }

    public void put(K key, V value) {
        int hash = key.hashCode();
        int segmentIndex = hash % segments.length;
        segments[segmentIndex].put(key, value);
    }

    private static class Segment<K, V> {
        private final Map<K, V> map = new HashMap<>();
        private final ReentrantLock lock = new ReentrantLock();

        public V get(K key) {
            try {
                lock.lock();
                return map.get(key);
            } finally {
                lock.unlock();
            }
        }

        public void put(K key, V value) {
            try {
                lock.lock();
                map.put(key, value);
            } finally {
                lock.unlock();
            }
        }
    }
}
/*
In the modified example I provided, the get operation includes a lock mainly for consistency and to ensure that the internal state of the ConcurrentHashMap remains stable during concurrent operations. In practice, the locking strategy for the get operation in ConcurrentHashMap is more nuanced, and not all implementations use locks for reads.

In many concurrent data structures, including ConcurrentHashMap, the use of locks for read operations (such as get) is often referred to as "locking for visibility." The lock ensures that the reading thread sees a consistent and up-to-date view of the data structure, even if other threads are concurrently modifying it.

Here are some reasons for including a lock in the get operation:

Visibility of Updates: Without proper synchronization, changes made by one thread might not be visible to other threads immediately. The lock ensures that the reading thread sees the most recent updates made by other threads.

Preventing Concurrent Modifications: If other threads are allowed to modify the map concurrently, a read operation without synchronization could occur simultaneously with a write operation, leading to undefined behavior or inconsistent results.

Atomicity: The lock ensures that the entire get operation is atomic. It prevents interleaving of steps by other threads, ensuring that the read operation is not affected by concurrent modifications.

It's worth noting that some concurrent data structures use lock-free or optimistic techniques for read operations to avoid the overhead of acquiring and releasing locks. However, these approaches are often more complex and are carefully designed to provide correctness and performance benefits in concurrent scenarios.

In real-world scenarios, the decision to use locks for read operations depends on the specific requirements of the data structure and the expected usage patterns in a concurrent environment.





 */