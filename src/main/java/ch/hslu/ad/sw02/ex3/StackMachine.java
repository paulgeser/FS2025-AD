package ch.hslu.ad.sw02.ex3;

import ch.hslu.ad.sw02.ex2.Stack;

public class StackMachine {

    private Stack<Integer> stack;

    public StackMachine() {
        this.stack = new Stack<Integer>(1000);
    }

    public void load(int number) {
        stack.push(number);
    }

    public void add() {
        stack.push(stack.pop() + stack.pop());
    }

    public void sub() {
        stack.push(stack.pop() - stack.pop());
    }

    public void mul() {
        stack.push(stack.pop() * stack.pop());
    }

    public void div() {
        stack.push(stack.pop() / stack.pop());
    }

    public int print(){
        return stack.pop();
    }
}
