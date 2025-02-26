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
    public static final int SECOND_ELEMENT_QUEUED = 2;
    public static final int THIRD_ELEMENT_QUEUED = 3;
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
    public void testUnqueueAnElementWithEmptyQueue(){
        assertThrows(IllegalStateException.class, queue::unqueue);
    }

    @Test
    public void testFullQueue(){
        queue.queue(FIRST_ELEMENT_QUEUED);
        queue.queue(SECOND_ELEMENT_QUEUED);
        queue.queue(THIRD_ELEMENT_QUEUED);
        assertTrue(queue.isFull());
    }
}
