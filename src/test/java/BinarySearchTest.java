import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {
    BinarySearch underTest = new BinarySearch();

    @Test
    public void binarySearchReturnProperIndex() {
        int[] input = new int[]{-1, 0, 1, 3, 4, 5, 6, 7, 8};
        int[] input2 = new int[]{2, 5};
        int result_lack_0 = underTest.search(input, 2);
        int result_lack_1 = underTest.search(input, -2);
        int result_lack_3 = underTest.search(input, 9);
        int result0 = underTest.search(input, -1);
        int result1 = underTest.search(input, 0);
        int result2 = underTest.search(input, 1);
        int result3 = underTest.search(input, 3);
        int result4 = underTest.search(input, 4);
        int result5 = underTest.search(input, 5);
        int result6 = underTest.search(input, 6);
        int result7 = underTest.search(input, 7);
        int result8 = underTest.search(input, 8);
        int result9 = underTest.search(input, 9);
        int result10 = underTest.search(input, -1);
        int resultInput2_1 = underTest.search(input2, 5);
        Assert.assertEquals(-1, result_lack_0);
        Assert.assertEquals(-1, result_lack_1);
        Assert.assertEquals(-1, result_lack_3);
        Assert.assertEquals(1, result1);
        Assert.assertEquals(2, result2);
        Assert.assertEquals(3, result3);
        Assert.assertEquals(4, result4);
        Assert.assertEquals(5, result5);
        Assert.assertEquals(6, result6);
        Assert.assertEquals(7, result7);
        Assert.assertEquals(8, result8);
        Assert.assertEquals(8, result8);
        Assert.assertEquals(-1, result9);
        Assert.assertEquals(0, result10);
        Assert.assertEquals(1, resultInput2_1);
    }
}