package learning;

/**
 * Not mine
 * Left for recursion practice
 */

public class Decompose {
    public static String decompose(long n) {
        return indecompose(n, n * n);
    }

    public static String indecompose(long n, long sum) {
        for (long i = n - 1; i >= 1; i--) {
            long divlater = sum - i * i;
            if (divlater == 0) {
                return "" + i;
            }
            if (divlater > 0) {
                String res = indecompose(i, divlater);
                if (res != null) {
                    return res + " " + i;
                }
            }
        }
        return null;
    }
}
