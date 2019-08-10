public class Robery {
    public int rob(int[] nums) {
        /*第一间和最后一间不能同时抢*/
        int[] dp1 = new int[nums.length];     //不抢最后一间
        int[] dp2 = new int[nums.length];     //不抢第一间
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        dp2[0] = 0;
        dp2[1] = nums[1];
        System.out.println(dp1[0] + " " + dp2[0]);
        System.out.println(dp1[1] + " " + dp2[1]);
        for(int i = 2; i < nums.length ; i++) {
            dp1[i] = Math.max(dp1[i-2] + nums[i], dp1[i-1]);
            dp2[i] = Math.max(dp2[i-2] + nums[i], dp2[i-1]);
            System.out.println(dp1[i] + " " + dp2[i]);
        }

        return Math.max(dp1[nums.length - 2], dp2[nums.length-1]);
    }
}

class RoberyTest {
    public void test() {
        int[] nums = new int[]{4, 1, 2, 7, 5, 3, 1};
        System.out.println(new Robery().rob(nums));
    }
}