import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @version 11.2.2022
 * @author 25pandey
 */
public class RomanToDecimalTest {

    @Test
    /**
     * test of decimalToRoman method
     */
    public void decimalToRoman() {
        assertEquals(RomanToDecimal.decimalToRoman(14), "XIV");
        assertEquals(RomanToDecimal.decimalToRoman(1974), "MCMLXXIV");
    }

    @Test
    /**
     * test of romanToDecimal method
     */
    public void romanToDecimal() {
        assertEquals(RomanToDecimal.romanToDecimal("XIV"), 14);
        assertEquals(RomanToDecimal.romanToDecimal("IVIV"), -2);    // not correct, but valid
        assertEquals(RomanToDecimal.romanToDecimal("hello"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("IX"), 9);
        assertEquals(RomanToDecimal.romanToDecimal("XIXI"), -2);
        assertEquals(RomanToDecimal.romanToDecimal("ILIKETRAINS"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("iliketrains"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("LXHID"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("kanishkyboi"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("MJKLD"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("MCLII"), 1152);
        assertEquals(RomanToDecimal.romanToDecimal("qwerty"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("mmmcmcmcdiiix"), -2);
        assertEquals(RomanToDecimal.romanToDecimal("MPD"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("mpd"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("LD"), -2);
        assertEquals(RomanToDecimal.romanToDecimal("ld"), -2);
        assertEquals(RomanToDecimal.romanToDecimal("MJISTHEGOAT"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("mjisthegoat"), -1);
        assertNotEquals(RomanToDecimal.romanToDecimal("IVIV"), 10); //not equals
        assertNotEquals(RomanToDecimal.romanToDecimal("XIIIII"), 15); //not equals
    }
}
