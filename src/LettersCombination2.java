import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class LettersCombination2 {
    private static ArrayList<String> results = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        if(str.length() == 0) {
            return results;
        }
        char[] letters = str.toCharArray();
        Arrays.sort(letters);
        boolean[] flag = new boolean[letters.length];
        getPermutation(letters, "", flag);
        return results;
    }
    private void getPermutation(char[] letters, String result, boolean[] flag) {
        if(result.length() == letters.length) {
            results.add(result);
            return;
        }
        char temp = '/';
        for(int i = 0; i < letters.length; i++) {
            if(temp != letters[i] && !flag[i]) {
                String newStr = result + letters[i];
                flag[i] = true;
                temp = letters[i];
                getPermutation(letters, newStr, flag);
                flag[i] = false;
            }
        }
    }
}

class LettersPermutation2Test {
    public void test() {
        ArrayList<String> results = new LettersCombination2().Permutation("aa");
        System.out.println(results);
    }
}