class SodukuSolution {
    public char[][] initboard;

    public void solveSudoku(char[][] board) {
        initboard = board;
        try {
            solve(board);
        } catch (RuntimeException e) {

        }
        print(board);
    }


    public void solve(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(i, j, board, k)) {
                            char[][] newboard = new char[9][9];
                            copy(board, newboard);
                            newboard[i][j] = k;
                            solve(newboard);
                        }

                    }
                    return;
                }
            }
        }
        copy(board, initboard);
        throw new RuntimeException();

    }


    public boolean isValid(int i, int j, char[][] board, char num) {
        for (int k = 0; k < 9; k++) {
            if (k != i && num == board[k][j]) {
                return false;
            }
            if (k != j && num == board[i][k]) {
                return false;
            }
        }
        int blockX = (i / 3) * 3;
        int blockY = (j / 3) * 3;
        for (int x = blockX; x < 3 + blockX; x++) {
            for (int y = blockY; y < 3 + blockY; y++) {
                if (!(x == i && y == j) && board[x][y] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public void copy(char[][] from, char[][] to) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                to[i][j] = from[i][j];
            }
        }
    }

    public void print(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");

            }
            System.out.println();
        }
    }
}
