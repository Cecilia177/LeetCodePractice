import java.util.Arrays;
import java.util.Scanner;

public class LettersCombination {
    public void combine() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] letters = str.toCharArray();

        Arrays.sort(letters);
        getCombination(letters, "", new boolean[letters.length]);
    }

    private void getCombination(char[] letters, String temp, boolean[] flag) {
        if(temp.length() == letters.length) {
            System.out.println(temp);
            return;
        }
        char last = '/';
        for(int i = 0; i < letters.length; i++) {
//            System.out.println("current index: " + i  + " " + letters[i]);

            if(!flag[i] && last !=letters[i]) {
                flag[i] = true;
                last = letters[i];
                String newStr = temp + letters[i];
                getCombination(letters, newStr, flag);
                flag[i] = false;
            }
        }

    }
}
