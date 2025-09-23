package stack;

import java.util.Stack;

public class MinStack {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>(); // to store min value

    public MinStack() {
        this.s1 = s1;
        this.s2 = s2;
    }

    public void push(int val) {
        s1.push(val);

        if (s2.isEmpty() || val <= s2.peek()) {
            s2.push(val);
        }
    }

    public void pop() {
        int popVal = s1.pop();

        if (popVal == s2.peek()) {
            s2.pop();
        }
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("getMin(): " + minStack.getMin());
        minStack.pop();
        System.out.println("top(): " + minStack.top());
        System.out.println("getMin(): " + minStack.getMin());
    }
}
