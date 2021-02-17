package org.bao;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class RoundThree {

    /**
     * 28. 实现 strStr()
     */

    public int strStr(String haystack, String needle) {


        if (haystack.length() > 0 && "".equals(needle)) {
            return 0;
        }

        if (needle.length() > haystack.length()) {
            return -1;
        }

        int ind = needle.length();
        for (int i = 0; i < haystack.length() - ind + 1; i++) {
            String str = haystack.substring(i, i + ind);
            if (str.equals(needle)) {
                return i;
            }
        }

        return -1;

    }


    public int strStr2(String haystack, String needle) {


        if (haystack.length() > 0 && "".equals(needle)) {
            return 0;
        }

        if (needle.length() > haystack.length()) {
            return -1;
        }


        if ("".equals(haystack) && "".equals(needle)) {
            return 0;
        }

        int ind = needle.length();
        for (int i = 0; i < haystack.length() - ind + 1; i++) {
            for (int j = 0; j < ind; j++) {
                char h = haystack.charAt(i + j);
                char n = needle.charAt(j);
                if (h != n) {
                    break;
                }
                if (j == ind - 1) {
                    return i;
                }
            }
        }

        return -1;

    }


    /**
     * 35. 搜索插入位置
     */
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return start;

    }

    /**
     * 38. 外观数列
     */

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String preStr = countAndSay(n - 1);
        char[] chars = preStr.toCharArray();
        int count = 1;
        char currentChar = chars[0];
        StringBuffer result = new StringBuffer();
        for (int i = 1; i < chars.length; i++) {
            if (currentChar == chars[i]) {
                count++;
            } else {
                result.append(count).append(currentChar);
                currentChar = chars[i];
                count = 1;
            }
        }
        result.append(count).append(currentChar);
        return result.toString();
    }

    /**
     * 53. 最大子序和
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int sumMax = 0;
        int[][] status = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (j == 0) {
                    status[i][j] = nums[0];
                    sumMax = nums[0];
                    continue;
                }
                status[i][j] = status[i][j - 1] + nums[j];
                sumMax = Math.max(sumMax, status[i][j]);
            }
        }
        return sumMax;

    }


    public int maxSubArray2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int sumMax = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if (currentSum <= 0) {
                currentSum = nums[i];
                sumMax = Math.max(sumMax, nums[i]);
            } else if ((currentSum + nums[i]) >= currentSum) {
                currentSum = currentSum + nums[i];

            } else if ((currentSum + nums[i]) < currentSum) {
                sumMax = Math.max(sumMax, currentSum);
                currentSum = currentSum + nums[i];
            }

        }
        return Math.max(sumMax, currentSum);
    }

    /**
     * 58. 最后一个单词的长度
     */
    public int lengthOfLastWord(String s) {

        if (s.length() == 0) {
            return 0;
        }
        //s=s.trim();

        int spaceIndex = -1;
        int actualLenth = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (i == (actualLenth - 1)) {
                    actualLenth--;
                } else {
                    spaceIndex = i;
                    break;
                }

            }
        }

        if (spaceIndex == -1) {
            return actualLenth;
        }

        return actualLenth - spaceIndex - 1;

    }

    /**
     * 66. 加一
     */

    public int[] plusOne(int[] digits) {

        if (digits.length == 0) {
            return digits;
        }

        //[9,9,9]
        int[] newDigits;
        for (int i = digits.length - 1; i >= 0; i--) {
            int addResult = digits[i] + 1;
            if (addResult / 10 > 0) {
                //carry the one
                if (i == 0) {
                    newDigits = new int[digits.length + 1];
                    newDigits[0] = 1;
                    return newDigits;
                }
                digits[i] = addResult % 10;
            } else {
                digits[i] = addResult;
                break;
            }
        }
        return digits;
    }

    /**
     * 67. 二进制求和
     */

    public String addBinary(String a, String b) {
        int maxLen;
        int minLen;
        byte[] longer = null;
        byte[] shorter = null;
        if (a.length() >= b.length()) {
            maxLen = a.length();
            longer = a.getBytes();
            shorter = b.getBytes();
        } else {
            maxLen = b.length();
            longer = b.getBytes();
            shorter = a.getBytes();
        }

        byte carry = '0';
        int dis = longer.length - shorter.length;
        for (int i = maxLen - 1; i >= 0; i--) {
            byte aByte;
            byte bByte;
            if (longer.length - 1 < i) {
                aByte = '0';
            } else {
                aByte = longer[i];
            }
            if (i - dis < 0) {
                bByte = '0';
            } else {
                bByte = shorter[i - dis];
            }
            byte addResult = addBytes(addBytes(aByte, bByte), carry);
            carry = getCarry(aByte, bByte, carry);
            longer[i] = addResult;
        }

        if ('1' == carry) {
            longer = this.extendBytes(longer, maxLen + 1);
            longer[0] = '1';
        }
        return new String(longer);
    }

    private byte addBytes(byte aByte, byte bByte) {
        if ((aByte ^ bByte) == 1) {
            return '1';
        }
        return '0';
    }

    private byte getCarry(byte aByte, byte bByte, byte carry) {
        if ('1' == aByte && '1' == bByte) {
            return '1';
        }
        if ('1' == carry && '1' == bByte) {
            return '1';
        }
        if ('1' == aByte && '1' == carry) {
            return '1';
        }
        return '0';
    }


    private byte[] extendBytes(byte[] oldBytes, int length) {

        byte[] newBytes = new byte[length];
        for (int i = oldBytes.length - 1; i >= 0; i--) {
            newBytes[i + (length - oldBytes.length)] = oldBytes[i];
        }
        return newBytes;
    }


    public String addBinary2(String a, String b) {
        StringBuffer res = new StringBuffer();
        int maxLen = Math.max(a.length(), b.length());
        int carry = 0;
        for (int i = 0; i < maxLen; i++) {
            carry = carry + (i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0);
            carry = carry + (i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0);
            res.append(carry % 2);
            carry = carry / 2;
        }
        if (carry == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }

    /**
     * 69. x 的平方根
     */

    public int mySqrt(int x) {

        int start = 0;
        int end = x;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end-start) / 2;
            if ((long) mid * mid == x) {
                return mid;
            }
            if ((long) mid * mid < x) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public int mySqrt2(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }


}
