package org.bao;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

public class TestRoundThree {

    private RoundThree rt=new RoundThree();

    @Test
    public void strStr2Test(){
        Assert.assertEquals(-1,rt.strStr2("abcd","hh"));
        Assert.assertEquals(0,rt.strStr2("abcd",""));
        Assert.assertEquals(0,rt.strStr2("abcd","ab"));
        Assert.assertEquals(1,rt.strStr2("abcd","bc"));
        Assert.assertEquals(0,rt.strStr2("abcd","abcd"));
        Assert.assertEquals(3,rt.strStr2("abcd","d"));
        Assert.assertEquals(2,rt.strStr2("abcd","cd"));
        Assert.assertEquals(0,rt.strStr2("",""));
    }

    @Test
    public void searchInsertTest(){
        Assert.assertEquals(2,rt.searchInsert(new int[]{1,3,5,6},5));
        Assert.assertEquals(1,rt.searchInsert(new int[]{1,3,5,6},2));
        Assert.assertEquals(4,rt.searchInsert(new int[]{1,3,5,6},7));
        Assert.assertEquals(0,rt.searchInsert(new int[]{1,3,5,6},0));
        Assert.assertEquals(0,rt.searchInsert(new int[]{},0));
        Assert.assertEquals(0,rt.searchInsert(new int[]{12},11));
        Assert.assertEquals(1,rt.searchInsert(new int[]{12},13));
    }

    @Test
    public void countAndSayTest(){
        Assert.assertEquals("1",rt.countAndSay(1));
        Assert.assertEquals("11",rt.countAndSay(2));
        Assert.assertEquals("21",rt.countAndSay(3));
        Assert.assertEquals("1211",rt.countAndSay(4));
        Assert.assertEquals("111221",rt.countAndSay(5));
    }

    @Test
    public void testIntVariableInicialValue(){
        int[] ints=new int[1];
        System.out.println("ints[0]:"+ints[0]);
        String str="abc";
        String str2="123";
        String str3=String.valueOf(ints);
        System.out.println(str.toCharArray()[1]);
        System.out.println(str2.charAt(1));
        System.out.println("int array conver to string "+str3);
        System.out.println(str2.charAt(1)+str2.charAt(0));
        int i= str2.charAt(1);
        System.out.println("conver char to int : "+i);
        if('1'==str2.getBytes()[0]){
            System.out.println("char 1 is equal to byte 1 ");

        }




    }


    @Test
    public void testbytes(){
        byte[] bytes=new byte[3];
        bytes[0]=1;
        bytes[1]='0';
        bytes[2]='0';
        System.out.println("byte[0]:"+bytes[0]);
        System.out.println("byte[0]:"+bytes[1]);
        System.out.println("bytes for str :"+new String(bytes));

    }

    @Test
    public void maxSubArray2Test(){
        Assert.assertEquals(1,rt.maxSubArray2(new int[]{1}));
        Assert.assertEquals(-1,rt.maxSubArray2(new int[]{-1}));
        Assert.assertEquals(3,rt.maxSubArray2(new int[]{1,2}));
        //add condition and recount condition
        Assert.assertEquals(6,rt.maxSubArray2(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    @Test
    public void lengthOfLastWordTest(){
        Assert.assertEquals(0,rt.lengthOfLastWord("  "));
        Assert.assertEquals(3,rt.lengthOfLastWord("bao  "));
        Assert.assertEquals(0,rt.lengthOfLastWord(""));
        Assert.assertEquals(5,rt.lengthOfLastWord("Hello World"));
        Assert.assertEquals(1,rt.lengthOfLastWord("H"));
    }

    @Test
    public void plusOneTest(){
        Assert.assertArrayEquals(new int[]{1,2,4},rt.plusOne(new int[]{1,2,3}));
        Assert.assertArrayEquals(new int[]{1},rt.plusOne(new int[]{0}));
        Assert.assertArrayEquals(new int[]{1,0,0,0,},rt.plusOne(new int[]{9,9,9}));
    }

    @Test
    public void addBinaryTest(){
        Assert.assertEquals("10",rt.addBinary("1","1"));
        Assert.assertEquals("100",rt.addBinary("11","1"));
        Assert.assertEquals("10101",rt.addBinary("1010","1011"));
        Assert.assertEquals("10001",rt.addBinary("1110","11"));
        Assert.assertEquals("10000",rt.addBinary("1111","1"));
    }

    @Test
    public void mySqrtTest(){
        Assert.assertEquals(1,rt.mySqrt(1));
        Assert.assertEquals(1,rt.mySqrt(2));
        Assert.assertEquals(1,rt.mySqrt(3));
        Assert.assertEquals(2,rt.mySqrt(4));
        Assert.assertEquals(2,rt.mySqrt(5));
        Assert.assertEquals(2,rt.mySqrt(6));
        Assert.assertEquals(2,rt.mySqrt(7));
        Assert.assertEquals(2,rt.mySqrt(8));
        Assert.assertEquals(3,rt.mySqrt(9));
        Assert.assertEquals(8,rt.mySqrt(65));
        Assert.assertEquals(1465,rt.mySqrt(2147395));
        Assert.assertEquals(46339,rt.mySqrt(2147395599));
    }

}
