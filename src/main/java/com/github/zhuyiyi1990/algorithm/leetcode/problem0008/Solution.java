package com.github.zhuyiyi1990.algorithm.leetcode.problem0008;

public class Solution {

    public int myAtoi(String s) {
        if (s == null) {
            return 0;
        }
        int result = 0;
        char[] charArray = s.toCharArray();
        int i = 0;
        while (i < charArray.length && charArray[i] == ' ') {
            i++;
        }
        if (i >= charArray.length) {
            return 0;
        }
        int sign = 1;
        if (charArray[i] == '-') {
            sign = -1;
            i++;
        } else if (charArray[i] == '+') {
            i++;
        }
        for (; i < charArray.length; i++) {
            char c = charArray[i];
            if (c >= '0' && c <= '9') {
                if (result >= (int) Math.ceil((Integer.MAX_VALUE - (c - 48)) / 10.0)) {
                    // 正数越界
                    result = Integer.MAX_VALUE;
                    break;
                } else if (result <= (int) Math.floor((Integer.MIN_VALUE + (c - 48)) / 10.0)) {
                    // 负数越界
                    result = Integer.MIN_VALUE;
                    break;
                } else {
                    result = result * 10 + (c - 48) * sign;
                }
            } else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("42"));
        System.out.println(solution.myAtoi("   -042"));
        System.out.println(solution.myAtoi("1337c0d3"));
        System.out.println(solution.myAtoi("0-1"));
        System.out.println(solution.myAtoi("words and 987"));
        System.out.println(solution.myAtoi("99999999999999999999999999999999999"));
        System.out.println(solution.myAtoi("-99999999999999999999999999999999999"));
        System.out.println(solution.myAtoi("                  "));
        System.out.println(solution.myAtoi("2147483646"));
        System.out.println(solution.myAtoi("2147483647"));
        System.out.println(solution.myAtoi("2147483648"));
        System.out.println(solution.myAtoi("-2147483647"));
        System.out.println(solution.myAtoi("-2147483648"));
        System.out.println(solution.myAtoi("-2147483649"));
    }

}