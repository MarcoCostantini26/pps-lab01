package tdd;

import java.util.ArrayList;
import java.util.List;

public class CircularQueueImplementation implements CircularQueue{

    public static final int FIXED_CAPACITY = 3;
    public static final int OLDEST_ELEMENT = 0;
    public static final int ADJUST_INDEX_IN_QUEUE = 1;
    private final List<Integer> queue;

    public CircularQueueImplementation() {
        this.queue = new ArrayList<>();
    }


    @Override
    public void queue(int element) {
        if(this.isFull()){
            this.unqueue();
        }
        this.queue.add(this.size(), element);
    }

    @Override
    public int unqueue() {
        this.throwExeptionIfQueueIsEmpty();
        return this.queue.remove(OLDEST_ELEMENT);
    }

    @Override
    public boolean isFull() {
        return this.queue.size() == FIXED_CAPACITY;
    }

    @Override
    public int getNewestElement() {
        this.throwExeptionIfQueueIsEmpty();
        return this.queue.get(this.size() - ADJUST_INDEX_IN_QUEUE);
    }

    private void throwExeptionIfQueueIsEmpty(){
        if(this.isEmpty()){
            throw new IllegalStateException("queue is empty");
        }
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
