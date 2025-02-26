package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    public CircularQueue queue;

    @BeforeEach
    public void initQueue(){
        queue = new CircularQueueImplementation();
    }

    @Test
    public void testInitialStateOfQueue(){
        assertAll(
                () -> assertTrue(queue.isEmpty()),
                () -> assertEquals(0, queue.size())
        );

    }
}
