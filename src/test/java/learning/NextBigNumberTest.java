package learning;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NextBigNumberTest {
    @Test
    public void basicTests() {
        Assert.assertEquals(21, NextBigNumber.nextBiggerNumber(12));
        Assert.assertEquals(531, NextBigNumber.nextBiggerNumber(513));
        Assert.assertEquals(2071, NextBigNumber.nextBiggerNumber(2017));
        Assert.assertEquals(441, NextBigNumber.nextBiggerNumber(414));
        Assert.assertEquals(414, NextBigNumber.nextBiggerNumber(144));
        Assert.assertEquals(19009, NextBigNumber.nextBiggerNumber(10990));
        Assert.assertEquals(-1, NextBigNumber.nextBiggerNumber(531));
        Assert.assertEquals(1295672169, NextBigNumber.nextBiggerNumber(1295671962));
    }
}