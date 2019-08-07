public class LongestPalinSubstring {
    public String longestPalindrome(String s) {
        /*思路：
        * 方法一：二维数组dp[i][j]保存每字符i,j间的字符串是否为回文，若为回文则更新count=j-i+1
        *       dp[i][j] = dp[i+1][j-1] && s.charAt(i)==s.charAt(j)
        * 方法二：一维数组len[i]保存以字符i为中心的最长回文串长度（不属于动态规划），此处选择方法二*/


        int[] len = new int[s.length()];
        int max = 0;
        int temp = 0;
        for(int i = 0; i < s.length(); i++) {
            getLen(s, i, i, len);
            getLen(s, i, i+1, len);
            if(len[i] > max) {
                max = len[i];
                temp = i;
            }
        }
        int left = max % 2 == 0 ? temp - max / 2 + 1 : temp - max / 2;
        int right = temp + max / 2 + 1;
        //System.out.println("max: " + max + " left: " + left + " right: " + right);
        return s.substring(left, right);

    }

    private void getLen(String s, int i, int j, int[] len) {

        int pos = i;
        while(i >= 0 && j < s.length()) {
            if(s.charAt(i) != s.charAt(j)) {
                break;
            }

            i--;
            j++;
        }

        len[pos] = Math.max(len[pos], j - i - 1);
    }
}

class LongestPalinSubstringTest {
    public void test() {
        System.out.println(new LongestPalinSubstring().longestPalindrome("abba"));
    }
}