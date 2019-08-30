import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxInWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
    /*维持一个双向队列，遍历数组，每次加入当前元素时，将队列中所有小于当前元素的元素全部移除，
      保证队列头的元素一直是当前窗口中的最大值*/
        if(k > nums.length) {
            return null;
        }
        int[] result = new int[nums.length - k + 1];
        List<Integer> list = new ArrayList<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();    //存放窗口中的Index，以便判断元素是否在窗口之外
        int left = 0; int right = 0;
        while(right < nums.length) {
            if(right - left < k) {
                while(!deque.isEmpty() && nums[deque.getLast()] < nums[right]) {
                    deque.removeLast();
                }
                deque.addLast(right);
                right++;

            }
            if(right - left == k) {
                list.add(nums[deque.getFirst()]);
                for(Integer integer : deque) {
                    if(left == integer) {
                        deque.remove(integer);
                        break;
                    }
                }
                left++;

            }
        }
        int i = 0;
        for(Integer integer : list) {
            result[i++] = integer;
        }
        return result;

    }
}

class MaxInWindowTest {
    public void test() {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = new MaxInWindow().maxSlidingWindow(nums, k);

        for(int i : result) {
            System.out.print(i + " ");
        }
    }
}