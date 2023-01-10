import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchInsertTest {
    private final SearchInsert underTest = new SearchInsert();
    private final int[] input1 = new int[]{1, 3, 5, 7, 8, 10};
    private final int[] input2 = new int[]{1, 2, 3, 5, 6, 7};
    private final int[] inputOneElement = new int[]{1};

    @Test
    public void searchInsertForExistingNumbers() {
        int result1 = underTest.searchInsert(input1, 1);
        int result2 = underTest.searchInsert(input1, 3);
        int result3 = underTest.searchInsert(input1, 5);
        int result4 = underTest.searchInsert(input1, 7);
        int result5 = underTest.searchInsert(input1, 8);
        int result6 = underTest.searchInsert(input1, 10);

        assertEquals(0, result1);
        assertEquals(1, result2);
        assertEquals(2, result3);
        assertEquals(3, result4);
        assertEquals(4, result5);
        assertEquals(5, result6);
    }

    @Test
    public void searchInsertWhenOneElement() {
        int result1 = underTest.searchInsert(inputOneElement, 1);
        assertEquals(0, result1);
    }

    @Test
    public void searchInsertForNonExistingNumbersInTheMiddle() {
        int result_lack_in_middle_1 = underTest.searchInsert(input1, 2);
        int result_lack_in_middle_2 = underTest.searchInsert(input1, 6);
        int result_lack_in_middle_3 = underTest.searchInsert(input1, 9);
        int result_lack_in_middle_4 = underTest.searchInsert(input2, 4);

        assertEquals(1, result_lack_in_middle_1);
        assertEquals(3, result_lack_in_middle_2);
        assertEquals(5, result_lack_in_middle_3);
        assertEquals(3, result_lack_in_middle_4);
    }

    @Test
    public void searchInsertForNonExistingNumbersInCornerCases() {
        int result_lack_at_beginning = underTest.searchInsert(input1, 0);
        int result_lack_at_end = underTest.searchInsert(input1, 11);

        assertEquals(0, result_lack_at_beginning);
        assertEquals(6, result_lack_at_end);
    }
}