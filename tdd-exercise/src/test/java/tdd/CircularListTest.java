package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    public static final int EMPTY_QUEUE = 0;
    public static final int FIRST_ELEMENT_QUEUED = 1;
    public static final int ONE_ELEMENT_IN_QUEUE = 1;
    public static final int TWO_ELEMENT_IN_QUEUE = 2;
    public static final int SECOND_ELEMENT_QUEUED = 2;
    public static final int THIRD_ELEMENT_QUEUED = 3;
    public static final int NEW_ELEMENT = 4;
    public static final int QUEUE_FULL = 3;
    public CircularQueue queue;

    @BeforeEach
    public void initQueue(){
        queue = new CircularQueueImplementation();
    }

    @Test
    public void testInitialStateOfQueue(){
        assertAll(
                () -> assertTrue(queue.isEmpty()),
                () -> assertEquals(EMPTY_QUEUE, queue.size())
        );
    }

    @Test
    public void testQueueAnElement(){
        queue.queue(FIRST_ELEMENT_QUEUED);
        assertAll(
                () -> assertFalse(queue.isEmpty()),
                () -> assertEquals(ONE_ELEMENT_IN_QUEUE, queue.size())
        );
    }

    @Test
    public void testUnqueueAnElement(){
        queue.queue(FIRST_ELEMENT_QUEUED);
        assertAll(
                () -> assertEquals(FIRST_ELEMENT_QUEUED, queue.unqueue()),
                () -> assertTrue(queue.isEmpty()),
                () -> assertEquals(EMPTY_QUEUE, queue.size())
        );
    }

    @Test
    public void testUnqueueTwoElements(){
        queue.queue(FIRST_ELEMENT_QUEUED);
        queue.queue(SECOND_ELEMENT_QUEUED);
        assertAll(
                () -> assertEquals(FIRST_ELEMENT_QUEUED, queue.unqueue()),
                () -> assertFalse(queue.isEmpty()),
                () -> assertEquals(ONE_ELEMENT_IN_QUEUE, queue.size())
        );
    }

    @Test
    public void testUnqueueAnElementWithEmptyQueue(){
        assertThrows(IllegalStateException.class, queue::unqueue);
    }

    @Test
    public void testFullQueue(){
        this.fullTheQueue();
        assertTrue(queue.isFull());
    }

    @Test
    public void testQueueAnElementWithFullQueue(){
        this.fullTheQueue();
        queue.queue(NEW_ELEMENT);
        assertAll(
                () -> assertTrue(queue.isFull()),
                () -> assertEquals(QUEUE_FULL, queue.size()),
                () -> assertEquals(NEW_ELEMENT, queue.getNewestElement())
        );
    }

    @Test
    public void testUnqueueAnElementAfterQueueAnElementWithFullQueue(){
        this.fullTheQueue();
        queue.queue(NEW_ELEMENT);
        assertAll(
                () -> assertEquals(SECOND_ELEMENT_QUEUED, queue.unqueue()),
                () -> assertEquals(TWO_ELEMENT_IN_QUEUE, queue.size())
        );
    }



    private void fullTheQueue(){
        queue.queue(FIRST_ELEMENT_QUEUED);
        queue.queue(SECOND_ELEMENT_QUEUED);
        queue.queue(THIRD_ELEMENT_QUEUED);
    }
}
