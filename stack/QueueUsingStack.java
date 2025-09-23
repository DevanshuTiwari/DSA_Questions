package stack;

import java.util.Stack;

public class QueueUsingStack {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public QueueUsingStack() {

        this.s1 = s1;
        this.s2 = s2;

    }

    public void push(int x) {
        s2.add(x);
        while (!s1.empty()) {
            s2.add(s1.pop());
        }

        Stack<Integer> s = s1;
        s1 = s2;
        s2 = s;
    }

    public int pop() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return s1.empty();
    }

    public static void main(String[] args) {
        QueueUsingStack queueUsingStack = new QueueUsingStack();
        queueUsingStack.push(1);
        queueUsingStack.push(2);
        System.out.println(queueUsingStack.peek());
        System.out.println(queueUsingStack.pop());
        System.out.println(queueUsingStack.empty());
    }
}
