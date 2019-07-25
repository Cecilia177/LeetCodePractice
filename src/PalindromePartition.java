import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PalindromePartition {
//    private List<List<String>> results = new ArrayList<>();
    private int num = -1;
    public int partition(String s) {
        getOnePartition(s, s.length() - 1, 0);
//        Collections.reverse(results);
        return num;
    }

    private int getOnePartition(String s, int index, int count) {
        if(index == -1) {            //分割完毕
//            Collections.reverse(sub);
//            results.add(sub);
//            System.out.println(count);
            num = count - 1;
            return num;
        }
        for(int i = 0; i <= index; i++) {
            if(isPalindrome(s, i, index)) {
//                List<String> newSub = new ArrayList<>();
//                listCopy(sub, newSub);              //不能在原本sub中添加元素
//                newSub.add(s.substring(i, index +
                System.out.println("index: " + index + " i: " + i + " count: " + count);
                if(getOnePartition(s, i - 1, count + 1) != -1) {
                    break;
                }
            }

        }
        return num;

    }
    private void listCopy(List<String> source, List<String> target) {
        for(int i = 0; i < source.size(); i++) {
            target.add(source.get(i));
        }
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
        int results = new PalindromePartition().partition(s);
        System.out.println("results: " + results);
    }
}