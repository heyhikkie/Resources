/*Design n-Queens matrix having first Queen placed. Use backtracking to place remaining 
Queens to generate the final n-queen‘s matrix.*/

public class NQueensBacktracking {
    public static void solveNQueens(int n) {
        int[][] board = new int[n][n];
        placeQueens(board, 0, n);
        printBoard(board);
    }

    public static boolean isSafe(int[][] board, int row, int col, int n) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public static boolean placeQueens(int[][] board, int col, int n) {
        if (col == n) {
            return true;
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(board, i, col, n)) {
                board[i][col] = 1;

                if (placeQueens(board, col + 1, n)) {
                    return true;
                }

                board[i][col] = 0;
            }
        }

        return false;
    }

    public static void printBoard(int[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 8; // Change the value of 'n' for different board sizes
        solveNQueens(n);
    }
}
