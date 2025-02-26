package tdd;

import java.util.ArrayList;
import java.util.List;

public class CircularQueueImplementation implements CircularQueue{

    public static final int FIXED_CAPACITY = 3;
    public static final int OLDEST_ELEMENT = 0;
    private List<Integer> queue;

    public CircularQueueImplementation() {
        this.queue = new ArrayList<>(FIXED_CAPACITY);
    }


    @Override
    public void queue(int element) {
        this.queue.add(element);
    }

    @Override
    public int unqueue() {
        return this.queue.remove(OLDEST_ELEMENT);
    }

    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override
    public int size() {
        return this.queue.size();
    }
}
