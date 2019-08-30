public class CountCoins {
    public int coins(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < dp.length; i++) {
            if(i < 5) {
                dp[i] = dp[i-1] + dp[i-2];
            } else if(i < 10) {
                dp[i] = dp[i-1] + dp[i-2] + dp[i - 5];
            } else {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-5] + dp[i-10];
            }
        }
        return dp[n];
    }
}
