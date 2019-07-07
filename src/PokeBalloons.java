public class PokeBalloons {
    public int maxCoins(int[] nums) {
        /*动态规划问题找到递推式的关键在于找到每个状态间的联系，从最终结果状态进行分析：
        * 再原nums数组首位补上1，以便计算
        * 最终状态：首尾虚拟气球间的气球均被戳破，达到该状态的方式：戳破1/2/.../n号气球*/

        if(nums.length == 0) {
            return 0;
        }

        int[] newNums = new int[nums.length + 2];
        newNums[0] = 1;
        newNums[newNums.length - 1] = 1;
        for(int i = 1; i <= nums.length; i++) {
            newNums[i] = nums[i-1];
        }

        /*dp[i][j]保存i,j号之间的气球（不包括i,j）全部被戳破后所得最大收益，求dp[0][newNums.length - 1]*/
        int[][] dp = new int[newNums.length][newNums.length];
        for(int i = 0; i < newNums.length; i++) {
            dp[i][i] = 0;
        }
        for(int k = 1; k < dp.length; k++) {
            for(int row = 0; row + k < dp.length; row++) {
                int count = 0;
                int col = row + k;
                for(int i = row + 1; i <= col - 1; i++) {
                    count = Math.max(count, dp[row][i] + newNums[row]*newNums[i]*newNums[col] + dp[i][col] );
                }

                dp[row][col] = count;
            }
        }
        return dp[0][newNums.length - 1];
    }
}

class PokeBallonsTest {
    public void test() {
        int[] nums = new int[]{3,1,5,8};
        PokeBalloons pokeBalloons = new PokeBalloons();
        System.out.println(pokeBalloons.maxCoins(nums));
    }
}