/**
18-Jan-2022
https://www.codewars.com/kata/51ba717bb08c1cd60f00002f/
 */
public class RangeExtraction {
    public static String rangeExtraction(int[] arr) {
        StringBuilder result = new StringBuilder(String.valueOf(arr[0]));
        int lastNumber = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];

            if (Math.abs(current - arr[i - 1]) <= 1) {
                if (i == arr.length - 1 || Math.abs(current - arr[i + 1]) > 1) {
                    if (Math.abs(lastNumber - current) > 1) {
                        result.append("-").append(current);
                    } else {
                        result.append(",").append(current);
                    }
                }
            } else {
                lastNumber = current;
                result.append(",").append(current);
            }
        }

        return result.toString();
    }
}
