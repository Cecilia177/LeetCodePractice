import java.util.ArrayList;
import java.util.List;

public class InsertIntervalBisec {
    /*使用二分法分别查找待加入区间两个端点的位置*/
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if(intervals.length == 0) {

            return new int[][]{newInterval};
        }
        if(newInterval.length == 0) {
            return intervals;
        }
        List<int[]> resultList = new ArrayList<>();

        int[] leftLocation = locate(newInterval[0], intervals, 0, intervals.length);
        int[] rightLocation = locate(newInterval[1], intervals, 0, intervals.length);

        for(int i = 0; i < leftLocation[0]; i++) {
            resultList.add(intervals[i]);
        }

        int[] newArr = new int[2];
        if(leftLocation[0] == leftLocation[1]) {
            newArr[0] = intervals[leftLocation[0]][0];
        } else {
            newArr[0] = newInterval[0];
            if(leftLocation[0] >= 0) {
                resultList.add(intervals[leftLocation[0]]);
            }

        }
        int remains = rightLocation[1];
        if(rightLocation[0] == rightLocation[1]) {
            newArr[1] = intervals[rightLocation[1]][1];
            remains++;
        } else {
            newArr[1] = newInterval[1];
        }
        resultList.add(newArr);
        for(; remains < intervals.length; remains++) {
            resultList.add(intervals[remains]);
        }

        return listToArray(resultList);
    }

    public int[] locate(int k, int[][] intervals, int left, int right) {

        if(left > right) {
            return new int[]{right, left};
        }
        int mid = (left + right) / 2;
        if(intervals[mid][0] <= k && intervals[mid][1] >= k) {
            return new int[]{mid, mid};
        }
        if(intervals[mid][0] > k) {
            return locate(k, intervals, left, mid - 1);
        }
        if(intervals[mid][1] < k)
        {
            return locate(k, intervals, mid + 1, right);
        }

        return null;

    }

    public int[][] listToArray(List<int[]> list) {
        int[][] arr = new int[list.size()][];
        list.toArray(arr);
        return arr;
    }
}

class InsertIntervalBisecTest {
    public void test() {

        int[][] intervals = new int[][]{new int[]{1,3}, new int[]{6,9}};
        int[] newinterval = new int[]{2, 5};

//        InsertIntervalBisec insertIntervalBisec = new InsertIntervalBisec();

//        int[] location = insertIntervalBisec.locate(5, intervals, 0, 1);
        int[][] results = new InsertIntervalBisec().insert(intervals, newinterval);

        for(int[] result : results) {
            System.out.println(result[0] + ", " + result[1]);
        }
//        System.out.println(location[0] + ", " + location[1]);
    }
}
