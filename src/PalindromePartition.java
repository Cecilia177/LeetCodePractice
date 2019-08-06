import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PalindromePartition {
    private List<List<String>> results = new ArrayList<>();
    public List<List<String>> partition(String s) {
        getOnePartition(s, 0, new ArrayList<String>());
        return results;
    }

    private void getOnePartition(String s, int index, List<String> sub) {
        if(index == s.length()) {
            results.add(new ArrayList<>(sub));

            return;
        }
        for(int i = 0; i < s.length() - index; i++) {
            if(isPalindrome(s, index, index + i)) {
                sub.add(s.substring(index, index + 1 + i));
                getOnePartition(s, index + i + 1, sub);
                sub.remove(sub.size() - 1);
            }

        }
        return;

    }

    private boolean isPalindrome(String s, int start, int end) {
        for(int i = 0; i < (end - start + 1) / 2; i++) {
            if(s.charAt(start + i) != s.charAt(end - i)) {
                return false;
            }
        }
        return true;
    }
}

class PalindromePartitionTest {
    public void test() {
        String s = "aab";
        List<List<String>> results = new PalindromePartition().partition(s);
        System.out.println("results: " + results);
    }
}