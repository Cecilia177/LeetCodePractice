import java.util.Stack;

public class MaxRectangular {
    public int largestRectangleArea(int[] heights) {
        /*维护一个单调栈，保持从栈顶到栈底从大到小排列
        * 1. 从左至右遍历数组
        * 2. 对于每个位置的元素，更新area值
        *   2.1 若该位置的元素大于栈顶元素，则入栈，否则则出栈直至栈顶元素小于当前位置元素
        *   2.2 对于每个出栈的元素，计算一个面积值：出栈元素大小（即矩形高）× （当前元素角标-出栈元素角标）（即矩形宽）
        * 3. 最终保证所有元素均出栈*/

        if(heights.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int count = heights[0];
        for(int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                int pop = stack.pop();
                /*包含stack[top]柱子的最大矩形为stack[top -1] ~ i之间的宽度（不含左右） * stack[top]高*/
                count = Math.max(count, heights[pop]*(i - stack.peek() - 1));
            }
            stack.push(i);
        }

        while(stack.peek() != -1) {
            int pop = stack.pop();
            count = Math.max(count, heights[pop] * (heights.length - stack.peek() - 1));
        }
        return count;


    }
}

class MaxRectangularTest {
    public void test() {
        MaxRectangular maxRectangular = new MaxRectangular();
        int[] heights = new int[]{2,4,3,1,2};
        System.out.println(maxRectangular.largestRectangleArea(heights));
    }

}