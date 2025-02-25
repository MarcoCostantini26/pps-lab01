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
        if(this.isEmpty()){
            throw new IllegalStateException("the stack is empty.");
        }else{
            var lastValue = this.stack.get(this.size() - GET_RIGHT_INDEX);
            this.stack.remove(this.size() - GET_RIGHT_INDEX);
            return lastValue;
        }

    }

    @Override
    public int peek() {
        return 0;
    }

    @Override
    public int getMin() {
        return 0;
    }

    @Override
    public int getMax() {
        return 0;
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
