package tdd;

/**
 *  Task 3 - TDD for Circular Queue
 *  A simple CircularQueue that stores integers with a **fixed** capacity.
 *  When full, new elements overwrite the oldest ones.
 *  
 *  When removing elements, the oldest ones are removed first.
 *  Therefore, giving [4, 5, 3], the first element to be removed is 4, then 5, and finally 3.
 *  
 *  For the exercise: 
 *   - Think about the test cases you need to write.
 *   - Introduce methods in the interface in order to make the tests pass.
 *   - Refactor
 */
public interface CircularQueue {

    /**
     * Queue an element in the CircularQueue
     *
     */
    void queue(int element);

    /**
     * Unqueue the oldest element in the CircularQueue
     *
     * @return the oldest element
     * @throws IllegalStateException if the queue is empty.
     */
    int unqueue();

    /**
     * Checks if the queue is full.
     *
     * @return true if the queue is full, false otherwise.
     */
    boolean isFull();

    /**
     * Gets the newest element in the queue.
     *
     * @return The newest element of the queue.
     * @throws IllegalStateException if the queue is empty.
     */
    int getNewestElement();

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Gets the number of elements currently in the queue.
     *
     * @return The size of the queue.
     */
    int size();
}