package class01;

// 给定一个二维数组matrix，你可以从任何位置出发，走向上、下、左、右四个方向，返回能走出来的最长的递增链长度
public class Code05_LongestIncreasingPath {
    // solution one
    public static int longestIncreasingPath1(int[][] matrix) {
        int ans = 0;
        int N = matrix.length;
        int M = matrix[0].length;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ans = Math.max(ans, process1(matrix, i, j));
            }
        }

        return ans;
    }

    public static int process1(int[][] matrix, int i, int j) {
        int up = i > 0 && matrix[i][j] < matrix[i - 1][j] ? process1(matrix, i - 1, j) : 0;
        int down = i < (matrix.length - 1) && matrix[i][j] < matrix[i + 1][j] ? process1(matrix, i + 1, j) : 0;
        int left = j > 0 && matrix[i][j] < matrix[i][j - 1] ? process1(matrix, i, j - 1) : 0;
        int right = j < (matrix[0].length - 1) && matrix[i][j] < matrix[i][j + 1] ? process1(matrix, i, j + 1) : 0;

        return Math.max(Math.max(up, down), Math.max(left, right)) + 1;
    }

    // solution two
    public static int longestIncreasingPath(int[][] matrix) {
        int ans = 0;
        int N= matrix.length;
        int M = matrix[0].length;
        int[][] dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ans = Math.max(ans, process2(matrix, i, j, dp));
            }
        }

        return ans;
    }

    public static int process2(int[][] matrix, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int up = i > 0 && matrix[i][j] < matrix[i - 1][j] ? process2(matrix, i - 1, j, dp) : 0;
        int down = i < (matrix.length - 1) && matrix[i][j] < matrix[i + 1][j] ? process2(matrix, i + 1, j, dp) : 0;
        int left = j > 0 && matrix[i][j] < matrix[i][j - 1] ? process2(matrix, i, j - 1, dp) : 0;
        int right = j < (matrix[0].length - 1) && matrix[i][j] < matrix[i][j + 1] ? process2(matrix, i, j + 1, dp) : 0;

        int ans = Math.max(Math.max(up, down), Math.max(left, right)) + 1;
        dp[i][j] = ans;
        return ans;
    }
}
