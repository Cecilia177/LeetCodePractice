import java.util.ArrayList;
import java.util.List;

public class NQueensCount {
    private int count = 0;
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        solve(board, 0);
        return count;
    }

    private void solve(char[][] board, int currentRow) {
        if(currentRow == board.length) {
            count++;
            return;
        }
        for(int col = 0; col < board.length; col++) {
            if(isValid(board, currentRow, col)) {
                board[currentRow][col] = 'Q';
                solve(board, currentRow + 1);
                board[currentRow][col] = '.';
            }
        }
        return;
    }

    private boolean isValid(char[][] board, int row, int col) {
        //检查同列是否冲突
        for(int i = 0; i < row; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }
        //检查左上对角线
        int edgeLeft = (col > row ? row : col);
        for(int k = 1; k <= edgeLeft; k++) {
            if(board[row - k][col - k] == 'Q') {
                return false;
            }
        }
        //检查右上对角线
        int edgeRight = (board.length - col - 1 > row ? row : board.length - col - 1);
        for(int k = 1; k <= edgeRight; k++) {
            if(board[row - k][col + k] == 'Q') {
                return false;
            }
        }
        return true;

    }
}

class NQueensCountTest {
    public void test() {
        System.out.println(new NQueensCount().totalNQueens(8));
    }
}