public class ShortestPath {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] minSubPath = new int[m][n];  //从int[0][0]走到int[m-1][n-1]需要m+n-1步，用该数组保存到每个位置的最小步数

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i > 0 && j > 0) {
                    minSubPath[i][j] = Math.min(minSubPath[i-1][j] + grid[i][j], minSubPath[i][j-1] + grid[i][j]);
                } else if(i > 0) {
                    minSubPath[i][j] = minSubPath[i-1][j] + grid[i][j];
                } else if(j > 0){
                    minSubPath[i][j] = minSubPath[i][j-1] + grid[i][j];
                } else {
                    minSubPath[i][j] = grid[0][0];
                }


            }
        }

        printArray(minSubPath, m, n);
        return minSubPath[m-1][n-1];

    }

    public void printArray(int[][] arr, int m, int n) {
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class ShortestPathTest {
    public void test() {
        int[][] grid = new int[][]{new int[]{1,3,1}, new int[]{1,5,1}, new int[]{4,2,1}};
        new ShortestPath().minPathSum(grid);
    }
}