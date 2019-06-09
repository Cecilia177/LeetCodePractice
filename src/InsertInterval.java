import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    /*1. 新区间两端都在原区间内--》合并
    * 2. 新区间一端在原区间外，该端为插入后区间的端点
    *
    * */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) {

            return new int[][]{newInterval};
        }
        if(newInterval.length == 0) {
            return intervals;
        }
        List<int[]> resultList = new ArrayList<>();

        /*为待插入区间的左端点定位*/
        int left = 0;
        for(; left < intervals.length; left++) {
            if(intervals[left][1] < newInterval[0]) {
                resultList.add(intervals[left]);
            } else {
                break;
            }
        }
        System.out.println("left: " + left);
        if(left == intervals.length) {
            resultList.add(newInterval);
            return listToArray(resultList);
        }
        int[] newArr = new int[2];
        newArr[0] = (newInterval[0] > intervals[left][0] ? intervals[left][0] : newInterval[0]);
        int right = left;
        for(; right < intervals.length; right++) {
            if(intervals[right][0] >= newInterval[1]) {
                break;
            }
        }
        System.out.println("rignt: " + right);
        if(right < intervals.length && intervals[right][0] == newInterval[1]) {
            newArr[1] = intervals[right][1];
            right ++;
        } else if(right > 0){
            newArr[1] = (newInterval[1] > intervals[right-1][1] ? newInterval[1] : intervals[right-1][1]);
        } else {
            newArr[1] = newInterval[1];
        }
        resultList.add(newArr);
        for(int i = right; i < intervals.length; i++) {
            resultList.add(intervals[i]);

        }

        return listToArray(resultList);
    }

    public int[][] listToArray(List<int[]> list) {
        int[][] arr = new int[list.size()][];
        list.toArray(arr);
        return arr;
    }
}

class InsertIntervalTest {

    public void test() {
        int[][] intervals = new int[][]{new int[]{1,3}, new int[]{6,9}};
        int[] newinterval = new int[]{2, 5};

        int[][] results = new InsertInterval().insert(intervals, newinterval);

        for(int[] result : results) {
            System.out.println(result[0] + ", " + result[1]);
        }
    }


}