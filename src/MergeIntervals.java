import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        /*遍历各个区间，对于每个区间，向后查找可与其合并的区间，合并后将结果加入新的数组中*/
        if(intervals.length == 0) {
            return intervals;
        }
        quickSort(intervals, 0, intervals.length - 1);
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++) {
            int temp = intervals[i][1];
            int j = i + 1;
            for(; j < intervals.length; j++) {
                if(intervals[j][0] <= temp) {
                    temp = Math.max(temp, intervals[j][1]);

                } else {
                    break;
                }
            }
            int[] result = new int[]{intervals[i][0], temp};
            list.add(result);
            i = j - 1;
        }
        int[][] merged = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) {
            merged[i] = list.get(i);
        }
        return merged;
    }

    /*对区间按左边界大小进行排序*/
    private void quickSort(int[][] arr, int low, int high) {
        if(low < high) {
            int part = partition(arr, low, high);
            System.out.println("part: " + part);
            quickSort(arr, low, part - 1);
            quickSort(arr, part + 1, high);
        }

    }

    private int partition(int[][] arr, int low, int high) {
        int[] pivot = arr[low];
        while(low < high) {

            while (low < high && arr[high][0] >= pivot[0]) {
                high --;
            }
            arr[low] = arr[high];
            while (low < high && arr[low][0] <= pivot[0]) {
                low++;
            }
            arr[high] = arr[low];

        }
        arr[low] = pivot;
        return low;
    }

}

class MergeIntervalsTest {
    public void test() {
        int[][] intervals = new int[][]{new int[]{1, 3}, new int[]{2, 6}, new int[]{8, 10}, new int[]{15, 18}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] merged = mergeIntervals.merge(intervals);
        for(int i = 0; i < merged.length; i ++) {
            System.out.println(merged[i][0] + ", " + merged[i][1]);
        }

    }

}
