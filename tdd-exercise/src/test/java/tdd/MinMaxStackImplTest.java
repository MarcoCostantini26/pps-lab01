package tdd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    public static final int SIZE_STACK_AFTER_PUSH_TWO_ELEMENTS = 2;

    @Test
    public void todo() {
        assertTrue(true);
    }

    @Test
    public void initialStateOfStack(){
        final MinMaxStack stack = new MinMaxStackImplementation();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPushInStack(){
        final MinMaxStack stack = new MinMaxStackImplementation();
        stack.push(1);
        stack.push(2);
        assertAll(
                () -> assertFalse(stack.isEmpty()),
                () -> assertEquals(SIZE_STACK_AFTER_PUSH_TWO_ELEMENTS, stack.size())
        );
    }
}