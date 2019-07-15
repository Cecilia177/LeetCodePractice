public class IsMatch {

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for (int j = 0; j < pLen; j++) {
            dp[0][j + 1] = dp[0][j] && p.charAt(j) == '*';
        }
        for (int i = 0; i < sLen; i++) {
            for (int j = 0; j < pLen; j++) {
                dp[i + 1][j + 1] = (dp[i + 1][j] && p.charAt(j) == '*') ||
                        (dp[i][j + 1] && p.charAt(j) == '*') ||
                        (dp[i][j] && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?' || p.charAt(j) == '*'));


            }
        }

        return dp[sLen][pLen];
    }
}
