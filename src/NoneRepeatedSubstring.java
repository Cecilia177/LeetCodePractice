public class NoneRepeatedSubstring {
    public int lengthOfLongestSubstring(String s) {

        char[] sArr = s.toCharArray();
        System.out.println("--" + sArr[0] + "--");
        int[] win = new int[256];
        int left = 0;
        int right = 0;
        int length = 0;
        while(right < s.length()) {
            win[sArr[right]] ++;

            if(win[sArr[right]] > 1) {
                length = Math.max(length, right - left);
                while(win[sArr[left]] != 2) {
                    win[sArr[left]]--;
                    left ++;
                }
                win[sArr[left]]--;
                left ++;
            }
            right++;

        }
        length = Math.max(length, right - left);
        return length;

    }
}

class NoneRepeatedSubstringTest {
    public void test() {
        NoneRepeatedSubstring noneRepeatedSubstring = new NoneRepeatedSubstring();
        System.out.println(noneRepeatedSubstring.lengthOfLongestSubstring("abc"));
    }
}