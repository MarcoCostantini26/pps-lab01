package tdd;

import java.util.ArrayList;
import java.util.List;

public class MinMaxStackImplementation implements MinMaxStack{

    public static final int GET_RIGHT_INDEX = 1;
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
        return stack.stream().
    }

    @Override
    public int getMax() {
        return 0;
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
