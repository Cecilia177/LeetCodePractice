import java.util.ArrayList;
import java.util.List;

public class Wildcard {
    public List<int[]> match(String s, String m) {
        /*根据*将m分为若干份，分别查找各段在s中的位置*/
        String split = "\\*";
        String[] mSplit = m.split(split);
        System.out.println("mSplit length: " + mSplit.length);
        System.out.println(mSplit[0] + " " + mSplit[1]);
        List<int[]> result = new ArrayList<>();
        for(int j = 0; j < s.length(); j++) {
            int i = 0;
            int from = j;
            for(; i < mSplit.length && j < s.length(); i++) {
                System.out.println("j: " + j);
                System.out.println("substr: " + mSplit[i]);
                int index;
                if(mSplit[i].equals("")) {
                    index = j;
                } else {
                    index = s.indexOf(mSplit[i], j);
                }

                System.out.println("index: " + index);
                if(mSplit[i].equals("")) {
                    j++;
                } else {
                    j = index + mSplit[i].length();
                }

                if(index == -1) {
                    break;
                }
            }
            if(i == mSplit.length) {
                result.add(new int[]{from, j - from});
            } else {
                break;
            }
        }
        return result;

    }


}

class WildcardTest {
    public void test() {
        String s = "shopeemobile.com";
        String m = "*.com";

        List<int[]> result = new Wildcard().match(s, m);
        for(int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i)[0] + " " + result.get(i)[1]);
        }

    }
}