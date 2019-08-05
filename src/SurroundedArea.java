public class SurroundedArea {
    public void solve(char[][] board) {
        if(board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        /*遍历board中外围四条边上的每个点，若该点未被访问且为O，则从该点开始进行深度优先遍历*/
        for(int j = 0; j < n; j++) {
            fill(board, visited, 0, j, 'Y');
            fill(board, visited, m - 1, j, 'Y');
        }
        for(int i = 0; i < m; i++) {
            fill(board, visited, i, 0, 'Y');
            fill(board, visited, i, n - 1, 'Y');
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                fill(board, visited, i, j, 'X');
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void fill(char[][] board, boolean[][] visited, int x, int y, char replace) {
        if(x == board.length || y == board[0].length || x < 0 || y < 0) {
            return;
        }
        if(board[x][y] == 'O' && !visited[x][y]) {
            visited[x][y] = true;
            board[x][y] = replace;
            fill(board, visited, x - 1, y, replace);
            fill(board, visited, x + 1, y, replace);
            fill(board, visited, x, y - 1, replace);
            fill(board, visited, x, y + 1, replace);
        }
        return;
    }
}

class SurroundedAreaTest {
    public void test() {
        char[][] board = new char[][]{new char[]{'X', 'X', 'X', 'X'},
                new char[]{'X', 'O', 'O', 'X'}, new char[]{'X', 'X', 'O', 'X'},
                new char[]{'X', 'O', 'X', 'X'}};
        new SurroundedArea().solve(board);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}