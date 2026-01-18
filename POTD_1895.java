public class POTD_1895 {
    
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] rowPrefix = new int[m][n + 1];
        int[][] colPrefix = new int[m + 1][n];
        // Build prefix sums
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowPrefix[i][j + 1] = rowPrefix[i][j] + grid[i][j];
                colPrefix[i + 1][j] = colPrefix[i][j] + grid[i][j];
            }
        }
        for (int k = Math.min(m, n); k >= 2; k--) {
            for (int i = 0; i + k <= m; i++) {
                for (int j = 0; j + k <= n; j++) {
                    if (isMagic(grid, rowPrefix, colPrefix, i, j, k)) {
                        return k;
                    }
                }
            }
        }
        return 1;
    }
    private boolean isMagic(int[][] grid, int[][] rowPrefix, int[][] colPrefix,
                            int r, int c, int k) {
        int target = rowPrefix[r][c + k] - rowPrefix[r][c];
        for (int i = r; i < r + k; i++) {
            int rowSum = rowPrefix[i][c + k] - rowPrefix[i][c];
            if (rowSum != target) return false;
        }
        for (int j = c; j < c + k; j++) {
            int colSum = colPrefix[r + k][j] - colPrefix[r][j];
            if (colSum != target) return false;
        }
        int diag1 = 0;
        for (int i = 0; i < k; i++) {
            diag1 += grid[r + i][c + i];
        }
        if (diag1 != target) return false;
        int diag2 = 0;
        for (int i = 0; i < k; i++) {
            diag2 += grid[r + i][c + k - 1 - i];
        }
        if (diag2 != target) return false;

        return true;
    }
}