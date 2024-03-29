import java.util.Arrays;

public class MaxProfitAssignment {
    /*解法一：
    *   对于每个worker, 遍历其能胜任的工作中最大profit（注意：并非越难的工作profit越高）
    *   此种解法会导致超时
    * 解法二：
    *   贪心算法：按照profit大小对profit及对应的difficulty进行(快速)排序，尽量使所有worker都完成最高效益的工作*/

    public int profitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[] profitPer = new int[worker.length];

        quickSort(difficulty, profit, 0, profit.length - 1);

        System.out.println("profit after sorted: " + Arrays.toString(profit));

        for(int worknum = 0, profitnum = profit.length - 1; worknum < worker.length && profitnum >= 0 ; profitnum--) {
            for(int i = 0; i < worker.length; i ++) {
                if(worker[i] >= difficulty[profitnum] && profitPer[i] == 0) {
                    profitPer[i] = profit[profitnum];
                    worknum++;
                    System.out.println("worknum: " + worknum + " profitPer" + Arrays.toString(profitPer));
                }
            }
        }

        int totalProfit = 0;
        for(int i = 0; i < profitPer.length; i++) {
            totalProfit += profitPer[i];
        }
        return totalProfit;
    }

    private void quickSort(int[] difficulty, int[] profit, int low, int high) {
        if(low >= high) {
            return;
        }
        int pivotPosition = partition(difficulty, profit, low, high);
        System.out.println("pivotPos: " + pivotPosition);
        quickSort(difficulty, profit, low, pivotPosition - 1);
        quickSort(difficulty, profit, pivotPosition + 1, high);
    }

    private int partition(int[] difficulty, int[] profit, int low, int high) {

        int pivot = profit[low];
        int pivotDiff = difficulty[low];
        while (low < high) {
            while (low < high && profit[high] >= pivot) {
                high --;
            }
            profit[low] = profit[high];
            difficulty[low] = difficulty[high];
            while (low < high && profit[low] <= pivot) {
                low ++;
            }
            profit[high] = profit[low];
            difficulty[high] = difficulty[low];
        }
        profit[low] = pivot;
        difficulty[low] = pivotDiff;
        return low;

    }
}

class MaxProfitAssignmentTest{
    public void test() {
        int[] difficulty = new int[]{2,4,6,8,10};
        int[] profit = new int[]{10,20,30,40,50};
        int[] worker = new int[]{4,5,6,7};
        MaxProfitAssignment maxProfitAssignment = new MaxProfitAssignment();

        System.out.println(maxProfitAssignment.profitAssignment(difficulty, profit, worker));

    }

}
