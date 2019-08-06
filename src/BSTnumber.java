public class BSTnumber {
    public int numTrees(int n) {
        /*dp[i]中存放以1~i为节点组成的BST个数
        * 状态转移：dp[i] = {分别以1~i为根节点的BST个数总和}*/
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[0] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];

    }
}

class BSTnumberTest {
    public void test() {
        System.out.println(new BSTnumber().numTrees(3));
    }
}