import java.util.Scanner;

public class ShopeeOffice {
    public int numOfPath(int x, int y, int[][] bossPosition) {

        int[][] dp = new int[x + 1][y + 1];
        for(int i = 0; i < x + 1; i++) {
            for(int j = 0; j < y + 1; j++) {
                if(bossPosition[i][j] == -1) {
                    dp[i][j] = -1;
                }
            }
        }

        dp[0][0] = 0;
        for(int col = 1; col <= y; col++) {
            if(dp[0][col-1] != -1 && dp[0][col] != -1) {
                dp[0][col] = 1;
            }
        }
        for(int row = 1; row <= x; row++) {
            if(dp[row - 1][0] != -1 && dp[row][0] != -1) {
                dp[row][0] = 1;
            }
        }
        for(int row = 1; row <= x; row++) {
            for(int col = 1; col <= y; col++) {
                if(dp[row][col] != -1) {
                    if(dp[row - 1][col] != -1) {
                        dp[row][col] += dp[row - 1][col];
                    }
                    if(dp[row][col - 1] != -1) {
                        dp[row][col] += dp[row][col - 1];
                    }
                }
            }
        }
        return dp[x][y];
    }
}

class ShopeeOfficeTest {
    public void test() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int n = sc.nextInt();
        System.out.println("x: " + x + " y: " + y + " n: " + n);
        int[][] boss = new int[x + 1][y + 1];
        for(int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int k = sc.nextInt();
            boss[h][k] = -1;
        }
        ShopeeOffice shopeeOffice = new ShopeeOffice();
        System.out.println(shopeeOffice.numOfPath(x, y, boss));
    }
}