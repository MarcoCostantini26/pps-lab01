package tdd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    public static final int SIZE_STACK_AFTER_PUSH_TWO_ELEMENTS = 2;
    public static final int FIRTS_VALUE_IN_STACK = 1;
    public static final int SECOND_VALUE_IN_STACK = 2;
    public static final int EMPTY_STACK_SIZE = 0;
    public static final int ONE_VALUE_IN_STACK = 1;

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
        stack.push(FIRTS_VALUE_IN_STACK);
        stack.push(SECOND_VALUE_IN_STACK);
        assertAll(
                () -> assertFalse(stack.isEmpty()),
                () -> assertEquals(SIZE_STACK_AFTER_PUSH_TWO_ELEMENTS, stack.size())
        );
    }

    @Test
    public void testPopInStackWithOneValue(){
        final MinMaxStack stack = new MinMaxStackImplementation();
        stack.push(FIRTS_VALUE_IN_STACK);
        assertAll(
                () -> assertEquals(FIRTS_VALUE_IN_STACK, stack.pop()),
                () -> assertTrue(stack.isEmpty()),
                () -> assertEquals(EMPTY_STACK_SIZE, stack.size())
        );

    }

    @Test
    public void testPopInStackWithTwoValues(){
        final MinMaxStack stack = new MinMaxStackImplementation();
        stack.push(FIRTS_VALUE_IN_STACK);
        stack.push(SECOND_VALUE_IN_STACK);
        assertAll(
                () -> assertEquals(SECOND_VALUE_IN_STACK, stack.pop()),
                () -> assertFalse(stack.isEmpty()),
                () -> assertEquals(ONE_VALUE_IN_STACK, stack.size())
        );

    }

    @Test
    public void testPopThrowExeptionWithEmptyStack(){
        final MinMaxStack stack = new MinMaxStackImplementation();
        assertThrows(IllegalStateException.class, stack::pop);
    }
}