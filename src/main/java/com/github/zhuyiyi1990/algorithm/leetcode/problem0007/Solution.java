package com.github.zhuyiyi1990.algorithm.leetcode.problem0007;

//https://leetcode.com/problems/reverse-integer/
public class Solution {

    public int reverse(int x) {
        int result = 0;
        long temp = 0;
        while (x != 0) {
            temp = (long) result * 10 + x % 10;
            if (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE) {
                return 0;
            } else {
                result = (int) temp;
            }
            x /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(-123));
    }

}