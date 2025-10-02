package stack;

import java.util.Arrays;

public class CustomStack {
    private int[] stack;
    private int[] increments;
    private int maxSize;
    private int top;

    public CustomStack(int maxSize) {
        this.stack = new int[maxSize];
        this.increments = new int[maxSize];
        this.maxSize = maxSize;
        this.top = 0;
    }

    public void push(int x) {
        if (top < maxSize) {
            stack[top] = x;
            top++;
        }
    }

    public int pop() {
        if (top == 0) return -1;

        top--;

        int inc = increments[top];

        increments[top] = 0;

        if (top > 0) {
            increments[top - 1] += inc;
        }

        return stack[top] + inc;
    }

    public void increment(int k, int val) {
        int limit = Math.min(k, top);

        if (limit > 0) {
            increments[limit - 1] += val;
        }
    }

//    public int pop() {
//        if (top == 0) return -1;
//
//        top--;
//        return stack[top];
//    }
//
//    public void increment(int k, int val) {
//
//        int limit = Math.min(k, top);
//        for (int i = 0; i < limit; i++) { // O(N)
//            stack[i] += val;
//        }
//    }

    @Override
    public String toString() {
        return "CustomStack{" +
                "stack=" + Arrays.toString(stack) +
                ", maxSize=" + maxSize +
                ", top=" + top +
                '}';
    }

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(5);
        customStack.push(1);
        customStack.push(2);
        customStack.push(3);
        customStack.push(4);
        customStack.push(5);

        System.out.println(customStack);

        customStack.increment(5, 100);
        System.out.println(customStack);

        System.out.println("top of stack is: " + customStack.pop());
    }
}
