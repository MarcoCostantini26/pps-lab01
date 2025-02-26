package tdd;

import java.util.ArrayList;
import java.util.List;

public class CircularQueueImplementation implements CircularQueue{

    private List<Integer> queue;

    public CircularQueueImplementation() {
        this.queue = new ArrayList<>();
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
