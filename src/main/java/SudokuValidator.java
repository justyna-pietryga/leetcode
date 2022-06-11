import java.util.Arrays;

/**
 27-Jan-2022
 https://www.codewars.com/kata/51ba717bb08c1cd60f00002f/
 */
public class SudokuValidator {
    public static boolean check(int[][] sudoku) {
        if (sudoku.length != 9 || sudoku[0].length != 9) return false;

        int n = sudoku.length;
        int half = (n + 1) / 2;
        int sum = n * half;

        for (int i = 0; i < n; i++) {
            if (i % 3 == 0) {
                for (int j = 0; j <= n - 3; j += 3) {
                    if (!validateSudoku(getCopyOfPartOfTable(sudoku, i, i + 2, j, j + 2), sum)) return false;
                }
            }
            if (!validateSudoku(getCopyOfPartOfTable(sudoku, i, i, 0, n - 1), sum)) return false;
            if (!validateSudoku(getCopyOfPartOfTable(sudoku, 0, n - 1, i, i), sum)) return false;
        }

        return true;
    }

    private static int[][] getCopyOfPartOfTable(int[][] originalTable, int startRowIndex, int endRowIndex, int startColumnIndex, int endColumnIndex) {
        int[][] result = new int[endRowIndex - startRowIndex + 1][endColumnIndex - startColumnIndex + 1];
        for (int i = startRowIndex, k = 0; i <= endRowIndex; i++, k++) {
            for (int j = startColumnIndex, l = 0; j <= endColumnIndex; j++, l++) {
                result[k][l] = originalTable[i][j];
            }
        }

        return result;
    }

    private static boolean validateSudoku(int[][] partOfSudoku, int controlSum) {
        return Arrays.stream(partOfSudoku)
                .flatMapToInt(Arrays::stream)
                .distinct()
                .sum() == controlSum;
    }
}