import java.util.*;

import static java.util.Arrays.stream;

public class Test {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> results = new ArrayList<>();
        if(num.length == 0) {
            return results;
        }

        if(size > num.length) {
            results.add(Arrays.stream(num).max().getAsInt());
            return results;
        }
        int left = 0; int right = 0;
        TreeSet<Integer> set = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 == o2) {
                    return 0;
                }
                return o1 > o2 ? -1 : 1;

            }
        });
//        int maxInWin = num[0];
        while(right < num.length) {
            if(right - left < size - 1) {
                set.add(num[right]);
                right ++;
            } else {
                results.add(set.first());
                left ++;
                set.remove(set.first());
            }
        }
        return results;


    }


}

