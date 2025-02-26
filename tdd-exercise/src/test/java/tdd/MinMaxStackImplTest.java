package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    public static final int SIZE_STACK_AFTER_PUSH_TWO_ELEMENTS = 2;
    public static final int FIRST_VALUE_IN_STACK = 1;
    public static final int SECOND_VALUE_IN_STACK = 2;
    public static final int EMPTY_STACK_SIZE = 0;
    public static final int ONE_VALUE_IN_STACK = 1;
    public MinMaxStack stack;

    @BeforeEach
    public void initStack(){
        this.stack = new MinMaxStackImplementation();
    }

    @Test
    public void initialStateOfStack(){
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPushInStack(){
        stack.push(FIRST_VALUE_IN_STACK);
        stack.push(SECOND_VALUE_IN_STACK);
        assertAll(
                () -> assertFalse(stack.isEmpty()),
                () -> assertEquals(SIZE_STACK_AFTER_PUSH_TWO_ELEMENTS, stack.size())
        );
    }

    @Test
    public void testPopInStackWithOneValue(){
        stack.push(FIRST_VALUE_IN_STACK);
        assertAll(
                () -> assertEquals(FIRST_VALUE_IN_STACK, stack.pop()),
                () -> assertTrue(stack.isEmpty()),
                () -> assertEquals(EMPTY_STACK_SIZE, stack.size())
        );

    }

    @Test
    public void testPopInStackWithTwoValues(){
        stack.push(FIRST_VALUE_IN_STACK);
        stack.push(SECOND_VALUE_IN_STACK);
        assertAll(
                () -> assertEquals(SECOND_VALUE_IN_STACK, stack.pop()),
                () -> assertFalse(stack.isEmpty()),
                () -> assertEquals(ONE_VALUE_IN_STACK, stack.size())
        );

    }

    @Test
    public void testPeekStack(){
        stack.push(FIRST_VALUE_IN_STACK);
        stack.push(SECOND_VALUE_IN_STACK);
        assertEquals(SECOND_VALUE_IN_STACK, stack.peek());
    }

    @Test
    public void testMinInStack(){
        stack.push(FIRST_VALUE_IN_STACK);
        stack.push(SECOND_VALUE_IN_STACK);
        assertEquals(FIRST_VALUE_IN_STACK, stack.getMin());
    }

    @Test
    public void testMaxInStack(){
        stack.push(FIRST_VALUE_IN_STACK);
        stack.push(SECOND_VALUE_IN_STACK);
        assertEquals(SECOND_VALUE_IN_STACK, stack.getMax());
    }

    @Test
    public void testThrowsInAllMethods(){
        assertAll(
                () -> assertThrows(IllegalStateException.class, stack::peek),
                () -> assertThrows(IllegalStateException.class, stack::pop),
                () -> assertThrows(IllegalStateException.class, stack::getMax),
                () -> assertThrows(IllegalStateException.class, stack::getMin)
        );
    }
}