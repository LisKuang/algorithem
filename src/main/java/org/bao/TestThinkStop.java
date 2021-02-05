package org.bao;

import org.junit.Before;
import org.junit.*;
import org.junit.Assert;

public class TestThinkStop {

    private Solution solution;
    @Before
    public void beforeTest(){
        this.solution = new Solution();
    }

    @Test
    public void testReverseInteger(){
        Assert.assertEquals(12345,solution.reverseInteger(54321));
        Assert.assertEquals(-12345,solution.reverseInteger(-54321));
        Assert.assertEquals(0,solution.reverseInteger(1463847413));//2147483647
    }

    @Test
    public void testIsPalindrome(){
        Assert.assertTrue(solution.isPalindrome(12321));
        Assert.assertTrue(solution.isPalindrome(0));
        Assert.assertFalse(solution.isPalindrome(-121));
        Assert.assertFalse(solution.isPalindrome(123455));

    }

    @Test
    public void testromanToInt2(){
        Assert.assertEquals(5,solution.romanToInt2("V"));
        Assert.assertEquals(8,solution.romanToInt2("VIII"));
        Assert.assertEquals(4,solution.romanToInt2("IV"));
        Assert.assertEquals(9,solution.romanToInt2("IX"));
        Assert.assertEquals(58,solution.romanToInt2("LVIII"));
        Assert.assertEquals(1994,solution.romanToInt2("MCMXCIV"));
        Assert.assertEquals(300,solution.romanToInt2("CCC"));
        Assert.assertEquals(2425,solution.romanToInt2("MMCDXXV"));

    }
    @Test
    public void testlongestCommonPrefix2(){
        String[] stas={"abd09dd","abdffppp","abdffeep"};
        String[] stas1={"asd09dd","abdffppp","abdffeep"};
        String[] stas3={"12345","1234567","12345y"};
        String[] stas2={};
        String[] stas4={"a","b"};
        Assert.assertEquals("abd",solution.longestCommonPrefix2(stas));
        Assert.assertEquals("a",solution.longestCommonPrefix2(stas1));
        Assert.assertEquals("",solution.longestCommonPrefix2(stas2));
        Assert.assertEquals("",solution.longestCommonPrefix2(stas4));
        Assert.assertEquals("12345",solution.longestCommonPrefix2(stas3));
    }

    @Test
    public void testisValid2(){
        Assert.assertFalse(solution.isValid2("(]"));
        Assert.assertFalse(solution.isValid2("("));
        Assert.assertFalse(solution.isValid2("([)]"));
        Assert.assertFalse(solution.isValid2("([[[{{{{{{"));
        Assert.assertTrue(solution.isValid2("()[]{}"));
        Assert.assertTrue(solution.isValid2("{[]}"));
    }
}
