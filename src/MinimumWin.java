public class MinimumWin {
    public String minWindow(String s, String t) {
        /*滑动窗口方法
         * 1. 窗口右端向右移动，直至窗口中包含所有t中的字符
         * 2. 窗口左端向右移动，直至达到满足条件的最小窗口
         * 3. 记录此时窗口内的子串
         * 4. 重复1~3直至窗口右端移动至s末端*/

        /*判断一个窗口是否满足要求:
         * 1. 将t中各字符的字数映射到一个数组tArr[]
         * 2. 将window设为与tArr同等长度的数组win[]
         * 3. 在s上每遍历一个字母，若该字母存在于t中，则将该字母加入window，即在win[]相应位置的值加上1，
         *    判断win[]与tArr[]相应位置值是否相等，若相等则match++（记录数量已匹配的字符数）
         * 4. match == t.length 时window满足要求*/

        char[] sArr = s.toCharArray();
        int left = 0, right = 0;
        int[] tArr = new int[256];
        int[] window = new int[256];

        for (int i = 0; i < t.length(); i++) {
            tArr[t.charAt(i)]++;

        }
        int[] subStr = new int[3];      //保存备选窗口的left, right及长度值
        subStr[2] = s.length();
        int match = 0;
        while (right < s.length()) {
            while (match < t.length() && right < s.length()) {         //窗口暂不满足条件时
                if (tArr[sArr[right]] != 0) {   //right所指字符存在于t中，将该字符加入window中
                    window[sArr[right]]++;
                    if (window[sArr[right]] == tArr[sArr[right]]) {
                        match++;
                    }
                }
                right++;
            }
            System.out.println("right: " + right);
            while (match == t.length() && right < s.length()) {
                window[sArr[left]]--;
                if (window[sArr[right]] < tArr[sArr[right]]) {
                    match--;
                }
                left++;
            }
            if (subStr[2] > right - left) {
                subStr[0] = left + 1;
                subStr[1] = right;
                subStr[2] = right - left;
            }
        }
        return s.substring(subStr[0], subStr[1]);
    }
}

class MinimunWinTest {
    public void test() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        //expected return "BANC"
        MinimumWin minimumWin = new MinimumWin();
        System.out.println(minimumWin.minWindow(s, t));

    }
}