import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonenumber {
    private List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        Map<Character, String> numberToChar = new HashMap<>();
        numberToChar.put('2', "abc");
        numberToChar.put('3', "def");
        numberToChar.put('4', "ghi");
        numberToChar.put('5', "jkl");
        numberToChar.put('6', "mno");
        numberToChar.put('7', "pqrs");
        numberToChar.put('8', "tuv");
        numberToChar.put('9', "wxyz");

        if(digits.length() == 0) {
            return result;
        }

        getSubResult(digits, numberToChar, 0, "");
        return result;

    }

    private void getSubResult(String digits, Map<Character, String> numberToChar, int start, String subResult) {
        if(start == digits.length()) {
            result.add(subResult);
            return;        //递归函数中注意定义返回条件
        }
        String str = numberToChar.get(digits.charAt(start));   //第一位数字对应的字符串
        for(int i = 0; i < str.length(); i++) {
            getSubResult(digits, numberToChar, start + 1, subResult + str.charAt(i));
        }

    }
}

class PhonenumberTest {
    public void test() {
        List<String> result = new Phonenumber().letterCombinations("23");
        for(int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }

}
