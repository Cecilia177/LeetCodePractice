public class FindWords {

    private int m = 0;
    private int n = 0;

    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;

        boolean[][] flag = new boolean[m][n];
        for(int i  = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                flag[i][j] = true;
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(find(board, i, j, flag, word.toCharArray(), 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, int x, int y, boolean[][] flag, char[] wordArr, int current) {
        if(current == wordArr.length) {
            return true;
        }

        if(x < 0 || y < 0 || x >=m || y >= n) {
            return false;
        }

        if(wordArr[current] == board[x][y] && flag[x][y] == true) {
            boolean[][] newFlag = new boolean[m][n];
            copy(flag, newFlag);
            newFlag[x][y] = false;
            return find(board, x - 1, y, newFlag, wordArr, current + 1)
                    || find(board, x + 1, y, newFlag, wordArr, current + 1)
                    || find(board, x , y - 1, newFlag, wordArr, current +1)
                    || find(board, x, y + 1, newFlag, wordArr, current + 1);
        } else {
            return false;
        }
    }

    private void copy(boolean[][] resource, boolean[][] target) {
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                target[i][j] = resource[i][j];
            }
        }
    }
}

class FindWordsTest{
    public void test() {
        FindWords findWords = new FindWords();
        char[][] board = new char[][]{new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'E'}};

        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";

        System.out.println(findWords.exist(board, word1));
        System.out.println(findWords.exist(board, word2));
        System.out.println(findWords.exist(board, word3));
    }




}