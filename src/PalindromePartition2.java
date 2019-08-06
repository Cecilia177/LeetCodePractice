public class PalindromePartition2 {
    public int minCut(String s) {
        /*dp[i]中保存s中0~i位字符需要分割的次数
        * 状态转移：如何得出i的值，查找以i为中心的回文子串，若回文子串为k~h，则dp[i] = dp[k-1] + 1
        * 每查找到一个回文子串，更新dp[h]处的值*/
        int[] dp = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            dp[i] = s.length() - 1;        //Arrays.fill(dp, s.length() - 1);
        }
        for(int i = 0; i < s.length(); i++) {
            getSubString(dp, i, i, s);
            getSubString(dp, i, i + 1, s);
        }
        return dp[s.length() - 1];

    }
    private void getSubString(int dp[], int i, int j, String s) {

        while(i >= 0 && j < dp.length && s.charAt(i) == s.charAt(j)) {
            if(i != 0) {
                dp[j] = Math.min(dp[j], dp[i - 1] + 1);
            } else {
                dp[j] = 0;          //0~j本身即为回文，无需分割
            }
            i--;
            j++;
        }
    }
}

class PalindromePartition2Test {
    public void test() {
        System.out.println(new PalindromePartition2().minCut("abbab"));
    }
}