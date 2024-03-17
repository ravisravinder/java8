# Java Collection Classes Overview

This README provides an overview of the Java collection classes available in the Java Collections Framework.

## Interfaces

1. **Iterable**: Enables objects to be iterated over using the enhanced for loop or iterators.
2. **Collection**: The root interface in the collection hierarchy.
3. **Set**: A collection that contains no duplicate elements.
4. **List**: An ordered collection (sometimes called a sequence).
5. **Queue**: A collection used to hold multiple elements prior to processing.
6. **Deque**: A linear collection that supports element insertion and removal at both ends.
7. **Map**: An object that maps keys to values.

## Classes
## List Implementations
12. **ArrayList**: A resizable-array implementation of the List interface.
13. **LinkedList**: A doubly linked list implementation of the List and Deque interfaces.
14. **Vector**: A synchronized resizable-array implementation of the List interface (legacy class).
15. **Stack**: A stack implementation (legacy class).
22. **CopyOnWriteArrayList**: A thread-safe variant of ArrayList in which all mutative operations (add, set, and so on) are implemented by making a fresh copy of the underlying array.

## Set Implementations
10. **HashSet**: A hash table-based implementation of the Set interface.
11. **LinkedHashSet**: A hash table and linked list implementation of the Set interface with predictable iteration order.
18. **EnumSet**: A specialized Set implementation for use with enum elements.
23. **CopyOnWriteArraySet**: A thread-safe variant of Set in which all mutative operations are implemented by making a fresh copy of the underlying array.

## Queue IMplementations 
16. **PriorityQueue**: An unbounded priority queue based on a priority heap.
17. **ArrayDeque**: A resizable-array implementation of the Deque interface.


## Map Implementations

7. **HashMap**:
   A hash table-based implementation of the Map interface.
8. **TreeMap**: A red-black tree-based implementation of the NavigableMap interface.
9. **LinkedHashMap**: A hash table-based implementation of the Map interface with predictable iteration order.
19. **WeakHashMap**: A Map implementation with weak keys.
20. **IdentityHashMap**: A Map implementation based on reference-equality in place of object-equality.
21. **ConcurrentHashMap**: A thread-safe implementation of the Map interface.

#################

1. **AbstractCollection**: **Collection Interface**
    An abstract implementation of the Collection interface.
2. **AbstractList**:  **List Interface**
    An abstract implementation of the List interface.
3. **AbstractSequentialList**: **List Interface for Sequential access data(linked lists)**
     An abstract implementation of the List interface for sequential access data (such as linked lists).
4. **AbstractSet**: **Set interface**
    An abstract implementation of the Set interface.
5. **AbstractQueue**:  **Queue Interface**
    An abstract implementation of the Queue interface.
6. **AbstractMap**:  **Map Interface**
     An abstract implementation of the Map interface.

## Utility Classes
1. **Collections**: Provides various methods for manipulating collections (e.g., sorting, searching, shuffling).
2. **Arrays**: Provides methods for working with arrays (e.g., sorting, searching, comparing).

## Concurrent Interfaces

1. **BlockingQueue**: A queue that supports operations that wait for the queue to become non-empty when retrieving an element and wait for space to become available in the queue when storing an element.
2. **BlockingDeque**: A deque that supports operations that wait for the deque to become non-empty when retrieving an element and wait for space to become available in the deque when storing an element.

## Additional Classes and Interfaces

1. **NavigableMap and NavigableSet**: TreeMap implements NavigableMap, and TreeSet implements NavigableSet. These interfaces provide additional navigation methods and were added in Java 6.
2. **Legacy Classes**: Vector and Stack have been largely replaced by their more modern counterparts (ArrayList and ArrayDeque, respectively).
3. **Utility Classes**: The Collections Framework includes utility classes such as Collections (for manipulating collections) and Arrays (for working with arrays).
4. **Immutable Collections**: The `java.util.Collections` class provides methods to create immutable views of collections, ensuring that their contents cannot be modified.

# Java Queue Interface Implementations

In Java, the Queue interface is implemented by several classes in the Java Collections Framework. Here are some commonly used classes that implement the Queue interface:

## LinkedList

- **Description**: LinkedList class can be used as a queue by treating it as a first-in, first-out (FIFO) data structure.
- **Interface**: It implements the Queue interface.

## PriorityQueue

- **Description**: PriorityQueue class provides an unbounded priority queue based on a priority heap.
- **Interface**: It implements the Queue interface and orders elements according to their natural ordering or a specified comparator.

## ArrayDeque

- **Description**: ArrayDeque class provides a resizable-array implementation of the Deque interface, which extends the Queue interface. It can be used as a double-ended queue (deque) and also as a queue.
- **Interface**: It implements the Queue interface.

## ConcurrentLinkedQueue

- **Description**: ConcurrentLinkedQueue class provides a non-blocking concurrent queue based on linked nodes.
- **Interface**: It implements the Queue interface and is suitable for high-concurrency applications.

## LinkedBlockingQueue

- **Description**: LinkedBlockingQueue class provides a blocking queue backed by linked nodes.
- **Interface**: It implements the BlockingQueue interface, which extends the Queue interface, and is suitable for producer-consumer scenarios.

## PriorityBlockingQueue

- **Description**: PriorityBlockingQueue class provides a blocking priority queue based on a priority heap.
- **Interface**: It implements the BlockingQueue interface and orders elements according to their natural ordering or a specified comparator.

## DelayQueue

- **Description**: DelayQueue class implements the BlockingQueue interface and holds elements with associated expiration times. Elements are taken from the queue only when their delay has expired.

## SynchronousQueue

- **Description**: SynchronousQueue class is an implementation of the BlockingQueue interface where each insertion operation must wait for a corresponding removal operation by another thread, and vice versa.

## LinkedTransferQueue

- **Description**: LinkedTransferQueue class is an implementation of the TransferQueue interface, which extends the BlockingQueue interface. It allows producers to wait for consumers to receive elements concurrently.

## PriorityBlockingQueue (Repeated)

- **Description**: PriorityBlockingQueue class provides a blocking priority queue based on a priority heap, thus allowing elements to be ordered based on their priority.

### Classes implementing Dequeue Interface in Java

In Java, the Deque interface is implemented by several classes in the Java Collections Framework. Here are some commonly used classes that implement the Deque interface:

## ArrayDeque

- **Description**: ArrayDeque class provides a resizable-array implementation of the Deque interface. It stores its elements internally in an array and supports fast insertion and removal operations at both ends of the deque.

## LinkedList (Repeated)

- **Description**: LinkedList class can also be used as a double-ended queue (deque) by treating it as such. It implements the Deque interface and allows for efficient insertion and removal operations at both ends of the deque.

## LinkedBlockingDeque

- **Description**: LinkedBlockingDeque class provides a blocking deque backed by linked nodes. It implements the BlockingDeque interface, which extends the Deque interface, and supports blocking operations for producer-consumer scenarios.
