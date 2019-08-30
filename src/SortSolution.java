import java.util.Arrays;

public class SortSolution {
    public void fastSort(int[] arr, int low, int high) {
        if(low < high) {
            int pos = partition(arr, low, high);
            fastSort(arr, low, pos - 1);
            fastSort(arr, pos + 1, high);
        }

    }
    private int partition(int[]arr, int low, int high) {
        int pivot = arr[low];
        while(low < high) {
            while(low < high && arr[high] >= pivot) {
                high--;
            }
            arr[low] = arr[high];
            while(low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        System.out.println(low + " " + pivot);
        return low;
    }

    public void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {   //每轮挑选最大的放在最后
            boolean flag = false;
            for(int j = 1; j < arr.length - i; j++) {
                if(arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    flag = true;
                }

            }
            if(!flag) {
                break;
            }
        }
    }
}

class SortTest {
    public void test() {
        int[] arr = new int[]{2, 4, 6, 0, 3};
        new SortSolution().bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}