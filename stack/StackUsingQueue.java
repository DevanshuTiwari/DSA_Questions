package stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public StackUsingQueue() {
        this.q1 = q1;
        this.q2 = q2;

    }

    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }

        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    public int pop() {
        return q1.poll();

    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueue stackUsingQueue = new StackUsingQueue();
        stackUsingQueue.push(1);
        stackUsingQueue.push(2);
        System.out.println(stackUsingQueue.top());
        System.out.println(stackUsingQueue.pop());
        System.out.println(stackUsingQueue.empty());

    }
}
