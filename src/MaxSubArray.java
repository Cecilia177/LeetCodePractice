public class MaxSubArray {
    public int maxSubArray(int[] nums) {

        int max = nums[0];
        int temp = nums[0];
        for(int i = 1; i < nums.length; i++) {
            //若temp<0，则后面的最大和字串一定不包括前面和为temp的字串，即和为负的子串对最终和最大子串是无益的，全部抛弃
            temp = Math.max(temp + nums[i], nums[i]);
            //更新max值
            max = Math.max(max, temp);
        }
        return max;
    }
}
