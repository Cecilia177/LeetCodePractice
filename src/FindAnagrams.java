import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();

        int[] intP = new int[256];

        for(int i = 0; i < pArr.length; i++) {
            intP[pArr[i]]++;
        }

        int left = 0, right = 0;
        int match = 0;
        int[] window = new int[256];
        List<Integer> result = new ArrayList<>();
        while(right < sArr.length) {
            window[sArr[right]] ++;   //window中加入一个元素
            if(intP[sArr[right]] != 0 && window[sArr[right]] <= intP[sArr[right]]) {
                match++;

            }
            if(match == p.length()) {
                result.add(left);
            }
            right ++;
            if(right - left == p.length()) {
                window[sArr[left]] --;
                if(window[sArr[left]] < intP[sArr[left]] && intP[sArr[left]] != 0) {
                    match --;
                }
                left ++;

            }


        }
        return result;
    }
}

class FindAnagramsTest {
    public void test() {
        String s = "cbaebabacd";
        String p = "abc";
        FindAnagrams findAnagrams = new FindAnagrams();
        List<Integer> list = findAnagrams.findAnagrams(s, p);
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

}
