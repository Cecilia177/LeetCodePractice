import java.util.ArrayList;
import java.util.List;


public class WordBreak1 {

    private static int strLen;

    public boolean wordBreak(String s, List<String> wordDict) {

        strLen = s.length();
        return breakable(s, wordDict);
    }


    public boolean breakable(String s, List<String> wordDict) {
        /*采用动态规划，用数组dp[i]保存第i位结尾的子串能否被分割*/

        boolean[] dp = new boolean[strLen + 1];
        dp[0] = true;
        for(int i = 1; i <= strLen; i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }

        }

        return dp[strLen];
    }


    public boolean breakableRecur(String s, List<String> wordDict) {
        /*采用递归会超时*/
       for (int i = 0; i < wordDict.size(); i++) {
           String word = wordDict.get(i);
           System.out.println("word: " + word);
           if(s.equals("")) {
               return true;
           }
           if(s.indexOf(word) != -1) {
               String subs1 = s.substring(0, s.indexOf(word));
               String subs2 = s.substring(s.indexOf(word) + word.length());

               if(!(breakableRecur(subs1, wordDict) && breakableRecur(subs2, wordDict))) {
                   continue;
               } else {
                   return true;
               }

           }
       }
        return false;

    }

}

class WordBreakTest1{
    public void test() {
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats"); wordDict.add("dog"); wordDict.add("sand"); wordDict.add("and");
        wordDict.add("cat");
        WordBreak1 wordBreak1 = new WordBreak1();
        System.out.println(wordBreak1.wordBreak(s, wordDict));
    }
}