public class PalinSubstring {
    public int countSubstrings(String s) {
        //dp[i][j]中存放s中i~j位是否为回文字串，状态转移：dp[i][j] = dp[i+1][j-1] && (s.charAt(i)==s.charAt(j))
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            dp[i][i] = true;             //填充对角线
        }
        int count = s.length();
        for(int i = 0; i < s.length() - 1; i++) {
            dp[i+1][i] = true;            //填充副对角线
        }
        for(int i = 1; i < s.length(); i++) {
            for(int row = 0; row + i < s.length(); row++) {
                dp[row][row + i] = dp[row + 1][row+i - 1] && (s.charAt(row) == s.charAt(row + i));
                if(dp[row][row+i]) {
                    count++;

                }
            }
        }
        return count;

    }
    /*方法二：用一维dp，dp[i]中保存以i为中心（或以i与i+1为中心）的回文子串个数
    * 时间与空间消耗明显优于方法一*/
    private int num = 0;
    public int countSubstrings2(String s) {
        int[] dp = new int[s.length()];

        for(int i = 0; i < s.length(); i++) {

            getNum(s, i, i);
            getNum(s, i, i+1);

        }
        return num;
    }
    private void getNum(String s, int i, int j) {
        while(i >= 0 && j < s.length()) {
            if(s.charAt(i) != s.charAt(j)) {
                break;
            }
            num++;
            i--;
            j++;
        }
    }
}

class PalinSubstringTest {
    public void test() {
        System.out.println(new PalinSubstring().countSubstrings2("aba"));
    }
}
