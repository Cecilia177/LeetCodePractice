import java.util.ArrayList;

public class StringCombination {
    ArrayList<String> results = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        if(str.length() == 0) {
            return results;
        }
        int[] letters = new int['z' - 'A' + 1];
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            letters[str.charAt(i) - 'A']++;


        }
        getResult(letters, 0, "", str);
        return results;
    }
    private void getResult(int[] letters, int from, String subStr, String str) {
        if(subStr.length() == str.length()) {
            results.add(subStr);
            return;
        }
        for(int i = 0; i < letters.length; i++) {
            if(letters[i] != 0) {
                String newSubStr = subStr + (char)(i + 'A');
                letters[i] = 0;
                getResult(letters, i+1, newSubStr, str);
                letters[i] = 1;
            }
        }
    }
}

class StringCombinationTest {
    public void test() {
        System.out.print(new StringCombination().Permutation("bca"));
    }
}