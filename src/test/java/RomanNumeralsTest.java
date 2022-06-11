import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RomanNumeralsTest {
    @Test
    public void testToRoman() throws Exception {
        assertThat("1 converts to 'I'", RomanNumerals.toRoman(1), is("I"));
        assertThat("1 converts to 'I'", RomanNumerals.toRoman(8), is("VIII"));
        assertThat("1 converts to 'I'", RomanNumerals.toRoman(7), is("VII"));
        assertThat("1 converts to 'I'", RomanNumerals.toRoman(9), is("IX"));
        assertThat("1 converts to 'I'", RomanNumerals.toRoman(10), is("X"));
        assertThat("1 converts to 'I'", RomanNumerals.toRoman(500), is("D"));
        assertThat("1 converts to 'I'", RomanNumerals.toRoman(600), is("DC"));
        assertThat("1 converts to 'I'", RomanNumerals.toRoman(400), is("CD"));
        assertThat("1 converts to 'I'", RomanNumerals.toRoman(90), is("XC"));
        assertThat("1 converts to 'I'", RomanNumerals.toRoman(110), is("CX"));
        assertThat("1 converts to 'I'", RomanNumerals.toRoman(1400), is("MCD"));
        assertThat("1 converts to 'I'", RomanNumerals.toRoman(13), is("XIII"));
        assertThat("1 converts to 'I'", RomanNumerals.toRoman(14), is("XIV"));
        assertThat("1 converts to 'I'", RomanNumerals.toRoman(2664), is("MMDCLXIV"));
        assertThat("2 converts to 'II'", RomanNumerals.toRoman(2), is("II"));
        assertThat("2 converts to 'II'", RomanNumerals.toRoman(3999), is("MMMCMXCIX"));
        assertThat("2 converts to 'II'", RomanNumerals.toRoman(4000), is(""));
        assertThat("2 converts to 'II'", RomanNumerals.toRoman(640), is("DCXL"));
        assertThat("2 converts to 'II'", RomanNumerals.toRoman(2008), is("MMVIII"));
        assertThat("2 converts to 'II'", RomanNumerals.toRoman(2849), is("MMDCCCXLIX"));
    }

    @Test
    public void testFromRoman() throws Exception {
        assertThat("'I' converts to 1", RomanNumerals.fromRoman("I"), is(1));
        assertThat("'II' converts to 2", RomanNumerals.fromRoman("II"), is(2));
        assertThat("'II' converts to 2", RomanNumerals.fromRoman("III"), is(3));
        assertThat("'II' converts to 2", RomanNumerals.fromRoman("IV"), is(4));
        assertThat("'II' converts to 2", RomanNumerals.fromRoman("V"), is(5));
        assertThat("'II' converts to 2", RomanNumerals.fromRoman("VI"), is(6));
        assertThat("'II' converts to 2", RomanNumerals.fromRoman("VII"), is(7));
        assertThat("'II' converts to 2", RomanNumerals.fromRoman("VIII"), is(8));
        assertThat("'II' converts to 2", RomanNumerals.fromRoman("CX"), is(110));
        assertThat("'II' converts to 2", RomanNumerals.fromRoman("MMDCLXIV"), is(2664));
        assertThat("'II' converts to 2", RomanNumerals.fromRoman("MMMCMXCIX"), is(3999));
        assertThat("'II' converts to 2", RomanNumerals.fromRoman("DCXL"), is(640));
    }
}