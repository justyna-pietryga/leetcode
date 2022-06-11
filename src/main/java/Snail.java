import java.util.ArrayList;

/**
18-Jan-2022
https://www.codewars.com/kata/521c2db8ddc89b9b7a0000c1
 */
public class Snail {

    public static int[] snail(int[][] array) {
        int i = 0;
        int j = array.length - 1;
        if (array[0].length == 0) return new int[]{};

        ArrayList<Integer> result = new ArrayList<>();

        while (i <= j) {
            for (int k = i; k <= j; k++) result.add(array[i][k]);
            for (int k = i + 1; k <= j; k++) result.add(array[k][j]);
            for (int k = j - 1; k >= i; k--) result.add(array[j][k]);
            for (int k = j - 1; k >= i + 1; k--) result.add(array[k][i]);

            j--;
            i++;
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}