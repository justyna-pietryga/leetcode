package learning;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class DecomposeTest {

    @Test
    public void test1() {
        Decompose d = new Decompose();
        long n = 15018;
        assertEquals("5 9 173 15017",  d.decompose(n));
    }
}