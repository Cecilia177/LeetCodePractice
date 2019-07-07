import java.util.ArrayList;
import java.util.List;

public class WordBreak1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        return breakable(s, wordDict);
    }

    public boolean breakable(String s, List<String> wordDict) {

           for (int i = 0; i < wordDict.size(); i++) {
               String word = wordDict.get(i);
               if(s == "") {
                   return true;
               }
               if(s.indexOf(word) != -1) {
                   String subs1 = s.substring(0, s.indexOf(word));
                   String subs2 = s.substring(s.indexOf(word) + word.length());
                   System.out.println("subs1: " + subs1);
                   System.out.println("subs2: " + subs2);
                   return breakable(subs1, wordDict) && breakable(subs2, wordDict);

               } else {
                   continue;
               }
           }

            return false;

    }

}

class WordBreakTest1{
    public void test() {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet"); wordDict.add("code"); wordDict.add("and");
//        wordDict.add("sand"); wordDict.add("dog");

        WordBreak1 wordBreak1 = new WordBreak1();
        System.out.println(wordBreak1.wordBreak(s, wordDict));
    }
}