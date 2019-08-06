import javax.sql.rowset.spi.SyncProvider;
import java.util.ArrayList;
import java.util.List;

public class WordBreak {

    List<String> sentences = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {


        if(new WordBreak1().breakable(s, wordDict)) {
            getSentence(s, wordDict, 0, "");
        }
        return sentences;
    }

    public void getSentence(String s, List<String> wordDict, int start, String sentence) {
        if(start == s.length()) {
            sentences.add(sentence);
            //System.out.println("found one");
            return;
        }
       for(int i = start + 1; i <= s.length(); i++) {
           if(wordDict.contains(s.substring(start, i))) {
               String newSentence;
               if(sentence.equals("")) {
                   newSentence = s.substring(start, i);
               } else {
                   newSentence = sentence + " " + s.substring(start, i);
               }

               //System.out.println(newSentence);
               getSentence(s, wordDict, i, newSentence);

           }
       }
       return;

    }

}

class WordBreakTest{
    public void test() {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat"); wordDict.add("cats"); wordDict.add("and");
        wordDict.add("sand"); wordDict.add("dog");

        WordBreak wordBreak = new WordBreak();
        List<String> sentences = wordBreak.wordBreak(s, wordDict);

        for(String sentence : sentences) {
            System.out.println(sentence);
        }
    }
}