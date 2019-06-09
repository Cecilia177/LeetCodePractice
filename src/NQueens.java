import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    List<List<String>> solutions = new ArrayList<>();

    /*返回所有解法，每个List存放一种解法*/
    public List<List<String>> solveNQueens(int n) {

        String[][] initialBoard = new String[n][n];
        for(int j = 0; j < n; j++) {
            for(int i = 0; i < n; i++) {
                initialBoard[i][j] = ".";
            }

        }

        solve(initialBoard, 0, n);

        printList(solutions);
        return solutions;
    }

    public void solve(String[][] currentBoard, int currentRow, int n) {
        if(currentRow < n) {
            for(int column = 0; column < n; column++) {
                if(isValid(currentRow, column, currentBoard, n)) {
                    String[][] newBoard = new String[n][n];
                    copyBoard(currentBoard, newBoard, n);
                    newBoard[currentRow][column] = "Q";
                    if(currentRow == n-1) {
                        restoreSolution(solutions, newBoard) ;
                    }
                    solve(newBoard,currentRow + 1, n);
                }
            }
        }

        return;

    }

    public void printList(List<List<String>> list) {
        for(List<String> list1 : list) {
            for(String str: list1) {
                System.out.println(str);
            }
            System.out.println();
        }
    }

    public List<List<String>> restoreSolution(List<List<String>> solutions, String[][] arrSolution) {
        List<String> solution = new ArrayList<>();
        for(String[] strs : arrSolution) {
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < strs.length; i++) {
                sb.append(strs[i]);
            }
            solution.add(sb.toString());
        }
        solutions.add(solution);
        return solutions;
    }

    /*判断一个位置落子是否安全，只需判断该行以上区域中，同列是否有皇后，对角线上是否有皇后*/
    public boolean isValid(int i, int j, String[][] currentBoard, int n) {
        //判断同列是否有皇后
        for(int k = 0; k < i; k++) {
            if(currentBoard[k][j] == "Q") {
                return false;
            }
        }
        //检查左上对角线
        int edgeLeft = (i > j ? j : i);
        for(int k = 1; k <= edgeLeft; k++) {
            if(currentBoard[i - k][j - k] == "Q") {
                return false;
            }
        }
        //检查右上对角线
        int edgeRight = (n - j - 1 > i ? i : n - j - 1);
        for(int k = 1; k <= edgeRight; k++) {
            if(currentBoard[i - k][j + k] == "Q") {
                return false;
            }
        }
        return true;
    }
    public void copyBoard(String[][] resource, String[][] target, int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                target[i][j] = resource[i][j];
            }
        }
    }
}

class NQueensTest {
    public void test() {
        NQueens nQueens = new NQueens();
        nQueens.solveNQueens(5);
    }
}