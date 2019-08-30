public class Roses {
    public int solution(int k, int n) {
        /*k种不同的玫瑰花，放在n个位置上，要求每种花至少出现一次，返回方案数*/
        if(k > n) {
            return 0;
        }
        /*dp[i][j]为第0~i种花放在第0~j个位置上的方案数*/
        int[][] dp = new int[n][k];
        for(int i = 0; i < k; i++) {
            for(int j = i; j < n; j++) {
                if(i == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i-1][j-1] * (j + 1);
                }

            }
        }
        return dp[k][n];

    }

}
