/**
 * 10-Jan-2023
 * <a href="https://leetcode.com/problems/search-insert-position">...</a>
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int i = start + (end - start) / 2;
            if (nums[i] == target) {
                return i;
            } else if (nums[i] < target) {
                start = i + 1;
            } else {
                end = i - 1;
            }
        }

        return start;
    }
}
