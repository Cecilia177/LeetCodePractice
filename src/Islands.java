public class Islands {
    public int numIslands(char[][] grid) {
        int num = 0;
        if(grid.length == 0) {
            return num;
        }
        boolean[][] flag = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                /*遍历grid中的每一个点，若当前点未访问过且为1，则进行深度优先遍历*/
                if(!flag[i][j] && grid[i][j] == '1') {
                    num++;
                    getIslandsNum(grid, flag, i, j);
                }

            }
        }

        return num;
    }

    private void getIslandsNum(char[][] grid, boolean[][] visited, int row, int col) {
        if(isValid(grid, visited, row, col)) {
            visited[row][col] = true;

            getIslandsNum(grid, visited, row + 1, col);
            getIslandsNum(grid, visited, row, col + 1);
            getIslandsNum(grid, visited, row - 1, col);
            getIslandsNum(grid, visited, row, col - 1);
        }


        return;
    }

    private boolean isValid(char[][] grid, boolean[][] flag,int row, int col) {
        if(row >= grid.length || col >= grid[0].length || row < 0 || col < 0 || grid[row][col] == '0' || flag[row][col]) {
            return false;
        }
        return true;
    }
}
