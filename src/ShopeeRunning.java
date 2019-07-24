import java.util.Scanner;

public class ShopeeRunning {
    /*将music分为time段，每一段的和尽可能小，*/
    public int cut(int[] music, int time) {
        return splitCut(music, time, 0, music.length - 1);
    }

    private int splitCut(int[] music, int segmentNum, int left, int right) {
        int first = right - left + 1 - segmentNum;
        System.out.println("left: " + left + " right: " + right + " first: " + first);
        if(first == 0) {
            return arrMax(music, left, right);
        }
        if(segmentNum == 1) {
            return arrSum(music, left, right);
        }

        int sum = 0;
        for(int i = 0; i < music.length; i++) {
            sum += music[i];
        }
        int firstCount = 0; //第一个分段的和
        for(int i = 0; i <= first; i++) {   //第一分段从left到left+first
            firstCount += music[left + i];
            //本方案切分获取的最大分段值
            int count = Math.max(firstCount, splitCut(music, segmentNum - 1, left + i +1, right));

            sum = Math.min(sum, count);

            System.out.println("count: " + count + " sum: " + sum);
        }
        return sum;
    }

    private int arrMax(int[] music, int left, int right) {
        int max = music[left];
        for(int i = left + 1; i <= right; i++) {
            max = Math.max(max, music[i]);
        }
        return max;
    }
    private int arrSum(int[] music, int left, int right) {
        int sum = 0;
        for(int i = left; i <= right; i++) {
            sum += music[i];
        }
        return sum;
    }
}

class ShopeeRunningTest {
    public static void test() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int time = sc.nextInt();
        int[] music = new int[m];
        for(int i = 0; i < m; i++) {
            music[i] = sc.nextInt();
        }
//        int[] music = new int[]{6, 5, 6, 7, 6, 6, 3, 1};
//        int time = 5;
        System.out.println(new ShopeeRunning().cut(music, time));
    }
}
