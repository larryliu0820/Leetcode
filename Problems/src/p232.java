import java.util.Stack;

/**
 * Created by Valued Customer on 7/20/2017.
 * 232. Implement Queue using Stacks
 */
public class p232 {
    Stack<Integer> input;
    Stack<Integer> output;
    /** Initialize your data structure here. */
    public p232() {
        input = new Stack<>();
        output = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!output.empty()) input.push(output.pop());
        input.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!input.empty()) output.push(input.pop());
        return output.pop();
    }

    /** Get the front element. */
    public int peek() {
        while (!input.empty()) output.push(input.pop());
        return output.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (input.empty() && output.empty());
    }
}
