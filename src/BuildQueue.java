import java.util.Stack;

public class BuildQueue {
    /*用两个栈来实现一个队列
    * 1. 入队：入栈1，若栈1满且栈2空，将栈1中的元素依次放入栈2后再入栈1
    * 2. 出队：若栈2不为空，直接从栈2出栈元素，若栈2为空，将栈1的元素全部置入栈2后再出栈*/
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(!stack2.isEmpty()) {
           return stack2.pop();
        }
        while (!stack1.isEmpty()) {
            int num = stack1.pop();
            stack2.push(num);
        }
        return stack2.pop();
    }
}
