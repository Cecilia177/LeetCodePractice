import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    /*返回所有解法，每个List存放一种解法*/
    public List<List<String>> solveNQueens(int n) {

        String[][] initialBoard = new String[n][n];
        for(int j = 0; j < n; j++) {
            for(int i = 0; i < n; i++) {
                initialBoard[i][j] = ".";
            }

        }

        List<List<String>> solutions = new ArrayList<>();
        List<String> solution = new ArrayList<>();
        for(String[] strs : initialBoard) {
            String row= strs.toString();
            solution.add(row);
        }

        solutions.add(solution);
        printList(solutions);
        return solutions;
    }


    public void printList(List<List<String>> list) {
        for(List<String> list1 : list) {
            for(String str: list1) {
                System.out.println(str);
            }
        }
    }
}

class NQueensTest {
    public void test() {
        NQueens nQueens = new NQueens();
        nQueens.solveNQueens(4);
    }
}