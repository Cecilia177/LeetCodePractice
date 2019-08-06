import java.util.Stack;

public class LongestValidRacket {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {            //栈为空时，将当前‘(’下标入栈
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());  //栈顶元素为有效字串的前一个元素下标
                }
            }
        }
        return maxans;

    }



}

class LongestValidRacketTest {
    public void test() {
        System.out.println(new LongestValidRacket().longestValidParentheses("()()(()"));
    }
}
