package org.bao;

import java.util.*;

public class ThinkStop {
    public static void main(String[] args) {
        System.out.println("The max int : " + Integer.MAX_VALUE);//2147483647
        System.out.println("The max int : " + Integer.MIN_VALUE);//-2147483648
    }
}

class Solution {

    /**
     * 除法 stack pop
     * 取余 get the stack top element
     */
    public int reverseInteger(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }

    /**
     * -383 is not a palindrome
     * single number is a palindrome
     * the last reversing half before add new value
     * bigger then the first half, return false,
     * equivalence then return true
     * smaller then add new value, and compare again
     * still smaller then go to new loop
     */
    public boolean isPalindrome(int x) {
        //negatime num is not palindrome
        if (x < 0) {
            return false;
        }
        //0 or single num is palindrome
        if (x / 10 == 0) {
            return true;
        }
        //10 is not a palindrome;
        if (x % 10 == 0) {
            return false;
        }
        int reversingNumber = 0;
        while (x > reversingNumber) {
            reversingNumber = reversingNumber * 10 + x % 10;
            x = x / 10;
        }

        return x == reversingNumber || x == reversingNumber / 10;
    }

    public int romanToInt(String s) {
        //the same remark wont appear four continous times
        //3999
        //I=1           level 0
        // V=5 X=10     level 1
        // L=50 C=100   level 2
        // D=500 M=1000 level 3
        //IV=4 IX=9
        //XL=40 XC=90
        //CD=400 CM=900
        //remember the last remark
        int result = 0;
        int level = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'I': {//1
                    if (level == 1) {
                        result = result - 1;
                    } else {
                        result = result + 1;
                    }
                    break;
                }
                case 'V': {//5
                    level = 1;
                    result = result + 5;
                    break;
                }
                case 'X': {//10

                    if (level == 2) {
                        result = result - 10;
                    } else {
                        level = 1;
                        result = result + 10;
                    }

                    break;
                }
                case 'L': {//50
                    level = 2;
                    result = result + 50;
                    break;
                }
                case 'C': {//100

                    if (level == 3) {
                        result = result - 100;
                    } else {
                        level = 2;
                        result = result + 100;
                    }
                    break;
                }
                case 'D': {//500
                    level = 3;
                    result = result + 500;
                    break;
                }
                case 'M': {//1000
                    level = 3;
                    result = result + 1000;
                }
            }
        }

        return result;
    }

    public int romanToInt2(String s) {
        int sum = 0;
        int preNum = getRomanValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int currNum = getRomanValue(s.charAt(i));
            if (preNum < currNum) {//sub
                sum -= preNum;
            } else {//add
                sum += preNum;
            }
            preNum = currNum;
        }
        sum += preNum;
        return sum;
    }

    private int getRomanValue(char charAt) {
        switch (charAt) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLengh = Integer.MAX_VALUE;
        for (String str : strs) {
            minLengh = Math.min(str.length(), minLengh);
        }
        int low = 0;
        int high = minLengh - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (isCommonPrefix(strs, low, mid)) {
                low = mid + 1;
            } else {
                high = mid;
                if (low == high) {
                    high = low - 1;
                }
            }
        }
        return strs[0].substring(0, high + 1);
    }

    private boolean isCommonPrefix(String[] strs, int low, int mid) {
        for (String str : strs) {
            for (int i = low; i <= mid; i++) {
                if (strs[0].charAt(i) != str.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public String longestCommonPrefix2(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        String str0 = strs[0];
        int end = minLength - 1;
        outer:
        for (int i = 0; i < minLength; i++) {
            for (String str : strs) {
                if (str0.charAt(i) != str.charAt(i)) {
                    end = i - 1;
                    break outer;
                }
            }
        }
        return str0.substring(0, end + 1);
    }

    public boolean isValid(String s) {
        if (s.length() == 1) {
            return false;
        }

        Map<Character, Character> brackets = new HashMap<Character, Character>();
        brackets.put('(', ')');
        brackets.put('{', '}');
        brackets.put('[', ']');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (brackets.containsKey(s.charAt(i))) {
                //only left bracket can be added
                stack.add(s.charAt(i));
                continue;
            }
            //one right bracket pop the responding bracket, otherwise return false
            if (!stack.empty() && brackets.get(stack.peek()) == s.charAt(i)) {
                stack.pop();
            } else {
                return false;
            }
        }

        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isValid2(String s) {
        if (s.length() == 1) {
            return false;
        }

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (getRightBracket(s.charAt(i)) != 0) {
                //only left bracket can be added
                stack.push(s.charAt(i));
                continue;
            }
            //one right bracket pop the responding bracket, otherwise return false
            if (!stack.isEmpty() && getRightBracket(stack.peek()) == s.charAt(i)) {
                stack.pop();
            } else {
                return false;
            }
        }

        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    private char getRightBracket(char charAt) {
        switch (charAt) {
            case '(':
                return ')';
            case '{':
                return '}';
            case '[':
                return ']';
            default:
                return 0;
        }
    }

}
