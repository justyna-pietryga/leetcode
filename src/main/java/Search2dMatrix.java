/**
 * 08-08-2023
 * <a href="https://leetcode.com/problems/search-a-2d-matrix"/>
 */
public class Search2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] firstInRows = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            firstInRows[i] = matrix[i][0];
        }
        return isExistInMatrix(firstInRows, matrix, 0, matrix.length - 1, target);
    }

    private boolean isExistInMatrix(int[] firstInRows, int[][] matrix, int start, int end, int target) {
        int i = start + (end - start) / 2;
        if (target >= firstInRows[i] && (i == end || target < firstInRows[i + 1])) {
            return isExistInRow(target, matrix[i], 0, matrix[i].length - 1);
        } else if (target < firstInRows[i] && i != start) {
            return isExistInMatrix(firstInRows, matrix, 0, i, target);
        } else if (i != end && target >= firstInRows[i + 1]) {
            return isExistInMatrix(firstInRows, matrix, i + 1, end, target);
        } else {
            return false;
        }
    }

    private boolean isExistInRow(int target, int[] numbers, int start, int end) {
        int i = start + (end - start) / 2;
        if (target == numbers[i]) return true;
        else if (target > numbers[i] && i != end) return isExistInRow(target, numbers, i + 1, end);
        else if (target < numbers[i] && i != start) return isExistInRow(target, numbers, 0, i);
        else return false;
    }
}
