package tdd;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinMaxStackImplementation implements MinMaxStack{

    public static final int GET_RIGHT_INDEX = 1;
    public static final int NO_VALUE_FOUND = 0;
    private final List<Integer> stack;

    public MinMaxStackImplementation() {
        this.stack = new ArrayList<>();
    }

    @Override
    public void push(int value) {
        this.stack.add(value);
    }

    @Override
    public int pop() {
        this.throwAnIllegalStateExeptionIfStackIsEmpty();

        var lastValue = this.stack.get(this.size() - GET_RIGHT_INDEX);
        this.stack.remove(this.size() - GET_RIGHT_INDEX);
        return lastValue;
    }

    @Override
    public int peek() {
        this.throwAnIllegalStateExeptionIfStackIsEmpty();
        return this.stack.get(this.size() - GET_RIGHT_INDEX);
    }

    @Override
    public int getMin() {
        this.throwAnIllegalStateExeptionIfStackIsEmpty();
        return this.stack.stream().sorted().findFirst().orElse(NO_VALUE_FOUND);
    }

    @Override
    public int getMax() {
        this.throwAnIllegalStateExeptionIfStackIsEmpty();
        return this.stack.stream().sorted(Comparator.reverseOrder()).findFirst().orElse(NO_VALUE_FOUND);
    }

    private void throwAnIllegalStateExeptionIfStackIsEmpty(){
        if(this.isEmpty()){
            throw new IllegalStateException("the stack is empty.");
        }
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public int size() {
        return this.stack.size();
    }
}
