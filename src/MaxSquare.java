public class MaxSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        /*dp[i][j]中保存以(i, j)为右下角的最大正方形边长*/
        int max = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                if(i == 0 || j == 0) {
                    if(matrix[i][j] == '1') {
                        dp[i][j] = 1;
                        max = Math.max(max, dp[i][j]);
                        //System.out.println("i: " + i + " j: " + j + " " + dp[i][j]);
                    }

                } else {
                    if(matrix[i][j] == '1') {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
                        max = Math.max(max, dp[i][j]);
                        //System.out.println("i: " + i + " j: " + j + " " + dp[i][j]);
                    }
                }

            }
        }
        return max*max;
    }
}

class MaxSquareTest {
    public void test() {
        char[][] matrix = new char[][]{new char[]{'1', '0', '1', '0', '0'},
                                       new char[]{'1', '0', '1', '1', '1'},
                                       new char[]{'1', '1', '1', '1', '1'},
                                       new char[]{'1', '0', '0', '1', '0'}};
        System.out.println(new MaxSquare().maximalSquare(matrix));
    }
}