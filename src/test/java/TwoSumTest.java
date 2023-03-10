import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TwoSumTest {
    @Test
    public void twoSum() {
        TwoSum underTest = new TwoSum();
        int[] result1 = underTest.twoSum(new int[]{2, 7, 10, 13}, 9);
        int[] result2 = underTest.twoSum(new int[]{3,2,4}, 6);
        int[] result3 = underTest.twoSum(new int[]{3,3}, 6);
        assertArrayEquals( new int[]{0, 1}, result1);
        assertArrayEquals(new int[]{1, 2}, result2);
        assertArrayEquals(new int[]{0, 1}, result3);
    }
}