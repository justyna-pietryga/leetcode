import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 10-Mar-23
 * <a href="https://leetcode.com/problems/two-sum/description/"/a>
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> checked = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int difference = target - current;
            if (checked.containsKey(difference)) {
                return new int[]{checked.get(difference), i};
            }
            checked.put(nums[i], i);
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        Set<Integer> values = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int difference = target - current;
            values.remove(current);
            if (values.contains(difference) && i < nums.length - 1)
                return new int[]{i, search(difference, nums, i + 1)};
        }

        int half = target / 2;
        int firstIndex = search(half, nums, 0);
        int secondIndex = search(half, nums, firstIndex + 1);
        return new int[]{firstIndex, secondIndex};
    }

    public int search(int number, int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            if (nums[i] == number) return i;
        }
        return -1;
    }
}
