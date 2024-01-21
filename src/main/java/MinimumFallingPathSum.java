import java.util.Arrays;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Math.min;


/**
 * 21-01-2024
 * <a href="https://leetcode.com/problems/minimum-falling-path-sum/"/>
 */
public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int length = matrix.length;
        int[][] dp = new int[length][length];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, MAX_VALUE));

        int minSum = MAX_VALUE;

        for (int j = 0; j < length; j++) {
            int sum = sumFallingPath(matrix, dp, length, 0, j);
            if (sum < minSum) {
                minSum = sum;
            }
        }

        return minSum;
    }

    private int sumFallingPath(int[][] matrix, int[][] dp, int length, int i, int j) {
        if (i == length - 1) {
            dp[i][j] = matrix[i][j];
            return matrix[i][j];
        }

        if (dp[i][j] < MAX_VALUE) {
            return dp[i][j];
        }

        int number = matrix[i][j];

        int minSum = MAX_VALUE;
        if (j - 1 >= 0 && j - 1 < length) {
            minSum = min(minSum, number + sumFallingPath(matrix, dp, length, i + 1, j - 1));
        }
        if (j < length) {
            minSum = min(minSum, number + sumFallingPath(matrix, dp, length, i + 1, j));
        }
        if (j + 1 < length) {
            minSum = min(minSum, number + sumFallingPath(matrix, dp, length, i + 1, j + 1));
        }

        dp[i][j] = min(minSum, dp[i][j]);
        return minSum;
    }
}