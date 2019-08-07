public class InterleaveString {
    /*判断s3是否由s1和s2交错而成
    * dp[i][j]表示s1 0 ~ i-1 项+s2 0 ~j - 1项是否能组成s3前i+j项*/
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()) {
            return false;
        }
        if(s3.length() == 0) {
            return true;
        }
        boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];

        dp[0][0] = true;
        for(int row = 0; row < dp.length; row++) {
            for(int col = 0; col < dp[0].length; col++) {
                if(row == 0 && col == 0) {
                    continue;
                }
                if(row == 0) {
                    dp[row][col] = dp[row][col - 1] && s2.charAt(col - 1) == s3.charAt(col - 1);
                } else if(col == 0) {
                    dp[row][col] = dp[row - 1][col] && s1.charAt(row - 1) == s3.charAt(row - 1);
                } else {
                    dp[row][col] = (dp[row][col - 1] && s2.charAt(col - 1) == s3.charAt(row + col - 1))
                            || (dp[row - 1][col] && s1.charAt(row - 1) == s3.charAt(row + col - 1));
                }

            }
        }

        return dp[s1.length()][s2.length()];
    }
}

class InterleaveStringTest {
    public void test() {
        System.out.println(new InterleaveString().isInterleave("aabc", "dbbc", "aadbbcbc"));
    }
}
