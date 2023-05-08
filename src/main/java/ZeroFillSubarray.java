public class ZeroFillSubarray {
    public long zeroFilledSubarray(int[] nums) {
        int i = 0, j = 0;
        long result = 0;
        int length = nums.length;

        while (j <= length) {
            if (j == length || nums[j] != 0) {
                if (j != i) {
                    int diff = j - i;
//                    result += ((long) (diff + 1) * diff) / 2;
                    result += (long) ((double) diff / 2 * (diff + 1));
                }
                i = j + 1;
            }
            j++;
        }


        return result;
    }
}
