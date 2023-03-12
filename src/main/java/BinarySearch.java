/**
 08-Jan-2023
 <a href="https://leetcode.com/problems/binary-search">...</a>
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        return divideAndCheck(target, 0, nums.length - 1, nums);
    }

    private int divideAndCheck(int target, int start, int end, int[] nums) {
        int i = (end - start) / 2 + start;
        if (nums[i] == target) {
            return i;
        }
        else if (nums[i] > target && i != start) {
            return divideAndCheck(target, start, i - 1, nums);
        }
        else if (nums[i] < target && i != end) {
            return divideAndCheck(target, i + 1, end, nums);
        }
        else return -1;
    }
}
