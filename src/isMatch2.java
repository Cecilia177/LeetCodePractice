public class isMatch2 {
    public boolean isMatch(String s, String p) {
        //dp[i][j]表示s前i位与p前j位是否匹配
        // char[] s = s.toCharArr
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for(int i = 0; i < p.length(); i++) {

            dp[0][i+1] = i<1 ? dp[0][i] && p.charAt(i)=='*' : dp[0][i-1] && p.charAt(i)=='*';
            System.out.println("i: 0" + " j: " + (i+1) + " " + dp[0][i+1]);
        }
//        System.out.println("slen: " + s.length() + " plen: " + p.length());

        for(int i = 0; i < s.length(); i++) {

            for(int j = 0; j < p.length(); j++) {

               if(p.charAt(j) >= 'a' && p.charAt(j) <= 'z') {
                   dp[i+1][j+1] = dp[i][j] && p.charAt(j)==s.charAt(i);
               }
               if(p.charAt(j) == '.') {
                   dp[i+1][j+1] = dp[i][j];
               }
               if(p.charAt(j) == '*') {
                   if(p.charAt(j-1) != '.') {          //*前为字母
                       dp[i+1][j+1] = dp[i+1][j-1] && s.charAt(i) != p.charAt(j-1);
                   } else {                           //*前为.  ...  分别为匹配多个，匹配一个，匹配0个的情况
                       dp[i+1][j+1] = dp[i][j+1] || dp[i+1][j] || dp[i+1][j-1];
                   }
               }
                System.out.println("i: " + (i+1) + " j: " + (j+1) + " " + dp[i+1][j+1]);
            }

        }
        return dp[s.length()][p.length()];
    }
}

class isMatch2Test {
    public void test() {
        System.out.println(new isMatch2().isMatch("aa", "a*"));
    }
}