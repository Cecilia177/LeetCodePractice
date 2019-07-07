import javax.sql.rowset.spi.SyncProvider;
import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String> sentences = new ArrayList<>();

        for(int i = 0; i < wordDict.size(); i++) {
            getSentence(s, wordDict, i, sentences);
        }

        return sentences;
    }

    public String getSentence(String s, List<String> wordDict, int index, List<String> sentences) {
            if(index >= wordDict.size()) {
                return "";
            }
           String word = wordDict.get(index);
           if(s == "") {
               return "";
           }
           if(s.indexOf(word) != -1) {
               String subs1 = s.substring(0, s.indexOf(word));
               String subs2 = s.substring(s.indexOf(word) + word.length());
               System.out.println("subs1: " + subs1);
               System.out.println("subs2: " + subs2);
               String sentence = getSentence(subs1, wordDict, 0, sentences) + " " + word + " " + getSentence(subs2, wordDict, 0, sentences);
               sentences.add(sentence);
           } else {
               System.out.println("failure");
               return getSentence(s, wordDict, index + 1, sentences);
           }
            return "";

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