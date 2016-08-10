import java.util.Stack;

/**
 * Created by Valued Customer on 8/9/2016.
 */
public class p155 {
    public class MinStack {
        protected Stack<Integer> data;
        protected Stack<Integer> minStack;
        /** initialize your data structure here. */
        public MinStack() {
            data = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            data.push(x);
            if (!minStack.isEmpty())
                minStack.push(x<minStack.peek()?x:minStack.peek());
            else
                minStack.push(x);
        }

        public void pop() {
            if (!data.isEmpty()) {
                data.pop();
                minStack.pop();
            }
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
